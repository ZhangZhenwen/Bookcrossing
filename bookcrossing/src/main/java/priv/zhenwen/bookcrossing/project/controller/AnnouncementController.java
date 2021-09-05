package priv.zhenwen.bookcrossing.project.controller;

import priv.zhenwen.bookcrossing.project.entity.Announcement;
import priv.zhenwen.bookcrossing.project.service.AnnouncementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Announcement)表控制层
 *
 * @author zhenwen
 * @since 2021-09-05 10:46:19
 */
@RestController
@RequestMapping("announcement")
public class AnnouncementController {
    /**
     * 服务对象
     */
    @Resource
    private AnnouncementService announcementService;

    /**
     * 分页查询
     *
     * @param announcement 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Announcement>> queryByPage(Announcement announcement, PageRequest pageRequest) {
        return ResponseEntity.ok(this.announcementService.queryByPage(announcement, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Announcement> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.announcementService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param announcement 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Announcement> add(Announcement announcement) {
        return ResponseEntity.ok(this.announcementService.insert(announcement));
    }

    /**
     * 编辑数据
     *
     * @param announcement 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Announcement> edit(Announcement announcement) {
        return ResponseEntity.ok(this.announcementService.update(announcement));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.announcementService.deleteById(id));
    }

}

