package priv.zhenwen.bookcrossing.controller;

import priv.zhenwen.bookcrossing.entity.Link;
import priv.zhenwen.bookcrossing.service.LinkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Link)表控制层
 *
 * @author zhenwen
 * @since 2021-09-04 22:29:57
 */
@RestController
@RequestMapping("link")
public class LinkController {
    /**
     * 服务对象
     */
    @Resource
    private LinkService linkService;

    /**
     * 分页查询
     *
     * @param link 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Link>> queryByPage(Link link, PageRequest pageRequest) {
        return ResponseEntity.ok(this.linkService.queryByPage(link, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Link> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.linkService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param link 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Link> add(Link link) {
        return ResponseEntity.ok(this.linkService.insert(link));
    }

    /**
     * 编辑数据
     *
     * @param link 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Link> edit(Link link) {
        return ResponseEntity.ok(this.linkService.update(link));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.linkService.deleteById(id));
    }

}

