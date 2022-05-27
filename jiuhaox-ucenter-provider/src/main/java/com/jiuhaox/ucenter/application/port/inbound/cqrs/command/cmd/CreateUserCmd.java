package com.jiuhaox.ucenter.application.port.inbound.cqrs.command.cmd;

import com.jiuhaox.ddd.domain.concepts.Command;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserCmd implements Command {
    @NotBlank(message = "{user.realName.is.blank}")
    private String name;

    public User toUser() {
        User user = User.builder().name(this.getName()).build();
        return user;
    }
}
