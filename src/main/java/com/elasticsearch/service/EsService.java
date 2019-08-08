package com.elasticsearch.service;

import com.elasticsearch.module.Item;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>EsService  Class</h3>
 *
 * @author : YuXiang
 * @date : 2019-08-08 10:26
 **/
@Service
public class EsService {
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Resource
    private ItemRepository itemRepository;
    public void test(){
        //创建索引api
//        elasticsearchTemplate.createIndex(Item.class);

        //映射api
        //elasticsearchTemplate.putMapping();

        //删除索引api
        //elasticsearchTemplate.deleteIndex();

        Item item=new Item();
        item.setId(1L);
        item.setTitle("小米手机1");
        item.setCategory("手机");
        item.setBrand("小米");
        item.setPrice(3599.00);
        item.setImages("http://f.hiphotos.baidu.com/image/pic/item/0e2442a7d933c8956c0e8eeadb1373f08202002a.jpg");
        itemRepository.save(item);
    }

    public void test1(){
        List<Item> list = new ArrayList<>();
        Item item=new Item();
        item.setId(1L);
        item.setTitle("小米手机1");
        item.setCategory("手机");
        item.setBrand("小米");
        item.setPrice(3599.00);
        item.setImages("http://f.hiphotos.baidu.com/image/pic/item/0e2442a7d933c8956c0e8eeadb1373f08202002a.jpg");

        Item item1=new Item();
        item1.setId(2L);
        item1.setTitle("小米手机2");
        item1.setCategory("手机");
        item1.setBrand("小米");
        item1.setPrice(3499.00);
        item1.setImages("http://f.hiphotos.baidu.com/image/pic/item/0e2442a7d933c8956c0e8eeadb1373f08202002a.jpg");

        list.add(item);
        list.add(item1);
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }

    public void update(){
        //elasticsearch中本没有修改，它的修改原理是该是先删除在新增,修改和新增是同一个接口，区分的依据就是id
        Item item=new Item();
        item.setId(1L);
        item.setTitle("小米手机99");
        item.setCategory("手机");
        item.setBrand("小米");
        item.setPrice(3599.00);
        item.setImages("http://f.hiphotos.baidu.com/image/pic/item/0e2442a7d933c8956c0e8eeadb1373f08202002a.jpg");
        itemRepository.save(item);
    }


    public void query(){
        // 查找所有
        //Iterable<Item> list = this.itemRepository.findAll();
        // 对某字段排序查找所有 Sort.by("price").descending() 降序
        // Sort.by("price").ascending():升序
        Iterable<Item> list = itemRepository.findAll(Sort.by("price").ascending());

        for (Item item:list){
            System.err.println(item);
        }
    }
}
