package priv.zhenwen.bookcrossing.common.util;

import lombok.Data;

import java.util.List;

/**
 * @author zhenwen
 * @date 2020/10/12
 */
@Data
public class Pager<T> {
    private Integer page;
    private Integer size;
    private List<T> rows;
    private Integer total;

    public Pager() {
    }

    public Pager(Integer page, Integer size) {
        this(page, size, null, null);
    }

    public Pager(Integer page, Integer size, List<T> rows, Integer total) {
        this.page = page;
        this.size = size;
        this.rows = rows;
        this.total = total;
    }
}
