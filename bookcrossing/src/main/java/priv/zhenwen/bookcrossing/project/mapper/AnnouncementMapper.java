package priv.zhenwen.bookcrossing.project.mapper;

import priv.zhenwen.bookcrossing.project.entity.Announcement;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Announcement)表数据库访问层
 *
 * @author zhenwen
 * @since 2021-09-10 18:59:00
 */
public interface AnnouncementMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param announcementId 主键
     * @return 实例对象
     */
    Announcement queryById(Long announcementId);
    
    /**
     * 根据属性查询指定数据
     * 
     * @param announcement 查询条件
     * @return 对象列表
     */
    List<Announcement> queryAll(Announcement announcement);

    /**
     * 查询指定行数据
     *
     * @param announcement 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Announcement> queryAllByLimit(@Param("announcement") Announcement announcement, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param announcement 查询条件
     * @return 总行数
     */
    long count(Announcement announcement);

    /**
     * 新增数据
     *
     * @param announcement 实例对象
     * @return 影响行数
     */
    int insert(Announcement announcement);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Announcement> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Announcement> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Announcement> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Announcement> entities);

    /**
     * 修改数据
     *
     * @param announcement 实例对象
     * @return 影响行数
     */
    int update(Announcement announcement);

    /**
     * 通过主键删除数据
     *
     * @param announcementId 主键
     * @return 影响行数
     */
    int deleteById(Long announcementId);

}

