<template>
  <div id="sangpinadd">
    <div class="title">
      商品库列表<span style="font-size: 14px;font-weight: bold;"> - 新增商品</span>
    </div>
    <div class="title_jindu">
      <el-steps :active="active" finish-status="success" :align-center="true">
        <el-step title="基本信息"></el-step>
        <el-step title="拓展信息"></el-step>
      </el-steps>
    </div>
    <el-form :model="comentity"  ref="comentity" label-width="100px" class="demo-ruleForm">
      <div class="body" v-if="active==0">
          <div class="body_title">
            基本信息
          </div>
          <el-form-item label="商品名称" prop="comname">
            <el-row>
              <el-col :span="10">
                <el-input type="text" placeholder="请输入商品名称" v-model="comentity.comname" maxlength="60" show-word-limit></el-input>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item label="商品条码" prop="comname">
            <el-button size="small" style="width: 120px;" @click="guanlian_pro()">关联单品</el-button>
          </el-form-item>
          <el-form-item label="商品类目" prop="comname">
            <el-select v-model="comentity.ccy.ccyid" placeholder="请选择">
              <el-option  v-for="(v,i) in comleibie.leibie_list" :key="i" :label="v.ccyname" :value="v.ccyid"></el-option>
            </el-select>
          </el-form-item>
      </div>
      <div class="body" v-if="active==1">


      </div>
      <div class="buttom_baocun" style="text-align: center;padding-top: 15px;">
        <router-link to="/Sangpinindex" tag="span">
          <el-button size="small" style="width: 120px;">取消</el-button>
        </router-link>
        <el-button size="small" style="width: 120px;" type="primary">下一步</el-button>
        <el-button size="small" style="width: 120px;" type="primary">保存</el-button>
      </div>
    </el-form>
    <div class="tanchuang_box">
      <!-- 新增商品关联单品 -->
     <el-dialog title="关联单品" id="addpro_dialog" width="65%" :visible.sync="tanchuang.isxuanzepro" :close-on-click-modal="false" top="20px">
        <div class="addpro_isdan">
          <el-row>
            <el-col :span="2">销售方式</el-col>
            <el-col :span="10">
              <el-radio v-model="comentity.comiszu" label="0">单独销售</el-radio>
              <el-radio v-model="comentity.comiszu" label="1">组合销售</el-radio>
            </el-col>
          </el-row>
        </div>
        <div class="addpro_danpin">
          <el-row>
            <el-col :span="3" style="padding-right: 1px;">
              <el-select v-model="proshuju.jiansuo.tiaojian" placeholder="请选择" size="small">
                <el-option label="单品名称" value="lname"></el-option>
                <el-option label="单品条码" value="ltiaoma"></el-option>
              </el-select>
            </el-col>
            <el-col :span="6">
              <el-input placeholder="请输入内容" size="small" v-model="proshuju.jiansuo.canshu" class="input-with-select">
                <el-button slot="append" icon="el-icon-search"></el-button>
              </el-input>
            </el-col>
          </el-row>
          <div class="addpro_danpin_show">

          </div>
          <el-pagination
          @size-change="pageChange"
          @current-change="pageChange"
          :current-page="proshuju.show_page.current"
          :page-size="proshuju.show_page.size"
          :total="proshuju.show_page.total"
          layout="total, prev, pager, next, jumper"
          style="text-align: center;margin-top: 10px;" >
          </el-pagination>
        </div>
        <div slot="footer" class="dialog-footer">
          <el-button size="small" type="primary">确 定</el-button>
          <el-button size="small">取 消</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  export default {
   data(){
     return{
      tanchuang:{
       isxuanzepro:false,
      },
      active: 0,
      comentity:{
        comid:'',
        comiszu:'0',
        comname:'',
        combarcode:'',
        comsameprice:0,
        compricemin:0,
        compricemax:0,
        commarketprice:0,
        comweight:0,
        comvolume:0,
        comsalesvolume:0,
        comsalesstatus:1,
        coprs:[],
        pics:[],
        cprs:[],
        cpys:[],
        cll:{},
        ccy:{
          ccyid:''
        }
      },
      comleibie:{
        fuety:{
          ccyid:'',
          ccyname:''
        },
        leibie_list:[]
      },
      proshuju:{
        jiansuo:{
          tiaojian:'lname',
          canshu:''
        },
        show_page:{
          current:0,
          total:0,
          size:5
        },
      }
     }
   },
   methods:{
      comleibie_show(){
        this.$axios.post('commoditycomtroller/selectall_shangpinleimu')
        .then(r=>{
            this.comleibie.leibie_list=r.data;
            console.log(this.comleibie.leibie_list);
        }).catch(function(e){
            console.log("报错了，错误信息：",e);
        });
      },
      pro_selectAll(){
        
      },
      guanlian_pro(){
        this.tanchuang.isxuanzepro=true;
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
