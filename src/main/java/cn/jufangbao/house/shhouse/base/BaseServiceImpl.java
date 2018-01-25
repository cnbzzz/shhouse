package cn.jufangbao.house.shhouse.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * BaseServiceImpl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:34:41.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class BaseServiceImpl {

    protected Logger log = LogManager.getLogger();

    protected BaseResp succ(){
        return BaseResp.succResp();
    }

    protected BaseResp fail(){
        return BaseResp.failResp();
    }

    protected BaseResp succ(String msg){
        return BaseResp.succResp(msg);
    }

    protected BaseResp fail(String msg){
        return BaseResp.failResp(msg);
    }


    protected BaseUserResp succUserResp(String aoid){
        return BaseUserResp.succResp(aoid);
    }

    protected BaseUserResp failUserResp(String aoid){
        return BaseUserResp.failResp(aoid);
    }

    protected BaseUserResp succUserResp(String aoid, String msg){
        return BaseUserResp.succResp(aoid, msg);
    }

    protected BaseUserResp failUserResp(String aoid, String msg){
        return BaseUserResp.failResp(aoid, msg);
    }

}
