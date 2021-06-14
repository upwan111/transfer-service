package com.java.example.transfer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public final class Balance {
    private BigDecimal value;
}
