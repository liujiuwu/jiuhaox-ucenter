package com.jiuhaox.ucenter.application.port.outbound.repository;

import com.jiuhaox.boot.application.model.resp.PageResp;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.query.model.UserDTO;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.query.UserQuery;

public interface UserQueryRepository {
    PageResp<UserDTO> page(UserQuery query);
}
