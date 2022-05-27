package com.jiuhaox.ucenter.application.port.inbound.cqrs.query.model;

import lombok.Data;

import java.time.Instant;

@Data
public class UserDTO {
    private String id;

    private String name;

    private Instant createdAt;

    private String createdBy;

    private Instant updatedAt;

    private String updatedBy;
}
