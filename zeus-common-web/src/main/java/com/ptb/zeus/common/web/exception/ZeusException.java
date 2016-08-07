package com.ptb.zeus.common.web.exception;


import com.ptb.zeus.common.web.response.BaseResponse;

/**
 * Created by eric on 16/5/20.
 */
public class ZeusException extends RuntimeException {
    
    public final static int ArgsErrorCode=1001;
    public static final ZeusException PasswordOrPhoneError = new ZeusException("用户名或密码错误", 1120);
    public static final ZeusException NoActiveUserError = new ZeusException("没有激活的邮箱用户,请通过PC端登陆进行激活操作",1121);
    public static final ZeusException TokenError = new ZeusException("token失效", 1000);
    public static final ZeusException InerError = new ZeusException("内部错误", 1002);
    public static final ZeusException ArgsError = new ZeusException("参数错误", 1001);
    public static final ZeusException IndexStartEndError = new ZeusException("开始结果索引错误",1001);
    public static final ZeusException NoExistedMediaError = new ZeusException("不存在的媒体",1001);
    public static final ZeusException MoreTagForMediaError = new ZeusException("该媒体的标签已超过上限",1001);

    public static final ZeusException OptError = new ZeusException("操作失败", 1003);
    public static final ZeusException NoLoginError = new ZeusException("用户未登录", 1004);
    public static final ZeusException ValidateCodeExpiredError = new ZeusException("验证码已过期", 1100);
    public static final ZeusException SendVolidateOutError = new ZeusException("获取验证码次数已超过上限，请明天再试", 1101);
    public static final ZeusException ValidateCodeError = new ZeusException("验证码错误", 1101);
    public static final ZeusException ExistedPhoneError = new ZeusException("手机号已注册，可直接登录", 1110);
    public static final ZeusException ExistedUserError = new ZeusException("已注册的用户", 1110);
    public static final ZeusException NoExistedUserError = new ZeusException("未注册的用户", 1131);
    public static final ZeusException OldPasswordError = new ZeusException("旧密码不正确", 1132);
    public static final ZeusException ExistedUserName = new ZeusException("已存在的用户名", 1133);
    public static final ZeusException FavoratedMediaError = new ZeusException("已收藏的媒体", 1140);
    public static final ZeusException NoFavoratedMediaError = new ZeusException("未收藏的媒体", 1150);
    public static final ZeusException ExistMediaTagError = new ZeusException("标签已经存在", 1151);
    public static final ZeusException NoUpgradeError = new ZeusException("现在已经是最近版本了", 1153);
    public static final ZeusException ShareKeyInvalidError = new ZeusException("分享ID无效", 1160);
    public static final ZeusException PlatformTypeInvaildError = new ZeusException("无效的平台类型", 1170);
    public static final ZeusException ArticleTypeInvalidError = new ZeusException("无效的文章类型", 1171);
    public static final ZeusException InvalidSearchKeyError = new ZeusException("无效的搜索KEY", 1172);
    public static final ZeusException AddMediaError = new ZeusException("添加媒体失败", 1173);
    public static final ZeusException LinkInvalidError = new ZeusException("链接已失效",1074);
    public static final ZeusException ActiveUserError = new ZeusException("已激活的用户请直接登陆",1122);
    public static final ZeusException CodeFailure = new ZeusException("code失效错误",40029);
    public static final ZeusException OpenIdFailure = new ZeusException("openid失效错误",40003);
    public static final ZeusException MoreTagForUserError = new ZeusException("用户标签已经存在",5001);



    int errorCode;
    String errorMessage;
    BaseResponse respMessage;

    public ZeusException(String message, int errorCode) {
        super(message);
        this.errorMessage = message;
        this.errorCode = errorCode;
        this.respMessage = new BaseResponse<>(errorCode, message, null);
    }

    public BaseResponse respMessage() {
        return respMessage;
    }

    public ZeusException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage.getMessage();
        this.errorCode = errorMessage.getCode();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
