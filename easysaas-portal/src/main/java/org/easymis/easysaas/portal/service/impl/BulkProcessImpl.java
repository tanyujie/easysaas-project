package org.easymis.easysaas.portal.service.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.easymis.easysaas.portal.config.ElasticSearchConfig;
import org.easymis.easysaas.portal.service.BulkProcessService;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

/**
 * @author Ye
 * @time 2019锟斤拷3锟斤拷29锟斤拷
 *
 *       锟斤拷说锟斤拷锟斤拷通锟斤拷BulkProcess锟斤拷锟斤拷锟斤拷Mysql锟斤拷锟捷碉拷锟斤拷ElasticSearch锟斤拷
 */
@Service
public class BulkProcessImpl implements BulkProcessService{
    @Autowired
    private ElasticSearchConfig esUtil;
	private static final Logger logger = LogManager.getLogger(BulkProcessImpl.class);

	public static void main(String[] args) {
		try {
			//test();
			long startTime = System.currentTimeMillis();
			String tableName = "company";
//			String tableName = "TBL_ORG";
			createIndex(tableName);
			BulkProcessImpl bulk = new BulkProcessImpl();
			bulk.writeMysqlDataToES(tableName);
			//锟斤拷锟斤拷锟斤拷锟皆硷拷锟绞记憋拷锟斤拷锟皆碉拷Eclipse锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟捷ｏ拷 1800000 ,use time: 186s,5锟斤拷锟竭程ｏ拷5000一锟斤拷锟斤拷锟轿ｏ拷未锟斤拷锟斤拷锟斤拷刷锟斤拷时锟斤拷锟诫副锟斤拷锟斤拷
			//锟斤拷锟斤拷锟斤拷锟斤拷锟捷ｏ拷 1800000 ,use time: 168s,5锟斤拷锟竭程ｏ拷5000一锟斤拷锟斤拷锟轿ｏ拷锟斤拷锟斤拷锟斤拷刷锟斤拷时锟戒（-1锟斤拷锟诫副锟斤拷锟斤拷锟斤拷0锟斤拷

			logger.info(" use time: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createIndex(String indexName) throws IOException {
		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));// 锟斤拷始锟斤拷
		CreateIndexRequest requestIndex = new CreateIndexRequest(indexName.toLowerCase());// 锟斤拷锟斤拷锟斤拷锟斤拷
		// 锟斤拷锟斤拷锟斤拷每锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷之锟斤拷锟斤拷锟斤拷锟截讹拷锟斤拷锟矫★拷锟斤拷锟矫革拷锟斤拷锟斤拷锟斤拷刷锟斤拷时锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫э拷锟斤拷胁锟叫★拷锟斤拷锟斤拷锟?
		requestIndex.settings(Settings.builder().put("index.number_of_shards", 5)
				.put("index.number_of_replicas", 0)
				.put("index.refresh_interval", "-1"));
		CreateIndexResponse createIndexResponse = client.indices().create(requestIndex, RequestOptions.DEFAULT);
		logger.info("isAcknowledged:" + createIndexResponse.isAcknowledged());
		logger.info("isShardsAcknowledged:" + createIndexResponse.isShardsAcknowledged());

		client.close();

	}

