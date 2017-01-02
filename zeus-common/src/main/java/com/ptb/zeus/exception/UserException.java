package com.ptb.zeus.exception;

public class UserException extends RuntimeException {

	/*系统级别错误*/
	public static final UserException ArgError = new UserException("参数错误", 10000);
	public static final UserException InerError = new UserException("系统内部错误",10500);

	/*用户中心相关错误*/
	public static final UserException NoExistVaildCodeError = new UserException("验证码失效，请重新发送", 11000);
	public static final UserException UsernameOrPhoneExist = new UserException("手机号或用户名已注册", 11001);
	public static final UserException ErrorImgVcode = new UserException("错误的图片验证码", 11002);
	public static final UserException NoExistUserError = new UserException("用户不存在", 11003);
	public static final UserException NoExistAccountError = new UserException("用户账户不存在", 11003);
	public static final UserException UserTokenExpiredError  = new UserException("用户TOKEN过期", 11004);
	public static final UserException NoRegistUserError = new UserException("注册用户失败", 13001);
	public static final UserException UserTokenParseError= new UserException("用户TOKEN无效", 11005);
	/*服务相关的错误*/
	public static final UserException NoServiceAuthError = new UserException("无效的KEY或权限已到期",12001);
	public static final UserException LoginUndefineError = new UserException("登陆失败请重试",12002);
	public static final UserException SwitchingIPError = new UserException("正在切换IP，请稍后", 12003);

	/*购买相关的错误*/
	public static final UserException NoExistProductError = new UserException("不存在的商品", 13001);
	public static final UserException NotEnoughPointError = new UserException("账户点数不足，请充值", 13002);
	public static final UserException InvaildUIDRequest = new UserException("无效用户ID或你不能查看其它用户信息", 13003);
	public static final UserException NoExistOrderError = new UserException("不存在的订单", 13004);



	public static final UserException IdentifyVCodeImageUploadError = new UserException("上传识别图片失败", 13005);
	public static final UserException UploadFileSizeOutError = new UserException("上传识别太大", 13006);
	public static final UserException ServiceKeyError = new UserException("服务KEY类型不匹配", 13007);
	public static final UserException ServiceOverError = new UserException("服务时间或次数已耗尽", 13008);


	int errorCode;
	String errorMessage;

	public UserException(String message, int errorCode) {
		super(message);
		this.errorMessage = message;
		this.errorCode = errorCode;
	}

	public UserException(String format) {

		this.errorMessage = format;
		this.errorCode = -1;
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
