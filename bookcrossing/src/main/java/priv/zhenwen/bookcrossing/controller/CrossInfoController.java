package priv.zhenwen.bookcrossing.controller;

import priv.zhenwen.bookcrossing.entity.CrossInfo;
import priv.zhenwen.bookcrossing.service.CrossInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CrossInfo)表控制层
 *
 * @author zhenwen
 * @since 2021-09-04 22:52:26
 */
@RestController
@RequestMapping("crossInfo")
public class CrossInfoController {
    /**
     * 服务对象
     */
    @Resource
    private CrossInfoService crossInfoService;

    /**
     * 分页查询
     *
     * @param crossInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CrossInfo>> queryByPage(CrossInfo crossInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.crossInfoService.queryByPage(crossInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CrossInfo> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.crossInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param crossInfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CrossInfo> add(CrossInfo crossInfo) {
        return ResponseEntity.ok(this.crossInfoService.insert(crossInfo));
    }

    /**
     * 编辑数据
     *
     * @param crossInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CrossInfo> edit(CrossInfo crossInfo) {
        return ResponseEntity.ok(this.crossInfoService.update(crossInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.crossInfoService.deleteById(id));
    }

}

