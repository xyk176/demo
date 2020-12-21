<template>
  <div id="shangpinnavigation">
    <div class="body">
      <router-view/>
    </div>
  </div>
</template>

<script>
  export default {
   data(){
     return{

     }
   }
  }
</script>

<style>
  #shangpinnavigation .body{
    width: 100%;
    height: 500px;
    background: #FFFFFF;
    border-radius: 6px;
    border: 1px solid #E2E2E2;
    box-shadow: 0 2px 4px 0 rgba(0,0,0,.12), 0 0 6px 0 rgba(0,0,0,.04);
  }
  #shangpinnavigation .shangpinmain{
    background: #FFFFFF;
    border: 1px solid #E2E2E2;
    box-shadow: 0 2px 4px 0 rgba(0,0,0,.12), 0 0 6px 0 rgba(0,0,0,.04);
    border-radius: 6px;
  }
  #shangpinnavigation .el-aside .daohang_list{

  }
  #shangpinnavigation .el-aside .daohang_list .daohang_button{

  }
</style>
