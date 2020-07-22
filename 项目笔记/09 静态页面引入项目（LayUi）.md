# [LayUi](https://www.layui.com/)

## LayUi入门

* 下载[LAYUI MINI后台管理模板](http://layuimini.99php.cn/)

## 把LAYUI MINI 项目引入本项目
* 把layuimini里的***`api、css、images、js、li、page`***
  文件夹复制到WEB-INF文件夹下
* 在WEB-INF/pages里新建index.jsp并把layuimini里的index.html
  代码拷贝进来

## 新建BaseController

* 在com.gychen.controller文件夹中新建BaseController类

```java
package com.gychen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @RequestMapping("/index")
    public String index() { return "index"; }
}

```

## 添加JSTL和EL依赖（可用来获取路径信息）

* 在pom.xml中添加jstl和el坐标

```
<!-- jstl -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
    </dependency>

    <!-- el -->
    <dependency>
      <groupId>javax.el</groupId>
      <artifactId>javax.el-api</artifactId>
      <version>3.0.0</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.10.4</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.10.4</version>
    </dependency>

    <!-- 分页 -->
    <dependency>
      <groupId>com.github.pagehelper</groupId>
      <artifactId>pagehelper</artifactId>
      <version>5.1.2</version>
    </dependency>

    <!-- jackson时间格式 -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.5</version>
    </dependency>
```

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.gychen</groupId>
  <artifactId>libraryManagerSystem</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

  <name>libraryManagerSystem Maven Webapp</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <spring.version>5.1.3.RELEASE</spring.version>
    <slf4j.version>1.6.6</slf4j.version>
    <log4j.version>1.2.12</log4j.version>
    <mysql.version>8.0.20</mysql.version>
    <mybatis.version>3.4.5</mybatis.version>
  </properties>

  <dependencies>

    <!-- spring -->
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjweaver</artifactId>
      <version>1.6.8</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <!-- 单元测试 -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>compile</scope>
    </dependency>

    <!-- mysql -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>${mysql.version}</version>
    </dependency>

    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
      <scope>provided</scope>
    </dependency>

    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.0</version>
      <scope>provided</scope>
    </dependency>

    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>

    <!-- log start -->
    <dependency>
      <groupId>log4j</groupId>
      <artifactId>log4j</artifactId>
      <version>${log4j.version}</version>
    </dependency>

    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>${slf4j.version}</version>
    </dependency>

    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-log4j12</artifactId>
      <version>${slf4j.version}</version>
    </dependency>
    <!-- log end -->

    <!-- mybatis -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>${mybatis.version}</version>
    </dependency>

    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>1.3.0</version>
    </dependency>

    <dependency>
      <groupId>com.mchange</groupId>
      <artifactId>c3p0</artifactId>
      <version>0.9.5.2</version>
      <type>jar</type>
      <scope>compile</scope>
    </dependency>

    <!-- mybatis逆向工程 -->
    <dependency>
      <groupId>org.mybatis.generator</groupId>
      <artifactId>mybatis-generator-core</artifactId>
      <version>1.3.7</version>
    </dependency>

    <!-- jstl -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
    </dependency>

    <!-- el -->
    <dependency>
      <groupId>javax.el</groupId>
      <artifactId>javax.el-api</artifactId>
      <version>3.0.0</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.10.4</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.10.4</version>
    </dependency>

    <!-- 分页 -->
    <dependency>
      <groupId>com.github.pagehelper</groupId>
      <artifactId>pagehelper</artifactId>
      <version>5.1.2</version>
    </dependency>

    <!-- jackson时间格式 -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.5</version>
    </dependency>

  </dependencies>

  <build>
    <finalName>libraryManagerSystem</finalName>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>

        <!-- mybatis逆向工程 -->
        <plugin>
          <groupId>org.mybatis.generator</groupId>
          <artifactId>mybatis-generator-maven-plugin</artifactId>
          <version>1.3.2</version>
          <configuration>
            <!-- 在控制台打印执行日志 -->
            <verbose>true</verbose>
            <!-- 重复生成时会覆盖之前的文件-->
            <overwrite>true</overwrite>
          </configuration>
        </plugin>

      </plugins>
    </pluginManagement>
  </build>
</project>

```

## 配置springmvc.xml的静态资源开放权限

``` 需要添加的开放权限的文件路径
<!-- 过滤静态资源 开放静态资源访问权限 -->
    <mvc:default-servlet-handler/>
    <!-- 以下文件夹都不过滤 -->
    <mvc:resources mapping="/images/**" location="/images/"/>
    <mvc:resources mapping="/css/**" location="/css/"/>
    <mvc:resources mapping="/js/**" location="/js/"/>
    <mvc:resources mapping="/lib/**" location="/lib/"/>
    <mvc:resources mapping="/api/**" location="/api/"/>

```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/mvc
       http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!-- 开启注解扫描 只扫描controller层 -->
    <context:component-scan base-package="com.gychen.controller">

    </context:component-scan>

    <!-- 配置视图解析器 -->
    <bean id="internalResourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!-- 前缀 -->
        <property name="prefix" value="/WEB-INF/pages/"/>
        <!-- 后缀 -->
        <property name="suffix" value=".jsp"/>
    </bean>


    <!-- 过滤静态资源 开放静态资源访问权限 -->
    <mvc:default-servlet-handler/>
    <!-- 以下文件夹都不过滤 -->
    <mvc:resources mapping="/images/**" location="/images/"/>
    <mvc:resources mapping="/css/**" location="/css/"/>
    <mvc:resources mapping="/js/**" location="/js/"/>
    <mvc:resources mapping="/lib/**" location="/lib/"/>
    <mvc:resources mapping="/api/**" location="/api/"/>


    <!-- 开启springmvc的注解支持 -->
    <mvc:annotation-driven/>

</beans>
```

## 引入jstl标签

* 在WEB-INF/pages/index.jsp里引入jstl标签

``` jstl标签
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

* 获取项目路径和项目其它信息

```
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+
            "://"+request.getServerName()+
            ":"+request.getServerPort()+path+
            "/";
%>
```

* 在index.jsp中把相关路径信息更新

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 获取项目路径和项目其它信息 -->
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+
            "://"+request.getServerName()+
            ":"+request.getServerPort()+path+
            "/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>后台管理系统</title>
    <meta name="keywords" content="layuimini,layui,layui模板,layui后台,后台模板,admin,admin模板,layui mini">
    <meta name="description" content="layuimini基于layui的轻量级前端后台管理框架，最简洁、易用的后台框架模板，面向所有层次的前后端程序,只需提供一个接口就直接初始化整个框架，无需复杂操作。">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="<%=basePath%>images/favicon.ico">
    <link rel="stylesheet" href="<%=basePath%>lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>lib/font-awesome-4.7.0/css/font-awesome.min.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>css/layuimini.css?v=2.0.1" media="all">
    <link rel="stylesheet" href="<%=basePath%>css/themes/default.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>css/public.css" media="all">
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style id="layuimini-bg-color">
    </style>
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">

    <div class="layui-header header">
        <div class="layui-logo layuimini-logo layuimini-back-home"></div>

        <div class="layuimini-header-content">
            <a>
                <div class="layuimini-tool"><i title="展开" class="fa fa-outdent" data-side-fold="1"></i></div>
            </a>

            <!--电脑端头部菜单-->
            <ul class="layui-nav layui-layout-left layuimini-header-menu layuimini-menu-header-pc layuimini-pc-show">
            </ul>

            <!--手机端头部菜单-->
            <ul class="layui-nav layui-layout-left layuimini-header-menu layuimini-mobile-show">
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-list-ul"></i> 选择模块</a>
                    <dl class="layui-nav-child layuimini-menu-header-mobile">
                    </dl>
                </li>
            </ul>

            <ul class="layui-nav layui-layout-right">

                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" data-refresh="刷新"><i class="fa fa-refresh"></i></a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" data-clear="清理" class="layuimini-clear"><i class="fa fa-trash-o"></i></a>
                </li>
                <li class="layui-nav-item mobile layui-hide-xs" lay-unselect>
                    <a href="javascript:;" data-check-screen="full"><i class="fa fa-arrows-alt"></i></a>
                </li>
                <li class="layui-nav-item layuimini-setting">
                    <a href="javascript:;">admin</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" layuimini-content-href="page/user-setting.html" data-title="基本资料" data-icon="fa fa-gears">基本资料<span class="layui-badge-dot"></span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" layuimini-content-href="page/user-password.html" data-title="修改密码" data-icon="fa fa-gears">修改密码</a>
                        </dd>
                        <dd>
                            <hr>
                        </dd>
                        <dd>
                            <a href="javascript:;" class="login-out">退出登录</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item layuimini-select-bgcolor" lay-unselect>
                    <a href="javascript:;" data-bgcolor="配色方案"><i class="fa fa-ellipsis-v"></i></a>
                </li>
            </ul>
        </div>
    </div>

    <!--无限极左侧菜单-->
    <div class="layui-side layui-bg-black layuimini-menu-left">
    </div>

    <!--初始化加载层-->
    <div class="layuimini-loader">
        <div class="layuimini-loader-inner"></div>
    </div>

    <!--手机端遮罩层-->
    <div class="layuimini-make"></div>

    <!-- 移动导航 -->
    <div class="layuimini-site-mobile"><i class="layui-icon"></i></div>

    <div class="layui-body">

        <div class="layui-card layuimini-page-header layui-hide">
            <div class="layui-breadcrumb layuimini-page-title">
                <a lay-href="" href="/">主页</a><span lay-separator="">/</span>
                <a><cite>常规管理</cite></a><span lay-separator="">/</span>
                <a><cite>系统设置</cite></a>
            </div>
        </div>

        <div class="layuimini-content-page">
        </div>

    </div>

</div>
<script src="<%=basePath%>lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="<%=basePath%>js/lay-config.js?v=2.0.0" charset="utf-8"></script>
<script>
    layui.use(['jquery', 'layer', 'miniAdmin', 'miniTongji'], function () {
        var $ = layui.jquery,
            layer = layui.layer,
            miniAdmin = layui.miniAdmin,
            miniTongji = layui.miniTongji;

        var options = {
            iniUrl: "api/init.json",    // 初始化接口
            clearUrl: "api/clear.json", // 缓存清理接口
            renderPageVersion: true,    // 初始化页面是否加版本号
            bgColorDefault: false,      // 主题默认配置
            multiModule: true,          // 是否开启多模块
            menuChildOpen: false,       // 是否默认展开菜单
            loadingTime: 0,             // 初始化加载时间
            pageAnim: true,             // 切换菜单动画
        };
        miniAdmin.render(options);

        // 百度统计代码，只统计指定域名
        miniTongji.render({
            specific: true,
            domains: [
                '99php.cn',
                'layuimini.99php.cn',
                'layuimini-onepage.99php.cn',
            ],
        });

        $('.login-out').on("click", function () {
            layer.msg('退出登录成功', function () {
                window.location = 'page/login-1.html';
            });
        });
    });
</script>
</body>
</html>


```

* 启动Tomcat，在浏览器输入 http://localhost:8080/library/index
  跳出后台管理静态页面
  
## 修改主页左侧的功能导航栏分组

* 在webapp/api/init.json里更改相关信息

```json
{
  "homeInfo": {
    "title": "首页",
    "href": "page/welcome-1.html?t=1"
  },
  "logoInfo": {
    "title": "图书馆管理",
    "image": "images/logo.png",
    "href": ""
  },
  "menuInfo": [
    {
      "title": "功能管理",
      "icon": "fa fa-address-book",
      "href": "",
      "target": "_self",
      "child": [
        {
          "title": "借阅管理",
          "href": "page/table.html",
          "icon": "fa fa-flag",
          "target": "_self"
        },
        {
          "title": "图书管理",
          "href": "page/table.html",
          "icon": "fa fa-gears",
          "target": "_self"
        },
        {
          "title": "读者管理",
          "href": "page/table.html",
          "icon": "fa fa-file-text",
          "target": "_self"
        },
        {
          "title": "类型管理",
          "href": "page/type.html",
          "icon": "fa fa-spotify",
          "target": "_self"
        },
        {
          "title": "公告管理",
          "href": "page/table.html",
          "icon": "fa fa-window-maximize",
          "target": "_self"
        }
      ]
    },

    {
      "title": "统计分析",
      "icon": "fa fa-slideshare",
      "href": "",
      "target": "_self",
      "child": [
        {
          "title": "图标列表",
          "href": "page/icon.html",
          "icon": "fa fa-dot-circle-o",
          "target": "_self"
        },
        {
          "title": "图标选择",
          "href": "page/icon-picker.html",
          "icon": "fa fa-adn",
          "target": "_self"
        },
        {
          "title": "颜色选择",
          "href": "page/color-select.html",
          "icon": "fa fa-dashboard",
          "target": "_self"
        },
        {
          "title": "下拉选择",
          "href": "page/table-select.html",
          "icon": "fa fa-angle-double-down",
          "target": "_self"
        },
        {
          "title": "文件上传",
          "href": "page/upload.html",
          "icon": "fa fa-arrow-up",
          "target": "_self"
        },
        {
          "title": "富文本编辑器",
          "href": "page/editor.html",
          "icon": "fa fa-edit",
          "target": "_self"
        },
        {
          "title": "省市县区选择器",
          "href": "page/area.html",
          "icon": "fa fa-rocket",
          "target": "_self"
        }
      ]
    },
    {
      "title": "其它管理",
      "icon": "fa fa-slideshare",
      "href": "",
      "target": "_self",
      "child": [
        {
          "title": "多级菜单",
          "href": "",
          "icon": "fa fa-meetup",
          "target": "",
          "child": [
            {
              "title": "按钮1",
              "href": "page/button.html?v=1",
              "icon": "fa fa-calendar",
              "target": "_self",
              "child": [
                {
                  "title": "按钮2",
                  "href": "page/button.html?v=2",
                  "icon": "fa fa-snowflake-o",
                  "target": "_self",
                  "child": [
                    {
                      "title": "按钮3",
                      "href": "page/button.html?v=3",
                      "icon": "fa fa-snowflake-o",
                      "target": "_self"
                    },
                    {
                      "title": "表单4",
                      "href": "page/form.html?v=1",
                      "icon": "fa fa-calendar",
                      "target": "_self"
                    }
                  ]
                }
              ]
            }
          ]
        },
        {
          "title": "失效菜单",
          "href": "page/error.html",
          "icon": "fa fa-superpowers",
          "target": "_self"
        }
      ]
    }
  ]
}
```
