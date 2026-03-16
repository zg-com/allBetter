package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.SysMenu;
import com.learningmplat.backend.service.SysMenuService;
import com.learningmplat.backend.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author 13027
* @description 针对表【sys_menu(菜单与权限控制表)】的数据库操作Service实现
* @createDate 2026-03-16 13:41:11
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService{

}




