package com.spring.erp.repository;

import com.spring.erp.member.repository.MemberRepository;
import com.spring.erp.member.service.MemberService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;

import java.beans.BeanProperty;

public class MemberRepositoryTest {

    MemberService memberService;
    MemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
//        memberRepository = new MemberRepository();
//        memberService = new MemberService(memberRepository);
    }



}
