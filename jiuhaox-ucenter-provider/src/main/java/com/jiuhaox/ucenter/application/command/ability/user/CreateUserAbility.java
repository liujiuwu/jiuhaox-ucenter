package com.jiuhaox.ucenter.application.command.ability.user;

import com.jiuhaox.boot.application.ability.Ability;
import com.jiuhaox.boot.application.model.resp.Resp;
import com.jiuhaox.ucenter.application.command.ability.user.cmd.CreateUserAbilityCmd;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import com.jiuhaox.ucenter.domain.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateUserAbility implements Ability<CreateUserAbilityCmd, Void> {
    private final UserRepository userRepository;

    @Override
    public void checkHandler(CreateUserAbilityCmd cmd) {
    }

    @Override
    public Resp<Void> checkIdempotent(CreateUserAbilityCmd cmd) {
        //在这里进行幂等处理判断
        return Resp.ok();
    }

    @Override
    public Resp<Void> execute(final CreateUserAbilityCmd cmd) {

        User user = cmd.toUser();

        User save = userRepository.save(user);

        //发布用户新建的领域事件
        //TODO 发布领域事件
        return Resp.ok();
    }

}
