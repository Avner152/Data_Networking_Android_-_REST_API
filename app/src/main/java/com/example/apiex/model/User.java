package com.example.apiex.model;

import java.util.List;

public class User {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Data> data;

    public User() {
    }

    public User(int page, int per_page, int total, int total_pages, List<Data> dataList) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = dataList;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setData(List<Data> dataList) {
        this.data = dataList;
    }

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<Data> getData() {
        return data;
    }
}
