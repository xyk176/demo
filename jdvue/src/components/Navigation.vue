<template>
  <div id="navigation">
    <el-container class="myc">
      <el-aside width="150px" class="daohang">
        <div class="logoimg">
          <img src="../../static/log/log.png" width="100%" />
        </div>
        <div class="logtitle">
          <el-menu default-active="2" class="el-menu-vertical-demo" background-color="#22242F" text-color="#fff" active-text-color="#2589FF">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-shopping-bag-2"></i>
                <span>商品</span>
              </template>
              <el-menu-item-group title="单品库">
                <router-link to="/liebiao" tag="span">
                <el-menu-item index="1-1">单品库列表</el-menu-item>
                </router-link>
                <router-link to="/fenlei" tag="span">
                <el-menu-item index="1-2">单品库分类</el-menu-item>
                </router-link>
              </el-menu-item-group>
              <el-menu-item-group title="商品库">
                <el-menu-item index="1-3">商品库列表3</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>库存</span>
              </template>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-tickets"></i>
                <span>订单</span>
              </template>
              <el-menu-item-group>
                <router-link to="/Allorders">
                  <el-menu-item index="3-1">所有订单</el-menu-item>
                </router-link>
                <router-link to="/Alldelivergoods">
                  <el-menu-item index="3-2">发货管理</el-menu-item>
                </router-link>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </div>
      </el-aside>
      <el-container>
        <el-header class="isheader" height="50px">智慧零售</el-header>
        <el-main class="ismain">
          <div class="body">
            <router-view/>
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
</script>

<style>
 #navigation *{
   font-size: 12px;
  }
  #navigation .myc{
    height: 100%;
    position: absolute;
    top: 0px;
    left: 0px;
    width: 100%;
  }
  #navigation .logtitle .el-menu {
    background-color: #22242F;
    border-right: none;
  }
  #navigation .daohang{
    background-color: #22242F;
  }
  #navigation .daohang .logoimg{
    padding: 20px 50px;
  }
  #navigation .isheader{
    line-height: 50px;
    border: 1px solid #E2E2E2;
    box-shadow: 0 2px 4px 0 rgba(0,0,0,.12), 0 0 6px 0 rgba(0,0,0,.04);
    font-size: 14px;
    color: #595961;
    font-weight: bold;
    z-index: 10;
  }
  #navigation .ismain{
    background: #F9F9F9;
    padding: 10px;
  }

  #navigation .ismain .body{
    width: 100%;
    height: 500px;
    background: #FFFFFF;
    border-radius: 6px;
    border: 1px solid #E2E2E2;
    box-shadow: 0 2px 4px 0 rgba(0,0,0,.12), 0 0 6px 0 rgba(0,0,0,.04);
  }
  #navigation .ismain .shangpinmain{
    background: #FFFFFF;
    border: 1px solid #E2E2E2;
    box-shadow: 0 2px 4px 0 rgba(0,0,0,.12), 0 0 6px 0 rgba(0,0,0,.04);
    border-radius: 6px;
  }
</style>
