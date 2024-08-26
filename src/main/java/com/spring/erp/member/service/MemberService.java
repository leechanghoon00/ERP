package com.spring.erp.member.service;

import com.spring.erp.member.Entity.MemberEntity;
import com.spring.erp.member.dto.MemberDTO;


public interface MemberService {


    //중복 ID 체크

    //회원 가입
    MemberEntity addMember(MemberDTO memberDTO) ;

    //회원 수정

    //회원 탈퇴

}
