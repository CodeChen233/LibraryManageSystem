# 整合spring

## 1、新建ClassInfo实体类

* 根据数据库中的class_info表字段，在com.gychen.po里新建ClassInfo

```java
package com.gychen.po;

import java.io.Serializable;

public class ClassInfo implements Serializable {

    private Integer id;
    private String name;
    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

```

## 2、新建ClassInfoDao接口

* 在com.gychen.po里新建ClassInfoDao接口

```java
package com.gychen.dao;

import com.gychen.po.ClassInfo;
import java.util.List;

public interface ClassInfoDao {
    /**
     * 查询所有图书类型信息
     */
    List<ClassInfo> queryClassInfoAll();

}

```

## 3、新建ClassInfoService接口及其实现类

* 在com.gychen.service中新建ClassInfoService

```java
package com.gychen.service;

import com.gychen.po.ClassInfo;

import java.util.List;

public interface ClassInfoService {
    /**
     * 查询所有的图书类型信息
     */
    List<ClassInfo> queryClassInfoAll();
}

```

* 在com.gychen.service中新建ClassInfoServiceImpl

```java
package com.gychen.service;

import com.gychen.po.ClassInfo;

import java.util.List;

public class ClassInfoServiceImpl implements ClassInfoService {

    @Override
    public List<ClassInfo> queryClassInfoAll() {
        // 没有连接数据库，以打印控制台代替
        System.out.println("查询到了所有的图书类型.......");
        return null;
    }
}

```

## 4、配置spring相关配置文件

* 在resources文件夹下新建spring.xml

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


    <!-- 开启注解扫描 处理service层和dao层 controller层不处理-->
    <context:component-scan base-package="com.gychen">
        <!-- 配置不扫描的 -->
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>



</beans>
```

* 给ClassInfoServiceImpl中的类加上注解

```java
package com.gychen.service;

import com.gychen.po.ClassInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("classInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {

    @Override
    public List<ClassInfo> queryClassInfoAll() {
        // 没有连接数据库，以打印控制台代替
        System.out.println("查询到了所有的图书类型.......");
        return null;
    }
}

```

## 5、新建测试

* 在com.gychen.demo里新建TestDemo类

```java
package com.gychen.demo;

import com.gychen.service.ClassInfoService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    @Test
    public void testSpring(){
        // 获取spring容器
        ClassPathXmlApplicationContext app =
                new ClassPathXmlApplicationContext("spring.xml");

        // 获取bean
        ClassInfoService infoService = (ClassInfoService) app.getBean("classInfoService");
        infoService.queryClassInfoAll();
    }
}

```

* 点击测试得到打印结果，表明spring在本项目中可以正常工作，
  保证spring独立执行