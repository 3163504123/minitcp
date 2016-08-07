package com.ptb.zeus.common.web.bean.request.media;

import com.ptb.zeus.common.web.bean.request.base.ReqPmidType;
import com.ptb.zeus.common.common.ContactInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by MyThinkpad on 2016/6/26.
 */
public class ReqMediaContact extends ReqPmidType {

    @NotNull(message = "联系人信息不能为空")
    @Valid
    private ContactInfo contact;

    public ContactInfo getContact() {
        return contact;
    }

    public void setContact(ContactInfo contact) {
        this.contact = contact;
    }
}
