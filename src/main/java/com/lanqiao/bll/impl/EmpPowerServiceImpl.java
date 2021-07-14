package com.lanqiao.bll.impl;

import com.lanqiao.bean.EmpAccount;
import com.lanqiao.bean.EmpPower;
import com.lanqiao.bean.MenuTree;
import com.lanqiao.bll.EmpPowerService;
import com.lanqiao.mapper.AccountMapper;
import com.lanqiao.mapper.PowerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EmpPowerServiceImpl implements EmpPowerService {
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
    public MenuTree accountPower(String emp_id) throws Exception {
        PowerMapper mapper = sqlSession.getMapper(PowerMapper.class);//mybatis加载
        List<EmpPower> empPowers=mapper.getEmpPower(emp_id);//查询这个用户，并且返回这个用户的权力
        Map<String, List<String>> menuMap=new LinkedHashMap<>();
        for(EmpPower i:empPowers){
            if(!menuMap.containsKey(i.getFather_name())){
                System.out.println("i"+i.getFather_name());
                List<String> QueryPowerList=new ArrayList<>();
                for(EmpPower j:empPowers){
                    if(j.getFather_name().equals(i.getFather_name())){
                        QueryPowerList.add(j.getPower_name());
                        System.out.println("j:"+j.getPower_name());
                    }
                }
                menuMap.put(i.getFather_name(),QueryPowerList);
            }
        }
        //List<String> QueryPowerList1=new ArrayList<>();
       // List<String> QueryPowerList2=new ArrayList<>();
        //List<String> QueryPowerList3=new ArrayList<>();
       // List<String> QueryPowerList4=new ArrayList<>();

        //QueryPowerList1.add("个人信息");
        //QueryPowerList1.add("查看薪资");
        //QueryPowerList2.add("请销假");
        //QueryPowerList2.add("岗位变动");
        //QueryPowerList3.add("请销假审核");
        //QueryPowerList3.add("账号管理");
        //QueryPowerList4.add("账号管理");

        //menuMap.put("业务查询",QueryPowerList1);
        //menuMap.put("业务办理",QueryPowerList2);
        //menuMap.put("业务审核",QueryPowerList3);
        // menuMap.put("系统管理",QueryPowerList4);

        MenuTree menuTree=new MenuTree();
        menuTree.setMenutree(menuMap);
        return menuTree;
    }
}
