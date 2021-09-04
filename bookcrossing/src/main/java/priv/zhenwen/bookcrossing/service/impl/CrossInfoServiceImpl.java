package priv.zhenwen.bookcrossing.service.impl;

import priv.zhenwen.bookcrossing.entity.CrossInfo;
import priv.zhenwen.bookcrossing.mapper.CrossInfoMapper;
import priv.zhenwen.bookcrossing.service.CrossInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (CrossInfo)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-04 22:52:35
 */
@Service("crossInfoService")
public class CrossInfoServiceImpl implements CrossInfoService {
    @Resource
    private CrossInfoMapper crossInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param crossInfoId 主键
     * @return 实例对象
     */
    @Override
    public CrossInfo queryById(Long crossInfoId) {
        return this.crossInfoMapper.queryById(crossInfoId);
    }

    /**
     * 分页查询
     *
     * @param crossInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CrossInfo> queryByPage(CrossInfo crossInfo, PageRequest pageRequest) {
        long total = this.crossInfoMapper.count(crossInfo);
        return new PageImpl<>(this.crossInfoMapper.queryAllByLimit(crossInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param crossInfo 实例对象
     * @return 实例对象
     */
    @Override
    public CrossInfo insert(CrossInfo crossInfo) {
        this.crossInfoMapper.insert(crossInfo);
        return crossInfo;
    }

    /**
     * 修改数据
     *
     * @param crossInfo 实例对象
     * @return 实例对象
     */
    @Override
    public CrossInfo update(CrossInfo crossInfo) {
        this.crossInfoMapper.update(crossInfo);
        return this.queryById(crossInfo.getCrossInfoId());
    }

    /**
     * 通过主键删除数据
     *
     * @param crossInfoId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long crossInfoId) {
        return this.crossInfoMapper.deleteById(crossInfoId) > 0;
    }
}
