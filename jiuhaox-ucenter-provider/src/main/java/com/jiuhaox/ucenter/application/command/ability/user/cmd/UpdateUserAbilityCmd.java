package com.jiuhaox.ucenter.application.command.ability.user.cmd;

import com.jiuhaox.ddd.domain.concepts.Command;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateUserAbilityCmd implements Command {
    @NotBlank
    private String id;

    @NotBlank(message = "{user.name.is.blank}")
    private String name;

    public User toUser() {
        User user = User.builder().id(this.getId()).name(this.getName()).build();
        return user;
    }
}
