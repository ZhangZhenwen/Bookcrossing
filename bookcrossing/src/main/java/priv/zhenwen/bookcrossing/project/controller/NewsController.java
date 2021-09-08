package priv.zhenwen.bookcrossing.project.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import priv.zhenwen.bookcrossing.framework.web.domain.AjaxResult;
import priv.zhenwen.bookcrossing.project.entity.News;
import priv.zhenwen.bookcrossing.project.service.NewsService;

import javax.annotation.Resource;

/**
 * (News)表控制层
 *
 * @author zhenwen
 * @since 2021-09-08 16:57:14
 */
@RestController
@RequestMapping("news")
public class NewsController {
    /**
     * 服务对象
     */
    @Resource
    private NewsService newsService;

    /**
     * 分页查询
     *
     * @param news 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/list")
    public AjaxResult queryByPage(News news, Pageable pageRequest) {
        return AjaxResult.ok(this.newsService.queryByPage(news, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult queryById(@PathVariable("id") Long id) {
        return AjaxResult.ok(this.newsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param news 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public AjaxResult add(News news) {
        return AjaxResult.ok(this.newsService.insert(news));
    }

    /**
     * 编辑数据
     *
     * @param news 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    public AjaxResult edit(News news) {
        return AjaxResult.ok(this.newsService.update(news));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete")
    public AjaxResult deleteById(Long id) {
        return AjaxResult.ok(this.newsService.deleteById(id));
    }

}

