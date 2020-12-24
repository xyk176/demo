package com.demo.controller;

import com.demo.config.MyResult;
import com.demo.pojo.Customer;
import com.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author: 周子豪
 * @description: TODO
 * @Classname CustomerController
 * @Date 2020/12/23 21:08
 */
@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    /*
     * @Author 周子豪
     * @Description 21:16
     * @Date  2020/12/23
     * @param [cname, password, session]
     * @return com.demo.config.MyResult
     * 登录
    */
    @RequestMapping("/denglu")
    public MyResult dengLu(String cname, String password, HttpSession session){
        System.out.println(cname);
        System.out.println(password);
//        Emp emp=es.selectByename(ename);
        Customer customer = customerService.dengLu(cname,password);
        if (customer==null){
            return MyResult.ERROR("用户不存在！");
        }else if (customer.getCname().equals(cname.trim()) && customer.getPassword().equals(password.trim())){
            session.setAttribute("cid3",customer.getCid3());
            System.out.println(session.getAttribute("cid3"));
            return MyResult.returnObj(customer);
        }else {
//            return ResultVO.error("密码错误");
            return MyResult.ERROR("用户名或密码错误！");
        }
    }
}
