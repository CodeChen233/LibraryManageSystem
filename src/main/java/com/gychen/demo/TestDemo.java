//package com.gychen.demo;
//
//import com.gychen.service.ClassInfoService;
//import org.junit.Test;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class TestDemo {
//
//    @Test
//    public void testSpring(){
//        // 获取spring容器
//        ClassPathXmlApplicationContext app =
//                new ClassPathXmlApplicationContext("spring.xml");
//
//        // 获取bean
//        ClassInfoService infoService = (ClassInfoService) app.getBean("classInfoService");
//        infoService.queryClassInfoAll("");
//    }
//}
