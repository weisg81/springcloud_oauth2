package pers.weisg.cloud.api.services;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component // 不要忘记添加，不要忘记添加
public class UserClientServiceFallbackFactory implements FallbackFactory<UserClientService> {
    public UserClientService create(Throwable throwable) {
        return  null;
    }
}
