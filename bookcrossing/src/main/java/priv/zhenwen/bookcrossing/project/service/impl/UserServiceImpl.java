package priv.zhenwen.bookcrossing.project.service.impl;

import priv.zhenwen.bookcrossing.common.exception.user.UserEmailExistException;
import priv.zhenwen.bookcrossing.common.exception.user.UsernameExistException;
import priv.zhenwen.bookcrossing.common.util.StringUtils;
import priv.zhenwen.bookcrossing.project.entity.User;
import priv.zhenwen.bookcrossing.project.mapper.UserMapper;
import priv.zhenwen.bookcrossing.project.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-05 10:46:20
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long userId) {
        return this.userMapper.queryById(userId);
    }

    /**
     * 根据属性查询指定数据
     *
     * @param user 查询条件
     * @return 对象列表
     */
     @Override
    public List<User> queryAll(User user) {
        return this.userMapper.queryAll(user);
    }

    /**
     * 通过邮箱查询单条数据
     *
     * @param email 邮箱
     * @return 实例对象
     */
    @Override
    public User queryByEmail(String email) {
        return this.userMapper.queryByEmail(email);
    }

    /**
     * 通过用户名查询单条数据
     *
     * @param username 邮箱
     * @return 实例对象
     */
    @Override
    public User queryByUsername(String username) {
        return this.userMapper.queryByUsername(username);
    }

    /**
     * 通过账户名查询单条数据
     *
     * @param account 账号
     * @return 实例对象
     */
    @Override
    public User queryByAccount(String account) {
        User user = queryByEmail(account);

        if (StringUtils.isNull(user)) {
            user = queryByUsername(account);
        }

        return user;
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userMapper.count(user);
        return new PageImpl<>(this.userMapper.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        String email = user.getEmail();
        String username = user.getUsername();

        if (StringUtils.isNotNull(queryByEmail(email))) {
            throw new UserEmailExistException();
        }

        if (StringUtils.isNotNull(queryByUsername(username))) {
            throw new UsernameExistException();
        }

        this.userMapper.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userMapper.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.userMapper.deleteById(userId) > 0;
    }
}
