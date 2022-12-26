package com.zerobase.fastlms.loginhistory.repository;

import com.zerobase.fastlms.loginhistory.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
    List<LoginHistory> findAllByUserId(String userId);
}
