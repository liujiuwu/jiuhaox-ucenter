package com.jiuhaox.ucenter.adapter.outbound.repository.model;


import com.jiuhaox.boot.adapter.outbound.model.BasePO;
import com.jiuhaox.ucenter.adapter.outbound.repository.converter.UserConverter;
import com.jiuhaox.ucenter.application.query.model.resp.UserDTO;
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
        return UserConverter.INSTANCE.toAggregate(this);
    }

    public UserDTO toDTO() {
        UserDTO user = new UserDTO();
        user.setId(this.getId());
        user.setName(this.getName());
        user.setCreatedAt(this.getCreatedAt());
        user.setCreatedBy(this.getCreatedBy());
        user.setUpdatedAt(this.getUpdatedAt());
        user.setUpdatedBy(this.getUpdatedBy());
        return user;
    }
}
