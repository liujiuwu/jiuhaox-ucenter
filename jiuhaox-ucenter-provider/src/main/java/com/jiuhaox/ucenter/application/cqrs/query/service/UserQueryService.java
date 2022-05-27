package com.jiuhaox.ucenter.application.cqrs.query.service;

import com.jiuhaox.boot.application.model.resp.PageResp;
import com.jiuhaox.ddd.domain.concepts.QueryService;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.query.model.UserDTO;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.query.UserQuery;
import com.jiuhaox.ucenter.application.port.outbound.repository.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryService implements QueryService {
    private final UserQueryRepository userQueryRepository;

    public PageResp<UserDTO> page(UserQuery query) {
        return userQueryRepository.page(query);
    }
}
