package com.baoanh.selfpasswordmanagement.helper;

import lombok.Data;

@Data
public class SecretKeyHelper {

    private SecretKeyHelper() {
    }

    private static String key = "";

    public static void setKey(String key) {
        SecretKeyHelper.key = key;
    }

    public static String getKey() {
        return key;
    }
}
