# 项目介绍

本项目是根据多个实战整理的Java项目，技术栈是spring-boot

## 实现的功能

1、mybatis 持久层框架

2、swagger2 API文档框架

3、pagehelper 分页插件

4、mysql驱动

5、ServerResponseJsonResult 返回数据类 

## 小设计

1、把分页的相关方法抽取到BaseService文件

2、接收参数的类取名以BO结尾，返回到前端的数据的类以VO结尾

2、分页有关的参数抽取到BaseBO文件，需要接收分页参数的类继承BaseBO类

3、所有接口的content-type都是'application/json'，接收参数都是对象形式接收（这样做是为了前端统一服装请求接口）
