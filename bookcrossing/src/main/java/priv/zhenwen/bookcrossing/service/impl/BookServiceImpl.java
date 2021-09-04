package priv.zhenwen.bookcrossing.service.impl;

import priv.zhenwen.bookcrossing.entity.Book;
import priv.zhenwen.bookcrossing.mapper.BookMapper;
import priv.zhenwen.bookcrossing.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Book)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-04 22:29:57
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    @Override
    public Book queryById(Long bookId) {
        return this.bookMapper.queryById(bookId);
    }

    /**
     * 分页查询
     *
     * @param book 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Book> queryByPage(Book book, PageRequest pageRequest) {
        long total = this.bookMapper.count(book);
        return new PageImpl<>(this.bookMapper.queryAllByLimit(book, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public Book insert(Book book) {
        this.bookMapper.insert(book);
        return book;
    }

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public Book update(Book book) {
        this.bookMapper.update(book);
        return this.queryById(book.getBookId());
    }

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long bookId) {
        return this.bookMapper.deleteById(bookId) > 0;
    }
}
