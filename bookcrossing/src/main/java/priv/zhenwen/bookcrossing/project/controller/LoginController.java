package priv.zhenwen.bookcrossing.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.zhenwen.bookcrossing.common.constant.Constants;
import priv.zhenwen.bookcrossing.framework.security.service.LoginService;
import priv.zhenwen.bookcrossing.framework.web.domain.AjaxResult;
import priv.zhenwen.bookcrossing.project.entity.User;
import priv.zhenwen.bookcrossing.project.service.UserService;

import javax.annotation.Resource;

/**
 * @author zhenwen
 * @date 2021/9/7
 */
@RestController
@RequestMapping
public class LoginController {

    @Resource
    LoginService loginService;

    @Resource
    UserService userService;

    @PostMapping("/login")
    public AjaxResult login(String username, String password) {
        String token = loginService.login(username, password);

        AjaxResult result = AjaxResult.success();
        result.put(Constants.TOKEN, token);

        return result;
    }

    @PostMapping("/register")
    public AjaxResult register(User user) {
        userService.insert(user);
        return AjaxResult.success("注册成功！");
    }
}
