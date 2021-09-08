package priv.zhenwen.bookcrossing.project.mapper;

import priv.zhenwen.bookcrossing.project.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Book)表数据库访问层
 *
 * @author zhenwen
 * @since 2021-09-08 16:57:14
 */
public interface BookMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    Book queryById(Long bookId);
    
    /**
     * 根据属性查询指定数据
     * 
     * @param book 查询条件
     * @return 对象列表
     */
    List<Book> queryAll(Book book);

    /**
     * 查询指定行数据
     *
     * @param book 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Book> queryAllByLimit(@Param("book") Book book, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param book 查询条件
     * @return 总行数
     */
    long count(Book book);

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 影响行数
     */
    int insert(Book book);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Book> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Book> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Book> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Book> entities);

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 影响行数
     */
    int update(Book book);

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 影响行数
     */
    int deleteById(Long bookId);

}

