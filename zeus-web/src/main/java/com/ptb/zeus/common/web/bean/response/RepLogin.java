package com.ptb.zeus.common.web.bean.response;


import com.ptb.zeus.common.model.User;

/**
 * Created by eric on 16/5/22.
 */
public class RepLogin {
    UserInfo userInfo;

    public RepLogin() {
    }


    public RepLogin(User targetUser, String token) {
        this.userInfo = new UserInfo(targetUser, token);
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public static class UserInfo {
        private final String nickName;
        private final String token;
        private final String userName;
        private final String email;
        private final String phone;
        private final String headImg;
        private final String companyAddress;
        private final long userId;
        private int remark;
        private int price;

        public UserInfo(User targetUser, String token) {
            this.nickName = targetUser.getUsername();
            this.userName = targetUser.getPhone() != null ? targetUser.getPhone() : targetUser.getEmail();
            this.email = targetUser.getEmail();
            this.phone = targetUser.getPhone();
            this.headImg = targetUser.getPortraitsUrl();
            this.token = token;
            this.companyAddress = targetUser.getCompanyaddress();
            this.userId = targetUser.getId();
        }

        public int getRemark() {
            return remark;
        }

        public void setRemark(int remark) {
            this.remark = remark;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getNickName() {
            return nickName;
        }

        public String getUserName() {
            return userName;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getToken() {
            return token;
        }

        public String getHeadImg() {
            return headImg;
        }

        public String getCompanyAddress() {
            return companyAddress;
        }

        public long getUserId() {
            return userId;
        }

    }
}