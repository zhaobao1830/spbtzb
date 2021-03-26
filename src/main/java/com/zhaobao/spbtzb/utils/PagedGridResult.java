package com.zhaobao.spbtzb.utils;

import java.util.List;

/**
 * @Author: zhaobao1830
 * @Date: 2021/3/25 17:32
 * 返回分页数据
 */
public class PagedGridResult {
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     *  总页数
     */
    private Integer pages;
    /**
     * 总条数
     */
    private long total;
    /**
     * 每行显示的内容
     */
    private List<?> rows;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
