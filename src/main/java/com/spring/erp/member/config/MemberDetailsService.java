package com.spring.erp.member.config;

import com.spring.erp.member.Entity.MemberEntity;
import com.spring.erp.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username)//사용자의 이름을 입력받아 그에 해당하는 정보를 UserDetails로 객체로 변환
            throws UsernameNotFoundException { //사용자를 찾지 못했을 때 UsernameNotFoundException 예외 전달
        MemberEntity member = memberRepository.findById(username) //MemberEntity를 데이터베이스에서 조회
                .orElseThrow(() -> new UsernameNotFoundException("Could not found user" + username));
                //

        return User.builder() //시큐리티의 UserDetails 인터페이스를 구현한 클래스
                .username(member.getCoUserNm()) // 사용자 이름 설정
                .password(member.getCoPwd()) // 암호화된 비밀번호 설정
                .roles("USER") //권한 설정
                .build(); //UserDetails 객체 생성
    }

}
