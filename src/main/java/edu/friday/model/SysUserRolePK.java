package edu.friday.model;

import java.io.Serializable;
import java.util.Objects;

public class SysUserRolePK implements Serializable {
    private long userId;
    private long roleId;

    @javax.persistence.Column(name = "user_id")
    @javax.persistence.Id
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @javax.persistence.Column(name = "role_id")
    @javax.persistence.Id
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUserRolePK that = (SysUserRolePK) o;
        return userId == that.userId &&
                roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }
}
