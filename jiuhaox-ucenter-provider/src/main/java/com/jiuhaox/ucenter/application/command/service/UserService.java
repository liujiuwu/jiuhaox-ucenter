package com.jiuhaox.ucenter.application.command.service;

import com.jiuhaox.foundation.exceptions.AppErrorCode;
import com.jiuhaox.ucenter.application.command.model.CreateUserCmd;
import com.jiuhaox.ucenter.application.command.model.DeleteUserCmd;
import com.jiuhaox.ucenter.domain.contexts.usercontext.user.model.User;
import com.jiuhaox.ucenter.domain.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(CreateUserCmd cmd) {
        User user = new User();
        user.setName(cmd.getName());
        userRepository.save(user);
    }

    public void delete(DeleteUserCmd cmd) {
        userRepository.byId("dd").orElseThrow(AppErrorCode.ERR_DATA_NOT_FOUND::throwIt);
        userRepository.delete(cmd.getId());
    }
}
