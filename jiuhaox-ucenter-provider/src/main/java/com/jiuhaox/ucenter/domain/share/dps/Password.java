package com.jiuhaox.ucenter.domain.share.dps;

import cn.hutool.core.lang.Assert;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public record Password(String pwd, String salt) {
    public Password {
        Assert.notBlank(pwd, "不能为空");
        Assert.notBlank(salt, "不能为空");
    }

    public static void main(String[] args) {
        final Password password = new Password("", "");
    }
}
