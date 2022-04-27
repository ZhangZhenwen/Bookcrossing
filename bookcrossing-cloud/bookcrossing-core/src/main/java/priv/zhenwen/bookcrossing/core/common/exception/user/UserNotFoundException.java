package priv.zhenwen.bookcrossing.core.common.exception.user;

/**
 * @author zhenwen
 * @date 2021/9/16
 */

public class UserNotFoundException extends UserException {
    public UserNotFoundException() {
        super("user.notfound", null);
    }
}
