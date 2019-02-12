package pers.weisg.cloud.cloudbiz;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import pers.weisg.cloud.common.swagger.annotation.EnableCloudSwagger2;

@EnableCloudSwagger2
//@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
//@EnableCircuitBreaker//对hystrixR熔断机制的支持
//@SpringBootApplication
@SpringCloudApplication
public class CloudBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBizApplication.class, args);
    }

}

