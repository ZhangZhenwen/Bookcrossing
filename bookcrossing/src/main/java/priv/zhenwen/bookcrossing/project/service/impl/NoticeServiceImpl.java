package priv.zhenwen.bookcrossing.project.service.impl;

import priv.zhenwen.bookcrossing.project.entity.Notice;
import priv.zhenwen.bookcrossing.project.mapper.NoticeMapper;
import priv.zhenwen.bookcrossing.project.service.NoticeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Notice)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-08 16:57:14
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
     * 根据属性查询指定数据
     * 
     * @param notice 查询条件
     * @return 对象列表
     */
     @Override
    public List<Notice> queryAll(Notice notice) {
        return this.noticeMapper.queryAll(notice);
    }


    /**
     * 分页查询
     *
     * @param notice 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Notice> queryByPage(Notice notice, Pageable pageRequest) {
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
