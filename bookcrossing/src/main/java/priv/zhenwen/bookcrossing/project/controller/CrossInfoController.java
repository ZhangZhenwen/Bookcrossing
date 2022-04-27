package priv.zhenwen.bookcrossing.project.controller;

import priv.zhenwen.bookcrossing.project.entity.CrossInfo;
import priv.zhenwen.bookcrossing.project.entity.vo.ApplyVo;
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
     * 查询请求列表
     *
     * @return 查询结果
     */
    @GetMapping("/applyList")
    public AjaxResult queryForApply() {
        return AjaxResult.ok(this.crossInfoService.queryForApply());
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
     * 处理漂流请求
     *
     * @param crossInfo 漂流请求
     * @return 是否成功
     */
    @PostMapping("/handle")
    public AjaxResult handleCrossing(@RequestBody CrossInfo crossInfo) {
        return AjaxResult.ok(this.crossInfoService.handleCrossing(crossInfo));
    }

    /**
     * 是否正在漂流图书
     *
     * @param crossInfo 漂流请求
     * @return 是否正在漂流
     */
    @PostMapping("/checkApply")
    public AjaxResult isApplying(@RequestBody CrossInfo crossInfo) {
        return AjaxResult.ok(this.crossInfoService.isApplying(crossInfo));
    }

    /**
     * 同意图书漂流申请
     *
     * @param applyVo 漂流申请
     * @return 是否拒绝成功
     */
    @PostMapping("/agree")
    public AjaxResult agree(@RequestBody ApplyVo applyVo) {
        return AjaxResult.ok(this.crossInfoService.agree(applyVo));
    }

    /**
     * 拒绝图书漂流申请
     *
     * @param applyVo 漂流申请
     * @return 是否拒绝成功
     */
    @PostMapping("/refuse")
    public AjaxResult refuse(@RequestBody ApplyVo applyVo) {
        return AjaxResult.ok(this.crossInfoService.refuse(applyVo));
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

