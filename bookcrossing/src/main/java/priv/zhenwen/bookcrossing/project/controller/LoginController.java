package priv.zhenwen.bookcrossing.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.zhenwen.bookcrossing.common.constant.Constants;
import priv.zhenwen.bookcrossing.framework.security.LoginBody;
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
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        String token = loginService.login(loginBody.getEmail(), loginBody.getPassword());

        AjaxResult result = AjaxResult.ok("登录成功！");
        result.put(Constants.TOKEN, token);

        return result;
    }

    @PostMapping("/admin/login")
    public AjaxResult adminLogin(@RequestBody LoginBody loginBody) {
        String token = loginService.adminLogin(loginBody.getEmail(), loginBody.getPassword());

        AjaxResult result = AjaxResult.ok("登录成功！");
        result.put(Constants.TOKEN, token);

        return result;
    }

    @PostMapping("/register")
    public AjaxResult register(@RequestBody User user) {
        userService.insert(user);
        return AjaxResult.ok("注册成功！");
    }
}
