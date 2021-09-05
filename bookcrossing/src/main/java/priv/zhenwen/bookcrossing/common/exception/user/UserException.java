package priv.zhenwen.bookcrossing.common.exception.user;

import priv.zhenwen.bookcrossing.common.exception.BaseException;

/**
 * @author zhenwen
 * @date 2020/11/10
 */

public class UserException extends BaseException {
    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
