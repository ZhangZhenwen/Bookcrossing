package priv.zhenwen.bookcrossing.service;

import priv.zhenwen.bookcrossing.entity.New;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (New)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-04 22:29:57
 */
public interface NewService {

    /**
     * 通过ID查询单条数据
     *
     * @param newId 主键
     * @return 实例对象
     */
    New queryById(Long newId);

    /**
     * 分页查询
     *
     * @param new 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<New> queryByPage(New new, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param new 实例对象
     * @return 实例对象
     */
    New insert(New new);

    /**
     * 修改数据
     *
     * @param new 实例对象
     * @return 实例对象
     */
    New update(New new);

    /**
     * 通过主键删除数据
     *
     * @param newId 主键
     * @return 是否成功
     */
    boolean deleteById(Long newId);

}
