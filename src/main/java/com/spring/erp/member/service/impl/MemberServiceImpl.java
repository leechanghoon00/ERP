package com.spring.erp.member.service.impl;

import com.spring.erp.member.Entity.MemberEntity;
import com.spring.erp.member.dto.MemberDTO;
import com.spring.erp.member.repository.MemberRepository;
import com.spring.erp.member.service.MemberService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;



    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }



    @Override
    public MemberEntity addMember(MemberDTO memberDTO) {
        // TODO : dto 를 entity로 변환시켜서 memberRepository.save(MemberEntity객체);

        // 유저 등록 시 비밀번호 암호화
        // 여기서 dto의 비밀번호를 암호화 한 후 암호화된 비밀번호를 가진 DTO 를 toEntity 메소드를통해 암호화된 비밀번호가있는 Entity로 변환시킨다.
        // memberdto.get비밀번호 한 후에 이거 암호화해서 다시 set비밀번호를 한다.
        // CRUD 보통 이런형식이니까 DB관련해서 작업할거면 서비스단은 이흐름으로 가는게 좋다.

        //암호화
        String encryptedPassword = passwordEncoder.encode(memberDTO.getCoPwd());
        //암호화 된 비밀번호를 DTO에 전달
        memberDTO.setCoPwd(encryptedPassword);


        // DTO를 Entity로 변환
        MemberEntity memberEntity = memberDTO.toEntity(memberDTO);

        // 변환된 Entity를 저장
        return memberRepository.save(memberEntity);
    }

}
