package com.lanqiao.bll.impl;

import com.lanqiao.bean.EmpAccount;
import com.lanqiao.bean.MenuTree;
import com.lanqiao.bean.Result;
import com.lanqiao.bll.EmpAccountService;
import com.lanqiao.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class EmpAccountServiceImpl implements EmpAccountService {
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;
    static {
        // Mybatis 配置文件
        String resource = "mybatis-config.xml";

        // 得到配置文件流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建会话工厂，传入 MyBatis 的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
    }
    @Override
    public Result checkLogin(String username, String userpassword) throws Exception {
        System.out.println("登录登录登录");
        System.out.println(username);
        System.out.println(userpassword);
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);//mybatis加载
        EmpAccount emp=mapper.checkEmpInfo(username);//查询这个用户，并且返回这个用户的信息
        System.out.println(emp);
        if(emp!=null){
            if(emp.getEmp_id().equals(username) && emp.getEmp_password().equals(userpassword)){
                return new Result("enable");
            }else {
                return new Result("disable");
            }
        }else{
            return new Result("disable");
        }
    }


}
