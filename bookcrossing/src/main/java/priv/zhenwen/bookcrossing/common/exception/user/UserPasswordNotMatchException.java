package priv.zhenwen.bookcrossing.common.exception.user;

/**
 * @author zhenwen
 * @date 2020/11/10
 */

public class UserPasswordNotMatchException extends UserException {

    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
