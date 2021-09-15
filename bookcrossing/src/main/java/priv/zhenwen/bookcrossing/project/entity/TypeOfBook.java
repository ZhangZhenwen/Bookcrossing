package priv.zhenwen.bookcrossing.project.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TypeOfBook)实体类
 *
 * @author zhenwen
 * @since 2021-09-14 17:26:16
 */
public class TypeOfBook implements Serializable {
    private static final long serialVersionUID = 807711581472954601L;
    /**
     * 图书ID
     */
    private Long bookId;
    /**
     * 图书类型ID
     */
    private Long bookTypeId;
    /**
     * 创建时间
     */
    private Date createDate;


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Long bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}

