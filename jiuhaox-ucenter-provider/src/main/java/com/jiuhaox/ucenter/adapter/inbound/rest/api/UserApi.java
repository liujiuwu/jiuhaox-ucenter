package com.jiuhaox.ucenter.adapter.inbound.rest.api;

import com.jiuhaox.boot.application.model.resp.PageResp;
import com.jiuhaox.boot.application.model.resp.Resp;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.command.cmd.CreateUserCmd;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.command.cmd.UpdateUserCmd;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.command.usecase.UserUseCase;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.query.UserQuery;
import com.jiuhaox.ucenter.application.port.inbound.cqrs.query.model.UserDTO;
import com.jiuhaox.ucenter.application.cqrs.query.service.UserQueryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApi {
    private final UserUseCase userUseCase;

    private final UserQueryService userQueryService;

    @PostMapping
    Resp create(@Valid @RequestBody CreateUserCmd cmd) {
        userUseCase.create(cmd);
        return Resp.ok();
    }

    @PutMapping
    Resp update(@Valid @RequestBody UpdateUserCmd cmd) {
        userUseCase.update(cmd);
        return Resp.ok();
    }

    @DeleteMapping("/{id}")
    Resp delete(@PathVariable("id") String userId) {
        userUseCase.deleteById(userId);
        return Resp.ok();
    }

    @GetMapping
    Resp<PageResp<UserDTO>> query(UserQuery req) {
        return Resp.ok(userQueryService.page(req));
    }
}
