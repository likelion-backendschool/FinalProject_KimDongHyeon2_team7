package com.ll.exam.mutbooks.app.email.repository;

import com.ll.exam.mutbooks.app.email.entity.SendEmailLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendEmailLogRepository extends JpaRepository<SendEmailLog, Long> {
}
