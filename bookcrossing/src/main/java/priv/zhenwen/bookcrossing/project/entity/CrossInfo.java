package priv.zhenwen.bookcrossing.project.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (CrossInfo)实体类
 *
 * @author zhenwen
 * @since 2021-09-08 16:57:14
 */
public class CrossInfo implements Serializable {
    private static final long serialVersionUID = 383026625575318478L;
    /**
     * 漂流ID
     */
    private Long crossInfoId;
    /**
     * 图书ID
     */
    private Integer bookId;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 漂流类型
     */
    private String type;
    /**
     * 漂流状态（1：申请中、2：申请成功、3：漂流中、4：已完成）
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 用户ID
     */
    private Integer userId;


    public Long getCrossInfoId() {
        return crossInfoId;
    }

    public void setCrossInfoId(Long crossInfoId) {
        this.crossInfoId = crossInfoId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}

