<template>
  <div>
    <span style="margin-left: 500px;font-weight: 700;">个人信息</span><br/><br/>
    <div class="div1">
      <el-form label-position="left" style="margin-left: 200px;margin-top: 10px;" label-width="80px" :model="customer">
        用户名：<el-input style="width: 600px;"></el-input><br/><br/>
        密&nbsp;&nbsp;&nbsp;码：<el-input style="width: 600px;"></el-input><br/></br/>
        手机号：<el-input style="width: 600px;"></el-input>
        
      </el-form>
    </div>
  </div>
</template>

<script>

</script>

<style>
  .div1{
    border: 1px solid white;
    width: 100%;
    height: 500px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  }
</style>
