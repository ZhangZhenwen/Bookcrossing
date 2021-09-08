package priv.zhenwen.bookcrossing.framework.web.page;

/**
 * @author zhenwen
 * @date 2021/9/8
 */

public class PageHelper {
    private int page;

    private int size;

    private int total;

    private int totalPages;

    public PageHelper() {

    }

    public PageHelper(int page, int size, int total) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.totalPages = (total % size) == 0 ? total / size : total / size + 1;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
