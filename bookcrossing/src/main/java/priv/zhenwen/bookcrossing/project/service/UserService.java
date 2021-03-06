package priv.zhenwen.bookcrossing.project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import priv.zhenwen.bookcrossing.project.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-05 10:46:20
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Long userId);

    /**
     * 根据属性查询指定数据
     *
     * @param user 查询条件
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 根据邮箱查询单条数据
     *
     * @param email 邮箱
     * @return 实例对象
     */
    User queryByEmail(String email);

    /**
     * 根据用户名查询单条数据
     *
     * @param username 邮箱
     * @return 实例对象
     */
    User queryByUsername(String username);

    /**
     * 根据账号查询单条数据
     *
     * @param account 账号
     * @return 实例对象
     */
    User queryByAccount(String account);

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<User> queryByPage(User user, Pageable pageRequest);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Long userId);

}
