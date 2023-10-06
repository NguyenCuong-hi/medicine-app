package com.example.medicineapp.dto.request.search;

import java.io.Serializable;
import java.util.UUID;

public class SearchDto implements Serializable {

    private UUID id;
    private int pageSize;
    private int pageIndex;
    private String orderByFilter;
    private String keyword;


    public void setPageSize(Integer pageSize){

        if(pageSize != null && pageIndex > 0){
            this.pageSize = pageSize;
        }
    }

    public void setPageIndex(Integer pageIndex){
        if(pageIndex != null && pageIndex > 1){
            this.pageIndex = pageIndex;
        }
    }

    public void setPageIndexAndPageSize(Integer pageIndex, Integer pageSize){
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public int getOffset(){
        return (this.pageIndex - 1) * this.pageSize;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getOrderByFilter() {
        return orderByFilter;
    }

    public void setOrderByFilter(String orderByFilter) {
        this.orderByFilter = orderByFilter;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
