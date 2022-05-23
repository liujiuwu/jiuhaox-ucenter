package com.jiuhaox.ucenter.application.command.model;

import com.jiuhaox.ddd.domain.concepts.Command;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeleteUserCmd implements Command {
    @NotBlank
    private String id;
}
