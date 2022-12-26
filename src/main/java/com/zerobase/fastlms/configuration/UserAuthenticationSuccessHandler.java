package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.components.RequestUtils;
import com.zerobase.fastlms.loginhistory.service.LoginHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class UserAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private final LoginHistoryService loginHistoryService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        String userAgent = RequestUtils.getUserAgent(request);
        String clientIp = RequestUtils.getClientIp(request);
        String userId = authentication.getName();

        loginHistoryService.addLog(userAgent, clientIp, userId);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
