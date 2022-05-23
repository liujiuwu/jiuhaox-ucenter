package com.jiuhaox.ucenter.adapter.outbound.repository.model;


import com.jiuhaox.ddd.domain.valueobject.Auditor;
import com.jiuhaox.ddd.outbound.concepts.PersistenceObject;
import com.jiuhaox.ucenter.application.query.model.resp.UserDTO;
import com.jiuhaox.ucenter.domain.contexts.usercontext.user.model.User;
import com.jiuhaox.ucenter.domain.share.valueobject.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("users")
public class UserPO implements PersistenceObject<User> {
    @Id
    private String id;

    private String name;

    private LocalDateTime createdAt;

    private Auditor createdBy;

    private LocalDateTime updatedAt;

    private Auditor updatedBy;

    private Address address;

    @Override
    public User toDomain() {
        User user = new User();
        user.setId(this.getId());
        user.setName(this.getName());
        return user;
    }

    public UserDTO toDTO() {
        UserDTO user = new UserDTO();
        user.setId(this.getId());
        user.setName(this.getName());
        return user;
    }
}
