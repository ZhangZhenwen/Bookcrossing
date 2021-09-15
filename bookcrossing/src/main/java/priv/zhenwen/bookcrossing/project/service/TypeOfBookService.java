package priv.zhenwen.bookcrossing.project.service;

import priv.zhenwen.bookcrossing.project.entity.TypeOfBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (TypeOfBook)表服务接口
 *
 * @author zhenwen
 * @since 2021-09-14 17:26:16
 */
public interface TypeOfBookService {

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
     * 分页查询
     *
     * @param typeOfBook 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<TypeOfBook> queryByPage(TypeOfBook typeOfBook, Pageable pageRequest);

    /**
     * 新增数据
     *
     * @param typeOfBook 实例对象
     * @return 实例对象
     */
    TypeOfBook insert(TypeOfBook typeOfBook);

    /**
     * 修改数据
     *
     * @param typeOfBook 实例对象
     * @return 实例对象
     */
    TypeOfBook update(TypeOfBook typeOfBook);

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    boolean deleteById(Long bookId);

}
