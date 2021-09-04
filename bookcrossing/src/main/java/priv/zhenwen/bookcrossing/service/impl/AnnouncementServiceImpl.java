package priv.zhenwen.bookcrossing.service.impl;

import priv.zhenwen.bookcrossing.entity.Announcement;
import priv.zhenwen.bookcrossing.mapper.AnnouncementMapper;
import priv.zhenwen.bookcrossing.service.AnnouncementService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Announcement)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-04 22:29:55
 */
@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService {
    @Resource
    private AnnouncementMapper announcementMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param announcementId 主键
     * @return 实例对象
     */
    @Override
    public Announcement queryById(Long announcementId) {
        return this.announcementMapper.queryById(announcementId);
    }

    /**
     * 分页查询
     *
     * @param announcement 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Announcement> queryByPage(Announcement announcement, PageRequest pageRequest) {
        long total = this.announcementMapper.count(announcement);
        return new PageImpl<>(this.announcementMapper.queryAllByLimit(announcement, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param announcement 实例对象
     * @return 实例对象
     */
    @Override
    public Announcement insert(Announcement announcement) {
        this.announcementMapper.insert(announcement);
        return announcement;
    }

    /**
     * 修改数据
     *
     * @param announcement 实例对象
     * @return 实例对象
     */
    @Override
    public Announcement update(Announcement announcement) {
        this.announcementMapper.update(announcement);
        return this.queryById(announcement.getAnnouncementId());
    }

    /**
     * 通过主键删除数据
     *
     * @param announcementId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long announcementId) {
        return this.announcementMapper.deleteById(announcementId) > 0;
    }
}
