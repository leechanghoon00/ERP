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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity member = memberRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Could not found user" + username));

//        log.info("Success find member {}", member);

        return User.builder()
                .username(member.getCoUserNm())
                .password(passwordEncoder.encode(member.getCoPwd()))
                .roles("ADMIN")
                .build();
    }

}
