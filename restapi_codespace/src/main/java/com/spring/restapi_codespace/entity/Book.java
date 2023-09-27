package com.spring.restapi_codespace.entity;

import java.util.Date;

public class Book {
    private int bookid;
    private String bookName;
    private int pageNo;
    private Date lastupdated;
    
    public int getBookid() {
        return bookid;
    }
    @Override
    public String toString() {
        return "Book [bookid=" + bookid + ", bookName=" + bookName + ", pageNo=" + pageNo + ", lastupdated="
                + lastupdated + "]";
    }
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    public Book(int bookid, String bookName, int pageNo, Date lastupdated) {
        this.bookid = bookid;
        this.bookName = bookName;
        this.pageNo = pageNo;
        this.lastupdated = lastupdated;
    }
    public Book() {
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public Date getLastupdated() {
        return lastupdated;
    }
    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }
    
}
