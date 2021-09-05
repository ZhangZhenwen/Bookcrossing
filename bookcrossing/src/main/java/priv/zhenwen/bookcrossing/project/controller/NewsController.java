package priv.zhenwen.bookcrossing.project.controller;

import priv.zhenwen.bookcrossing.project.entity.News;
import priv.zhenwen.bookcrossing.project.service.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (News)表控制层
 *
 * @author zhenwen
 * @since 2021-09-05 10:58:44
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
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<News>> queryByPage(News news, PageRequest pageRequest) {
        return ResponseEntity.ok(this.newsService.queryByPage(news, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<News> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.newsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param news 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<News> add(News news) {
        return ResponseEntity.ok(this.newsService.insert(news));
    }

    /**
     * 编辑数据
     *
     * @param news 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<News> edit(News news) {
        return ResponseEntity.ok(this.newsService.update(news));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.newsService.deleteById(id));
    }

}

