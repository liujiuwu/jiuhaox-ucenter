package com.jiuhaox.ucenter.application.query.service;

import com.jiuhaox.ddd.domain.concepts.QueryService;
import com.jiuhaox.foundation.model.resp.PageResp;
import com.jiuhaox.ucenter.adapter.outbound.repository.UserPORepository;
import com.jiuhaox.ucenter.adapter.outbound.repository.model.UserPO;
import com.jiuhaox.ucenter.application.query.model.UserQuery;
import com.jiuhaox.ucenter.application.query.model.resp.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryService implements QueryService {
    private final UserPORepository userPORepository;

    public PageResp<UserDTO> findAll(UserQuery query) {
        final Page<UserPO> page = userPORepository.findAll(Example.of(new UserPO()), PageRequest.of(query.getPage(), query.getSize()));
        return PageResp.<UserDTO>builder().content(page.getContent().stream().map(UserPO::toDTO).toList()).page(query.getPage()).size(query.getSize()).total(page.getTotalElements()).build();
    }
}
