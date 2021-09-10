package priv.zhenwen.bookcrossing.project.mapper;

import priv.zhenwen.bookcrossing.project.entity.CrossInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (CrossInfo)表数据库访问层
 *
 * @author zhenwen
 * @since 2021-09-10 18:59:00
 */
public interface CrossInfoMapper {

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
     * 查询指定行数据
     *
     * @param crossInfo 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<CrossInfo> queryAllByLimit(@Param("crossInfo") CrossInfo crossInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param crossInfo 查询条件
     * @return 总行数
     */
    long count(CrossInfo crossInfo);

    /**
     * 新增数据
     *
     * @param crossInfo 实例对象
     * @return 影响行数
     */
    int insert(CrossInfo crossInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CrossInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CrossInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CrossInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CrossInfo> entities);

    /**
     * 修改数据
     *
     * @param crossInfo 实例对象
     * @return 影响行数
     */
    int update(CrossInfo crossInfo);

    /**
     * 通过主键删除数据
     *
     * @param crossInfoId 主键
     * @return 影响行数
     */
    int deleteById(Long crossInfoId);

}

