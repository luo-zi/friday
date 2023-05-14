package edu.friday.model;

import java.sql.Timestamp;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "sys_role", schema = "friday", catalog = "")
public class SysRole {
    private long roleId;
    private String roleName;
    private String roleKey;
    private int roleSort;
    private String dataScope;
    private String status;
    private String delFlag;
    private String createBy;
    private Timestamp createTime;
    private String updateBy;
    private Timestamp updateTime;
    private String remark;

    @javax.persistence.Id
    @javax.persistence.Column(name = "role_id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "role_key")
    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "role_sort")
    public int getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(int roleSort) {
        this.roleSort = roleSort;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "data_scope")
    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "del_flag")
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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
        SysRole sysRole = (SysRole) o;
        return roleId == sysRole.roleId &&
                roleSort == sysRole.roleSort &&
                Objects.equals(roleName, sysRole.roleName) &&
                Objects.equals(roleKey, sysRole.roleKey) &&
                Objects.equals(dataScope, sysRole.dataScope) &&
                Objects.equals(status, sysRole.status) &&
                Objects.equals(delFlag, sysRole.delFlag) &&
                Objects.equals(createBy, sysRole.createBy) &&
                Objects.equals(createTime, sysRole.createTime) &&
                Objects.equals(updateBy, sysRole.updateBy) &&
                Objects.equals(updateTime, sysRole.updateTime) &&
                Objects.equals(remark, sysRole.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleKey, roleSort, dataScope, status, delFlag, createBy, createTime, updateBy, updateTime, remark);
    }
}
