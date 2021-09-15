package priv.zhenwen.bookcrossing.project.service;

import priv.zhenwen.bookcrossing.project.entity.BookType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (BookType)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-14 17:25:29
 */
public interface BookTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param bookTypeId 主键
     * @return 实例对象
     */
    BookType queryById(Long bookTypeId);
    
    /**
     * 根据属性查询指定数据
     * 
     * @param bookType 查询条件
     * @return 对象列表
     */
    List<BookType> queryAll(BookType bookType);

    /**
     * 分页查询
     *
     * @param bookType 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<BookType> queryByPage(BookType bookType, Pageable pageRequest);

    /**
     * 新增数据
     *
     * @param bookType 实例对象
     * @return 实例对象
     */
    BookType insert(BookType bookType);

    /**
     * 修改数据
     *
     * @param bookType 实例对象
     * @return 实例对象
     */
    BookType update(BookType bookType);

    /**
     * 通过主键删除数据
     *
     * @param bookTypeId 主键
     * @return 是否成功
     */
    boolean deleteById(Long bookTypeId);

}
