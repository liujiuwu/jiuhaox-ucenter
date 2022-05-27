package com.jiuhaox.ucenter.application.cqrs.command.ability;

import com.jiuhaox.boot.application.ability.Ability;
import com.jiuhaox.boot.application.model.resp.Resp;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.command.cmd.UpdateUserCmd;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import com.jiuhaox.ucenter.domain.aggregates.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserAbility implements Ability<UpdateUserCmd, Void> {
    private final UserRepository userRepository;

    @Override
    public void checkHandler(UpdateUserCmd cmd) {
    }

    @Override
    public Resp<Void> checkIdempotent(UpdateUserCmd cmd) {
        //在这里进行幂等处理判断
        return Resp.ok();
    }

    @Override
    public Resp<Void> execute(final UpdateUserCmd cmd) {
        User user = cmd.toUser();

        User save = userRepository.save(user);

        //TODO 发布领域事件
        return Resp.ok();
    }

}
