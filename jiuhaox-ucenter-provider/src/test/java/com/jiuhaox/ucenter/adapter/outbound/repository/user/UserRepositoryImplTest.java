package com.jiuhaox.ucenter.adapter.outbound.repository.user;

import com.jiuhaox.ucenter.AppServerTest;
import com.jiuhaox.ucenter.adapter.outbound.repository.UserRepositoryImpl;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import com.jiuhaox.ucenter.domain.aggregates.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataMongoTest
@EnableMongoRepositories("**.repository")
@ContextConfiguration(classes = {AppServerTest.class, UserRepositoryImpl.class})
class UserRepositoryImplTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void should_save_succ_when_save_given_one_user() {
        final User user = User.builder().name("test").build();
        final User saveUser = userRepository.save(user);

        final Optional<User> userOpt = userRepository.byId(saveUser.getId());
        assertThat(userOpt).isNotEmpty();
        assertThat(userOpt.get().getName()).isEqualTo("test");
    }
}