package com.jiuhaox.ucenter.adapter.outbound.repository.model;


import com.jiuhaox.boot.adapter.outbound.model.BasePO;
import com.jiuhaox.ucenter.adapter.outbound.repository.converter.UserConverter;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@Document("users")
public class UserPO extends BasePO<User, String> {
    @Id
    private String id;

    private String name;

    @Override
    public User toAggregate() {
        return UserConverter.INSTANCE.toUser(this);
    }
}
