package com.ptb.zeus.common.utils;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by eric on 16/6/13.
 */
public class CookieUtils {
    public static void addUserCookie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        addUserCookie(httpServletRequest, httpServletResponse, 1);
    }

    public static void addUserCookie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, long uid) {
        Cookie[] cookies = httpServletRequest.getCookies();
        boolean hasUuid = false;
        boolean hasuid = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("uuid")) {
                    hasUuid = true;
                }
                if (cookie.getName().equals("uid")) {
                    hasuid = true;
                }
            }
        }

        if (!hasUuid) {
            Cookie uuidCookie = new Cookie("uuid", UUID.randomUUID().toString());
            uuidCookie.setMaxAge(Integer.MAX_VALUE);
            uuidCookie.setPath("/");
            httpServletResponse.addCookie(uuidCookie);
        }

        Cookie uidCookie = new Cookie("uid", String.valueOf(uid));
        uidCookie.setMaxAge(Integer.MAX_VALUE);
        uidCookie.setPath("/");
        httpServletResponse.addCookie(uidCookie);
    }
}
