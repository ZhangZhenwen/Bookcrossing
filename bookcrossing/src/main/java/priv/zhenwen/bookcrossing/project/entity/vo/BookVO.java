package priv.zhenwen.bookcrossing.project.entity.vo;

import priv.zhenwen.bookcrossing.project.entity.Book;

import java.util.Date;

/**
 * @author zhenwen
 * @date 2022/5/25
 */

public class BookVO {
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
    private String type;
    /**
     * 图书状态（0：上传中、1：可出借、2：已出借）
     */
    private String status;
    /**
     * 创建时间
     */

    private Date createDate;

    /**
     * 拥有者用户名称
     */
    private String username;

    /**
     * 电子书名称
     */
    private String pdfName;

    /**
     * 电子书下载路径
     */
    private String pdfUrl;

    public BookVO() {
    }

    public BookVO(Book book, String type, String status, String username) {
        this.bookId = book.getBookId();
        this.bookNo = book.getBookNo();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.introduction = book.getIntroduction();
        this.type = type;
        this.status = status;
        this.createDate = book.getCreateDate();
        this.username = username;
        this.pdfName = book.getPdfName();
        this.pdfUrl = book.getPdfUrl();
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
