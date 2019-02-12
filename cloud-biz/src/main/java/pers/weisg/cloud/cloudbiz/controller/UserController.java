package pers.weisg.cloud.cloudbiz.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.weisg.cloud.cloudbiz.controller.api.UserControllerApi;
import pers.weisg.cloud.cloudbiz.entity.User;
import pers.weisg.cloud.cloudbiz.service.UserService;
import pers.weisg.cloud.common.core.util.ApiResult;
import pers.weisg.cloud.common.core.util.ApiResultUtil;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author weisg
 * @since 2019-02-11
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController implements UserControllerApi {
    @Autowired private UserService userService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return User
    */
    @GetMapping("/test/{id}")
    public ApiResult<User> get(@PathVariable Integer id) {
        return ApiResultUtil.ok(userService.getById(id));
    }

    /**
     * 添加
     * @param  user  实体
     * @return success/false
     */
    @PostMapping
    public ApiResult<Boolean> add(@RequestBody User user) {
        return ApiResultUtil.ok(userService.save(user));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public ApiResult<Boolean> delete(@PathVariable Integer id) {
        User user = new User();
        user.setId(null);
        return ApiResultUtil.ok(userService.updateById(user));
    }

    /**
     * 编辑
     * @param  user  实体
     * @return success/false
     */
    @PutMapping
    public ApiResult<Boolean> edit(@RequestBody User user) {
        return ApiResultUtil.ok(userService.updateById(user));
    }
}
