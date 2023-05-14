package edu.friday.common.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel implements Serializable {
    private static final long serialVersion=21432L;
    @Column(name = "create_by")
    private String createBy;
    @Column(updatable = false,name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @Column(name = "update_by")
    private String updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "remark")
    private String remark;
    @PrePersist
    protected void onCreate(){
        this.createTime=new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updateTime=new Date();
    }
}
