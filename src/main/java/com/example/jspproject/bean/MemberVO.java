package com.example.jspproject.bean;

import java.util.Date;

public class MemberVO {
    private int sid;
    private String name;
    private String email;
    private String phone;
    private String rc;
    private String detail;
    private String photo;
    private Date regdate;

    public int getSid() {return sid;}
    public void setSid(int sid) {this.sid = sid;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public String getRc() {return rc;}
    public void setRc(String rc) {this.rc = rc;}
    public String getDetail() {return detail;}
    public void setDetail(String detail) {this.detail = detail;}
    public String getPhoto() {return photo;}
    public void setPhoto(String photo) {this.photo = photo;}
    public Date getRegdate() {return regdate;}
    public void setRegdate(Date regdate) {this.regdate = regdate;}

}
