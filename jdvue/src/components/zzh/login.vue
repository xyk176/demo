<template>
  <div id="bigdiv">
    <div class="crm">
      <!-- <img src="../img/crmimg.png" class="cc"/>CRM管理系统 -->
    </div>

    <el-form id="backstagelogin">
      <h2 class="logindl">智慧零售前台登录</h2>
      <!-- <img src="../img/users.png" class="imguser"/> -->

      <el-form-item prop="account">
        <el-input class="textuser" placeholder="请输入账号"  v-model="users" clearable style="width: 290px;">
        </el-input>
      </el-form-item><br />

      <!-- <img src="../img/upwds.png" class="imgupwd"/> -->
      <el-form-item prop="apwd">
        <el-input class="textpwd" placeholder="请输入密码"  v-model="pwd" show-password style="width: 290px;">
        </el-input>
      </el-form-item><br />

      <el-button class="denglu" type="primary" @click="selectBylogin">登录</el-button>
    </el-form >
  </div>
</template>

<script>
export default {
  data() {
    return {
      pwd: '',
      users:''
    }
  },
  methods:{
    selectBylogin(){
      let dd={
        pwd:this.pwd,
        users:this.users
      };
      let ppp = this.$qs.stringify(dd);
      this.$axios.post("emp/elogin",ppp)
        .then(r=>{
          if(r.data.code){
            sessionStorage.setItem('eid',r.data.vo.eid);
            this.$router.push({
              name:'Menu'
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
  .denglu{
    margin-top: 0px;
    color: white;
    margin-left: 35px;
    width: 290px;
    height: 40px;
    font-size: 20px;
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
  }
  .textuser{
    margin-bottom: -10px;
    margin-top: 80px;
  }
  /* .textpwd{
      margin-bottom: 10px;
    } */
  /* .imguser{
    position: relative;
    top: 120px;
    right: 150px;
  } */
  /* .imgupwd{
    position: relative;
    top: 40px;
    right: 150px;

  } */
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
