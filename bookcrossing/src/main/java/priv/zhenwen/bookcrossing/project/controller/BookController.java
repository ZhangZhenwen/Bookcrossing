package priv.zhenwen.bookcrossing.project.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import priv.zhenwen.bookcrossing.framework.web.domain.AjaxResult;
import priv.zhenwen.bookcrossing.project.entity.Book;
import priv.zhenwen.bookcrossing.project.service.BookService;

import javax.annotation.Resource;

/**
 * (Book)表控制层
 *
 * @author zhenwen
 * @since 2021-09-14 17:25:29
 */
@RestController
@RequestMapping("book")
public class BookController {
    /**
     * 服务对象
     */
    @Resource
    private BookService bookService;

    /**
     * 分页查询
     *
     * @param book 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/list")
    public AjaxResult queryByPage(Book book, Pageable pageRequest) {
        return AjaxResult.ok(this.bookService.queryByPage(book, pageRequest));
    }

    @GetMapping("/vo")
    public AjaxResult queryVOByPage(Book book, Pageable pageable) {
        return AjaxResult.ok(this.bookService.getBookVOList(book, pageable));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult queryById(@PathVariable("id") Long id) {
        return AjaxResult.ok(this.bookService.queryById(id));
    }

    @GetMapping("/detail")
    public AjaxResult getBookDetailVo(Long id) {
        return AjaxResult.ok(this.bookService.getBookDetail(id));
    }

    /**
     * 通过属性查询单条数据
     *
     * @param book 属性
     * @return 单条数据
     */
    @GetMapping("/get")
    public AjaxResult queryByBook(Book book) {
        return AjaxResult.ok(this.bookService.queryByBook(book));
    }

    /**
     * 新增数据
     *
     * @param book 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Book book) {
        return AjaxResult.ok(this.bookService.insert(book));
    }

    /**
     * 编辑数据
     *
     * @param book 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody Book book) {
        return AjaxResult.ok(this.bookService.update(book));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public AjaxResult deleteById(@RequestBody Long id) {
        return AjaxResult.ok(this.bookService.deleteById(id));
    }
}

