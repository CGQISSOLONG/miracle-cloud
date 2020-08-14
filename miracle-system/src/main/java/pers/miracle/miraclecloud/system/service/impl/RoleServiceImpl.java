package pers.miracle.miraclecloud.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import pers.miracle.miraclecloud.system.entity.Role;
import pers.miracle.miraclecloud.system.mapper.RoleMapper;
import pers.miracle.miraclecloud.system.service.IRoleService;
import pers.miracle.miraclecloud.system.vo.RoleMenuVO;
import java.util.Arrays;


/**
 * @author: 蔡奇峰
 * @date: 2020/8/12 下午4:23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 添加角色并绑定其菜单
     *
     * @param vo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRole(RoleMenuVO vo) {
        save(vo);
        if (!CollectionUtils.isEmpty(vo.getMenus())) {
            roleMapper.bindMenu(vo.getRoleId(), vo.getMenus());
        }
    }

    /**
     * 更新角色及菜单
     *
     * @param roleMenuVo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRole(RoleMenuVO roleMenuVo) {
        updateById(roleMenuVo);

        roleMapper.clearMenu(roleMenuVo.getRoleId());
        if (!CollectionUtils.isEmpty(roleMenuVo.getMenus())) {
            roleMapper.bindMenu(roleMenuVo.getRoleId(), roleMenuVo.getMenus());
        }


    }

    /**
     * 清空角色的菜单
     *
     * @param roleId
     */
    @Override
    public void clearMenu(String roleId) {

        roleMapper.clearMenu(roleId);
    }

    /**
     * 删除角色并清空其菜单
     *
     * @param roleIds
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRole(String[] roleIds) {
        removeByIds(Arrays.asList(roleIds));

        for (String id : roleIds) {
            clearMenu(id);
        }
    }
}
