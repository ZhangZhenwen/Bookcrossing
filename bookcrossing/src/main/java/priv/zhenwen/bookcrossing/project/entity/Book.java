package priv.zhenwen.bookcrossing.project.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author zhenwen
 * @since 2021-09-08 16:57:14
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 240024776408336073L;
    /**
     * 图书ID
     */
    private Long bookId;
    /**
     * 图书编号
     */
    private String bookNo;
    /**
     * 图书名称
     */
    private String name;
    /**
     * 图书作者
     */
    private String author;
    /**
     * 图书类型
     */
    private String type;
    /**
     * 图书状态（0：上传中、1：可出借、2：已出借）
     */
    private String status;
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

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}

