package priv.zhenwen.bookcrossing.framework.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import priv.zhenwen.bookcrossing.common.constant.UserStatus;
import priv.zhenwen.bookcrossing.common.exception.BaseException;
import priv.zhenwen.bookcrossing.common.util.StringUtils;
import priv.zhenwen.bookcrossing.framework.security.LoginUser;
import priv.zhenwen.bookcrossing.project.entity.User;
import priv.zhenwen.bookcrossing.project.service.UserService;

/**
 * @author zhenwen
 * @date 2020/11/11
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User temp = new User();
        temp.setEmail(username);
        User user = userService.queryAll(temp).get(0);

        if (StringUtils.isNull(user))
        {
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        else if (UserStatus.REVIEW.equals(user.getStatus()))
        {
            throw new BaseException("对不起，您的账号：" + username + " 已停用");
        }

        return createLoginUser(user);
    }

    public UserDetails createLoginUser(User user) {
        return new LoginUser(user);
    }
}
