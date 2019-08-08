package com.elasticsearch.service;

import com.elasticsearch.module.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
    //Long为实体类主键的数据类型
}
