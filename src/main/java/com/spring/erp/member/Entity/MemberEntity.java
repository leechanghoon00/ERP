package com.spring.erp.member.Entity;

import com.spring.erp.member.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MemberEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long coSeq;

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
