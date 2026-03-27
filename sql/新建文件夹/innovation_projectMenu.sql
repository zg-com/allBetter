-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('大创项目管理', '3', '1', 'innovation_project', 'system/innovation_project/index', 1, 0, 'C', '0', '0', 'system:innovation_project:list', '#', 'admin', sysdate(), '', null, '大创项目管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('大创项目管理查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:innovation_project:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('大创项目管理新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:innovation_project:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('大创项目管理修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:innovation_project:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('大创项目管理删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:innovation_project:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('大创项目管理导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:innovation_project:export',       '#', 'admin', sysdate(), '', null, '');