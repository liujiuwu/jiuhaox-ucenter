package com.jiuhaox.ucenter.application.port.inbound.cqrs.command.cmd;

import com.jiuhaox.ddd.domain.concepts.Command;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateUserCmd implements Command {
    @NotBlank
    private String id;

    @NotBlank(message = "{user.name.is.blank}")
    private String name;

    public User toUser() {
        User user = User.builder().id(this.getId()).name(this.getName()).build();
        return user;
    }
}
