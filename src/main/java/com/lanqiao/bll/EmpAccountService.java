package com.lanqiao.bll;

import com.lanqiao.bean.MenuTree;
import com.lanqiao.bean.Result;

public interface EmpAccountService {
    public Result checkLogin(String username,String userpassword) throws Exception;
}
