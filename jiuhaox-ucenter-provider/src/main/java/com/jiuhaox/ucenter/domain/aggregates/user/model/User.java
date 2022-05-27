package com.jiuhaox.ucenter.domain.aggregates.user.model;

import com.jiuhaox.ddd.domain.concepts.AggregateRoot;
import com.jiuhaox.ddd.domain.model.BaseEntity;
import com.jiuhaox.ucenter.application.cqrs.command.service.UserService;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class User extends BaseEntity<String> implements AggregateRoot<String> {
    private String name;
}
