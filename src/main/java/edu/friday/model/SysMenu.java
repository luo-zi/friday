package edu.friday.model;

import java.sql.Timestamp;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "sys_menu", schema = "friday", catalog = "")
public class SysMenu {
    private long menuId;
    private String menuName;
    private Long parentId;
    private Integer orderNum;
    private String path;
    private String component;
    private Integer isFrame;
    private String menuType;
    private String visible;
    private String perms;
    private String icon;
    private String createBy;
    private Timestamp createTime;
    private String updateBy;
    private Timestamp updateTime;
    private String remark;

    @javax.persistence.Id
    @javax.persistence.Column(name = "menu_id")
    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "menu_name")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "parent_id")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "order_num")
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "component")
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "is_frame")
    public Integer getIsFrame() {
        return isFrame;
    }

    public void setIsFrame(Integer isFrame) {
        this.isFrame = isFrame;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "menu_type")
    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "visible")
    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "perms")
    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "create_by")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysMenu sysMenu = (SysMenu) o;
        return menuId == sysMenu.menuId &&
                Objects.equals(menuName, sysMenu.menuName) &&
                Objects.equals(parentId, sysMenu.parentId) &&
                Objects.equals(orderNum, sysMenu.orderNum) &&
                Objects.equals(path, sysMenu.path) &&
                Objects.equals(component, sysMenu.component) &&
                Objects.equals(isFrame, sysMenu.isFrame) &&
                Objects.equals(menuType, sysMenu.menuType) &&
                Objects.equals(visible, sysMenu.visible) &&
                Objects.equals(perms, sysMenu.perms) &&
                Objects.equals(icon, sysMenu.icon) &&
                Objects.equals(createBy, sysMenu.createBy) &&
                Objects.equals(createTime, sysMenu.createTime) &&
                Objects.equals(updateBy, sysMenu.updateBy) &&
                Objects.equals(updateTime, sysMenu.updateTime) &&
                Objects.equals(remark, sysMenu.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, menuName, parentId, orderNum, path, component, isFrame, menuType, visible, perms, icon, createBy, createTime, updateBy, updateTime, remark);
    }
}
