<template>
  <div>
    <el-container>
      <el-header>Header</el-header>
      <el-main>
        <div class="Left_div">
          <el-menu default-active="2" class="el-menu-vertical-demo" style=" max-width: 150px;">
               <el-menu-item index="i.ccyid" v-for="i in goostype">
                 <div class="Goods_Div">
                   <img src="../../static/log/log.png" class="img_div"/>
                   <span>{{i.ccyname}}</span>
                 </div>
               </el-menu-item>
           </el-menu>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  import "../../static/css/Shopping.css";
  export default{
    data(){
      return{
        goostype:[],
      }
    },
    methods:{
      S_GoodsType(){//查询所有商品分类
        this.$myhttp.getObjs("/shopping/s_GoodsType",null,res=>{
          this.goostype=res;
          console.log("所有商品分类--",res);
        })
      },

    },
    created() {
      this.S_GoodsType();
    }
  }
</script>

<style scoped="scoped">
  .el-menu-item:hover{
      border-radius: 17px;
  }
  .el-menu-item{
    margin-top: 3px;
    margin-bottom: 3px;
  }
  .el-menu{
    border-radius: 17px;
  }
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
