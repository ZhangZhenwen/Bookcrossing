package priv.zhenwen.bookcrossing.project.service;

import priv.zhenwen.bookcrossing.project.entity.CrossInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (CrossInfo)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-05 10:46:19
 */
public interface CrossInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param crossInfoId 主键
     * @return 实例对象
     */
    CrossInfo queryById(Long crossInfoId);
    
    /**
     * 根据属性查询指定数据
     * 
     * @param crossInfo 查询条件
     * @return 对象列表
     */
    List<CrossInfo> queryAll(CrossInfo crossInfo);

    /**
     * 分页查询
     *
     * @param crossInfo 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<CrossInfo> queryByPage(CrossInfo crossInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param crossInfo 实例对象
     * @return 实例对象
     */
    CrossInfo insert(CrossInfo crossInfo);

    /**
     * 修改数据
     *
     * @param crossInfo 实例对象
     * @return 实例对象
     */
    CrossInfo update(CrossInfo crossInfo);

    /**
     * 通过主键删除数据
     *
     * @param crossInfoId 主键
     * @return 是否成功
     */
    boolean deleteById(Long crossInfoId);

}
