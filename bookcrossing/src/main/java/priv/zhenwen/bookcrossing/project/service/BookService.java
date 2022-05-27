package priv.zhenwen.bookcrossing.project.service;

import priv.zhenwen.bookcrossing.project.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import priv.zhenwen.bookcrossing.project.entity.vo.BookVO;

import java.util.List;

/**
 * (Book)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-14 17:25:29
 */
public interface BookService {

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
     * 分页查询
     *
     * @param book 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Book> queryByPage(Book book, Pageable pageRequest);

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    Book insert(Book book);

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    Book update(Book book);

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    boolean deleteById(Long bookId);

    /**
     * 通过属性查询单条数据
     *
     * @param book 属性
     * @return 实例对象
     */
    Book queryByBook(Book book);

    Book getBookDetail(Long bookId);

    Page<BookVO> getBookVOList(Book book, Pageable pageRequest);
}
