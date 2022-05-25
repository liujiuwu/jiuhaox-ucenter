package com.jiuhaox.ucenter.adapter.outbound.repository.model;


import com.jiuhaox.ddd.outbound.concepts.PersistenceObject;
import com.jiuhaox.ucenter.adapter.outbound.repository.converter.UserDomainConverter;
import com.jiuhaox.ucenter.application.query.model.resp.UserDTO;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("users")
public class UserPO implements PersistenceObject<User, String> {
    @Id
    private String id;

    private String name;


    public UserDTO toDTO() {
        UserDTO user = new UserDTO();
        user.setId(this.getId());
        user.setName(this.getName());
        return user;
    }

    @Override
    public User toAggregate() {
        return UserDomainConverter.INSTANCE.toAggregate(this);
    }
}
