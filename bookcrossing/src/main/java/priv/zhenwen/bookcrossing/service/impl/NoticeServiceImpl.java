package priv.zhenwen.bookcrossing.service.impl;

import priv.zhenwen.bookcrossing.entity.Notice;
import priv.zhenwen.bookcrossing.mapper.NoticeMapper;
import priv.zhenwen.bookcrossing.service.NoticeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Notice)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-04 22:29:58
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param noticeId 主键
     * @return 实例对象
     */
    @Override
    public Notice queryById(Long noticeId) {
        return this.noticeMapper.queryById(noticeId);
    }

    /**
     * 分页查询
     *
     * @param notice 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Notice> queryByPage(Notice notice, PageRequest pageRequest) {
        long total = this.noticeMapper.count(notice);
        return new PageImpl<>(this.noticeMapper.queryAllByLimit(notice, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice insert(Notice notice) {
        this.noticeMapper.insert(notice);
        return notice;
    }

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice update(Notice notice) {
        this.noticeMapper.update(notice);
        return this.queryById(notice.getNoticeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param noticeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long noticeId) {
        return this.noticeMapper.deleteById(noticeId) > 0;
    }
}
