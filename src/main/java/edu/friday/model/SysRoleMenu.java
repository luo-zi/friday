package edu.friday.model;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "sys_role_menu", schema = "friday", catalog = "")
@javax.persistence.IdClass(SysRoleMenuPK.class)
public class SysRoleMenu {
    private long roleId;
    private long menuId;

    @javax.persistence.Id
    @javax.persistence.Column(name = "role_id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @javax.persistence.Id
    @javax.persistence.Column(name = "menu_id")
    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRoleMenu that = (SysRoleMenu) o;
        return roleId == that.roleId &&
                menuId == that.menuId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, menuId);
    }
}
