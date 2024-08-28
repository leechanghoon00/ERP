package com.spring.erp.member.dto;

import com.spring.erp.member.entity.MemberEntity;
import lombok.Data;


@Data
public class MemberDTO {
    //TODO :회원가입에 필요한 정보들 넣기
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

    // DTO를 Entity로 변환하는 메서드
    public MemberEntity toEntity() {
        MemberEntity member = new MemberEntity();
        member.setCoId(this.coId);
        member.setCoPwd(this.coPwd);
        member.setCoName(this.coName);
        member.setCoEmail(this.coEmail);
        member.setCoAddress(this.coAddress);
        member.setCoJoinDate(this.coJoinDate);
        member.setCoPhone(this.coPhone);
        member.setCoPosiCd(this.coPosiCd);
        member.setCoUserCd(this.coUserCd);
        member.setCoDeparCd(this.coDeparCd);
        member.setCoDeuserCd(this.coDeuserCd);
        member.setCoUserNm(this.coUserNm);
        member.setCoDeuserNm(this.coDeuserNm);

        return member;
    }
}
