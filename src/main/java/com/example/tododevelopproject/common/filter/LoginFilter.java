package com.example.tododevelopproject.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LoginFilter implements Filter {

    // 속성
    private static final String[] WHITE_LIST = {"/auth/session-login", "/members/signup"} ;

    // 생성자

    // 기능
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        log.info("request URI = {}", requestURI);

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        log.info("로그인 필터 로직 실행");

        if (!isWhiteList(requestURI)) {

            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute("loginMember") == null) {
                httpResponse.setCharacterEncoding("UTF-8"); // UTF-8로 인코딩 설정
                httpResponse.setContentType("application/json; charset=UTF-8"); // Content-Type 설정
                httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("errorCode", "401 UNAUTHORIZED");
                errorResponse.put("error", "로그인하지 않은 상태입니다. 로그인 해주세요.");

                ObjectMapper objectMapper = new ObjectMapper();
                String jsonResponse = objectMapper.writeValueAsString(errorResponse);

                httpResponse.getWriter().write(jsonResponse);

                return;
            }

            // 로그인 성공 로직
            log.info("로그인에 성공했습니다.");
        }

        filterChain.doFilter(request, response);
    }

    private boolean isWhiteList(String requestURI) {

        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
