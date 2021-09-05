package priv.zhenwen.bookcrossing.project.service;

import priv.zhenwen.bookcrossing.project.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-05 10:46:19
 */
public interface CommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    Comment queryById(Long commentId);
    
    /**
     * 根据属性查询指定数据
     * 
     * @param comment 查询条件
     * @return 对象列表
     */
    List<Comment> queryAll(Comment comment);

    /**
     * 分页查询
     *
     * @param comment 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Comment> queryByPage(Comment comment, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment insert(Comment comment);

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment update(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    boolean deleteById(Long commentId);

}
