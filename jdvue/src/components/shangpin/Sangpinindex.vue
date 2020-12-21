<template>
  <div id="sangpinindex">
    <div class="title">
      商品库列表
    </div>
    <div class="body">
      <div class="shangping_jiansuo" >
        <el-row>
          <el-col :span="2" style="padding-right: 1px;">
            <el-select v-model="jiansuo.ptjiansuo.tiaojian" placeholder="请选择" size="small">
              <el-option label="商品名称" value="1"></el-option>
              <el-option label="商品条码" value="2"></el-option>
              <el-option label="商品编号" value="3"></el-option>
            </el-select>
          </el-col>
          <el-col :span="5">
            <el-input placeholder="请输入内容" size="small" v-model="jiansuo.ptjiansuo.canshu" class="input-with-select">
              <el-button slot="append" icon="el-icon-search"></el-button>
            </el-input>
          </el-col>
          <el-col :span="17" style="text-align: right;">
            <el-button size="small">高级筛选</el-button>
          </el-col>
        </el-row>
        <el-divider></el-divider>
        <el-row>
          <el-col :span="2" style="text-align: center;color: #595961;line-height: 32px;text-align: left;padding-left: 10px;">
            快捷操作
          </el-col>
          <el-col :span="10">
            <el-button size="small">新增商品</el-button>
            <el-button size="small">批量可售</el-button>
            <el-button size="small">批量禁售</el-button>
          </el-col>
        </el-row>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
   data(){
     return{
       jiansuo:{
        ptjiansuo:{
          tiaojian:'1',
          canshu:''
        }
       }
     }
   },
   methods:{
    selectall(){
      this.$axios.post('textcoller/selectall')
      .then(r=>{

      }).catch(function(e){
          console.log("报错了，错误信息：",e);
      });
    }
   },
   mounted(){
    this.selectall();
   }
  }
</script>

<style>
  #sangpinindex{
    padding: 10px;
  }
  #sangpinindex .title{
    height: 60px;
    line-height: 60px;
    font-size: 14px;
    color: #595961;
    font-weight: bold;
    padding-left: 10px;
  }
  #sangpinindex .body{
    border-radius: 5px;
    padding: 10px;
    background: #F2F2F6;
  }
  #sangpinindex .body .shangping_jiansuo{
    width: 100%;
    border-radius: 5px;
    padding: 10px;
    background: #FFFFFF;
    box-sizing: border-box;
    padding-bottom: 20px;
  }
</style>
