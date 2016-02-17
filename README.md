# SpringBootService
this is Spring Boot Service Project skeleton template.Include redis,rabbitmq,jersey restful,timing ,mybatis.The structure of the easy expansion, easy maintenance </br>
这是一个spring boot微服务的框架，包括redis，mq，restful，定时器，mybabit。易扩容、易维护的架构。</br>

# 项目说明
* 该项目使用maven进行管理,可直接在maven projects下Plugins的spring-boot中运行.切记勿忘数据库的配置。 </br>

# 快速开发的服务模版说明
![](https://raw.githubusercontent.com/orange1438/SpringBootService/master/Frame.jpg) </br>
1.restful,远程调用接口使用，可供前端或者其他服务调用；</br>
2.逻辑服务层：对远程调用作逻辑处理。</br>
3.redis：缓存系统，3.0以上版本可配置集群。</br>
4.rabbitmq：消息中间件（如果不喜欢这个MQ，可替换，不改变框架）。</br>
5.mybabit && mysql：数据库，可配置集群</br>

# 如何做到快速开发呢？
举例说明：</br>一个网上购物购物系统，可以把各个功能模块拆分如下：</br>
1.用户服务：提供用户信息，只操作用户的数据表。</br>
2.订单服务：只操作订单相关的表。</br>
3.支付服务：只操作与金额相关的表，以及银行支付接口。</br>
4.。。。。。、。（其他服务略）</br>
SpringBootService正是把以上各个服务可以单独的拆分独立运行，各个服务的通讯，目前框架采用的是MQ和restful。如果QPS量大了，可以把相同的服务多开几个，用nginx来实现负载均衡。如果redis不行了？集群。mysql不行了？集群。MQ不行了？集群。