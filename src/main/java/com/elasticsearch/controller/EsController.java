package com.elasticsearch.controller;

import com.elasticsearch.service.EsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <h3>EsController  Class</h3>
 * 如果需要将es和mybatis和mysql结合，还需要安装logStash,用来同步mysql和es的数据
 * @author : YuXiang
 * @date : 2019-08-08 10:40
 **/
@RestController
public class EsController {
    @Resource
    private EsService esService;

    @GetMapping("/test")
    public void test(){
        esService.test();
    }

    @GetMapping("/test1")
    public void test1(){
        esService.test1();
    }

    @GetMapping("/test2")
    public void update(){
        esService.update();
    }

    @GetMapping("/test3")
    public void query(){
        esService.query();
    }
}
