package com.lanqiao.bll;

import com.lanqiao.bean.EmpAccount;
import com.lanqiao.bean.MenuTree;

public interface EmpPowerService {
    public MenuTree accountPower(String emp_id) throws Exception;
}
