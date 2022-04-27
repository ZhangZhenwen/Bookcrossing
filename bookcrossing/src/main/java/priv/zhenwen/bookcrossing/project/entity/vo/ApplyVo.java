package priv.zhenwen.bookcrossing.project.entity.vo;

import priv.zhenwen.bookcrossing.project.entity.Book;
import priv.zhenwen.bookcrossing.project.entity.CrossInfo;
import priv.zhenwen.bookcrossing.project.entity.User;

import java.util.Date;

/**
 * @author zhenwen
 * @date 2021/9/16
 */

public class ApplyVo {
    /**
     * 漂流ID
     */
    private Long crossInfoId;
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
     * 创建时间
     */
    private Date createDate;

    /**
     * 用户名
     */
    private String username;

    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 用户ID
     */
    private Long userId;

    public ApplyVo() {
    }

    public ApplyVo(Book book, User user, CrossInfo crossInfo) {
        this.crossInfoId = crossInfo.getCrossInfoId();
        this.bookId = book.getBookId();
        this.bookNo = book.getBookNo();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.createDate = book.getCreateDate();
        this.username = user.getUsername();
        this.updateDate = crossInfo.getUpdateDate();
        this.userId = user.getUserId();
    }

    public Long getCrossInfoId() {
        return crossInfoId;
    }

    public void setCrossInfoId(Long crossInfoId) {
        this.crossInfoId = crossInfoId;
    }

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
