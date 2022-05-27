package priv.zhenwen.bookcrossing.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import priv.zhenwen.bookcrossing.common.constant.CrossInfoStatus;
import priv.zhenwen.bookcrossing.framework.security.service.LoginService;
import priv.zhenwen.bookcrossing.project.entity.Book;
import priv.zhenwen.bookcrossing.project.entity.CrossInfo;
import priv.zhenwen.bookcrossing.project.entity.User;
import priv.zhenwen.bookcrossing.project.entity.vo.ApplyVo;
import priv.zhenwen.bookcrossing.project.entity.vo.UserCrossInfoVo;
import priv.zhenwen.bookcrossing.project.mapper.CrossInfoMapper;
import priv.zhenwen.bookcrossing.project.service.BookService;
import priv.zhenwen.bookcrossing.project.service.CrossInfoService;
import priv.zhenwen.bookcrossing.project.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * (CrossInfo)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-10 18:59:00
 */
@Service("crossInfoService")
public class CrossInfoServiceImpl implements CrossInfoService {
    @Resource
    private CrossInfoMapper crossInfoMapper;

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    /**
     * 通过ID查询单条数据
     *
     * @param crossInfoId 主键
     * @return 实例对象
     */
    @Override
    public CrossInfo queryById(Long crossInfoId) {
        return this.crossInfoMapper.queryById(crossInfoId);
    }
    
    /**
     * 根据属性查询指定数据
     * 
     * @param crossInfo 查询条件
     * @return 对象列表
     */
     @Override
    public List<CrossInfo> queryAll(CrossInfo crossInfo) {
        return this.crossInfoMapper.queryAll(crossInfo);
    }


    /**
     * 分页查询
     *
     * @param crossInfo 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<CrossInfo> queryByPage(CrossInfo crossInfo, Pageable pageRequest) {
        long total = this.crossInfoMapper.count(crossInfo);
        return new PageImpl<>(this.crossInfoMapper.queryAllByLimit(crossInfo, pageRequest), pageRequest, total);
    }

    @Override
    public Page<UserCrossInfoVo> queryUserCrossInfoVOPage(CrossInfo crossInfo, Pageable pageRequest) {
        long total = this.crossInfoMapper.count(crossInfo);
        Page<CrossInfo> crossInfoPage = queryByPage(crossInfo, pageRequest);
        Iterator<CrossInfo> iterator = crossInfoPage.iterator();
        List<UserCrossInfoVo> userCrossInfoVos = new ArrayList<>();
        while (iterator.hasNext()) {
            CrossInfo item = iterator.next();
             // 漂流状态（0：已拒绝、1：申请中、2：申请成功、3：漂流中、4：已完成）
            String status = item.getStatus();
            switch (status) {
                case "0":
                    status = "已拒绝";
                    break;
                case "1":
                    status = "申请中";
                    break;
                case "2":
                    status = "申请成功";
                    break;
                case "3":
                    status = "漂流中";
                    break;
                case "4":
                    status = "已完成";
                    break;
            }
            item.setStatus(status);
            UserCrossInfoVo vo = new UserCrossInfoVo(bookService.queryById(item.getBookId()), item);
            userCrossInfoVos.add(vo);
        }
        return new PageImpl<>(userCrossInfoVos, pageRequest, total);
    }

    /**
     * 查询申请列表
     *
     * @return 查询结果
     */
    @Override
    public Page<ApplyVo> queryForApply() {
        Long userId = this.loginService.getUserId();

        Book queryBook = new Book();
        queryBook.setUserId(userId);
        List<Book> bookList = bookService.queryAll(queryBook);

        List<ApplyVo> applyVos = new ArrayList<>();

        for (Book book : bookList) {
            CrossInfo queryInfo = new CrossInfo();
            queryInfo.setBookId(book.getBookId());
            queryInfo.setStatus(CrossInfoStatus.APPLY);

            for (CrossInfo info : queryAll(queryInfo)) {
                User target = userService.queryById(info.getUserId());
                ApplyVo applyVo = new ApplyVo(book, target, info);
                applyVos.add(applyVo);
            }

        }

        return new PageImpl<>(applyVos);
    }

    /**
     * 新增数据
     *
     * @param crossInfo 实例对象
     * @return 实例对象
     */
    @Override
    public CrossInfo insert(CrossInfo crossInfo) {
        this.crossInfoMapper.insert(crossInfo);
        return crossInfo;
    }

    /**
     * 修改数据
     *
     * @param crossInfo 实例对象
     * @return 实例对象
     */
    @Override
    public CrossInfo update(CrossInfo crossInfo) {
        crossInfo.setUpdateDate(new Date());
        this.crossInfoMapper.update(crossInfo);
        return this.queryById(crossInfo.getCrossInfoId());
    }

    /**
     * 通过主键删除数据
     *
     * @param crossInfoId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long crossInfoId) {
        return this.crossInfoMapper.deleteById(crossInfoId) > 0;
    }

    /**
     * 处理漂流请求
     * @param crossInfo 漂流请求
     * @return 是否成功
     */
    @Override
    public boolean handleCrossing(CrossInfo crossInfo) {
        crossInfo.setStatus("1");
        crossInfo.setType("0");
        crossInfo.setCreateDate(new Date());
        crossInfo.setUpdateDate(new Date());

        Long userId = loginService.getUserId();

        crossInfo.setUserId(userId);

        return this.crossInfoMapper.insert(crossInfo) > 0;
    }

    /**
     * 是否正在申请漂流
     *
     * @param crossInfo 漂流申请
     * @return 漂流申请
     */
    @Override
    public boolean isApplying(CrossInfo crossInfo) {
        Long userId = loginService.getUserId();

        crossInfo.setStatus("1");
        crossInfo.setUserId(userId);

        return !this.crossInfoMapper.queryAll(crossInfo).isEmpty();
    }

    @Override
    public boolean agree(ApplyVo applyVo) {
        Book book = bookService.queryById(applyVo.getBookId());
        CrossInfo crossInfo = queryById(applyVo.getCrossInfoId());
        crossInfo.setStatus("4");
        update(crossInfo);

        book.setStatus("2");
        book.setUserId(applyVo.getUserId());
        bookService.update(book);

        return true;
    }

    /**
     * 拒绝漂流请求
     *
     * @param applyVo 漂流请求
     * @return 是否拒绝成功
     */
    @Override
    public boolean refuse(ApplyVo applyVo) {
        CrossInfo crossInfo = queryById(applyVo.getCrossInfoId());

        crossInfo.setStatus("0");
        update(crossInfo);

        return true;
    }
}
