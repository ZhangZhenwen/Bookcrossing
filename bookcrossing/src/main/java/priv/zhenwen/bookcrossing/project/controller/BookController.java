package priv.zhenwen.bookcrossing.project.controller;

import priv.zhenwen.bookcrossing.project.entity.Book;
import priv.zhenwen.bookcrossing.project.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Book)表控制层
 *
 * @author zhenwen
 * @since 2021-09-05 10:46:19
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
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Book>> queryByPage(Book book, PageRequest pageRequest) {
        return ResponseEntity.ok(this.bookService.queryByPage(book, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Book> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.bookService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param book 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Book> add(Book book) {
        return ResponseEntity.ok(this.bookService.insert(book));
    }

    /**
     * 编辑数据
     *
     * @param book 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Book> edit(Book book) {
        return ResponseEntity.ok(this.bookService.update(book));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.bookService.deleteById(id));
    }

}

