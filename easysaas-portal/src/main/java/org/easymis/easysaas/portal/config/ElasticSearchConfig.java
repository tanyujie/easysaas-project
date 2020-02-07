package org.easymis.easysaas.portal.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.easymis.easysaas.portal.entitys.bean.EsEntity;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;
/**
 * 
　 * <p>Title: ElasticSearchConfig</p>
　 * <p>Description: 实现ElasticSearch初始化配置信息</p>
　 * @author 谭宇杰
　 * @date 2019年12月1日
 */
@Configuration
public class ElasticSearchConfig {


    @Value("${spring.elasticsearch.host}")
    public String host;
    @Value("${spring.elasticsearch.port}")
    public int port;
    @Value("${spring.elasticsearch.scheme}")
    public String scheme;

    public static final String INDEX_NAME = "company-index";
    
    public static final String INDEX_NAME_DISHONEST = "dishonest-index";
    public static final String CREATE_INDEX = "{\n" +
            "    \"properties\": {\n" +
            "      \"companyId\":{\n" +
            "        \"type\":\"text\"\n" +
            "      },\n" +
            "      \"companyName\":{\n" +
            "        \"type\":\"text\",\n" +
            "        \"analyzer\": \"ik_max_word\",\n" +
            "        \"search_analyzer\": \"ik_smart\"\n" +
            "      },\n" +
            "      \"url\":{\n" +
            "        \"type\":\"text\",\n" +
            "        \"index\": true,\n" +
            "        \"analyzer\": \"ik_max_word\",\n" +
            "        \"search_analyzer\": \"ik_smart\"\n" +
            "      }\n" +
            "    }\n" +
            "  }";

    public static RestHighLevelClient client = null;


    @PostConstruct
    public void init() {
        try {
            if (client != null) {
                client.close();
            }
            //初始化ES操作客户端
            final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY,
                    new UsernamePasswordCredentials("elastic", "123456"));  //es账号密码

            //client = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, scheme)));
            client = new RestHighLevelClient(RestClient.builder(
                            new HttpHost(host,port)
                            ).setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
                                public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                                    httpClientBuilder.disableAuthCaching();
                                    return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                                }
                            })
            		);
            CreateIndexRequest request;
            if (this.indexExist(INDEX_NAME)) {
                //DeleteIndexRequest deleteIndexRequest= new DeleteIndexRequest(INDEX_NAME);
                //client.indices().delete(deleteIndexRequest,  RequestOptions.DEFAULT);
                //return;
            }else {
                request = new CreateIndexRequest(INDEX_NAME);
                request.settings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 2));
                //request.mapping(CREATE_INDEX, XContentType.JSON);
                request.mapping(buildIndexMapping(),XContentType.JSON);
            }
            //查老赖索引
            if (this.indexExist(INDEX_NAME_DISHONEST)) {
                //DeleteIndexRequest deleteIndexRequest= new DeleteIndexRequest(INDEX_NAME_DISHONEST);
                //client.indices().delete(deleteIndexRequest,  RequestOptions.DEFAULT);
                return;
            }else {
            	 request = new CreateIndexRequest(INDEX_NAME_DISHONEST);
            	 request.mapping(buildIndexDishonestMapping(),XContentType.JSON);
            }

            CreateIndexResponse res = client.indices().create(request, RequestOptions.DEFAULT);
            
            if (!res.isAcknowledged()) {
                throw new RuntimeException("初始化失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Description: 判断某个index是否存在
     *
     * @param index index名
     * @return boolean
     * @author 谭宇杰
     * @date 2019/7/24 14:57
     */
    public boolean indexExist(String index) throws Exception {
        GetIndexRequest request = new GetIndexRequest(index);
        request.local(false);
        request.humanReadable(true);
        request.includeDefaults(false);
        return client.indices().exists(request, RequestOptions.DEFAULT);
    }

    /**
     * Description: 插入/更新一条记录
     *
     * @param index  index
     * @param entity 对象
     * @author 谭宇杰
     * @date 2019/7/24 15:02
     */
    public void insertOrUpdateOne(String index, EsEntity entity) {
        IndexRequest request = new IndexRequest(index);
        request.id(entity.getId());
        request.source(JSON.toJSONString(entity.getData()), XContentType.JSON);
        try {
            client.index(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Description: 批量插入数据
     *
     * @param index index
     * @param list  带插入列表
     * @author 谭宇杰
     * @date 2019/7/24 17:38
     */
    public void insertBatch(String index, List<EsEntity> list) {
        BulkRequest request = new BulkRequest();
        list.forEach(item -> request.add(new IndexRequest(index).id(item.getId())
                .source(JSON.toJSONString(item.getData()), XContentType.JSON)));
        try {
            client.bulk(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Description: 批量删除
     *
     * @param index  index
     * @param idList 待删除列表
     * @author 谭宇杰
     * @date 2019/7/25 14:24
     */
    public <T> void deleteBatch(String index, Collection<T> idList) {
        BulkRequest request = new BulkRequest();
        idList.forEach(item -> request.add(new DeleteRequest(index, item.toString())));
        try {
            client.bulk(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Description: 搜索
     *
     * @param index   index
     * @param builder 查询参数
     * @param c       结果类对象
     * @return java.util.ArrayList
     * @author 谭宇杰
     * @date 2019/7/25 13:46
     */
    public <T> List<T> search(String index, SearchSourceBuilder builder, Class<T> c) {
        SearchRequest request = new SearchRequest(index);
        request.source(builder);
        try {
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            List<T> res = new ArrayList<>(hits.length);
            for (SearchHit hit : hits) {
                res.add(JSON.parseObject(hit.getSourceAsString(), c));
            }
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Description: 删除index
     *
     * @param index index
     * @return void
     * @author 谭宇杰
     * @date 2019/7/26 11:30
     */
    public void deleteIndex(String index) {
        try {
            client.indices().delete(new DeleteIndexRequest(index), RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Description: delete by query
     *
     * @param index   index
     * @param builder builder
     * @author 谭宇杰
     * @date 2019/7/26 15:16
     */
    public void deleteByQuery(String index, QueryBuilder builder) {
        DeleteByQueryRequest request = new DeleteByQueryRequest(index);
        request.setQuery(builder);
        //设置批量操作数量,最大为10000
        request.setBatchSize(10000);
        request.setConflicts("proceed");
        try {
            client.deleteByQuery(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	/**
	 * 
	 * <p>
	 * Title: buildIndexMapping
	 * </p>
	 * <p>
	 * Description: 设置index的mapping
	 * </p>
	 * @param request
	 */
	public String buildIndexMapping() {
		Map<String, Object> jsonMap = new HashMap<>();
		Map<String, Object> name = new HashMap<>();
		name.put("type", "text");
		name.put("analyzer", "ik_max_word");
		name.put("search_analyzer", "ik_max_word");
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("companyName", name);
		Map<String, Object> indexMapping = new HashMap<>();
		indexMapping.put("properties", properties);
		//jsonMap.put("books", book);
		return  JSON.toJSONString(indexMapping);

	}
	public String buildIndexDishonestMapping() {
		Map<String, Object> jsonMap = new HashMap<>();
		Map<String, Object> name = new HashMap<>();
		name.put("type", "text");
		name.put("analyzer", "ik_max_word");
		name.put("search_analyzer", "ik_max_word");
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("name", name);
		Map<String, Object> indexMapping = new HashMap<>();
		indexMapping.put("properties", properties);
		//jsonMap.put("books", book);
		return  JSON.toJSONString(indexMapping);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElasticSearchConfig esc= new ElasticSearchConfig();
		System.out.print(esc.buildIndexMapping());
	}

}
