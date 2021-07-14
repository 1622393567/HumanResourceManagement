package com.lanqiao.mapper;

import com.lanqiao.bean.EmpPower;

import java.util.List;

public interface PowerMapper {
   public List<EmpPower> getEmpPower(String emp_id);
}
