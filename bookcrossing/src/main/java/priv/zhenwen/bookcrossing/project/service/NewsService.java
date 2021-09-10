package priv.zhenwen.bookcrossing.project.service;

import priv.zhenwen.bookcrossing.project.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (News)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-10 18:59:00
 */
public interface NewsService {

    /**
     * 通过ID查询单条数据
     *
     * @param newsId 主键
     * @return 实例对象
     */
    News queryById(Long newsId);
    
    /**
     * 根据属性查询指定数据
     * 
     * @param news 查询条件
     * @return 对象列表
     */
    List<News> queryAll(News news);

    /**
     * 分页查询
     *
     * @param news 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<News> queryByPage(News news, Pageable pageRequest);

    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    News insert(News news);

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    News update(News news);

    /**
     * 通过主键删除数据
     *
     * @param newsId 主键
     * @return 是否成功
     */
    boolean deleteById(Long newsId);

}
