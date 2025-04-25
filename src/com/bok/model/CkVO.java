package com.bok.model;

import java.sql.Date;

public class CkVO {
    private String ckCategory;
    private int ckNum;
    private String tip;
    private Date ckDate;
    private int ckContentNum;
    private String ckTitle;
    private String ckContent;

    // 기본 생성자
    public CkVO() {

    }
    // 모든 필드를 받는 생성자
    public CkVO(String ckCategory, int ckNum, String tip, Date ckDate, int ckContentNum, String ckTitle, String ckContent) {
        this.ckCategory = ckCategory;
        this.ckNum = ckNum;
        this.tip = tip;
        this.ckDate = ckDate;
        this.ckContentNum = ckContentNum;
        this.ckTitle = ckTitle;
        this.ckContent = ckContent;
    }
   
    public CkVO(String ckCategory, Date ckDate, String ckContent, String ckTitle, String ckTip) {
        this.ckCategory = ckCategory;
        this.ckDate = ckDate;
        this.ckContent = ckContent;
        this.ckTitle = ckTitle;
        this.tip = ckTip;
    }
    // 필수 필드만 받는 생성자
    public CkVO(String ckCategory, Date ckDate, String ckContent, String ckTitle) {
        this.ckCategory = ckCategory;
        this.ckDate = ckDate;
        this.ckContent = ckContent;
        this.ckTitle = ckTitle;
    }

   
    public CkVO(String ckTitle, String ckContent, int ckNum, int ckContentNum) {
        this.ckTitle = ckTitle;
        this.ckContent = ckContent;
        this.ckNum = ckNum;
        this.ckContentNum = ckContentNum;
    }


    public CkVO(String string, Date date) {
        this.ckTitle = ckTitle;
	}
	public String getckCategory() {
        return ckCategory;
    }

    public void setckCategory(String ckCategory) {
        this.ckCategory = ckCategory;
    }

    public int getCkNum() {
        return ckNum;
    }

    public void setCkNum(int ckNum) {
        this.ckNum = ckNum;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Date getCkDate() {
        return ckDate;
    }

    public void setCkDate(Date ckDate) {
        this.ckDate = ckDate;
    }

    public int getCkContentNum() {
        return ckContentNum;
    }

    public void setCkContentNum(int ckContentNum) {
        this.ckContentNum = ckContentNum;
    }

    public String getCkTitle() {
        return ckTitle;
    }

    public void setCkTitle(String ckTitle) {
        this.ckTitle = ckTitle;
    }

    public String getCkContent() {
        return ckContent;
    }

    public void setCkContent(String ckContent) {
        this.ckContent = ckContent;
    }

    @Override
    public String toString() {
        return "CkVO [ckCategory=" + ckCategory + ", ckNum=" + ckNum + ", tip=" + tip + ", ckDate=" + ckDate
                + ", ckContentNum=" + ckContentNum + ", ckTitle=" + ckTitle + ", ckContent=" + ckContent + "]";
    }
}