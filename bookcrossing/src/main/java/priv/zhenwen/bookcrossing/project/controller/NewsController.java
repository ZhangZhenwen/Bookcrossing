package priv.zhenwen.bookcrossing.project.controller;

import priv.zhenwen.bookcrossing.project.entity.News;
import priv.zhenwen.bookcrossing.project.service.NewsService;
import priv.zhenwen.bookcrossing.framework.web.domain.AjaxResult;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (News)表控制层
 *
 * @author zhenwen
 * @since 2021-09-10 18:59:00
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
    public AjaxResult add(@RequestBody News news) {
        return AjaxResult.ok(this.newsService.insert(news));
    }

    /**
     * 编辑数据
     *
     * @param news 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody News news) {
        return AjaxResult.ok(this.newsService.update(news));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public AjaxResult deleteById(@RequestBody Long id) {
        return AjaxResult.ok(this.newsService.deleteById(id));
    }

}