	/**
	 * 
	 * <p>
	 * Title: writeMysqlDataToES
	 * </p>
	 * <p>
	 * Description: 将mysql 数据查出组装成es需要的map格式，通过批量写入es中
	 * </p>
	 * @param tableName
	 */
	public void writeMysqlDataToES(String tableName) {
		RestHighLevelClient client = esUtil.client;
		BulkProcessor bulkProcessor = getBulkProcessor(client);

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBHelper.getConn();
			logger.info("Start handle data :" + tableName);

			String sql = "SELECT * from company" ;

			ps = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ps.setFetchSize(Integer.MIN_VALUE);
			rs = ps.executeQuery();

			ResultSetMetaData colData = rs.getMetaData();

			ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();

			HashMap<String, String> map = null;
			int count = 0;
			String c = null;
			String v = null;
			 BulkRequest request = new BulkRequest();
			while (rs.next()) {
				count++;
				map = new HashMap<String, String>(100);
				for (int i = 1; i <= colData.getColumnCount(); i++) {
					c = colData.getColumnName(i);
					v = rs.getString(c);
					map.put(lineToHump(c), v);
				}
				dataList.add(map);
				// 每20锟斤拷锟斤拷写一锟轿ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷蔚锟斤拷锟斤拷锟斤拷一锟斤拷锟结交
				if (count % 200000 == 0) {
					logger.info("Mysql handle data number : " + count);
					// 写锟斤拷ES
					for (HashMap<String, String> hashMap2 : dataList) {
						 bulkProcessor.add(new IndexRequest(tableName).id(hashMap2.get("companyId")).source(JSON.toJSONString(hashMap2),XContentType.JSON));
					}
				     client.bulk(request, RequestOptions.DEFAULT);
				     
					// 每锟结交一锟轿便将map锟斤拷list锟斤拷锟�
					map.clear();
					dataList.clear();
				}
			}
			// count % 200000 锟斤拷锟斤拷未锟结交锟斤拷锟斤拷锟斤拷
			for (HashMap<String, String> hashMap2 : dataList) {
				bulkProcessor.add(new IndexRequest(tableName).id(hashMap2.get("companyId")).source(JSON.toJSONString(hashMap2),
						XContentType.JSON));
			}
		    client.bulk(request, RequestOptions.DEFAULT);
			logger.info("-------------------------- Finally insert number total : " + count);
            // 锟斤拷锟斤拷锟斤拷刷锟铰碉拷es, 注锟斤拷锟斤拷一锟斤拷执锟叫后并诧拷锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷取锟斤拷锟斤拷bulkProcessor锟斤拷锟矫碉拷刷锟斤拷时锟斤拷
			bulkProcessor.flush();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
				boolean terminatedFlag = bulkProcessor.awaitClose(150L, TimeUnit.SECONDS);
//				client.close();
				logger.info(terminatedFlag);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	private static BulkProcessor getBulkProcessor(RestHighLevelClient client) {

		BulkProcessor bulkProcessor = null;
		try {

			BulkProcessor.Listener listener = new BulkProcessor.Listener() {
				@Override
				public void beforeBulk(long executionId, BulkRequest request) {
					logger.info("Try to insert data number : " + request.numberOfActions());
				}

				@Override
				public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
					logger.info("************** Success insert data number : " + request.numberOfActions() + " , id: "
							+ executionId);
				}

				@Override
				public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
					logger.error("Bulk is unsuccess : " + failure + ", executionId: " + executionId);
				}
			};

			BiConsumer<BulkRequest, ActionListener<BulkResponse>> bulkConsumer = (request, bulkListener) -> client
					.bulkAsync(request, RequestOptions.DEFAULT, bulkListener);

			BulkProcessor.Builder builder = BulkProcessor.builder(bulkConsumer, listener);
			builder.setBulkActions(10000);
			builder.setBulkSize(new ByteSizeValue(300L, ByteSizeUnit.MB));
			builder.setConcurrentRequests(10);
			builder.setFlushInterval(TimeValue.timeValueSeconds(100L));
			builder.setBackoffPolicy(BackoffPolicy.constantBackoff(TimeValue.timeValueSeconds(1L), 3));
			// 注锟斤拷悖猴拷锟斤拷锟斤拷锟叫撅拷锟叫碉拷樱锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟矫伙拷锟斤拷锟揭伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟揭皇憋拷锟斤拷锟揭裁蛔拷猓拷诘锟斤拷锟绞弊拷饪达拷欧锟斤拷郑锟斤拷锟斤拷锟斤拷builder锟斤拷锟矫碉拷锟斤拷锟斤拷没锟斤拷锟斤拷效
			bulkProcessor = builder.build();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				bulkProcessor.awaitClose(100L, TimeUnit.SECONDS);
				client.close();
			} catch (Exception e1) {
				logger.error(e1.getMessage());
			}

		}
		return bulkProcessor;
	}
	 /** 下划线转驼峰 */
	  public static String lineToHump(String str) {
		  StringBuilder builder = new StringBuilder();
		  List<String> dataList = Arrays.asList(str.split("_"));
		  for (int i = 0; i < dataList.size(); i++) {
			  String temp=dataList.get(i);
			  if(i>0)
				  builder.append(StringUtils.capitalize(temp));
			  else
				  builder.append(StringUtils.trim(temp));
			}
/*		  Arrays.asList(str.split("_")).forEach(
	                Integer index = Arrays.IndexOf(temp);
				  temp -> builder.append(StringUtils.capitalize(temp)));*/
		  return builder.toString();
	 }
}
