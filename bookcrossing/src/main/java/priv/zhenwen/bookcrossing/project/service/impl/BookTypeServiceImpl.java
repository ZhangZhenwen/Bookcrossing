package priv.zhenwen.bookcrossing.project.service.impl;

import priv.zhenwen.bookcrossing.project.entity.BookType;
import priv.zhenwen.bookcrossing.project.mapper.BookTypeMapper;
import priv.zhenwen.bookcrossing.project.service.BookTypeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BookType)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-14 17:25:29
 */
@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService {
    @Resource
    private BookTypeMapper bookTypeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param bookTypeId 主键
     * @return 实例对象
     */
    @Override
    public BookType queryById(Long bookTypeId) {
        return this.bookTypeMapper.queryById(bookTypeId);
    }
    
    /**
     * 根据属性查询指定数据
     * 
     * @param bookType 查询条件
     * @return 对象列表
     */
     @Override
    public List<BookType> queryAll(BookType bookType) {
        return this.bookTypeMapper.queryAll(bookType);
    }


    /**
     * 分页查询
     *
     * @param bookType 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<BookType> queryByPage(BookType bookType, Pageable pageRequest) {
        long total = this.bookTypeMapper.count(bookType);
        return new PageImpl<>(this.bookTypeMapper.queryAllByLimit(bookType, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param bookType 实例对象
     * @return 实例对象
     */
    @Override
    public BookType insert(BookType bookType) {
        this.bookTypeMapper.insert(bookType);
        return bookType;
    }

    /**
     * 修改数据
     *
     * @param bookType 实例对象
     * @return 实例对象
     */
    @Override
    public BookType update(BookType bookType) {
        this.bookTypeMapper.update(bookType);
        return this.queryById(bookType.getBookTypeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param bookTypeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long bookTypeId) {
        return this.bookTypeMapper.deleteById(bookTypeId) > 0;
    }
}
