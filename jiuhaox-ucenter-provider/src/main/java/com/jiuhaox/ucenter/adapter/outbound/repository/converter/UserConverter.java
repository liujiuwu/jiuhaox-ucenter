package com.jiuhaox.ucenter.adapter.outbound.repository.converter;

import com.jiuhaox.boot.adapter.outbound.concepts.DomainConverter;
import com.jiuhaox.ucenter.adapter.outbound.repository.model.UserPO;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.query.model.UserDTO;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter extends DomainConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    User toUser(UserPO userPO);

    UserPO toUserPO(User user);

    UserDTO toUserDTO(UserPO userPO);
}
