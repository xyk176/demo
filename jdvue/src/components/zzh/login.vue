<template>
  <div id="bigdiv">
    <div class="crm">
    </div>

    <el-form id="backstagelogin">
      <h2 class="logindl">智慧零售前台登录</h2>

      <el-form-item prop="account">
        <el-input class="textuser" placeholder="请输入账号"  v-model="name" clearable style="width: 290px;">
        </el-input>
      </el-form-item><br />

      <el-form-item prop="apwd">
        <el-input class="textpwd" placeholder="请输入密码"  v-model="pwd" show-password style="width: 290px;">
        </el-input>
      </el-form-item><br />
        <el-button class="denglu" type="primary" @click="selectBylogin" style="width: 290px;margin-left: 35px;">登录</el-button>
    </el-form >
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: '',
      pwd:''
    }
  },
  methods:{
    selectBylogin(){
      let param={
        cname:this.name,
        password:this.pwd
      };
      this.$axios.post("customer/denglu",param)
        .then(r=>{
          if(r.data.code){
            sessionStorage.setItem('cid3',r.data.vo.cid3);
            this.$router.push({
              name:'user'
            })
          }
        })
    }
  }
}
</script>

<style>
  *{
    margin: 0px;
    padding:0px;
  }
  .crm{
    color: white;
    height: 40px;
    width: 270px;
    position: relative;
    top: 20px;
    left: 30px;
    font-size: 30px;
  }
  /* .cc{
    position: relative;
    top: 10px;
    right: 10px;
  } */
  #bigdiv{
    background: url(../../../static/image/login.jpg);
    background-size: cover;
    height: 100%;

  }
  .logindl{
    /* margin-top: 75px; */
    position: relative;
    top: 60px;
    left: 20px;
    color: white;
  }
  .el-input {
    position: relative;
    font-size: 14px;
    left: 20px;
    display: inline-block;
    width: 100%;
  }
  #bigdiv #backstagelogin{
    /* width: 100%; */
    height: 595px;
    margin: 0px auto;
    text-align: center;
    margin-top: 65px;
    /* width: 330px; */
  }
  .textuser{
    margin-bottom: -10px;
    margin-top: 80px;
  }
  .el-form-item__error {
    color: #F56C6C;
    font-size: 14px;
    line-height: 1;
    padding-top: 4px;
    position: absolute;
    bottom: 10px;
    left: 41%;
  }
</style>
