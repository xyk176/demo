package com.demo.controller;

import com.demo.config.MyResult;
import com.demo.config.ResultVO;
import com.demo.pojo.Customer;
import com.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author: 周子豪
 * @description: TODO
 * @Classname CustomerController
 * @Date 2020/12/23 21:08
 */
@RestController
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
    public ResultVO dengLu(@RequestParam("cname") String cname, @RequestParam("password") String password, HttpSession session){
        Customer customer = customerService.dengLu(cname);
        if (customer == null){
            return ResultVO.error("用户不存在！");
        }else if (customer.getPassword().equals(password.trim())){
            session.setAttribute("cid3",customer.getCid3());
            System.out.println(session.getAttribute("cid3"));
            return ResultVO.okAndVO(customer);
        }else {
            return ResultVO.error("密码错误");
        }
    }

    /*
     * @Author 周子豪
     * @Description 11:09
     * @Date  2020/12/24
     * @param [cid]
     * @return com.demo.config.MyResult
     * 根据客户id查询
    */
    @RequestMapping("/selectByCid")
    public MyResult selectByCid(Integer cid){
        Customer customer = customerService.selectByCid(cid);
        return MyResult.returnObj(customer);
    }

    @RequestMapping("/updateCustomer")
    public ResultVO updateCustomer(String cname,String password,String cphone,Integer cid){
        if(cphone.length()!=11){
            return ResultVO.error("手机号必须为11位数！");
        }else if(cname.length()==0){
            return ResultVO.error("用户名不能为空！");
        }else if(password.length()==0 || password.length()<6 || password.length() > 12){
            return ResultVO.error("密码不能为空且不能小于6或大于12位数！");
        }else {
            int i = customerService.updateCustomer(cname,password,cphone,cid);
            if(i>0){
                return ResultVO.ok("修改成功！");
            }else {
                return ResultVO.error("修改失败！");
            }
        }
    }
}
