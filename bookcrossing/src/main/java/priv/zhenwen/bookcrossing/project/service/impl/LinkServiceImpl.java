package priv.zhenwen.bookcrossing.project.service.impl;

import priv.zhenwen.bookcrossing.project.entity.Link;
import priv.zhenwen.bookcrossing.project.mapper.LinkMapper;
import priv.zhenwen.bookcrossing.project.service.LinkService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Link)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-05 10:46:19
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {
    @Resource
    private LinkMapper linkMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param linkId 主键
     * @return 实例对象
     */
    @Override
    public Link queryById(Long linkId) {
        return this.linkMapper.queryById(linkId);
    }
    
    /**
     * 根据属性查询指定数据
     * 
     * @param link 查询条件
     * @return 对象列表
     */
     @Override
    public List<Link> queryAll(Link link) {
        return this.linkMapper.queryAll(link);
    }


    /**
     * 分页查询
     *
     * @param link 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Link> queryByPage(Link link, PageRequest pageRequest) {
        long total = this.linkMapper.count(link);
        return new PageImpl<>(this.linkMapper.queryAllByLimit(link, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param link 实例对象
     * @return 实例对象
     */
    @Override
    public Link insert(Link link) {
        this.linkMapper.insert(link);
        return link;
    }

    /**
     * 修改数据
     *
     * @param link 实例对象
     * @return 实例对象
     */
    @Override
    public Link update(Link link) {
        this.linkMapper.update(link);
        return this.queryById(link.getLinkId());
    }

    /**
     * 通过主键删除数据
     *
     * @param linkId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long linkId) {
        return this.linkMapper.deleteById(linkId) > 0;
    }
}
