package priv.zhenwen.bookcrossing.project.service.impl;

import priv.zhenwen.bookcrossing.project.entity.TypeOfBook;
import priv.zhenwen.bookcrossing.project.mapper.TypeOfBookMapper;
import priv.zhenwen.bookcrossing.project.service.TypeOfBookService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TypeOfBook)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-14 17:26:16
 */
@Service("typeOfBookService")
public class TypeOfBookServiceImpl implements TypeOfBookService {
    @Resource
    private TypeOfBookMapper typeOfBookMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    @Override
    public TypeOfBook queryById(Long bookId) {
        return this.typeOfBookMapper.queryById(bookId);
    }
    
    /**
     * 根据属性查询指定数据
     * 
     * @param typeOfBook 查询条件
     * @return 对象列表
     */
     @Override
    public List<TypeOfBook> queryAll(TypeOfBook typeOfBook) {
        return this.typeOfBookMapper.queryAll(typeOfBook);
    }


    /**
     * 分页查询
     *
     * @param typeOfBook 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<TypeOfBook> queryByPage(TypeOfBook typeOfBook, Pageable pageRequest) {
        long total = this.typeOfBookMapper.count(typeOfBook);
        return new PageImpl<>(this.typeOfBookMapper.queryAllByLimit(typeOfBook, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param typeOfBook 实例对象
     * @return 实例对象
     */
    @Override
    public TypeOfBook insert(TypeOfBook typeOfBook) {
        this.typeOfBookMapper.insert(typeOfBook);
        return typeOfBook;
    }

    /**
     * 修改数据
     *
     * @param typeOfBook 实例对象
     * @return 实例对象
     */
    @Override
    public TypeOfBook update(TypeOfBook typeOfBook) {
        this.typeOfBookMapper.update(typeOfBook);
        return this.queryById(typeOfBook.getBookId());
    }

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long bookId) {
        return this.typeOfBookMapper.deleteById(bookId) > 0;
    }
}
