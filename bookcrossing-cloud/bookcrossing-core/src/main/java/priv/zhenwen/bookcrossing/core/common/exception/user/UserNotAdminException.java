package priv.zhenwen.bookcrossing.core.common.exception.user;

/**
 * @author zhenwen
 * @date 2021/9/14
 */

public class UserNotAdminException extends UserException{
    public UserNotAdminException () {
        super("user.not.admin", null);
    }
}
