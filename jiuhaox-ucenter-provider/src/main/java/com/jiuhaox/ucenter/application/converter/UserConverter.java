package com.jiuhaox.ucenter.application.converter;

import com.jiuhaox.ucenter.application.command.ability.user.cmd.CreateUserAbilityCmd;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;

public interface UserConverter {
    User toUser(CreateUserAbilityCmd cmd);


}
