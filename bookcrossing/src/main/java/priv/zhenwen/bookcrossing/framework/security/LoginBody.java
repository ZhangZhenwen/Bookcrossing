package priv.zhenwen.bookcrossing.framework.security;

import lombok.Data;

/**
 * @author zhenwen
 * @date 2020/11/10
 */
@Data
public class LoginBody {

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;
}
