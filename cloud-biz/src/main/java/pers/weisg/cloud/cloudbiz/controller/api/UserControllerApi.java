package pers.weisg.cloud.cloudbiz.controller.api;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import pers.weisg.cloud.cloudbiz.entity.User;
import pers.weisg.cloud.common.core.util.ApiResult;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author weisg
 * @since 2019-02-11
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-11")

@Api(value = "api", description = "The  API")
@RequestMapping("/user")
public interface UserControllerApi{

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return User
    */
    @ApiOperation(value = "通过ID查询", nickname = "通过ID查询", notes = "通过ID查询", response = ApiResult.class, tags = {
            "api", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class),
            @ApiResponse(code = 400, message = "Invalid service supplied"),
            @ApiResponse(code = 404, message = "request not found") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "通过ID查询", required = true, dataType = "String")
    })
    @GetMapping("/{id}")
    public ApiResult<User> get(@PathVariable Integer id) ;

    /**
     * 添加
     * @param  user  实体
     * @return success/false
     */
    @ApiOperation(value = "分页查询信息", nickname = "分页查询信息", notes = "分页查询信息", response = ApiResult.class, tags = {
            "api", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class),
            @ApiResponse(code = 400, message = "Invalid service supplied"),
            @ApiResponse(code = 404, message = "request not found") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "分页查询信息", required = true, dataType = "User")
    })
    @PostMapping
    public ApiResult<Boolean> add(@RequestBody User user);

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @ApiOperation(value = "删除", nickname = "删除", notes = "删除", response = ApiResult.class, tags = {
            "api", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class),
            @ApiResponse(code = 400, message = "Invalid service supplied"),
            @ApiResponse(code = 404, message = "request not found") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除", required = true, dataType = "String")
    })
    @DeleteMapping("/{id}")
    public ApiResult<Boolean> delete(@PathVariable Integer id);

    /**
     * 编辑
     * @param  user  实体
     * @return success/false
     */
    @ApiOperation(value = "编辑", nickname = "编辑", notes = "编辑", response = ApiResult.class, tags = {
            "api", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class),
            @ApiResponse(code = 400, message = "Invalid service supplied"),
            @ApiResponse(code = 404, message = "request not found") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "编辑", required = true, dataType = "User")
    })
    @PutMapping
    public ApiResult<Boolean> edit(@RequestBody User user);
}
