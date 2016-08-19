## gmoni
一个分布式集群监控，采用java和groovy混合编写，全部使用注解配置
agent部署在目标服务器上，采用拉取（http请求的）的方法，关于数据收集采用拉还是推的方式，各有利弊，推的话会复杂一些，但是个人认为状态收集采用推是不必要的。



关于数据的可视化这目前没有完成，计划就是使用thymeleaf和百度的echarts js库。前端这一块比较生疏。

关于quartz在spring中的配置：
[spring-doc:scheduling-quartz](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#scheduling-quartz)
[a demo](http://www.concretepage.com/spring-4/spring-4-quartz-2-scheduler-integration-annotation-example-using-javaconfig)


使用jpa和hibernate-jpa实现：
[组合主键](https://github.com/cexowengui/Java-note/wiki/spring-jpa-%E4%B8%ADcrudRepository%E5%A4%84%E7%90%86%E7%BB%84%E5%90%88%E4%B8%BB%E9%94%AE)


后续还应该加上