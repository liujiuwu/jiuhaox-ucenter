package com.jiuhaox.ucenter.application.command.service;

import com.jiuhaox.ucenter.application.command.ability.user.CreateUserAbility;
import com.jiuhaox.ucenter.domain.port.repository.UserRepository;
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