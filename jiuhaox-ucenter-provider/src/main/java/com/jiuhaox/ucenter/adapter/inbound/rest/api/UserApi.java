package com.jiuhaox.ucenter.adapter.inbound.rest.api;

import com.jiuhaox.foundation.model.resp.PageResp;
import com.jiuhaox.foundation.model.resp.Resp;
import com.jiuhaox.ucenter.application.command.model.CreateUserCmd;
import com.jiuhaox.ucenter.application.command.model.DeleteUserCmd;
import com.jiuhaox.ucenter.application.command.service.UserService;
import com.jiuhaox.ucenter.application.query.model.UserQuery;
import com.jiuhaox.ucenter.application.query.model.resp.UserDTO;
import com.jiuhaox.ucenter.application.query.service.UserQueryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserApi {
    private final UserService userService;

    private final UserQueryService userQueryService;

    @PostMapping
    Resp create(@Valid @RequestBody CreateUserCmd cmd) {
        userService.createUser(cmd);
        return Resp.ok();
    }

    @DeleteMapping
    Resp delete(@Valid DeleteUserCmd cmd) {
        log.info("{}", cmd);
        userService.delete(cmd);
        return Resp.ok();
    }

    @GetMapping
    Resp<PageResp<UserDTO>> query(UserQuery req) {
        return Resp.ok(userQueryService.findAll(req));
    }
}
