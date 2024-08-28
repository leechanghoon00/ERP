package com.spring.erp.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "member",  // 테이블 이름을 지정
        uniqueConstraints = {
                @UniqueConstraint(name = "UNIQUE_co_PHONE", columnNames = {"coPhone"})
        }
)
public class MemberEntity {

    @Id
    private String coId; //아이디
    private String coPwd; //비번
    private String coName; //이름
    private String coEmail; // 이메일
    private String coAddress; // 주소
    private String coJoinDate; // 입사날짜
    private String coPhone; // 폰번호
    private String coPosiCd; //부서
    private int coUserCd;  //부서코드
    private String coDeparCd; //직급
    private int coDeuserCd; //직급코드
    private String coUserNm;
    private String coDeuserNm;

}
