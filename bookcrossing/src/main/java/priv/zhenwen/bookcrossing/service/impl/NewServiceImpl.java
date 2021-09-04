package priv.zhenwen.bookcrossing.service.impl;

import priv.zhenwen.bookcrossing.entity.New;
import priv.zhenwen.bookcrossing.mapper.NewMapper;
import priv.zhenwen.bookcrossing.service.NewService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (New)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-04 22:29:57
 */
@Service("newService")
public class NewServiceImpl implements NewService {
    @Resource
    private NewMapper newMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param newId 主键
     * @return 实例对象
     */
    @Override
    public New queryById(Long newId) {
        return this.newMapper.queryById(newId);
    }

    /**
     * 分页查询
     *
     * @param new 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<New> queryByPage(New new, PageRequest pageRequest) {
        long total = this.newMapper.count(new);
        return new PageImpl<>(this.newMapper.queryAllByLimit(new, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param new 实例对象
     * @return 实例对象
     */
    @Override
    public New insert(New new) {
        this.newMapper.insert(new);
        return new;
    }

    /**
     * 修改数据
     *
     * @param new 实例对象
     * @return 实例对象
     */
    @Override
    public New update(New new) {
        this.newMapper.update(new);
        return this.queryById(new.getNewId());
    }

    /**
     * 通过主键删除数据
     *
     * @param newId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long newId) {
        return this.newMapper.deleteById(newId) > 0;
    }
}
