package com.spring.erp.member.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final MemberDetailsService memberDetailsService;

    public SecurityConfig(@Lazy MemberDetailsService memberDetailsService) {
        this.memberDetailsService = memberDetailsService;
    }


    // 특정 HTTP요청에 대한 웹 기반 보안 구성
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // http요청에 대한 접근권한
                .authorizeHttpRequests(authz -> authz // 요청에 대한 권한 설정
                        .requestMatchers("/api/add", "/login").permitAll() //요청 모두 허용 인증없이 사용가능
                        .anyRequest().authenticated() //나머지 경로는 인증요구
                )
                //폼 기반 로그인 설정 구성
                .formLogin(form -> form // 로그인 페이지 및 로그인 후 리다이렉션 설정
                        .loginPage("/login") // 로그인 페이지의 URL설정 , 로그인하지않은상태에서 접근하면 이 페이지로 리다이렉트
                        .defaultSuccessUrl("/main") //로그인 성공 후 home 페이지로 리다이렉트
                )
                //로그아웃 설정
                .logout(logout -> logout //로그아웃 처리 설정
                        .logoutSuccessUrl("/login") //로그아웃 후 login페이지로 리다이렉트
                        .invalidateHttpSession(true) // 로그아웃 후 세션 삭제하여 보안 강화
                )
                // CSRF(Cross-Site Request Forgery) 보호설정 비활성화
                 .csrf(AbstractHttpConfigurer::disable)

                .build();
    }


    // 인증 관리자 관련 설정
    @Bean
    public AuthenticationManager authProvider() throws Exception {
        // 객체 생성
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();


        daoAuthenticationProvider.setUserDetailsService((memberDetailsService)); // 사용자 세부 정보를 제공하는 'UserDetailsService'를 설정,여기에 주입할 실제 구현체('')가 필요함 데이터 베이스 조회를 담당하는 서비스 구현체
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder()); // 비밀번호를 인코딩할 'PasswordEncoder' 설정

        return new ProviderManager(daoAuthenticationProvider);
    }

    //패스워드 인코더로 사용할 빈 등록
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(); // 객체 생성하고 반환 , 비밀번호를 'BCrypt' 해서 알고리즘을 사용하여 인코딩

    }
}




