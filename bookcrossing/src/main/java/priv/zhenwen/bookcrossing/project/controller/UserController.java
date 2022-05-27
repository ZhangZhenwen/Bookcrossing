package priv.zhenwen.bookcrossing.project.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import priv.zhenwen.bookcrossing.framework.web.domain.AjaxResult;
import priv.zhenwen.bookcrossing.project.entity.User;
import priv.zhenwen.bookcrossing.project.service.UserService;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author zhenwen
 * @since 2021-09-05 10:46:20
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/list")
    public AjaxResult queryByPage(User user, Pageable pageRequest) {
        return AjaxResult.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult queryById(@PathVariable("id") Long id) {
        return AjaxResult.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody User user) {
        return AjaxResult.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody User user) {
        return AjaxResult.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public AjaxResult deleteById(@RequestBody Long id) {
        return AjaxResult.ok(this.userService.deleteById(id));
    }

}

