package com.jiuhaox.ucenter.application.cqrs.command.ability;

import com.jiuhaox.boot.application.ability.Ability;
import com.jiuhaox.boot.application.model.resp.Resp;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.command.cmd.CreateUserCmd;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import com.jiuhaox.ucenter.domain.aggregates.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateUserAbility implements Ability<CreateUserCmd, Void> {
    private final UserRepository userRepository;

    @Override
    public void checkHandler(CreateUserCmd cmd) {
    }

    @Override
    public Resp<Void> checkIdempotent(CreateUserCmd cmd) {
        //在这里进行幂等处理判断
        return Resp.ok();
    }

    @Override
    public Resp<Void> execute(final CreateUserCmd cmd) {

        User user = cmd.toUser();

        User save = userRepository.save(user);

        //发布用户新建的领域事件
        //TODO 发布领域事件
        return Resp.ok();
    }

}
