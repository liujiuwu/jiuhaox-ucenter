package com.jiuhaox.ucenter.application.port.outbound.publisher;

import com.jiuhaox.ddd.domain.concepts.DomainEvent;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
