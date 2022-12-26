package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.loginhistory.entity.LoginHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginHistoryDto {
    LocalDateTime loginDt;
    String clientIp;
    String userAgent;

    public static LoginHistoryDto of(LoginHistory loginHistory) {
        return LoginHistoryDto.builder()
                .loginDt(loginHistory.getLoginDt())
                .clientIp(loginHistory.getClientIp())
                .userAgent(loginHistory.getUserAgent())
                .build();
    }

    public static List<LoginHistoryDto> of(List<LoginHistory> loginHistory) {
        if (loginHistory == null) {
            return null;
        }

        List<LoginHistoryDto> loginHistoryList = new ArrayList<>();
        for (LoginHistory x : loginHistory) {
            loginHistoryList.add(LoginHistoryDto.of(x));
        }
        return loginHistoryList;
    }

    public String getLoginDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return loginDt != null ? loginDt.format(formatter) : "";
    }
}
