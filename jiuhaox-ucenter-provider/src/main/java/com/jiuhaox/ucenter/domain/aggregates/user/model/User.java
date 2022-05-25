package com.jiuhaox.ucenter.domain.aggregates.user.model;

import com.jiuhaox.ddd.domain.concepts.AggregateRoot;
import com.jiuhaox.ucenter.domain.share.valueobject.Address;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Value;

@Getter
@Builder
public class User implements AggregateRoot<String> {
    private String id;

    private String name;
}
