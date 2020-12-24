<template>
  <div id="sangpinadd">
    <div class="title">
      单品库列表<span style="font-size: 14px;font-weight: bold;"> - 修改单品</span>
    </div>

    <el-form label-width="100px" class="demo-ruleForm">
      <div class="body">

          <el-form-item label="单品条码">
            <el-row>
              <el-col :span="10">
                <el-input type="text" v-model="ltiaoma"></el-input>
              </el-col>
            </el-row>
          </el-form-item>

          <el-form-item label="单品名称">
            <el-row>
              <el-col :span="10">
                <el-input type="text" v-model="lname" ></el-input>
              </el-col>
            </el-row>
          </el-form-item>

          <el-form-item label="单品图片">
            <template slot-scope="scope">
              <img :src="picpath"  width="36px"/>
            </template>
          </el-form-item>

          <el-form-item label="单品规格">
            <el-row>
              <el-col :span="10">
                <el-input type="text" v-model="lguige"></el-input>
              </el-col>
            </el-row>
          </el-form-item>

          <el-form-item label="单品分类">
            <el-row>
              <el-col :span="10">
                <el-input type="text" v-model="cname" :disabled=true></el-input>

              </el-col>
            </el-row>
          </el-form-item>

          <el-form-item label="单品单位">
            <el-row>
              <el-col :span="10">
                <el-input type="text" v-model="ldanwei"></el-input>
              </el-col>
            </el-row>
          </el-form-item>

          <el-form-item label="单品成本" prop="lchengben">
            <el-row>
              <el-col :span="3">
                <el-input type="text" placeholder="元" v-model="lchengben"></el-input>
              </el-col>
            </el-row>
          </el-form-item>
      </div>
      <div class="buttom_baocun" style="text-align: center;padding-top: 15px;">
        <router-link to="/liebiao" tag="span">
          <el-button size="small" style="width: 120px;">取消</el-button>
        </router-link>
        <el-button size="small" style="width: 120px;" type="primary" @click="updatedanpin">保存</el-button>
      </div>
    </el-form>

  </div>
</template>

<script>
  export default {
   data(){
     return{
        ltiaoma:this.$route.query.params.ltiaoma,//单品条码
        lname:this.$route.query.params.lname,//单品名称
        lguige:this.$route.query.params.lguige,//单品规格
        cname:this.$route.query.params.cname,//单品分类
        lchengben:this.$route.query.params.lchengben,//单品成本
        ldanwei:this.$route.query.params.ldanwei,//单品成本
        picpath:this.$route.query.params.picpath,//单品图片
        lid:this.$route.query.params.lid,//单品图片
        cid2:this.$route.query.params.cid2,//单品分类id
        danpin:{},
        // options: [],
        // defaultPropss: {
        //   children: 'sorts',
        //   label: 'cname',
        //   value: 'cid2',
        //   checkStrictly: true
        // },
     }
   },
   methods:{
     load(){

     }
     ,updatedanpin(){

       let param={
         lname:this.lname,
         lguige:this.lguige,
         ldanwei:this.ldanwei,
         ltiaoma:this.ltiaoma,
         lchengben:this.lchengben,
         lid:this.lid
       }
       this.$axios.put("/product/updateproduct/",param)
       .then((res)=>{
         console.log("canshu",param)
         alert("成功啦")
         this.$router.push({path:'/liebiao'})
       })
     }

   },
   created() {
     this.load();
   }
  }
</script>

<style>
  #sangpinadd{
    padding: 10px;
  }
  #sangpinadd .title{
    height: 60px;
    line-height: 60px;
    font-size: 14px;
    color: #595961;
    padding-left: 10px;
  }
  #sangpinadd .body{
    border-radius: 5px;
    padding: 20px;
    background: #F2F2F6;
  }
  #sangpinadd .body .body_title{
    font-size: 16px;
    color: #595961;
    margin-bottom: 20px;
    font-weight: 600;
  }
  #sangpinadd .title_jindu{
    height: 80px;
  }
  #sangpinadd #addpro_dialog .el-dialog{
    border-radius: 8px;
  }
  #sangpinadd #addpro_dialog .el-dialog .addpro_isdan{
    border-radius: 6px;
    padding: 15px 20px;
    background: #F2F2F6;
  }
  #sangpinadd #addpro_dialog .el-dialog .addpro_danpin{
    margin-top: 10px;
    border-radius: 6px;
    padding: 15px 20px;
    background: #F2F2F6;
  }
</style>
