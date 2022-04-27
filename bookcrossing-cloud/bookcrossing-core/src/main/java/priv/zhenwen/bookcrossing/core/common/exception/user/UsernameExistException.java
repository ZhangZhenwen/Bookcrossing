package priv.zhenwen.bookcrossing.core.common.exception.user;

/**
 * @author zhenwen
 * @date 2021/9/7
 */

public class UsernameExistException extends UserException {
    public UsernameExistException() {
        super("user.username.exist", null);
    }
}
