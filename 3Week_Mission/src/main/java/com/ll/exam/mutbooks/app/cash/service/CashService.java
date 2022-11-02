package com.ll.exam.mutbooks.app.cash.service;

import com.ll.exam.mutbooks.app.cash.entity.CashLog;
import com.ll.exam.mutbooks.app.cash.repository.CashLogRepository;
import com.ll.exam.mutbooks.app.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashService {
    private final CashLogRepository cashLogRepository;

    public CashLog addCash(Member member, long price, String eventType) {
        CashLog cashLog = CashLog.builder()
                .member(member)
                .price(price)
                .eventType(eventType)
                .build();

        cashLogRepository.save(cashLog);

        return cashLog;
    }
}
