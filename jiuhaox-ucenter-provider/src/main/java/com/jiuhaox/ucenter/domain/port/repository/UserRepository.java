package com.jiuhaox.ucenter.domain.port.repository;


import com.jiuhaox.ddd.domain.concepts.Repository;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;

public interface UserRepository extends Repository<User, String> {
}
