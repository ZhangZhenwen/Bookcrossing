package priv.zhenwen.bookcrossing.framework.security.handle;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import priv.zhenwen.bookcrossing.common.constant.HttpStatus;
import priv.zhenwen.bookcrossing.common.util.ServletUtils;
import priv.zhenwen.bookcrossing.common.util.StringUtils;
import priv.zhenwen.bookcrossing.framework.security.LoginUser;
import priv.zhenwen.bookcrossing.framework.security.service.TokenService;
import priv.zhenwen.bookcrossing.framework.web.domain.AjaxResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhenwen
 * @date 2020/11/10
 */
@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
    @Autowired
    TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LoginUser loginUser = tokenService.getLoginUser(request);

        if (StringUtils.isNotNull(loginUser)) {
            String username = loginUser.getUsername();
            tokenService.delLoginUser(loginUser.getToken());
        }

        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(HttpStatus.SUCCESS, "退出成功")));
    }
}
