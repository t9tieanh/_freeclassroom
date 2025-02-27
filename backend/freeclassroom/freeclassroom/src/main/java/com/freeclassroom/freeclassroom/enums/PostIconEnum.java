package com.freeclassroom.freeclassroom.enums;

import lombok.Data;

public enum PostIconEnum {
    NOTICE("fa-solid fa-messages"),
    TEST("fa-regular fa-list-dropdown"),
    EXERCISE("fa-solid fa-upload")
    ;


    private final String icon;

    PostIconEnum(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}

