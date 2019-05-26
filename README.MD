
这是一套基于spring-cloud的购物商城系统目前定义的模块有
- comment-service :评论系统
- oauth-service : 权限系统,以及用户管理系统
- payment-service : 支付系统
- goods-service : 商品系统
- search-service : 多功能查询系统
- cloud-eureka  :注册中心系统
- cloud-config : 配置中心系统
- cloud-zuul :  服务路由系统

2019年5月20日19:13:21
工作任务计划完成顺序
cloud-zuul-----> cloud-oauth------> order service--->goods service---> payment service---> comment service

分为前台用户系统，和后台商户系统


服务与服务之间是通过接口相互调用的，为了将接口与具体的实现相互解耦，规定 所有api的module 全部存放 接口定义和DTO,
这个时候当其他的系统调用这个api的时候就完全不用知道具体实现方式以及实体类是什么了



有些模块需要用户用户登录验证，但是在有些地方不需要用户登录验证，所以在zuul做负载均衡之后需要做下一步操作

https://github.com/wiselyman/uaa-zuul

https://www.yiibai.com/spring-security/secure-spring-rest-api-using-oauth2.html

http://blog.didispace.com/spring-security-oauth2-xjf-3/