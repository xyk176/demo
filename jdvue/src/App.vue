<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
  #app *{
   font-size: 12px;
  }
  #app .myc{
    height: 100%;
    position: absolute;
    top: 0px;
    left: 0px;
    width: 100%;
  }
  #app .logtitle .el-menu {
    background-color: #22242F;
    border-right: none;
  }
  #app .daohang{
    background-color: #22242F;
  }
  #app .daohang .logoimg{
    padding: 20px 50px;
  }
  #app .isheader{
    line-height: 50px;
    border: 1px solid #E2E2E2;
    box-shadow: 0 2px 4px 0 rgba(0,0,0,.12), 0 0 6px 0 rgba(0,0,0,.04);
    font-size: 14px;
    color: #595961;
    font-weight: bold;
    z-index: 10;
  }
  #app .ismain{
    background: #F9F9F9;
    padding: 10px;
  }
</style>
