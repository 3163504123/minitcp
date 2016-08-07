package com.ptb.zeus.common.web.bean.request.user;

import com.ptb.zeus.common.web.bean.request.base.ReqPmidType;

import java.util.List;

/**
 * Created by eric on 16/5/25.
 */
public class ReqAddFavoriteMedia extends ReqPmidType {
    List<String> tags;

    Contact contact;

    int index;

    String key;

    public ReqAddFavoriteMedia() {
    }

    public ReqAddFavoriteMedia(String pMid, int type, List<String> strings, Contact contact) {
        this.tags = strings;
        this.contact = contact;
        this.pMid = pMid;
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public boolean report(){
        return null != key;
    }

    public static class Contact {
        String name;
        String phone;
        String email;
        String price;

        public Contact() {
        }

        public Contact(String name, String phone, String email, String price) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
