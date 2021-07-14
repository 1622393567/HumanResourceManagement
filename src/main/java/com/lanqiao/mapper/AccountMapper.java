package com.lanqiao.mapper;

import com.lanqiao.bean.EmpAccount;

public interface AccountMapper {
    public EmpAccount checkEmpInfo(String emp_id)throws Exception;
}
