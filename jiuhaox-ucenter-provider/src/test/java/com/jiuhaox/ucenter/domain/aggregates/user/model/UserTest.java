package com.jiuhaox.ucenter.domain.aggregates.user.model;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {
    @Test
    void should_return_correct_user_when_build_given_data() {
        final Instant now = Instant.now();
        final String userId = "user1";

        final User user = User.builder().id("1").name("test1")
                .createdAt(now).createdBy(userId)
                .updatedAt(now).createdBy(userId)
                .build();

        assertThat(user).isEqualTo(user);
        assertThat(user.getId()).isEqualTo("1");
        assertThat(user.getName()).isEqualTo("test1");
        assertThat(user.getCreatedAt()).isEqualTo(now);
        assertThat(user.getCreatedBy()).isEqualTo(userId);
    }
}