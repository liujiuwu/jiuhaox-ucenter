package com.jiuhaox.ucenter.adapter.outbound.repository;

import com.jiuhaox.ucenter.adapter.outbound.repository.model.UserPO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserPORepository extends MongoRepository<UserPO, String> {
}
