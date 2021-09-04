package priv.zhenwen.bookcrossing.mapper;

import priv.zhenwen.bookcrossing.entity.New;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (New)表数据库访问层
 *
 * @author zhenwen
 * @since 2021-09-04 22:29:57
 */
public interface NewMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param newId 主键
     * @return 实例对象
     */
    New queryById(Long newId);

    /**
     * 查询指定行数据
     *
     * @param new 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<New> queryAllByLimit(New new, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param new 查询条件
     * @return 总行数
     */
    long count(New new);

    /**
     * 新增数据
     *
     * @param new 实例对象
     * @return 影响行数
     */
    int insert(New new);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<New> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<New> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<New> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<New> entities);

    /**
     * 修改数据
     *
     * @param new 实例对象
     * @return 影响行数
     */
    int update(New new);

    /**
     * 通过主键删除数据
     *
     * @param newId 主键
     * @return 影响行数
     */
    int deleteById(Long newId);

}

