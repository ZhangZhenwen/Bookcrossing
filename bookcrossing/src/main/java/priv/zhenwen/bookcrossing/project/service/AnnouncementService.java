package priv.zhenwen.bookcrossing.project.service;

import priv.zhenwen.bookcrossing.project.entity.Announcement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Announcement)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-05 10:46:19
 */
public interface AnnouncementService {

    /**
     * 通过ID查询单条数据
     *
     * @param announcementId 主键
     * @return 实例对象
     */
    Announcement queryById(Long announcementId);
    
    /**
     * 根据属性查询指定数据
     * 
     * @param announcement 查询条件
     * @return 对象列表
     */
    List<Announcement> queryAll(Announcement announcement);

    /**
     * 分页查询
     *
     * @param announcement 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Announcement> queryByPage(Announcement announcement, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param announcement 实例对象
     * @return 实例对象
     */
    Announcement insert(Announcement announcement);

    /**
     * 修改数据
     *
     * @param announcement 实例对象
     * @return 实例对象
     */
    Announcement update(Announcement announcement);

    /**
     * 通过主键删除数据
     *
     * @param announcementId 主键
     * @return 是否成功
     */
    boolean deleteById(Long announcementId);

}
