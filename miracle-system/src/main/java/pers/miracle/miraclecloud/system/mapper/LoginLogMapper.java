package pers.miracle.miraclecloud.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import pers.miracle.miraclecloud.system.entity.LoginLog;

/**
 * @author cqf
 */
public interface LoginLogMapper extends BaseMapper<LoginLog> {
    int deleteByPrimaryKey(Long id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
}