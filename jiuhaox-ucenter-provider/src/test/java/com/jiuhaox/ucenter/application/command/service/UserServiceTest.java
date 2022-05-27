package com.jiuhaox.ucenter.application.command.service;

import com.jiuhaox.ucenter.application.cqrs.command.ability.CreateUserAbility;
import com.jiuhaox.ucenter.application.cqrs.command.service.UserService;
import com.jiuhaox.ucenter.domain.aggregates.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = {UserService.class, CreateUserAbility.class})
class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;
}