<template>
  <div>
    <span style="margin-left: 500px;font-weight: 700;">个人信息</span><br/><br/>
    <div class="div1">
      <el-form label-position="left" style="margin-left: 200px;margin-top: 10px;" label-width="80px" :model="customer">
        用户名：<el-input v-model="customer.cname" style="width: 600px;"></el-input><br/><br/>
        密&nbsp;&nbsp;&nbsp;码：<el-input v-model="customer.password" style="width: 600px;"></el-input><br/></br/>
        手机号：<el-input v-model="customer.cphone" style="width: 600px;"></el-input>
      </el-form><br/>
      <el-button @click="updateCustomer" style="margin-left: 265px;">保存</el-button>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        customer:{}
      }
    },
    methods:{
      /**
       * 查询个人信息
       */
      selectByCid(){
        let param = {
          cid:sessionStorage.getItem('cid3')
        };
        this.$axios.post("customer/selectByCid",param)
        .then(r=>{
          if(r.data){
            this.customer = r.data.obj;
            console.log(this.customer);
          }
        })
      },
      /**
       * 修改个人信息
       */
      updateCustomer(){
        let param = {
          cid:sessionStorage.getItem('cid3'),
          cname:this.customer.cname,
          password:this.customer.password,
          cphone:this.customer.cphone
        };
        this.$axios.post("customer/updateCustomer",param)
        .then(r=>{
          if(r.data){
            this.customer = r.data.obj
            console.log(this.customer);
            this.selectByCid();
          }
        })
      }

    },
    created(){
      this.selectByCid();
    }
  }
</script>

<style>
  .div1{
    border: 1px solid white;
    width: 100%;
    height: 500px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  }
</style>
