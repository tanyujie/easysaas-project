package org.easymis.easysaas.open.service;

import java.util.ArrayList;
import java.util.List;

import org.easymis.easysaas.open.config.ElasticSearchConfig;
import org.easymis.easysaas.open.entitys.bean.EsEntity;
import org.easymis.easysaas.open.entitys.mybatis.dto.Company;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/7/29 14:31
 */
@RestController
@RequestMapping("/book")
@Service
public class BookService {

    @Autowired
    private ElasticSearchConfig esUtil;

    /**
     * @param id 获取某一个
     */
    @GetMapping("/{id}")
    public Company getById(@PathVariable("id") int id) {
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(new TermQueryBuilder("id", id));
        List<Company> res = esUtil.search(ElasticSearchConfig.INDEX_NAME, builder, Company.class);
        if (res.size() > 0) {
            return res.get(0);
        } else {
            return null;
        }
    }

    /**
     * 获取全部
     */
    @GetMapping("/")
    public List<Company> getAll() {
        return esUtil.search(ElasticSearchConfig.INDEX_NAME, new SearchSourceBuilder(), Company.class);
    }

    /**
     * 根据关键词搜索某用户下的书
     *
     * @param content 关键词
     */
    @GetMapping("/search")
    public List<Company> searchByUserIdAndName(int userId, String content) {
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.termQuery("userId", userId));
        boolQueryBuilder.must(QueryBuilders.matchQuery("name", content));
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.size(10).query(boolQueryBuilder);
        return esUtil.search(ElasticSearchConfig.INDEX_NAME, builder, Company.class);

    }

    /**
     * 单个插入
     *
     * @param book book
     */
    @PostMapping("/")
    public void putOne( Company book) {
        EsEntity<Company> entity = new EsEntity<>(book.getCompanyId().toString(), book);
        esUtil.insertOrUpdateOne(ElasticSearchConfig.INDEX_NAME, entity);
    }

    /**
     * 批量插入
     *
     * @param books books
     */
    @PutMapping("/many")
    public void putList(@RequestBody List<Company> books) {
        List<EsEntity> list = new ArrayList<>();
        books.forEach(item -> list.add(new EsEntity<>(item.getCompanyId().toString(), item)));
        esUtil.insertBatch(ElasticSearchConfig.INDEX_NAME, list);
    }

    /**
     * 批量删除
     *
     * @param list list
     */
    @DeleteMapping("/deleteBatch")
    public void deleteBatch(List<Integer> list) {
        esUtil.deleteBatch(ElasticSearchConfig.INDEX_NAME, list);
    }

    /**
     * delete by query 根据用户id删除数据
     *
     * @param userId userId
     */
    @DeleteMapping("/userId/{userId}")
    public void deleteByUserId(@PathVariable("userId") int userId) {
        esUtil.deleteByQuery(ElasticSearchConfig.INDEX_NAME, new TermQueryBuilder("userId", userId));
    }


}
