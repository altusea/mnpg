package org.example.mnpg.enums;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.util.StringUtils;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public enum PermissionsLevel {

    HIGH("high", "高"),
    MEDIUM("medium", "中"),
    LOW("low", "低"),
    ;

    private final String code;
    private final String desc;

    PermissionsLevel(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    private static final Set<String> CODES = new HashSet<>();

    static {
        for (PermissionsLevel value : PermissionsLevel.values()) {
            CODES.add(value.getCode());
        }
    }

    public static boolean isValid(@Nullable String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }
        return PermissionsLevel.CODES.contains(value);
    }

    @Override
    public String toString() {
        return this.code;
    }

    public static void main(String[] args) {
        System.out.println(PermissionsLevel.isValid(null));
        System.out.println(PermissionsLevel.isValid(""));
        System.out.println(PermissionsLevel.isValid("low"));
        System.out.println(PermissionsLevel.isValid("lol"));
    }
}
