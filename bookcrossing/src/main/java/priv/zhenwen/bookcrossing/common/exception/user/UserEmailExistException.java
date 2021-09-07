package priv.zhenwen.bookcrossing.common.exception.user;

/**
 * @author zhenwen
 * @date 2021/9/7
 */

public class UserEmailExistException extends UserException {

    public UserEmailExistException() {
        super("user.email.exist", null);
    }
}
