package com.jiuhaox.ucenter.application.cqrs.command.service;

import com.jiuhaox.ucenter.application.cqrs.command.ability.CreateUserAbility;
import com.jiuhaox.ucenter.application.cqrs.command.ability.UpdateUserAbility;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.command.cmd.CreateUserCmd;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.command.cmd.UpdateUserCmd;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.command.usecase.UserUseCase;
import com.jiuhaox.ucenter.domain.aggregates.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserService implements UserUseCase {
    private final UserRepository userRepository;

    private final CreateUserAbility createUserAbility;

    private final UpdateUserAbility updateUserAbility;

    public void create(final CreateUserCmd cmd) {
        createUserAbility.executeAbility(cmd);
    }

    public void update(final UpdateUserCmd cmd) {
        updateUserAbility.executeAbility(cmd);
    }

    public void deleteById(final String id) {
        userRepository.delete(id);
    }
}
