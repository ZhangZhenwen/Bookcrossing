package priv.zhenwen.bookcrossing.project.service;

import priv.zhenwen.bookcrossing.project.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Notice)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-05 10:46:20
 */
public interface NoticeService {

    /**
     * 通过ID查询单条数据
     *
     * @param noticeId 主键
     * @return 实例对象
     */
    Notice queryById(Long noticeId);
    
    /**
     * 根据属性查询指定数据
     * 
     * @param notice 查询条件
     * @return 对象列表
     */
    List<Notice> queryAll(Notice notice);

    /**
     * 分页查询
     *
     * @param notice 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Notice> queryByPage(Notice notice, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice insert(Notice notice);

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice update(Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param noticeId 主键
     * @return 是否成功
     */
    boolean deleteById(Long noticeId);

}
