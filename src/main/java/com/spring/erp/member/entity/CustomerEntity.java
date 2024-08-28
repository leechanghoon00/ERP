package com.spring.erp.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@Entity
@Table(
        name = "customer",  // 테이블 이름을 지정
        uniqueConstraints = {
                @UniqueConstraint(name = "UNIQUE_CUS_PHONE", columnNames = {"cusPhone"})
        }
)
public class CustomerEntity {
    @Id
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
    private String conFirm;


}
