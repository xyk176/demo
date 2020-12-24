<template>
  <div>
    <el-container class="div">
      <el-aside width="200px">
        <div style="margin-top: 10px;">
          <div class="block"><el-avatar :size="50" :src="circleUrl"></el-avatar></div>
        </div>
        <el-menu
              default-active="2"
              class="el-menu-vertical-demo">
              <router-link to="/user" tag="span">
                <el-menu-item index="1">
                  <i class="el-icon-user"></i>
                  <span slot="title">个人信息</span>
                </el-menu-item>
              </router-link>
              <el-submenu index="2">
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span>收货地址</span>
                </template>
                <el-menu-item-group>
                  <router-link to="/address" tag="span">
                    <el-menu-item index="2-1">我的地址</el-menu-item>
                  </router-link>
                  <router-link to="/addressDelete" tag="span">
                    <el-menu-item index="2-2">删除记录</el-menu-item>
                  </router-link>
                </el-menu-item-group>
              </el-submenu>
              <router-link to="/orders" tag="span">
                <el-menu-item index="3">
                  <i class="el-icon-s-order"></i>
                  <span slot="title">我的订单</span>
                </el-menu-item>
              </router-link>
            </el-menu>
      </el-aside>
      <el-container>
        <el-header>
          <span>智慧零售个人中心</span>
          <div class="denglu1">
            <el-dropdown>
              <span class="el-dropdown-link" style="margin-right: 10px">
                <span class="duser">当前用户：{{cname}}</span><i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown" @click.native="tuichu()">
                <el-dropdown-item >退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </el-header>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        circleUrl: "../../../static/image/"+'75c9da8530e839235647e143035b591a'+'.jpg',
        cname:'',
        customer:[]
      }
    },
    methods:{
      selectAll(){
        let param = {
          cid:sessionStorage.getItem('cid3')
        };
        this.$axios.post("customer/selectByCid",param)
        .then(r=>{
          if(r.data){
            this.customer = r.data.obj.cname;
            this.cname = r.data.obj.cname;
          }
        })
      },
      tuichu(){
        sessionStorage.clear();
        this.$router.push({
          name: 'login'
        })
      }
    },
    created(){
      this.selectAll();
    }
  }
</script>

<style>
  .el-header {
      background-color: #E9EEF3;
      color: #333;
      /* text-align: center; */
      font-weight: 700;
      line-height: 60px;
      border: 1px solid white;

    }

    .el-aside {
      background-color: white;
      color: #333;
      text-align: center;
      border: 1px solid #B3C0D1;

    }
    .div{
      height: 100%;
      position: absolute;
      top: 0px;
      left: 0px;
      width: 100%;
    }
    .left{
      width: 50px;
    }
    .el-main {
      background-color: white;
      color: #333;
    }

    body > .el-container {
      margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
      line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
      line-height: 320px;
    }
    .el-menu-vertical-demo{
      border: 0px solid;
      margin-top: 20px;
    }
    .denglu1{
      float: right;

    }
</style>
