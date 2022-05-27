package priv.zhenwen.bookcrossing.project.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import priv.zhenwen.bookcrossing.framework.web.domain.AjaxResult;
import priv.zhenwen.bookcrossing.project.entity.BookType;
import priv.zhenwen.bookcrossing.project.service.BookTypeService;

import javax.annotation.Resource;

/**
 * (BookType)表控制层
 *
 * @author zhenwen
 * @since 2021-09-14 17:25:29
 */
@RestController
@RequestMapping("bookType")
public class BookTypeController {
    /**
     * 服务对象
     */
    @Resource
    private BookTypeService bookTypeService;

    /**
     * 分页查询
     *
     * @param bookType 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/list")
    public AjaxResult queryByPage(BookType bookType, Pageable pageRequest) {
        return AjaxResult.ok(this.bookTypeService.queryByPage(bookType, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult queryById(@PathVariable("id") Long id) {
        return AjaxResult.ok(this.bookTypeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param bookType 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody BookType bookType) {
        return AjaxResult.ok(this.bookTypeService.insert(bookType));
    }

    /**
     * 编辑数据
     *
     * @param bookType 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody BookType bookType) {
        return AjaxResult.ok(this.bookTypeService.update(bookType));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public AjaxResult deleteById(@RequestBody Long id) {
        return AjaxResult.ok(this.bookTypeService.deleteById(id));
    }

}

