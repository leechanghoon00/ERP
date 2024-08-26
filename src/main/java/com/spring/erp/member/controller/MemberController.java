package com.spring.erp.member.controller;

import com.spring.erp.member.Entity.MemberEntity;
import com.spring.erp.member.dto.MemberDTO;
import com.spring.erp.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/add")
    //TODO: Restful api 방식에대해서 공부가 필요 공부후 필요한 api로 적용 할것
    public MemberEntity addMember(@RequestBody MemberDTO memberDTO){
        return memberService.addMember(memberDTO);
    }

//    //회원 수정
//    @PatchMapping("/editMember")
//    public MemberEntity updateMember(MemberEntity MemberEntity) {
//        return memberService.editMember(member);
//    }


}
