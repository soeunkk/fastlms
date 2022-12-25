package com.zerobase.fastlms.loginhistory.repository;

import com.zerobase.fastlms.loginhistory.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
}
