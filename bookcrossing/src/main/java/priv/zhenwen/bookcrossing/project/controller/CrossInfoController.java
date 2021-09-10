package priv.zhenwen.bookcrossing.project.controller;

import priv.zhenwen.bookcrossing.project.entity.CrossInfo;
import priv.zhenwen.bookcrossing.project.service.CrossInfoService;
import priv.zhenwen.bookcrossing.framework.web.domain.AjaxResult;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CrossInfo)表控制层
 *
 * @author zhenwen
 * @since 2021-09-10 18:59:00
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
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/list")
    public AjaxResult queryByPage(CrossInfo crossInfo, Pageable pageRequest) {
        return AjaxResult.ok(this.crossInfoService.queryByPage(crossInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult queryById(@PathVariable("id") Long id) {
        return AjaxResult.ok(this.crossInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param crossInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody CrossInfo crossInfo) {
        return AjaxResult.ok(this.crossInfoService.insert(crossInfo));
    }

    /**
     * 编辑数据
     *
     * @param crossInfo 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody CrossInfo crossInfo) {
        return AjaxResult.ok(this.crossInfoService.update(crossInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete/{id}")
    public AjaxResult deleteById(@PathVariable Long id) {
        return AjaxResult.ok(this.crossInfoService.deleteById(id));
    }

}

