package com.zhaobao.spbtzb.service.impl.base;

import com.github.pagehelper.PageInfo;
import com.zhaobao.spbtzb.utils.PagedGridResult;

import java.util.List;

/**
 * @Author: zhaobao1830
 * @Date: 2021/3/26 8:56
 */
public class BaseService {

    /**
     * 封装分页方法
     * @param pageNum 当前页数
     * @param pageSize 每页条数
     * @param list 列表
     * @return {
     *     pageNum: 1
     *     pageSize: 6
     *     pages: 1
     *     rows: [{id: 1, username: "admin"}]
     *     total: 6
     * }
     */
    public PagedGridResult setterPagedGrid(Integer pageNum, Integer pageSize, List<?> list) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPageNum(pageNum);
        grid.setPageSize(pageSize);
        grid.setPages(pageList.getPages());
        grid.setTotal(pageList.getTotal());
        grid.setRows(list);
        return grid;
    }
}
