package com.jiuhaox.ucenter.domain.share.dps;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record Password(@Valid @NotBlank String pwd, String salt) {
    public static void main(String[] args) {
        final Password password = new Password("", "");
        System.out.println(password);
    }
}
