package priv.zhenwen.bookcrossing.service;

import priv.zhenwen.bookcrossing.entity.Announcement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Announcement)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-04 22:29:54
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
     * 分页查询
     *
     * @param announcement 筛选条件
     * @param pageRequest      分页对象
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
