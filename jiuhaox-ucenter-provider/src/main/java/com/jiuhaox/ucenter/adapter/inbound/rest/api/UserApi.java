package com.jiuhaox.ucenter.adapter.inbound.rest.api;

import com.jiuhaox.boot.model.resp.PageResp;
import com.jiuhaox.boot.model.resp.Resp;
import com.jiuhaox.ucenter.application.command.ability.user.cmd.CreateUserAbilityCmd;
import com.jiuhaox.ucenter.application.command.ability.user.cmd.UpdateUserAbilityCmd;
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
    Resp create(@Valid @RequestBody CreateUserAbilityCmd cmd) {
        userService.create(cmd);
        return Resp.ok();
    }

    @PutMapping
    Resp update(@Valid @RequestBody UpdateUserAbilityCmd cmd) {
        userService.update(cmd);
        return Resp.ok();
    }

    @DeleteMapping("/{id}")
    Resp delete(@PathVariable("id") String id) {
        userService.deleteById(id);
        return Resp.ok();
    }

    @GetMapping
    Resp<PageResp<UserDTO>> query(UserQuery req) {
        return Resp.ok(userQueryService.findAll(req));
    }
}
