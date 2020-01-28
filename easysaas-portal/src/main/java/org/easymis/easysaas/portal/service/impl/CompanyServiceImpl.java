package org.easymis.easysaas.portal.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.easymis.easysaas.portal.config.ElasticSearchConfig;
import org.easymis.easysaas.portal.config.EsEntity;
import org.easymis.easysaas.portal.entitys.mybatis.dto.Company;
import org.easymis.easysaas.portal.entitys.mybatis.mapper.CompanyMapper;
import org.easymis.easysaas.portal.service.CompanyService;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private ElasticSearchConfig esUtil;
    @Autowired
    private CompanyMapper mapper;
    
	@Override
	public Company getById(String id) {
		return mapper.findById(id);
/*        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(new TermQueryBuilder("id", id));
        List<Company> res = esUtil.search(ElasticSearchConfig.INDEX_NAME, builder, Company.class);
        if (res.size() > 0) {
            return res.get(0);
        } else {
            return null;
        }*/
    }

	@Override
	public List<Company> getAll() {
        return esUtil.search(ElasticSearchConfig.INDEX_NAME, new SearchSourceBuilder(), Company.class);
        
        }

	@Override
	public List<Company> search(String content) {
		BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
		// boolQueryBuilder.must(QueryBuilders.termQuery("userId", userId));
		boolQueryBuilder.must(QueryBuilders.matchQuery("name", content));
		SearchSourceBuilder builder = new SearchSourceBuilder();
		builder.size(10).query(boolQueryBuilder);
		return esUtil.search(ElasticSearchConfig.INDEX_NAME, builder, Company.class);

	}

	@Override
	public void insert(String id) {
		Company bean = mapper.findById(id);
        EsEntity<Company> entity = new EsEntity<>(bean.getId(), bean);
        esUtil.insertOrUpdateOne(ElasticSearchConfig.INDEX_NAME, entity);
    }

	@Override
	public void insert() {
		long startTime = System.currentTimeMillis();
		BulkProcessImpl bulk = new BulkProcessImpl();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBHelper.getConn();
			log.info("Start handle data :company");

			String sql = "SELECT * from " + "company";

			ps = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ps.setFetchSize(Integer.MIN_VALUE);
			rs = ps.executeQuery();

			ResultSetMetaData colData = rs.getMetaData();

			ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();

			HashMap<String, String> map = null;
			int count = 0;
			String c = null;
			String v = null;
			while (rs.next()) {
				count++;
				map = new HashMap<String, String>(100);
				for (int i = 1; i <= colData.getColumnCount(); i++) {
					c = colData.getColumnName(i);
					v = rs.getString(c);
					map.put(c, v);
				}
				dataList.add(map);
				// 写入ES
				if (count % 200000 == 0) {
					log.info("Mysql handle data number : " + count);
					// 写锟斤拷ES
					for (HashMap<String, String> hashMap2 : dataList) {
						Company bean = new Company();
						bean.setId(hashMap2.get("id"));
						bean.setName(hashMap2.get("name"));
				        EsEntity<Company> entity = new EsEntity<>(bean.getId(), bean);
				        esUtil.insertOrUpdateOne(ElasticSearchConfig.INDEX_NAME, entity);
					}
					// 每提交一次便将map与list清空
					map.clear();
					dataList.clear();
				}
			}

			// count % 200000 处理未提交的数据
			for (HashMap<String, String> hashMap2 : dataList) {
				Company bean = new Company();
				bean.setId(hashMap2.get("id"));
				bean.setName(hashMap2.get("name"));
				EsEntity<Company> entity = new EsEntity<>(bean.getId(), bean);
				esUtil.insertOrUpdateOne(ElasticSearchConfig.INDEX_NAME, entity);
			}

			log.info("-------------------------- Finally insert number total : " + count);
			// 将数据刷新到es, 注意这一步执行后并不会立即生效，取决于bulkProcessor设置的刷新时间

			
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	
		log.info(" use time: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
	}
	@Override
	public void save(List<Company> beans) {
        List<EsEntity> list = new ArrayList<>();
        beans.forEach(item -> list.add(new EsEntity<>(item.getId().toString(), item)));
        esUtil.insertBatch(ElasticSearchConfig.INDEX_NAME, list);
    }

	@Override
	public void deleteBatch(List<String> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest(ElasticSearchConfig.INDEX_NAME, id));
        try {
        	esUtil.client.bulk(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

	}


}
