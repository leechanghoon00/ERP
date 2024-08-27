package com.spring.erp.member.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class CustomerDTO {

    private String CusId; //거래처 아이디
    private String CusPwd; //거래처 비번
    private String CusName; //거래처 이름
    private String CusAddress; //거래처 주소
    private String CusPhone; // 거래처 번호
    private Date CusJoinDate; // 등록 일자
    private String CusCommonCd;
    private int CusUserCd;
    private String CusEmail; // 거래처 아이디
    private String Subject;
    private String Contents;
    private Date SendDate;
    private int MessageNo;
    private String Confirm;


}
