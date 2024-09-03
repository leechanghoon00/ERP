package com.spring.erp.member.controller;

import com.spring.erp.member.dto.MemberDTO;
import com.spring.erp.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/api")
@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/add") //회원가입
    //TODO: Restful api 방식에대해서 공부가 필요 공부후 필요한 api로 적용 할것
    public void addMember(@RequestBody MemberDTO memberDTO) {
        memberService.addMember(memberDTO);
    }


    @PostMapping("/login")
    public ModelAndView login(@RequestBody MemberDTO memberDTO) {
        boolean isAuthenticated = memberService.login(memberDTO);

        if (isAuthenticated) {
            // 로그인 성공 시 성공 페이지로 리디렉트
            return new ModelAndView("redirect:/main");
        } else {
            // 로그인 실패 시 에러 메시지를 모델에 추가하고 다시 로그인 페이지로 리디렉트
            ModelAndView modelAndView = new ModelAndView(new RedirectView("/login"));
            modelAndView.addObject("errorMessage", "로그인에 실패.");
            return modelAndView;
        }
    }


//    //회원 수정
//    @PatchMapping("/editMember")
//    public MemberEntity updateMember(MemberEntity MemberEntity) {
//        return memberService.editMember(member);
//    }


}
