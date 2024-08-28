package com.spring.erp.member.service.impl;

import com.spring.erp.member.entity.MemberEntity;
import com.spring.erp.member.dto.MemberDTO;
import com.spring.erp.member.repository.MemberRepository;
import com.spring.erp.member.service.MemberService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 생성자 주입으로 의존성 주입
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, BCryptPasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public void addMember(MemberDTO memberDTO) {
        // 유저 등록 시 비밀번호 암호화
        // 여기서 dto의 비밀번호를 암호화 한 후 암호화된 비밀번호를 가진 DTO 를 toEntity 메소드를통해 암호화된 비밀번호가있는 Entity로 변환시킨다.
        // memberdto.get비밀번호 한 후에 이거 암호화해서 다시 set비밀번호를 한다.
        // CRUD 보통 이런형식이니까 DB관련해서 작업할거면 서비스단은 이흐름으로 가는게 좋다.
        boolean exists = memberRepository.existsById(memberDTO.getCoId()); //아이디 중복 확인
        if (exists) {//중복 아이디가 있을 경우 메시지 반환
            throw new IllegalArgumentException("이미 존재하는 아이디 : "+memberDTO.getCoId());
        }
        //암호화
        String encryptedPassword = passwordEncoder.encode(memberDTO.getCoPwd());
        //암호화 된 비밀번호를 DTO에 전달
        memberDTO.setCoPwd(encryptedPassword);


        // DTO를 Entity로 변환
        MemberEntity memberEntity = memberDTO.toEntity();

        // 변환된 Entity를 저장
        memberRepository.save(memberEntity);
    }



}
