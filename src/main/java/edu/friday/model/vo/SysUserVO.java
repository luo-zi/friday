package edu.friday.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserVO implements Serializable {
    private static final  long serializable=231112321L;
    private Long userId;
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 0,max=30,message = "用户账号长度不能超过30个字符")
    private String userName;
    @Size(min = 0,max=30,message = "用户昵称长度不能超过30个字符")
    private String nickName;
    @Email(message = "邮箱格式不正确")
    @Size(min = 0,max=50,message = "邮箱长度不能超过50个字符")
    private String mail;
    @Size(min = 0,max=11,message = "手机号码长度不能超过11个字符")
    private String phoneNumber;
    private String sex;
    private String userType;
    private String avatar;
    @JsonProperty
    private String password;
    private String salt;
    private String status; // 0: used / 1: not used
    private String delFlag;// 0: exit / 1: not exit
    private String loginIP;
    private Date loginDate;
    private String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String remark;
    private List<SysRoleVO> roles;
    private  Long[] roleds;
    public SysUserVO(Long userId){
        this.userId=userId;
    }
    public boolean isAdmin(){
        return isAdmin(this.userId);
    }
    public static boolean isAdmin(Long userId){
        return userId!=null&&1L==userId;
    }


}
