package com.archforce.deploy.page;

import java.util.List;

/**
 * Created by lanyage on 2018/6/28.
 */
public class PageBean<T> {
    private int total;
    private int totalPage;
    private int pageNumber;
    private int pageSize;
    private int startIndex;
    private List<T> beanList;

    public int getTotal() {
        return total;
    }

    public PageBean<T> setTotal(int total) {
        this.total = total;
        return this;
    }

    public int getTotalPage() {
        return totalPage = this.total % this.pageSize == 0 ?
                (this.total / this.pageSize) : (this.total / this.pageSize + 1);
    }

    public PageBean<T> setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public PageBean<T> setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageBean<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getStartIndex() {
        return startIndex = this.pageSize * (this.pageNumber - 1);
    }

    public PageBean<T> setStartIndex(int startIndex) {
        this.startIndex = startIndex;
        return this;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public PageBean<T> setBeanList(List<T> products) {
        this.beanList = products;
        return this;
    }

    public PageBean() {
    }
}
