package com.jiuhaox.ucenter.domain.port.repository;


import com.jiuhaox.ddd.domain.concepts.AggregateRepository;
import com.jiuhaox.ucenter.domain.contexts.usercontext.user.model.User;

public interface UserRepository extends AggregateRepository<User, String> {
}
