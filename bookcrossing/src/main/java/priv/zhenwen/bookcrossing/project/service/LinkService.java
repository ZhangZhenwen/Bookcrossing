package priv.zhenwen.bookcrossing.project.service;

import priv.zhenwen.bookcrossing.project.entity.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Link)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-05 10:46:19
 */
public interface LinkService {

    /**
     * 通过ID查询单条数据
     *
     * @param linkId 主键
     * @return 实例对象
     */
    Link queryById(Long linkId);
    
    /**
     * 根据属性查询指定数据
     * 
     * @param link 查询条件
     * @return 对象列表
     */
    List<Link> queryAll(Link link);

    /**
     * 分页查询
     *
     * @param link 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Link> queryByPage(Link link, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param link 实例对象
     * @return 实例对象
     */
    Link insert(Link link);

    /**
     * 修改数据
     *
     * @param link 实例对象
     * @return 实例对象
     */
    Link update(Link link);

    /**
     * 通过主键删除数据
     *
     * @param linkId 主键
     * @return 是否成功
     */
    boolean deleteById(Long linkId);

}
