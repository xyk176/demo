package com.demo.controller;

import com.demo.config.MyResult;
import com.demo.config.ResultVO;
import com.demo.model.mdao.CustomerMapper;
import com.demo.pojo.Address;
import com.demo.pojo.OrderInfo;
import com.demo.pojo.Orders;
import com.demo.services.AddressService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 周子豪
 * @description: TODO
 * @Classname AddressController
 * @Date 2020/12/21 17:29
 */
@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;
    @Autowired
    CustomerMapper customerMapper;

    /*
     * @Author 周子豪
     * @Description 17:30
     * @Date  2020/12/21
     * @param []
     * @return java.lang.String
     */
    @RequestMapping("/demo")
    public String demo(){
        return "zzh";
    }

    /*
     * @Author 周子豪
     * @Description 16:28
     * @Date  2020/12/22
     * @param [no, size, cid]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Address>
     */
    @RequestMapping("/selectByCidAll")
    public PageInfo<Address> selectByCidAll(Integer no,Integer size,Integer cid){
        PageInfo<Address> info = addressService.selectByCidAll(no,size,cid);
        return info;
    }

    /*
     * @Author 周子豪
     * @Description 9:53
     * @Date  2020/12/22
     * @param [adid]
     * @return com.demo.config.MyResult
     * 设置默认地址
     */
    @RequestMapping("/updateAdisdefault")
    public ResultVO updateAdisdefault(Integer adid, Integer cid){
        int a = addressService.updateAdisdefault1(cid);
        int i = addressService.updateAdisdefault(adid);
        if(i>0){
            return ResultVO.ok("已设置为默认地址！");
        }else {
            return ResultVO.error("设置失败！");
        }
    }

    /*
     * @Author 周子豪
     * @Description 9:56
     * @Date  2020/12/22
     * @param [adprovince, adcity, adarea, addetailed, adid]
     * @return com.demo.config.MyResult
     * 修改收货地址信息
     */
    @RequestMapping("/updateAddress")
    public ResultVO updateAddress(String adprovince,String adcity,String adarea,String addetailed,Integer adid){
        int i = addressService.updateAddress(adprovince,adcity,adarea,addetailed,adid);
        if(i>0){
            return ResultVO.ok("修改成功！");
        }else {
            return ResultVO.error("修改失败！");
        }
    }

    /*
     * @Author 周子豪
     * @Description 9:58
     * @Date  2020/12/22
     * @param [adid]
     * @return com.demo.config.MyResult
     * 删除收货地址（逻辑删除）
     */
    @RequestMapping("/updateAdisdelete")
    public ResultVO updateAdisdelete(Integer adid){
        int i = addressService.updateAdisdelete(adid);
        if(i>0){
            return ResultVO.ok("删除成功，删除记录可恢复");
        }else {
            return ResultVO.error("删除失败！");
        }
    }

    /*
     * @Author 周子豪
     * @Description 9:47
     * @Date  2020/12/23
     * @param [address]
     * @return com.demo.config.MyResult
     * 新增收货地址
     */
    @RequestMapping("/insertAddress")
    public ResultVO insertAddress(Address address,Integer cid){
        int i = addressService.insertAddress(address,cid);
        if(i>0){
            return ResultVO.ok("收货地址新增成功！");
        }else {
            return ResultVO.error("收货地址新增失败！");
        }
    }

    /*
     * @Author 周子豪
     * @Description 11:13
     * @Date  2020/12/23
     * @param [cid]
     * @return com.demo.config.MyResult
     * 查询已删除的收货地址
     */
    @RequestMapping("/selectByCidAll1")
    public MyResult selectByCidAll1(Integer no,Integer size,Integer cid){
        PageInfo<Address> list = addressService.selectByCidAll1(no,size,cid);
        return MyResult.returnObj(list);
    }

    /*
     * @Author 周子豪
     * @Description 14:05
     * @Date  2020/12/23
     * @param [adid]
     * @return com.demo.config.MyResult
     * 恢复收货地址
     */
    @RequestMapping("/updateAdisdelete1")
    public ResultVO updateAdisdelete1(Integer adid){
        int i = addressService.updateAdisdelete1(adid);
        if(i>0){
            return ResultVO.ok("恢复成功！");
        }else {
            return ResultVO.error("恢复失败！");
        }
    }

    /*
     * @Author 周子豪
     * @Description 15:50
     * @Date  2020/12/23
     * @param [adid]
     * @return com.demo.config.MyResult
     * 删除收货地址（物理删除）
     */
    @RequestMapping("/deleteAddress")
    public ResultVO deleteAddress(Integer adid){
        int i = addressService.deleteAddress(adid);
        if(i>0){
            return ResultVO.ok("删除成功!");
        }else {
            return ResultVO.error("删除失败！");
        }
    }

    /*
     * @Author 周子豪
     * @Description 19:27
     * @Date  2020/12/23
     * @param [ortype, cid, no, size]
     * @return com.demo.config.MyResult
     * 根据客户id查询订单
     */
    @RequestMapping("/selectOrders")
    public MyResult selectOrders(String ortype,String orsip,Integer cid,Integer no,Integer size){
        PageInfo<Orders> list = addressService.selectOrders(ortype,orsip,cid,no,size);
        return MyResult.returnObj(list);
    }

    /*
     * @Author 周子豪
     * @Description 14:43
     * @Date  2020/12/24
     * @param [oId]
     * @return com.demo.config.MyResult
     * 查看订单详情
     */
    @RequestMapping("/selectComxq")
    public MyResult selectComxq(Integer oId){
        System.out.println(oId);
        List<OrderInfo> list = addressService.selectComxq(oId);
        return MyResult.returnObjs(list);
    }

    @RequestMapping("/selectOrderxq")
    public MyResult selectOrderxq(Integer oid){
        Orders orders = addressService.selectOrderxq(oid);
        return MyResult.returnObj(orders);
    }
}
