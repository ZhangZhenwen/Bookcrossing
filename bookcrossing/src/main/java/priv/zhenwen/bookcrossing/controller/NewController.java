package priv.zhenwen.bookcrossing.controller;

import priv.zhenwen.bookcrossing.entity.New;
import priv.zhenwen.bookcrossing.service.NewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (New)表控制层
 *
 * @author zhenwen
 * @since 2021-09-04 22:29:57
 */
@RestController
@RequestMapping("new")
public class NewController {
    /**
     * 服务对象
     */
    @Resource
    private NewService newService;

    /**
     * 分页查询
     *
     * @param new 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<New>> queryByPage(New new, PageRequest pageRequest) {
        return ResponseEntity.ok(this.newService.queryByPage(new, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<New> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.newService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param new 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<New> add(New new) {
        return ResponseEntity.ok(this.newService.insert(new));
    }

    /**
     * 编辑数据
     *
     * @param new 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<New> edit(New new) {
        return ResponseEntity.ok(this.newService.update(new));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.newService.deleteById(id));
    }

}
