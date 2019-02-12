package pers.weisg.cloud.cloudbiz.service.impl;

import pers.weisg.cloud.cloudbiz.entity.User;
import pers.weisg.cloud.cloudbiz.mapper.UserMapper;
import pers.weisg.cloud.cloudbiz.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weisg
 * @since 2019-02-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
