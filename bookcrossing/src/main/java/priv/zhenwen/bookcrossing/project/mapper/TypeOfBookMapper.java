package priv.zhenwen.bookcrossing.project.mapper;

import priv.zhenwen.bookcrossing.project.entity.TypeOfBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (TypeOfBook)表数据库访问层
 *
 * @author zhenwen
 * @since 2021-09-14 17:26:16
 */
public interface TypeOfBookMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    TypeOfBook queryById(Long bookId);
    
    /**
     * 根据属性查询指定数据
     * 
     * @param typeOfBook 查询条件
     * @return 对象列表
     */
    List<TypeOfBook> queryAll(TypeOfBook typeOfBook);

    /**
     * 查询指定行数据
     *
     * @param typeOfBook 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<TypeOfBook> queryAllByLimit(@Param("typeOfBook") TypeOfBook typeOfBook, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param typeOfBook 查询条件
     * @return 总行数
     */
    long count(TypeOfBook typeOfBook);

    /**
     * 新增数据
     *
     * @param typeOfBook 实例对象
     * @return 影响行数
     */
    int insert(TypeOfBook typeOfBook);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TypeOfBook> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TypeOfBook> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TypeOfBook> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TypeOfBook> entities);

    /**
     * 修改数据
     *
     * @param typeOfBook 实例对象
     * @return 影响行数
     */
    int update(TypeOfBook typeOfBook);

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 影响行数
     */
    int deleteById(Long bookId);

}

