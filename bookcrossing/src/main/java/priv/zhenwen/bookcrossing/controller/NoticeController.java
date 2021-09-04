package priv.zhenwen.bookcrossing.controller;

import priv.zhenwen.bookcrossing.entity.Notice;
import priv.zhenwen.bookcrossing.service.NoticeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Notice)表控制层
 *
 * @author zhenwen
 * @since 2021-09-04 22:29:57
 */
@RestController
@RequestMapping("notice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;

    /**
     * 分页查询
     *
     * @param notice 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Notice>> queryByPage(Notice notice, PageRequest pageRequest) {
        return ResponseEntity.ok(this.noticeService.queryByPage(notice, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Notice> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.noticeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param notice 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Notice> add(Notice notice) {
        return ResponseEntity.ok(this.noticeService.insert(notice));
    }

    /**
     * 编辑数据
     *
     * @param notice 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Notice> edit(Notice notice) {
        return ResponseEntity.ok(this.noticeService.update(notice));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.noticeService.deleteById(id));
    }

}

