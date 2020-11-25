# nacos-demo

> 该demo是将SpringCloud项目接入Nacos作为注册中心以及配置中心，并且还介绍了OpenFeign的使用。

### 项目结构

- 【nacos-base】
  - 作为依赖包存在，减少其它模块重复引用；
- 【nacos-provider】
  - 在nacos上注册服务，并提供使用；
- 【nacos-consumer】
  - 在nacos上注册服务，消费(RestTemplate+Ribbon服务调用)；
- 【nacos-feign】
  - 服务之间相互调用采用`OpenFeign`，`OpenFeign`自身整合力`Ribbon`和`Hystrix`，为服务调用提供了更优雅的方式；
- 【nacos-config】
  - `spring cloud`项目接入`nacos`作为配置中心，实现动态获取参数；

---

### 项目启动说明

1. 参考官方文档[Nacos快速开始](https://nacos.io/zh-cn/docs/quick-start.html)，启动`nacos server `，访问：`http://localhost:8848/nacos/index.html`，默认账号、密码均为`nacos`可以看到**nacos**后台页面；

2. 调用测试：

   1. 启动【nacos-provider】【nacos-consumer】访问`http://localhost:9528/consumer`可以看到，返回的是`nacos-provider`中的接口`/helloNacos`的返回值；

   2. 启动【nacos-provider】【nacos-feign】访问`http://localhost:9529/feign`可以看到，返回的是`nacos-provider`中的接口`/helloNacos`的返回值；

   3. 启动【nacos-config】，在**nacos**后台页面新建配置：

      ```text
      DataId: nacos-config.yml
      配置格式: YAML
      配置内容: nacos:
      			    config: hello nacos!
      ```

      访问`http://localhost:8080/getValue`，可以读取到配置`hello nacos!`

### 参考资料

[nacos入门](https://blog.csdn.net/qq_33619378/category_9291906.html)
