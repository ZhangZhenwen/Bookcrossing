package priv.zhenwen.bookcrossing.project.entity.vo;

import priv.zhenwen.bookcrossing.project.entity.Book;
import priv.zhenwen.bookcrossing.project.entity.CrossInfo;

import java.util.Date;

/**
 * @author zhenwen
 * @date 2022/5/4
 */

public class UserCrossInfoVo {
    private String bookNo;
    private String name;
    private String author;
    private Date createDate;
    private Date updateDate;
    private String type;
    private String status;

    public UserCrossInfoVo() {
    }

    public UserCrossInfoVo(Book book, CrossInfo crossInfo) {
        this.bookNo = book.getBookNo();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.createDate = crossInfo.getCreateDate();
        this.updateDate = crossInfo.getUpdateDate();
        this.type = crossInfo.getType();
        this.status = crossInfo.getStatus();
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
}
