package priv.zhenwen.bookcrossing.project.service.impl;

import priv.zhenwen.bookcrossing.project.entity.News;
import priv.zhenwen.bookcrossing.project.mapper.NewsMapper;
import priv.zhenwen.bookcrossing.project.service.NewsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (News)表服务实现类
 *
 * @author zhenwen
 * @since 2021-09-05 10:58:44
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param newsId 主键
     * @return 实例对象
     */
    @Override
    public News queryById(Long newsId) {
        return this.newsMapper.queryById(newsId);
    }
    
    /**
     * 根据属性查询指定数据
     * 
     * @param news 查询条件
     * @return 对象列表
     */
     @Override
    public List<News> queryAll(News news) {
        return this.newsMapper.queryAll(news);
    }


    /**
     * 分页查询
     *
     * @param news 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<News> queryByPage(News news, PageRequest pageRequest) {
        long total = this.newsMapper.count(news);
        return new PageImpl<>(this.newsMapper.queryAllByLimit(news, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    @Override
    public News insert(News news) {
        this.newsMapper.insert(news);
        return news;
    }

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    @Override
    public News update(News news) {
        this.newsMapper.update(news);
        return this.queryById(news.getNewsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param newsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long newsId) {
        return this.newsMapper.deleteById(newsId) > 0;
    }
}
