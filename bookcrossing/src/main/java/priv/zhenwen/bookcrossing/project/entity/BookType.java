package priv.zhenwen.bookcrossing.project.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (BookType)实体类
 *
 * @author zhenwen
 * @since 2021-09-14 17:25:29
 */
public class BookType implements Serializable {
    private static final long serialVersionUID = -65815559494045577L;
    /**
     * 图书类型主键
     */
    private Long bookTypeId;
    /**
     * 图书类型代码
     */
    private String typeCode;
    /**
     * 图书类型名称
     */
    private String typeName;
    /**
     * 创建时间
     */
    private Date createDate;


    public Long getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Long bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}

