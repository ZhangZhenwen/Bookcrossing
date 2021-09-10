package priv.zhenwen.bookcrossing.project.service.impl;

import priv.zhenwen.bookcrossing.project.entity.Comment;
import priv.zhenwen.bookcrossing.project.mapper.CommentMapper;
import priv.zhenwen.bookcrossing.project.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-10 18:59:00
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Override
    public Comment queryById(Long commentId) {
        return this.commentMapper.queryById(commentId);
    }
    
    /**
     * 根据属性查询指定数据
     * 
     * @param comment 查询条件
     * @return 对象列表
     */
     @Override
    public List<Comment> queryAll(Comment comment) {
        return this.commentMapper.queryAll(comment);
    }


    /**
     * 分页查询
     *
     * @param comment 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Comment> queryByPage(Comment comment, Pageable pageRequest) {
        long total = this.commentMapper.count(comment);
        return new PageImpl<>(this.commentMapper.queryAllByLimit(comment, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment insert(Comment comment) {
        this.commentMapper.insert(comment);
        return comment;
    }

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment update(Comment comment) {
        this.commentMapper.update(comment);
        return this.queryById(comment.getCommentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long commentId) {
        return this.commentMapper.deleteById(commentId) > 0;
    }
}
