package com.spring.erp.member.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class CustomerEntity {
    @Id
    private String cus_id; //거래처 아이디
    private String cus_pwd; //거래처 비번
    private String cus_name; //거래처 이름
    private String cus_address; //거래처 주소
    private String cus_phone; // 거래처 번호
    private Date cus_joinDate; // 등록 일자
    private String cus_common_cd;
    private int cus_user_cd;
    private String cus_email; // 거래처 아이디
    private String subject;
    private String contents;
    private Date sendDate;
    private int message_no;
    private String confirm;

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_pwd() {
        return cus_pwd;
    }

    public void setCus_pwd(String cus_pwd) {
        this.cus_pwd = cus_pwd;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_address() {
        return cus_address;
    }

    public void setCus_address(String cus_address) {
        this.cus_address = cus_address;
    }

    public String getCus_phone() {
        return cus_phone;
    }

    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }

    public Date getCus_joinDate() {
        return cus_joinDate;
    }

    public void setCus_joinDate(Date cus_joinDate) {
        this.cus_joinDate = cus_joinDate;
    }

    public String getCus_common_cd() {
        return cus_common_cd;
    }

    public void setCus_common_cd(String cus_common_cd) {
        this.cus_common_cd = cus_common_cd;
    }

    public int getCus_user_cd() {
        return cus_user_cd;
    }

    public void setCus_user_cd(int cus_user_cd) {
        this.cus_user_cd = cus_user_cd;
    }

    public String getCus_email() {
        return cus_email;
    }

    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public int getMessage_no() {
        return message_no;
    }

    public void setMessage_no(int message_no) {
        this.message_no = message_no;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}
