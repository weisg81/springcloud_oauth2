package pers.weisg.cloud.api.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.weisg.cloud.api.entities.User;
import pers.weisg.cloud.common.core.util.ApiResult;


/**
 * 
 * @Description: 修改microservicecloud-api工程，根据已经有的DeptClientService接口

新建

一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 * @author zzyy
 * @date 2018年4月21日
 */
@FeignClient(value = "CLOUD-BIZ",fallbackFactory=UserClientServiceFallbackFactory.class)
@RequestMapping("/user")
public interface UserClientService {

    @GetMapping("/{id}")
    public ApiResult<User> get(@PathVariable Integer id) ;
}
