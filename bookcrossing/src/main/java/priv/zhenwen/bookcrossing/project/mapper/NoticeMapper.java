package priv.zhenwen.bookcrossing.project.mapper;

import priv.zhenwen.bookcrossing.project.entity.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Notice)表数据库访问层
 *
 * @author zhenwen
 * @since 2021-09-10 18:59:00
 */
public interface NoticeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param noticeId 主键
     * @return 实例对象
     */
    Notice queryById(Long noticeId);
    
    /**
     * 根据属性查询指定数据
     * 
     * @param notice 查询条件
     * @return 对象列表
     */
    List<Notice> queryAll(Notice notice);

    /**
     * 查询指定行数据
     *
     * @param notice 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Notice> queryAllByLimit(@Param("notice") Notice notice, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param notice 查询条件
     * @return 总行数
     */
    long count(Notice notice);

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 影响行数
     */
    int insert(Notice notice);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Notice> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Notice> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Notice> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Notice> entities);

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 影响行数
     */
    int update(Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param noticeId 主键
     * @return 影响行数
     */
    int deleteById(Long noticeId);

}

