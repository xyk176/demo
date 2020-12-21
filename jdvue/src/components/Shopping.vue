<template>
  <div>
    <el-container>
      <el-header>Header</el-header>
      <el-main>
        <el-container>
          <el-aside width="200px">Aside</el-aside>
          <el-main>Main</el-main>
        </el-container>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  export default{
    data(){
      return{

      }
    },
    methods:{

    },
    created() {

    }
  }
</script>

<style scoped="scoped">
  .el-header, .el-footer {
      background-color: #B3C0D1;
      color: #333;
      text-align: center;
      line-height: 60px;
    }
  .el-main {
      background-color: #E9EEF3;
      color: #333;
      text-align: center;
      line-height: 160px;
    }
</style>
