package com.jiuhaox.ucenter.domain.aggregates.user.event;

import cn.hutool.core.lang.UUID;
import com.jiuhaox.ddd.domain.enums.EventStatus;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import org.junit.jupiter.api.Test;

import java.time.Instant;

class UserCreateEventTest {

    @Test
    void test(){
        final UserCreateEvent.UserCreateEventBuilder<?, ?> eventBuilder = UserCreateEvent.builder();

        User user = User.builder().id(UUID.fastUUID().toString()).name("test1").build();
        final UserCreateEvent event = eventBuilder.id(UUID.fastUUID().toString()).domainId(user.getId()).status(EventStatus.PENDING).data(user).createdAt(Instant.now()).build();

        System.out.println(event);

    }
}