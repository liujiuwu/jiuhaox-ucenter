package com.jiuhaox.ucenter.application.command.service;

import com.jiuhaox.ucenter.application.command.ability.user.CreateUserAbility;
import com.jiuhaox.ucenter.application.command.ability.user.UpdateUserAbility;
import com.jiuhaox.ucenter.application.command.ability.user.cmd.CreateUserAbilityCmd;
import com.jiuhaox.ucenter.application.command.ability.user.cmd.UpdateUserAbilityCmd;
import com.jiuhaox.ucenter.domain.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final CreateUserAbility createUserAbility;

    private final UpdateUserAbility updateUserAbility;

    @Transactional(rollbackFor = Exception.class)
    public void create(final CreateUserAbilityCmd cmd) {
        createUserAbility.executeAbility(cmd);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(final UpdateUserAbilityCmd cmd) {
        updateUserAbility.executeAbility(cmd);
    }

    public void deleteById(final String id) {
        userRepository.delete(id);
    }
}
