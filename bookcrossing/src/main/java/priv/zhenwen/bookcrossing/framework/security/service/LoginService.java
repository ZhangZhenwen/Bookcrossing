package priv.zhenwen.bookcrossing.framework.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import priv.zhenwen.bookcrossing.common.exception.CustomException;
import priv.zhenwen.bookcrossing.common.exception.user.UserPasswordNotMatchException;
import priv.zhenwen.bookcrossing.common.util.ServletUtils;
import priv.zhenwen.bookcrossing.common.util.StringUtils;
import priv.zhenwen.bookcrossing.framework.security.LoginUser;
import priv.zhenwen.bookcrossing.project.entity.User;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenwen
 * @date 2020/11/10
 */
@Component
public class LoginService {

    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 登录验证
     *
     * @param username 账户
     * @param password 密码
     * @param code 验证码
     * @param uuid 标识符
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid) {
        Authentication authentication = null;

        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e){
            if (e instanceof BadCredentialsException) {
                throw new UserPasswordNotMatchException();
            } else {
                throw new CustomException(e.getMessage());
            }
        }

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenService.createToken(loginUser);
    }

    /**
     * 获取用户信息
     * @return info
     */
    public Map<String, Object> getInfo() {
        Map<String, Object> infos = new HashMap<>(4);

        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());

        if (StringUtils.isNotNull(loginUser)) {
            User user = loginUser.getUser();
            infos.put("user", user);
        }

        return infos;
    }
}