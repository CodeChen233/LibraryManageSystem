# 整合mybatis

## 配置数据源文件jdbc.properties

* 在sources里新建jdbc.properties

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/library?serverTimezone=GMT%2B8
jdbc.username=root
jdbc.password=1996chen
```

## 配置SqlMapConfig.xml

* 在sources里新建SqlMapConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd//mybatis-3-config.dtd">


<configuration>
    

    <!-- 定义别名 -->
    <typeAliases>
        <!--        <typeAlias type="com.gychen.po.ClassInfo" alias="classInfo"/>-->
        <!-- 或者扫包 po下的所有类都有别名 -->
        <package name="com.gychen.po"/>
    </typeAliases>



</configuration>
```

## 配置spring.xml

* 在spring.xml中配置mybatis相关

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 加载数据库jdbc.properties文件 -->
    <context:property-placeholder location="classpath:jdbc.properties"/>


    <!-- 开启注解扫描 处理service层和dao层 controller层不处理-->
    <context:component-scan base-package="com.gychen">
        <!-- 配置不扫描的 -->
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>


    <!-- 配置数据源信息 -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driver}"/>
        <property name="jdbcUrl" value="${jdbc.url}"/>
        <property name="user" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <!-- 配置mybatis的session工厂 -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!-- 配置数据源 -->
        <property name="dataSource" ref="dataSource"/>
        <!-- 加载mybatis全局配置文件 -->
        <property name="configLocation" value="classpath:SqlMapConfig.xml"/>
    </bean>
    
    <!-- 配置mapper相关扫描器 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.gychen.dao"/>
    </bean>



</beans>
```

# 测试SSM整合

## 测试spring-springmvc-mybatis整合情况

* 改写com.gychen.dao.ClassInfoDao

```java
package com.gychen.dao;

import com.gychen.po.ClassInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("classDao")
public interface ClassInfoDao {
    /**
     * 查询所有图书类型信息
     */
    @Select("select * from class_info")
    List<ClassInfo> queryClassInfoAll();

}

```

* 在ClassInfoServiceImpl中调用Dao层中的查询方法

```java
package com.gychen.service;

import com.gychen.dao.ClassInfoDao;
import com.gychen.po.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("classInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {

    @Autowired
    private ClassInfoDao classDao;

    @Override
    public List<ClassInfo> queryClassInfoAll() {

        // 没有连接数据库，以打印控制台代替
        System.out.println("查询到了所有的图书类型.......");

        // 已经配置了数据库
        System.out.println("获取图书类型记录数为："+classDao.queryClassInfoAll().size());
        List<ClassInfo> classInfos = classDao.queryClassInfoAll();
        for (ClassInfo classInfo : classInfos) {
            System.out.println(classInfo);
        }

        return null;
    }
}

```

* 在TestController里新建测试方法

```java
package com.gychen.controller;

import com.gychen.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    private ClassInfoService classInfoService;

    @RequestMapping("/test")
    public String testIndex(){
        System.out.println("测试springmvc内容");
        return "test";
    }

    @RequestMapping("/test01")
    public String testSpring(){
        classInfoService.queryClassInfoAll();
        System.out.println("测试spring和springmvc整合");
        return "test01";
    }

    @RequestMapping("/test02")
    public String testSSM(){
        classInfoService.queryClassInfoAll();
        System.out.println("测试SSM整合");
        return "test02";
    }
}

```

* 在pages里新建test02.jsp

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSM整合测试</title>
</head>
<body>
    SSM整合测试
</body>
</html>
```

* 开启服务器，输入
  http://localhost:8080/library/test02
  出现结果，表明SSM整合成功