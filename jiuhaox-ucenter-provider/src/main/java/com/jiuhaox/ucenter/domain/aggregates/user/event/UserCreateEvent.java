package com.jiuhaox.ucenter.domain.aggregates.user.event;

import com.jiuhaox.ddd.domain.model.BaseDomainEvent;
import com.jiuhaox.ucenter.application.cqrs.command.service.UserService;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@SuperBuilder
public class UserCreateEvent extends BaseDomainEvent<User, String, String> {
}
