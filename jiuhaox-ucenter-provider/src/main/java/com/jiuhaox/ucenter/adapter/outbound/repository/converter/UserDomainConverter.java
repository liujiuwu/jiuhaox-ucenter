package com.jiuhaox.ucenter.adapter.outbound.repository.converter;

import com.jiuhaox.ddd.outbound.concepts.DomainConverter;
import com.jiuhaox.ucenter.adapter.outbound.repository.model.UserPO;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDomainConverter extends DomainConverter<User, UserPO, String> {
    UserDomainConverter INSTANCE = Mappers.getMapper(UserDomainConverter.class);
}
