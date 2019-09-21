
这是一套基于spring-cloud系統
- cloud-comment-service :评论系统
- mall-security-service : 权限系统,以及用户管理系统
- mall-products-service : 商品系统
- cloud-search-service : 多功能查询系统
- cloud-eureka  :注册中心系统
- cloud-config-service : 配置中心系统
- cloud-zuul :  服务路由系统

在common模块封装了基本的MVC类，常用增删改查基本不用写，只需要实现自己特殊的业务场景逻辑代码即可

查询可以使用动态的search参数封装了一下，使用起来还是比较方便的

服务与服务之间是通过接口相互调用的，为了将接口与具体的实现相互解耦，规定 所有api的module 全部存放 接口定义和DTO,
这个时候当其他的系统调用这个api的时候就完全不用知道具体实现方式以及实体类是什么了



有些模块需要用户用户登录验证，但是在有些地方不需要用户登录验证，所以在zuul做负载均衡之后需要做下一步操作


| 使用技术                     | 版本        |
| -------------------------------- | ------------- |
| Spring-cloud                     | Greenwich.SR1 |
| spring-cloud                     | 2.1.4         |
| Spring boot admin                | 2.1.5         |
| spring-social                    | 1.1.6.        |
| spring-data-jpa                  | 2.1.4         |
| spring-data-redis                | 2.1.6         |
| spring-cloud-stream-binder-kafka | 2.1.2         |
| kafka-clients                    | 2.0.1         |
| spring-data-elasticsearch        | 2.1.4         |
| elasticsearch                    | 5.6.16        |
|                                  |               |

各服务之间的端口列表：（尽量满足模块在后期部署的时候集群端口能够连续）

| 模块                     | 端口        |
| -------------------------------- | ------------- |
| cloud-eureka-server              | 8761          |
| cloud-config-service             | 8871          |
| cloud-zuul-service               | 8981          |
| cloud-boot-admin                 | 9091          |
| mall-stream-service              | 9201          |
| mall-security-service            | 9311          |
| mall-products-service            | 9421          |
| mall-voucher-service             | 9531          |
| cloud-search-service             | 9641          |
| cloud-order-service              | 9751          |
| cloud-comment-service            | 9861          |


喜欢的小伙伴可以联系我，共同学习
