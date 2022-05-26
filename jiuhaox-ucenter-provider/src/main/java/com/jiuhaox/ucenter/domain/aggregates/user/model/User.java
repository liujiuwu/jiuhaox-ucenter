package com.jiuhaox.ucenter.domain.aggregates.user.model;

import com.jiuhaox.ddd.domain.concepts.AggregateRoot;
import com.jiuhaox.ddd.domain.model.BaseEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class User extends BaseEntity<String> implements AggregateRoot<String> {
    private String name;
}
