package priv.zhenwen.bookcrossing.framework.security;

import lombok.Data;

/**
 * @author zhenwen
 * @date 2020/11/10
 */
@Data
public class LoginBody {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 标识符
     */
    private String uuid = "";
}
