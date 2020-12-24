<template>
  <div id="sangpinadd">
    <div class="title">
      单品库列表<span style="font-size: 14px;font-weight: bold;"> - 新增单品</span>
    </div>

    <el-form :model="comentity"  ref="comentity" label-width="100px" class="demo-ruleForm">
      <div class="body" v-if="active==0">

          <el-form-item label="单品条码" prop="ltiaoma">
            <el-row>
              <el-col :span="10">
                <el-input type="text" placeholder="请输入单品条码" v-model="comentity.ltiaoma" maxlength="60" show-word-limit></el-input>
              </el-col>
            </el-row>
          </el-form-item>

          <el-form-item label="单品名称" prop="lname">
            <el-row>
              <el-col :span="10">
                <el-input type="text" placeholder="请输入单品名称" v-model="comentity.lname" maxlength="60" show-word-limit></el-input>
              </el-col>
            </el-row>
          </el-form-item>

          <el-form-item label="单品规格" prop="lguige">
            <el-row>
              <el-col :span="10">
                <el-input type="text" placeholder="请输入单品规格" v-model="comentity.lguige" maxlength="60" show-word-limit></el-input>
              </el-col>
            </el-row>
          </el-form-item>

          <el-form-item label="单品分类" prop="comname">
            <el-cascader
                :options="options"
                :props="defaultPropss"
                @change="changea"
                clearable></el-cascader>
          </el-form-item>

          <el-form-item label="单品单位" prop="ldanwei">
            <el-select v-model="ldanwei" placeholder="请选择">
                <el-option
                  v-for="item in options2"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
          </el-form-item>

          <el-form-item label="单品成本" prop="lchengben">
            <el-row>
              <el-col :span="3">
                <el-input type="text" placeholder="元" v-model="comentity.lchengben" show-word-limit></el-input>
              </el-col>
              <el-col :span="13">
                <div style="margin-left: 15px;">设置单品的销售成本，作为统计利润的依据</div>
              </el-col>
            </el-row>
          </el-form-item>


      </div>
      <div class="body" v-if="active==1">


      </div>
      <div class="buttom_baocun" style="text-align: center;padding-top: 15px;">
        <router-link to="/liebiao" tag="span">
          <el-button size="small" style="width: 120px;">取消</el-button>
        </router-link>
        <el-button size="small" style="width: 120px;" type="primary" @click="savedanpin">保存</el-button>
      </div>
    </el-form>

  </div>
</template>

<script>
  export default {
   data(){
     return{
      options: [],
      defaultPropss: {
        children: 'sorts',
        label: 'cname',
        value: 'cid2',
        checkStrictly: true
      },
      options2: [{
                value: '1',
                label: '袋'
              }, {
                value: '2',
                label: '盒'
              }, {
                value: '3',
                label: '箱'
              }, {
                value: '4',
                label: '包'
              }, {
                value: '5',
                label: '瓶'
              }, {
                value: '6',
                label: '只'
              }, {
                value: '7',
                label: '套'
              }, {
                value: '8',
                label: '块'
              }, {
                value: '9',
                label: '捆'
              }, {
                value: '10',
                label: '提'
              }],
              ldanwei: '',
      active: 0,
      comentity:{
        ltiaoma:'',//单品条码
        lname:'',//单品名称
        lguige:'',//单品规格
        cid2:0,//单品分类id
        lchengben:null//单品成本
      },
      kucun:{}
     }
   },
   methods:{
     changea(e){
       console.log("aaaaaaaa",e)
       this.comentity.cid2=e[e.length-1];
       console.log("分类id",this.comentity.cid2)
     },
      comleibie_show(){
        this.$axios.post("/sort/all")
        .then((res)=>{
          this.options=res.data;
          console.log("所有分类",this.options)
        }).catch(function(e){
            console.log("报错了，错误信息：",e);
        });
      },
      savedanpin(){
        this.comentity.ldanwei=this.ldanwei;//单品单位
        this.comentity.prs = {cid2:this.comentity.cid2};
        this.$axios.put("/product/insert",this.comentity).then((res)=>{
          console.log("新增的单品：",this.comentity);
          //跳转页面
          this.$router.push({path:'/liebiao'})
        })
      }
   },
   mounted(){
     this.comleibie_show();
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
