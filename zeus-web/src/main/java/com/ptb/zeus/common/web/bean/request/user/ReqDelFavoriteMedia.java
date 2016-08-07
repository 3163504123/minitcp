package com.ptb.zeus.common.web.bean.request.user;

import com.ptb.zeus.common.web.bean.request.base.ReqPmidType;

/**
 * Created by eric on 16/5/25.
 */
public class ReqDelFavoriteMedia extends ReqPmidType {
    public ReqDelFavoriteMedia(String s) {
        this.pMid = s;
    }

    public ReqDelFavoriteMedia() {
    }

    public ReqDelFavoriteMedia(String pmid, int i) {
        this.pMid =pmid;
        this.type=i;
    }
}
