package com.zerobase.fastlms.loginhistory.service;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;
import com.zerobase.fastlms.loginhistory.entity.LoginHistory;
import com.zerobase.fastlms.loginhistory.repository.LoginHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<LoginHistoryDto> findByUserId(String userId) {
        List<LoginHistory> allByUserId = loginHistoryRepository.findAllByUserId(userId);
        return LoginHistoryDto.of(allByUserId);
    }
}
