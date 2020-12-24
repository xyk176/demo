<template>
  <div>
    <div class="order_div2">
      订单详情信息
    </div><br/>
    <el-row :gutter="10">
      <el-col :span="12">
        <div class="text">订单id：{{orderxq.oId}}</div>
      </el-col>
      <el-col :span="12">
        <div class="text">下单用户：{{orderxq.customer.cname}}</div>
      </el-col>
      <el-col :span="12">
        <div class="text">订单状态：{{orderxq.ortype}}</div>
      </el-col>
      <el-col :span="12">
        <div class="text">订单金额：{{orderxq.price}}</div>
      </el-col>
      <el-col :span="12">
        <div class="text">下单时间：{{orderxq.oDate}}</div>
      </el-col>
      <el-col :span="12">
        <div class="text">支付方式：{{orderxq.pay}}</div>
      </el-col>
      <el-col :span="12">
        <div class="text">发货方式：{{orderxq.orsip}}</div>
      </el-col>
      <el-col :span="12">
        <div class="text">订单备注：{{orderxq.remarks}}</div>
      </el-col>
    </el-row><br/>
    <el-divider>收货地址 <i class="el-icon-setting"></i> </el-divider>
    <el-row :gutter="10">
      <el-col :span="12">
        <div class="text">省：{{orderxq.address.adprovince}}</div>
      </el-col>
      <el-col :span="12">
        <div class="text">市：{{orderxq.address.adcity}}</div>
      </el-col>
      <el-col :span="12">
        <div class="text">区/县：{{orderxq.address.adarea}}</div>
      </el-col>
      <el-col :span="12">
        <div class="text">详细地址：{{orderxq.address.addetailed}}</div>
      </el-col>
    </el-row><br/>
    <el-divider>商品信息 <i class="el-icon-setting"></i> </el-divider>
    <el-table :data="com" style="width: 100%">
      <el-table-column prop="com.comid" label="ID"></el-table-column>
      <el-table-column prop="com.comname" label="商品名"></el-table-column>
      <el-table-column prop="com.combarcode" label="商品条码"></el-table-column>
      <el-table-column prop="com.commarketprice" label="商品价格"></el-table-column>
      <el-table-column prop="order.oId" label="订单编号"></el-table-column>
    </el-table><br/>
  </div>
</template>

<script>
  export default {
    data(){
      return {
        orderxq:{},
        com:[],
        oid:''
      }
    },
    methods:{
      selectComxq(){
        this.oid = this.$route.query.oId
        let param = {
          oId:this.oid
        };
        this.$axios.post("address/selectComxq",param)
        .then(r=>{
          this.com = r.data.objs;
          console.log(this.com);
        })
      },
      selectOrderxq(){
        let param = {
          oid:this.oid
        };
        this.$axios.post("address/selectOrderxq",param)
        .then(r=>{
          if(r.data){
            this.orderxq = r.data.obj;
            console.log(r);
          }
        })
      }
    },
    created(){
      this.selectComxq();
      this.selectOrderxq();
    }
  }
</script>

<style>
  .text{
    margin-left: 100px;
  }
  .order_div2{
    border: 1px solid #EAEAEA;
    width: 100%;
    height: 50px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    font-weight: 700;
    font-size: 20px;
  }
</style>
