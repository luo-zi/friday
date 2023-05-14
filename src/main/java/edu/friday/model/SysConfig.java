package edu.friday.model;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.*;
@javax.persistence.Entity
@javax.persistence.Table(name = "sys_config", schema = "friday", catalog = "")
public class SysConfig {
    private int configId;
    private String configName;
    private String configKey;
    private String configValue;
    private String configType;
    private String createBy;
    private Timestamp createTime;
    private String updateBy;
    private Timestamp updateTime;
    private String remark;

    @javax.persistence.Id
    @javax.persistence.Column(name = "config_id")
    public int getConfigId() {
        return configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "config_name")
    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "config_key")
    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "config_value")
    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "config_type")
    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
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
        SysConfig sysConfig = (SysConfig) o;
        return configId == sysConfig.configId &&
                Objects.equals(configName, sysConfig.configName) &&
                Objects.equals(configKey, sysConfig.configKey) &&
                Objects.equals(configValue, sysConfig.configValue) &&
                Objects.equals(configType, sysConfig.configType) &&
                Objects.equals(createBy, sysConfig.createBy) &&
                Objects.equals(createTime, sysConfig.createTime) &&
                Objects.equals(updateBy, sysConfig.updateBy) &&
                Objects.equals(updateTime, sysConfig.updateTime) &&
                Objects.equals(remark, sysConfig.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(configId, configName, configKey, configValue, configType, createBy, createTime, updateBy, updateTime, remark);
    }
}
