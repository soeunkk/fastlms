package com.zerobase.fastlms.loginhistory.controller;

import com.zerobase.fastlms.components.RequestUtils;
import com.zerobase.fastlms.loginhistory.service.LoginHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class LoginHistoryController {
    private final LoginHistoryService loginHistoryService;

    @GetMapping("/login-success")
    public String loginSuccess(HttpServletRequest request, Principal principal) {
        String userAgent = RequestUtils.getUserAgent(request);
        String clientIp = RequestUtils.getClientIp(request);
        String userId = principal.getName();

        loginHistoryService.addLog(userAgent, clientIp, userId);

        return "redirect:/";
    }
}
