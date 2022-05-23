package com.jiuhaox.ucenter.domain.contexts.usercontext.user.model;

import com.jiuhaox.ddd.domain.concepts.AggregateRoot;
import com.jiuhaox.ucenter.domain.share.valueobject.Address;
import lombok.Data;

@Data
public class User implements AggregateRoot<String> {
    private String id;

    private String name;

    private Address address;
}
