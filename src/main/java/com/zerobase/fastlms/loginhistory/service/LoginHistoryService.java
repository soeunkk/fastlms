package com.zerobase.fastlms.loginhistory.service;

import com.zerobase.fastlms.loginhistory.entity.LoginHistory;
import com.zerobase.fastlms.loginhistory.repository.LoginHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class LoginHistoryService {
    private final LoginHistoryRepository loginHistoryRepository;

    public void addLog(String userAgent, String clientIp, String userId) {
        LoginHistory loginHistory = LoginHistory.builder()
                .userId(userId)
                .loginDt(LocalDateTime.now())
                .userAgent(userAgent)
                .clientIp(clientIp)
                .build();
        loginHistoryRepository.save(loginHistory);
    }
}
