package com.elasticsearch.module;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * <h3>Item  Class</h3>
 * shards 分片数量 默认5
 * indexName 索引库名称
 * type 对应在索引库中的类型
 * replicas 副本数量 默认1
 *
 *
 *
 * type 字段类型，是枚举 可以是text、long、short、date、integer、object等
 * Text 存储数据时会自动分词，并建立索引
 * keyword 存储数据时，不会分词建立索引
 * index 是否索引 默认是true
 * store 是否存储 默认是false
 * analyzer 分词器类型。这里是下载的ik分词器
 * @author : YuXiang
 * @date : 2019-08-08 10:11
 **/
@Data
@Document(indexName = "item",type = "docs",shards = 1,replicas = 0)
public class Item {
    @Id
    private Long id;
    //标题
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;
    //分类
    @Field(type = FieldType.Keyword)
    private String category;
    //品牌
    @Field(type = FieldType.Keyword)
    private String brand;
    //价格
    @Field(type = FieldType.Double)
    private Double price;
    //图片
    @Field(index = false,type = FieldType.Keyword)
    private String images;
}
