package priv.zhenwen.bookcrossing.project.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author zhenwen
 * @since 2021-09-14 17:25:29
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 207957734585618110L;
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
     * 图书简介
     */
    private String introduction;
    /**
     * 图书类型
     */
    private Long type;
    /**
     * 图书状态（0：上传中、1：可出借、2：已出借）
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 拥有者用户ID
     */
    private Long userId;

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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

