package com.ptb.zeus.common.web.bean.request.common;

import com.alibaba.fastjson.JSON;
import com.ptb.zeus.common.web.bean.request.media.ReqMediaHotArticle;
import com.ptb.zeus.common.web.bean.request.media.ReqRankHotMedia;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26 0026.
 */
public class ReqOrRepCombine {
    public List<ReqAction> getActions() {
        return actions;
    }

    public void setActions(List<ReqAction> actions) {
        this.actions = actions;
    }

    public List<ReqAction> actions;





    public static void main(String[] args) {
        ReqOrRepCombine reqCombine = new ReqOrRepCombine();
        ReqAction reqAction = new ReqAction();
        reqAction.setAction(1001);
        reqAction.setBody(new ReqMediaHotArticle());
        ReqAction reqAction1 = new ReqAction();
        reqAction1.setAction(2);
        reqAction1.setBody(new ReqRankHotMedia());
        reqCombine.setActions(Arrays.asList(reqAction,reqAction1));
        System.out.println(JSON.toJSONString(reqCombine));
        String test = "{\"actions\":[{\"action\":1,\"body\":{\"end\":10,\"start\":0,\"type\":0}},{\"action\":2,\"body\":{\"end\":10,\"start\":0,\"type\":0}}]}";
        ReqOrRepCombine reqCombine1 = JSON.parseObject(test, ReqOrRepCombine.class);
        for (ReqAction action : reqCombine1.getActions()) {
            switch (action.getAction()) {
                case 1:
                    ReqMediaHotArticle reqMediaHotArticle = JSON.parseObject(reqCombine1.getActions().get(0).getBody().toString(), ReqMediaHotArticle.class);


            }
        }
    }


}
