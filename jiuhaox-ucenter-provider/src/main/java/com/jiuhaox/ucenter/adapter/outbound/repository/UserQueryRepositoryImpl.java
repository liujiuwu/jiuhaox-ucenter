package com.jiuhaox.ucenter.adapter.outbound.repository;

import com.jiuhaox.boot.application.model.resp.PageResp;
import com.jiuhaox.ucenter.adapter.outbound.repository.converter.UserConverter;
import com.jiuhaox.ucenter.adapter.outbound.repository.model.UserPO;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.query.model.UserDTO;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.query.UserQuery;
import com.jiuhaox.ucenter.application.port.outbound.repository.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository {
    private final UserPORepository userPORepository;

    @Override
    public PageResp<UserDTO> page(final UserQuery query) {
        final UserPO queryPO = new UserPO();
        final Example<UserPO> example = Example.of(queryPO);
        final Page<UserPO> page = userPORepository.findAll(example, PageRequest.of(query.getPage(), query.getSize()));
        return PageResp.<UserDTO>builder().content(page.getContent().stream().map(UserConverter.INSTANCE::toUserDTO).toList()).page(query.getPage()).size(query.getSize()).total(page.getTotalElements()).build();
    }
}
