package com.jiuhaox.ucenter.application.command.ability.user;

import com.jiuhaox.boot.application.ability.Ability;
import com.jiuhaox.boot.model.resp.Resp;
import com.jiuhaox.ucenter.application.command.ability.user.cmd.UpdateUserAbilityCmd;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import com.jiuhaox.ucenter.domain.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserAbility implements Ability<UpdateUserAbilityCmd, Void> {
    private final UserRepository userRepository;

    @Override
    public void checkHandler(UpdateUserAbilityCmd cmd) {
    }

    @Override
    public Resp<Void> checkIdempotent(UpdateUserAbilityCmd cmd) {
        //在这里进行幂等处理判断
        return Resp.ok();
    }

    @Override
    public Resp<Void> execute(final UpdateUserAbilityCmd cmd) {
        User user = cmd.toUser();

        User save = userRepository.save(user);

        //TODO 发布领域事件
        return Resp.ok();
    }

}
