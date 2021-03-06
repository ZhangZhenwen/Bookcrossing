package priv.zhenwen.bookcrossing.project.service;

import priv.zhenwen.bookcrossing.project.entity.CrossInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import priv.zhenwen.bookcrossing.project.entity.vo.ApplyVo;
import priv.zhenwen.bookcrossing.project.entity.vo.UserCrossInfoVo;

import java.util.List;

/**
 * (CrossInfo)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-10 18:59:00
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
    Page<CrossInfo> queryByPage(CrossInfo crossInfo, Pageable pageRequest);

    Page<UserCrossInfoVo> queryUserCrossInfoVOPage(CrossInfo crossInfo, Pageable pageRequest);

    /**
     * 查询申请列表
     *
     * @return 查询结果
     */
    Page<ApplyVo> queryForApply();

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

    /**
     * 处理漂流请求
     *
     * @param crossInfo 漂流请求
     * @return 是否成功
     */
    boolean handleCrossing(CrossInfo crossInfo);

    /**
     * 是否正在申请漂流
     *
     * @param crossInfo 漂流申请
     * @return 漂流申请
     */
    boolean isApplying(CrossInfo crossInfo);

    /**
     * 同意漂流请求
     *
     * @param applyVo 漂流请求
     * @return 是否拒绝成功
     */
    boolean agree(ApplyVo applyVo);

    /**
     * 拒绝漂流请求
     *
     * @param applyVo 漂流请求
     * @return 是否拒绝成功
     */
    boolean refuse(ApplyVo applyVo);
}
