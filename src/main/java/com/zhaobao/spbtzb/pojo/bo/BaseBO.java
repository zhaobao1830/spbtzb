package com.zhaobao.spbtzb.pojo.bo;

/**
 * @Author: zhaobao1830
 * @Date: 2021/3/25 17:21
 */
public class BaseBO {

    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 每页条数
     */
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BaseBO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
