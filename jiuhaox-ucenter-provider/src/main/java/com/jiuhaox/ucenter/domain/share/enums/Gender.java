package com.jiuhaox.ucenter.domain.share.enums;

import com.jiuhaox.foundation.enums.EnumCodeName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender implements EnumCodeName {
    MALE("男"),
    FEMALE("女"),
    UNKNOWN("未知"),
    ;

    final String name;
}
