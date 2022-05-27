package com.jiuhaox.ucenter.application.port.inbound.cqrs.command.usecase;

import com.jiuhaox.ucenter.application.port.inbound.cqrs.command.cmd.CreateUserCmd;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.command.cmd.UpdateUserCmd;

public interface UserUseCase {
    void create(final CreateUserCmd cmd);

    void update(final UpdateUserCmd cmd);

    void deleteById(final String userId);
}
