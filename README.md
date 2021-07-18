# dubbo-triple(grpc)-demo

## 环境

- dubbo 3.0.1
- grpc 1.36.0
- spring boot 2.3.9.RELEASE
- net.devh:grpc-client-spring-boot-starter:2.12.0.RELEASE

## 项目结构

### dubbo-proto-lib

编写 proto 文件编译 dubbo 和 grpc 的 stub

使用时需要先`mvn clean install`安装到本地

> 使用 maven 进行编译
>- 因为 gradle 的 grpc 插件暂时还不能指定 `mainClass` https://github.com/google/protobuf-gradle-plugin/issues/455

### provider-demo

dubbo 实现的生产者 使用 triple 协议,
使用 dubbo 的 stub 进行调用

### consumer-demo

dubbo 实现的消费者 使用 triple 协议,使用 dubbo 的 stub 进行调用

### grpc-consumer-demo

原生 grpc 的消费者，使用 grpc 插件默认生成的 stub 进行调用


