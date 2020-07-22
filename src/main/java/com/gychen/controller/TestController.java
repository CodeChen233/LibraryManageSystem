//package com.gychen.controller;
//
//import com.gychen.service.ClassInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class TestController {
//
//    @Autowired
//    private ClassInfoService classInfoService;
//
//    @RequestMapping("/test")
//    public String testIndex(){
//        System.out.println("测试springmvc内容");
//        return "test";
//    }
//
//    @RequestMapping("/test01")
//    public String testSpring(){
//        classInfoService.queryClassInfoAll("文学");
//        System.out.println("测试spring和springmvc整合");
//        return "test01";
//    }
//
//    @RequestMapping("/test02")
//    public String testSSM(){
//        classInfoService.queryClassInfoAll("文学");
//        System.out.println("测试SSM整合");
//        return "test02";
//    }
//}
