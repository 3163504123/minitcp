package com.ptb.zeus.common.web.utils;

import com.ptb.zeus.common.model.User;
import com.ptb.zeus.common.utils.PasswordHelper;
import com.ptb.zeus.common.web.exception.ZeusException;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by eric on 16/5/21.
 */
public class CommonUtil {


    public static List<String> filterVaildTags(List<String> tags) {
        List<String> collect = tags.stream().distinct().filter(t -> StringUtils.isNotBlank(t) && !t.equals("无标签")).map(
                t -> {
                    if (t.length() > 15) {
                        throw new ZeusException("标签不能超过15个字符", ZeusException.ArgsErrorCode);
                    }
                    return t;
                }
        ).collect(Collectors.toList());
        if (collect.size() > 6) {
            throw new ZeusException("标签数不能超过6个", ZeusException.ArgsErrorCode);
        }
        return collect;
    }

    public static String createActiveUserToken(User user) {
        String s = PasswordHelper.encryptPassword(String.format("active:%d:%d", user.getId(), System.currentTimeMillis() / 1000));
        return s;
    }

    public static String createFindPasswordToken(User user) {
        String s = PasswordHelper.encryptPassword(String.format("find:%d:%d", user.getId(), System.currentTimeMillis() / 1000));
        return s;
    }
    public static String createUserToken(User user, String device) {
        return PasswordHelper.encryptPassword(String.format("ut:%d-%s-%s", user.getId(), user.getPassword(), device));
    }
}
