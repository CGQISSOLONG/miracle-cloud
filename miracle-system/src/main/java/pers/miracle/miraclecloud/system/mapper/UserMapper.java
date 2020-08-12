package pers.miracle.miraclecloud.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.miracle.miraclecloud.system.entity.User;

import java.util.List;

/**
 * @author: 蔡奇峰
 * @date: 2020/8/10 下午4:57
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户
     *
     * @param user
     * @return
     */
    List<User> listByUser(User user);

    /**
     * 用户精确查询
     *
     * @param userName
     * @param password
     * @return
     */
    User getOne(@Param("userName") String userName, @Param("password") String password);
}
