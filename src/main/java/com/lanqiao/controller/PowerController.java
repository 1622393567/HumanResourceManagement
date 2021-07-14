package com.lanqiao.controller;

import com.lanqiao.bean.EmpAccount;
import com.lanqiao.bean.MenuTree;

import com.lanqiao.bll.EmpPowerService;
import com.lanqiao.mvc.annotation.Controller;
import com.lanqiao.mvc.annotation.RequestMapping;
@Controller
public class PowerController {
    private EmpPowerService powerService;

    public void setPowerService(EmpPowerService powerService) {
        this.powerService = powerService;
    }

    @RequestMapping(value = "Main.do")
    public MenuTree accountPower(EmpAccount emp) throws Exception {
        return powerService.accountPower(emp.getEmp_id());
    }
}


