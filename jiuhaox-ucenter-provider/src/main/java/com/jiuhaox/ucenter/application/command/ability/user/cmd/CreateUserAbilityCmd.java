package com.jiuhaox.ucenter.application.command.ability.user.cmd;

import com.jiuhaox.ddd.domain.concepts.Command;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserAbilityCmd implements Command {
    @NotBlank(message = "{user.realName.is.blank}")
    private String name;

    public User toUser() {
        User user = User.builder().name(this.getName()).build();
        return user;
    }
}
