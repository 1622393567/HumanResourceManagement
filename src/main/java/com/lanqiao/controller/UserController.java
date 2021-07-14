package com.lanqiao.controller;


import com.lanqiao.bean.EmpAccount;
import com.lanqiao.bean.Result;
import com.lanqiao.bll.EmpAccountService;
import com.lanqiao.mvc.annotation.Controller;
import com.lanqiao.mvc.annotation.RequestMapping;

@Controller
public class UserController {
    private EmpAccountService accountService;

    public void setAccountService(EmpAccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("user/checkLogin.do")
    public Result checkLogin(EmpAccount emp) throws Exception {
        //传入参数 输出结果
        return accountService.checkLogin(emp.getEmp_id(),emp.getEmp_password());
    }
   /* @RequestMapping(value = "Main.do")
    public MenuTree accountPower() throws Exception {
        return accountService.accountPower();
    }

    */
  /*  @RequestMapping("user/addUser.do")
    public String addUser(Users user){
        System.out.println("添加用户");
        System.out.println(user.getUsername());
        System.out.println(user.getUserpassword());
        System.out.println(user.getAge());
        return "forward:viewUser.jsp";
    }
    @RequestMapping("user/viewUser.do")
    public Users viewUser(){
        Users users=new Users();
        users.setUsername("lisi");
        users.setUserpassword("ls1234");
        users.setAge(33);
        return users;
    }

   */

}