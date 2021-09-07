package priv.zhenwen.bookcrossing.project.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author zhenwen
 * @since 2021-09-07 10:54:11
 */
public class User implements Serializable {
    private static final long serialVersionUID = 844586867165292045L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名称
     */
    @Pattern(regexp = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]{4,20}$")
    private String username;
    /**
     * 用户邮箱
     */
    @Email(message = "邮箱格式错误")
    private String email;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户类型（0：管理员、1：普通用户）
     */
    private String type;
    /**
     * 用户状态（0：未审核、1：审核中、2：审核通过）
     */
    private String status;
    /**
     * 用户手机号
     */
    @Pattern(regexp = "^1[3-9]\\d{9}$")
    private String tel;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}

