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
    @Column
    private String coId; //아이디
    @Column
    private String coPwd; //비번
    @Column
    private String coName; //이름
    @Column
    private String coEmail; // 이메일
    @Column
    private String coAddress; // 주소
    @Column
    private String coJoinDate; // 입사날짜
    @Column
    private String coPhone; // 폰번호
    @Column
    private String coPosiCd; //부서
    @Column
    private int coUserCd;  //부서코드
    @Column
    private String coDeparCd; //직급
    @Column
    private int coDeuserCd; //직급코드
    @Column
    private String coUserNm;
    @Column
    private String coDeuserNm;

}
