package com.spring.erp.member.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class CustomerDTO {

    private String cusId; //거래처 아이디
    private String cusPwd; //거래처 비번
    private String cusName; //거래처 이름
    private String cusAddress; //거래처 주소
    private String cusPhone; // 거래처 번호
    private Date cusJoinDate; // 등록 일자
    private String cusCommonCd;
    private int cusUserCd;
    private String cusEmail; // 거래처 아이디
    private String subject;
    private String contents;
    private Date sendDate;
    private int messageNo;
    private String confirm;


}
