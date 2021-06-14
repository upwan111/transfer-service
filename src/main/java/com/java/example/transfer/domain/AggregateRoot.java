package com.java.example.transfer.domain;

import com.java.example.transfer.events.DomainEvent;
import org.springframework.data.annotation.Transient;

public abstract class AggregateRoot {

    @Transient
    private DomainEvent event;

    public void registerEvent(DomainEvent event) {
        this.event = event;
    }

    public DomainEvent event() {
        return this.event;
    }
}
