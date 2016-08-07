package com.ptb.zeus.common.web.exception;

/**
 * Created by eric on 16/5/20.
 */
public enum ErrorMessage {


    CODE_TOKENINVALID {
        public int getCode() {
            return 1000;
        }

        public String getMessage() {
            return "出错了";
        }
    },

    CODE_ERRORARGS {
        public int getCode() {
            return 1001;
        }

        public String getMessage() {
            return "出错了";
        }
    },

    Code_ERRIDORPASSWORD {
        public int getCode() {
            return 1120;
        }

        public String getMessage() {
            return "用户名或密码错误";
        }
    },


    CODE_INERERROR {
        public int getCode() {
            return 1002;
        }

        public String getMessage() {
            return "出错了";
        }
    };


    public int getCode() {
        return 0;
    }

    public String getMessage() {
        return "error";
    }
}
