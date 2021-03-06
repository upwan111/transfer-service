package com.java.example.transfer.events;

import com.java.example.transfer.domain.Account;
import com.java.example.transfer.domain.Amount;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransferCompleted extends DomainEvent{

    private Account source;
    private Account destination;
    private Amount amount;

    public TransferCompleted(String aggregateId, Account source, Account destination, Amount amount) {
        super("transfer-completed",aggregateId, "TRANSACTION");
        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }
}
