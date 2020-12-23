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
    <el-form :model="comentity" ref="comentity" label-width="100px" class="demo-ruleForm">
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
          <el-form-item label="商品条码" prop="combarcode">
            <el-row>
              <el-col :span="4" v-if="comentity.combarcode!=''">
                 <el-tag size="mini" v-if="comentity.comiszu=='1'" type="success" effect="plain" style="margin-right: 5px;">组</el-tag>
                 <el-tag size="mini" v-if="comentity.comiszu!='1'" effect="plain" style="margin-right: 5px;">单</el-tag>
                 {{comentity.combarcode}}
              </el-col>
              <el-col :span="10">
                <el-button size="small" style="width: 120px;" @click="guanlian_pro()">关联单品</el-button>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item label="商品类目">
            <el-select v-model="comentity.ccy.ccyid" placeholder="请选择">
              <el-option  v-for="(v,i) in comleibie.leibie_list" :key="i" :label="v.ccyname" :value="v.ccyid"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="商品价格">
            <el-row>
              <el-col :span="4">
                <el-input-number style="width: 100%;" :controls="false" v-model="comentity.comsameprice" :min="0"></el-input-number>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item label="售价区间">
            <el-row>
              <el-col :span="4">
                <el-input-number style="width: 100%;" :controls="false" v-model="comentity.compricemin" :max="comentity.compricemax"></el-input-number>
              </el-col>
              <el-col :span="1" style="text-align: center;"><span>——</span></el-col>
              <el-col :span="4">
                <el-input-number style="width: 100%;" :controls="false" v-model="comentity.compricemax" :min="comentity.compricemin"></el-input-number>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item label="市场价">
            <el-row>
              <el-col :span="4">
                <el-input-number style="width: 100%;" :controls="false" v-model="comentity.commarketprice" :min="0"></el-input-number>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item label="重量">
            <el-row>
              <el-col :span="5">
                <el-input style="width: 100%;" :controls="false" v-model="comentity.comweight" :min="0">
                  <template slot="append">Kg</template>
                </el-input>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item label="体积">
            <el-row>
              <el-col :span="5">
                <el-input style="width: 100%;" :controls="false" v-model="comentity.comvolume" :min="0">
                  <template slot="append">m³</template>
                </el-input>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item label="商品图片" prop="coprs">
            <div class="body_pic_box">
              <ul>
                <li v-for="(v,i) in comentity.pics" :key="i">
                  <div class="pic_li_cha" @click="pic_deleteRow(i)"><i class="el-icon-close"></i></div>
                  <div class="pic_li_img">
                    <el-image style="width: 100%; height: 100%" :src="v.pic.picpath" fit="cover"></el-image>
                  </div>
                </li>
                <li>
                  <div @click="xuanze_pic()" ng-if="!(goodsImageUrl.length>=10)" class="goods-img-add-contant pull-left pos-rlt pointer m-r-lg m-t-xs m-b-sm ng-scope" ng-click="uploadImg()">
                      <div class="goods-img-add-div">
                          <i class="fa fa-plus text-muted"></i>
                          <p>添加图片</p>
                      </div>
                  </div>
                </li>
              </ul>
            </div>
          </el-form-item>
      </div>
      <div class="body" v-if="active==1">
        <el-form-item label="商品名称" prop="comname">
          <el-row>
            <el-col :span="10">
              <el-input type="text" placeholder="请输入商品名称" v-model="comentity.comname" maxlength="60" show-word-limit></el-input>
            </el-col>
          </el-row>
        </el-form-item>
      </div>
      <div class="buttom_baocun" style="text-align: center;padding-top: 15px;">
        <router-link to="/Sangpinindex" tag="span">
          <el-button size="small" style="width: 120px;">取消</el-button>
        </router-link>
        <el-button size="small" style="width: 120px;" type="primary">下一步</el-button>
        <el-button size="small" style="width: 120px;" type="primary" @click="com_insert()">保存</el-button>
      </div>
    </el-form>
    <div class="tanchuang_box">
      <!-- 新增商品关联单品 -->
     <el-dialog title="关联单品" id="addpro_dialog" width="65%" :visible.sync="tanchuang.isxuanzepro" :close-on-click-modal="false" top="20px">
       <el-form :model="proshuju"  ref="proshuju" :rules="prozu_rules" label-width="100px" class="demo-ruleForm">
        <div class="addpro_isdan">
          <el-row>
            <el-col :span="2">销售方式</el-col>
            <el-col :span="10">
              <el-radio v-model="comentity.comiszu" label="0" @change="is_zuchange()">单独销售</el-radio>
              <el-radio v-model="comentity.comiszu" label="1" @change="is_zuchange()">组合销售</el-radio>
            </el-col>
          </el-row>
        </div>
        <div class="addpro_danpin">
          <el-row>
            <el-col :span="15">选择单品</el-col>
            <el-col :span="3" style="padding-right: 1px;">
              <el-select v-model="proshuju.jiansuo.tiaojian" placeholder="请选择" size="small">
                <el-option label="单品名称" value="lname"></el-option>
                <el-option label="单品条码" value="ltiaoma"></el-option>
              </el-select>
            </el-col>
            <el-col :span="6">
              <el-input placeholder="请输入内容" size="small" v-model="proshuju.jiansuo.canshu" class="input-with-select">
                <el-button slot="append" icon="el-icon-search" @click="pt_jiansuo()"></el-button>
              </el-input>
            </el-col>
          </el-row>
          <div class="addpro_danpin_show">
            <el-table  ref="multipleTable" :data="proshuju.pro_list" style="width: 100%" highlight-current-row @current-change="pro_handleCurrentChange">
              <el-table-column label="单品名称">
                <template slot-scope="scope">
                  <div class="shangping_table_name">
                    <el-row>
                      <div style="float: left;height: 36px;width: 36px;overflow: hidden;border-radius: 6px;"><img :src="scope.row.picturetopro[0].pic.picpath"  width="36px"/></div>
                      <div style="float: left;height: 36px;line-height: 36px;margin-left: 15px;">{{scope.row.lname}}</div>
                    </el-row>
                  </div>
                </template>
              </el-table-column>
              <el-table-column label="商品规格" prop="lguige" width="150" ></el-table-column>
              <el-table-column label="商品条码" prop="ltiaoma" width="150"  align="center"></el-table-column>
              <el-table-column label="单品成本" width="90" align="center">
                <template slot-scope="scope">
                  ￥{{scope.row.lchengben}}
                </template>
              </el-table-column>
              <el-table-column label="商品单位" prop="ldanwei" width="80"  align="center"></el-table-column>
            </el-table>
          </div>
          <div class="addpro_danpin_fenye">
            <el-pagination
            @size-change="pro_pageChange"
            @current-change="pro_pageChange"
            :current-page="proshuju.show_page.current"
            :page-size="proshuju.show_page.size"
            :total="proshuju.show_page.total"
            layout="total, prev, pager, next, jumper"
            style="text-align: center;margin-top: 10px;" >
            </el-pagination>
          </div>
        </div>
        <div class="addpro_zuhecout" v-if="comentity.comiszu=='1'">
          <el-row style="margin: 10px 0px;">
            组合单品明细
          </el-row>
          <div class="zuhecout_table">
            <el-table :data="proshuju.xuan_pro" style="width: 100%">
              <el-table-column label="单品名称" prop="lname"></el-table-column>
              <el-table-column label="商品条码" prop="ltiaoma" width="150"  align="center"></el-table-column>
              <el-table-column label="单品成本" width="90" align="center">
                <template slot-scope="scope">
                  ￥{{scope.row.lchengben}}
                </template>
              </el-table-column>
              <el-table-column label="组合内数量" width="155" align="center">
                <template slot-scope="scope">
                  <el-input-number v-model="scope.row.ctpnum" controls-position="right" size="small"  :min="1" :max="999999" :controls="false"></el-input-number>
                </template>
              </el-table-column>
              <el-table-column label="商品单位" prop="ldanwei" width="80"  align="center"></el-table-column>
              <el-table-column label="操作" width="120" align="center">
                <template slot-scope="scope">
                  <el-button icon="el-icon-minus" size="mini" circle  @click.native.prevent="pro_deleteRow(scope.$index, proshuju.xuan_pro)"></el-button>
                </template>
              </el-table-column>
            </el-table>
          </div>
          <div class="zuhecout_xaingxi">
             <el-row>
               <el-col :span="12">
                 <el-form-item label="组合名称" prop="zuhe_name">
                   <el-input type="text" placeholder="请输入组合名称" v-model="proshuju.zuhe_name" show-word-limit></el-input>
                 </el-form-item>
               </el-col>
               <el-col :span="12">
                 <el-form-item label="组合条码" >
                   <el-input type="text" placeholder="如无条码系统将会自动生成" v-model="proshuju.zuhe_tiaoma" show-word-limit></el-input>
                 </el-form-item>
               </el-col>
             </el-row>
          </div>
        </div>
        <div class="dialog-footer" style="padding: 10px 5px 0px;text-align: right;">
          <el-button size="small" type="primary" @click="pro_queding('proshuju')">确 定</el-button>
          <el-button size="small">取 消</el-button>
        </div>
       </el-form>
      </el-dialog>

      <!-- 新增商品新增选择图片 -->
      <el-dialog title="选择图片" id="addimg_dialog" width="60%" :visible.sync="tanchuang.isxuanzeimg" :close-on-click-modal="false" top="20px">
          <div class="addimg_left">
            <div style="margin-bottom: 15px;font-weight: 600;">图片分组</div>
            <el-tree :data="picshuju.picsg_list" :props="defaultProps" @node-click="pic_handleNodeClick"></el-tree>
          </div>
          <div class="addimg_right">
            <ul>
              <li v-for="(v,i) in picshuju.pic_list" :key="i" @click="pic_Click(v)">
                <div class="addimg_right_mubu" v-if="v.isclick">
                  <div class="addimg_right_mubu_box">
                    <el-image src="../static/log/gou.png" fit="cover" class="image"></el-image>
                  </div>
                </div>
                <el-card :body-style="{ padding: '0px' }">
                  <el-image style="width: 160px; 160px" :src="v.picpath" fit="cover" class="image"></el-image>
                  <div style="padding: 14px;width:100%;overflow:hidden; text-overflow:ellipsis; white-space:nowrap;">
                    <span>{{v.picpath.split("/")[v.picpath.split("/").length-1]}}</span>
                  </div>
                </el-card>
              </li>
            </ul>
          </div>
          <div class="addimg_button">
            <el-button size="small" type="primary" @click="pic_xuan_baocun()">确 定</el-button>
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
       isxuanzeimg:false,
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
      /* 关联单品所需参数 */
      proshuju:{
        jiansuo:{
          tiaojian:'lname',
          canshu:''
        },
        pro_list:[],
        xuan_pro:[],
        zuhe_name:'',
        zuhe_tiaoma:'',
        show_page:{
          current:0,
          total:0,
          size:5
        },
      },
      /* 选择商品图片所需参数 */
      picshuju:{
        pic_list:[],
        picsg_list:[],
        pic_xuan:[]
      },
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      prozu_rules: {
        zuhe_name: [
          { required: true, message: '请输入组合名称', trigger: 'blur' }
        ]
      },
      com_rules: {
        comname: [
          { required: true, message: '请输入商品名称', trigger: 'blur' }
        ],
        combarcode: [
          { required: true, message: '请选择关联单品', trigger: 'blur' }
        ],
        coprs: [
          { required: true, message: '请选择图片'}
        ],
      },
     }
   },
   methods:{
      /* 商品类目查询全部 */
      comleibie_show(){
        this.$axios.post('commoditycomtroller/selectall_shangpinleimu')
        .then(r=>{
            this.comleibie.leibie_list=r.data;
        }).catch(function(e){
            console.log("报错了，错误信息：",e);
        });
      },
      /* 单品查询全部 */
      pro_selectAll(){
        let pream={
          tiaojian:this.proshuju.jiansuo.tiaojian,
          canshu:this.proshuju.jiansuo.canshu,
          current:this.proshuju.show_page.current,
          size:this.proshuju.show_page.size
        }
        this.$axios.post('commoditycomtroller/selectallpro_pttiaojian',pream)
        .then(r=>{
            this.proshuju.pro_list=r.data.list;
            this.proshuju.show_page.total=r.data.total;
            this.proshuju.show_page.current = r.data.pageNum;
        }).catch(function(e){
            console.log("报错了，错误信息：",e);
        });
      },
      /* 关联单品弹窗选择是否组合响应事件 */
      is_zuchange(){
        this.proshuju.xuan_pro=[];
      },
      /* 关联单品弹窗条件检索方法 */
      pt_jiansuo(){
        this.proshuju.show_page.current=0;
        this.pro_selectAll();
      },
      /* 关联单品分页切页事件 */
      pro_pageChange(v){
        this.proshuju.show_page.current=v;
        this.pro_selectAll();
      },
      /* 商品新增关联单品弹窗显示方法 */
      guanlian_pro(){
        this.tanchuang.isxuanzepro=true;
        this.pro_selectAll();
      },
      /* 关联单品移除选择的单品方法 */
      pro_deleteRow(index, rows) {
        rows.splice(index, 1);
      },
      /* 关联单品选择单品方法 */
      pro_handleCurrentChange(val){
        if(this.comentity.comiszu=='1'){
          val.ctpnum=0;
          let isno = true;
          this.proshuju.xuan_pro.forEach(v=>{
            if(val.lid==v.lid){
              isno=false;
            }
          })
          if(isno){
            this.proshuju.xuan_pro.push(val);
          }
        }else{
          this.proshuju.xuan_pro=[];
          this.proshuju.xuan_pro.push(val);
        }
      },
      /* 关联单品选择确认方法 */
      pro_queding(formName){
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if(this.proshuju.xuan_pro.length!=0){
              if(this.comentity.comiszu=='1'){
                let compro=[];
                this.proshuju.xuan_pro.forEach(v=>{
                  compro.push({
                    ctpnum:v.ctpnum,
                    products:{
                      lid:v.lid
                    }
                  })
                })
                this.comentity.coprs=compro;
                if(this.proshuju.zuhe_tiaoma==''){
                  this.comentity.combarcode='PR'+new Date().getTime();
                }else{
                  this.comentity.combarcode=this.proshuju.zuhe_tiaoma;
                }
              }else{
                let compro=[{
                  products:{
                    lid:this.proshuju.xuan_pro[0].lid
                  }
                }];
                this.comentity.coprs=compro;
                this.comentity.combarcode=this.proshuju.xuan_pro[0].ltiaoma;
              }
              this.tanchuang.isxuanzepro=false;
            }else{
              this.$message({
                message: '您还没有选择单品！',
                type: 'warning'
              });
            }
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      /* 商品新增选择图片弹窗显示方法 */
      xuanze_pic(){
        this.tanchuang.isxuanzeimg=true;
        this.pic_selectAll();
      },
      /* 查询全部图片并进行处理 */
      pic_selectAll(){
        let tree = [];
        this.$axios.post('commoditycomtroller/selectall_pic')
        .then(r=>{
            r.data.forEach(v=>{
              v.isclick=false;
            })
            this.picshuju.pic_list=r.data;
            tree.push({
              label: '全部图片',
              list:r.data,
              children: []
            });
            this.$axios.post('commoditycomtroller/selectall_picspic')
            .then(r=>{
                r.data.forEach(v=>{
                  v.pics.forEach(v=>{
                    v.isclick=false;
                  })
                  tree[0].children.push({
                    label: v.prcost,
                    list:v.pics
                  })
                })
                this.picshuju.picsg_list=tree;

            }).catch(function(e){
                console.log("报错了，错误信息：",e);
            });
        }).catch(function(e){
            console.log("报错了，错误信息：",e);
        });
      },
      /* 图片分组选中事件 */
      pic_handleNodeClick(v){
        v.list.forEach(v=>{
          v.isclick=false;
        })
        this.picshuju.pic_list=v.list;
      },
      /* 图片点击选中事件 */
      pic_Click(v){
        v.isclick=!v.isclick;
      },
      /* 图片选中保存 */
      pic_xuan_baocun(){
        let xuan=[];
        this.picshuju.pic_list.forEach(v=>{
          if(v.isclick){
            xuan.push(v);
          }
        })
        xuan.forEach((v,i)=>{
          let iszhu = 0;
          if(i==0){
            iszhu=1;
          }
          this.comentity.pics.push({
            ptciszhu:iszhu,
            pic:v
          })
        })
        this.tanchuang.isxuanzeimg=false;
      },
      /* 选择的图片移除操作 */
      pic_deleteRow(index) {
        this.comentity.pics.splice(index, 1);
        if(this.comentity.pics.length>0){
          this.comentity.pics.forEach((v,i)=>{
            if(i==0){
              v.ptciszhu=1;
            }
          })
        }
      },
      /* 添加保存商品 */
      com_insert(){
        this.$axios.put('commoditycomtroller/com_insert',this.comentity)
        .then(r=>{
            if(r.data){
              this.$message({
                message: '创建成功！',
                type: 'success'
              });
              this.$router.push({
              name:'Sangpinindex'
              })
            }else{
              this.$message.error('创建失败！');
            }
        }).catch(function(e){
            console.log("报错了，错误信息：",e);
        });
      },
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
    border-radius: 8px;
    padding: 15px 20px;
    background: #F2F2F6;
  }
  #sangpinadd #addpro_dialog .el-dialog .addpro_danpin{
    margin-top: 10px;
    border-radius: 8px;
    padding: 15px 20px;
    background: #F2F2F6;
  }
  #sangpinadd #addpro_dialog .el-dialog .addpro_danpin .addpro_danpin_show{
    background: #FFFFFF;
    min-height: 60px;
    border-radius: 8px;
    margin-top: 10px;
    padding: 10px;
  }
  #sangpinadd #addpro_dialog .el-dialog .addpro_danpin .addpro_danpin_fenye{
    border-radius: 8px;
    background: #FFFFFF;
    margin-top: 5px;
    box-sizing: border-box;
  }
  #sangpinadd #addpro_dialog .el-dialog .addpro_zuhecout{
    margin-top: 10px;
    border-radius: 8px;
    padding: 15px 20px;
    background: #F2F2F6;
  }
  #sangpinadd #addpro_dialog .el-dialog .addpro_zuhecout .zuhecout_table{
    border-radius: 8px;
    border: 1px solid #E2E2E2;
    overflow: hidden;
  }
  #sangpinadd #addpro_dialog .el-dialog .addpro_zuhecout .zuhecout_xaingxi{
    border-radius: 8px;
    background: #FFFFFF;
    padding: 10px 15px;
    margin-top: 10px;
  }
  #sangpinadd #addpro_dialog .el-dialog .addpro_zuhecout .zuhecout_xaingxi .el-form-item {
    margin-bottom: 0px;
  }
</style>
<!-- 添加商品图片样式 -->
<style>
  #sangpinadd .body .el-form-item .body_pic_box{
    width: 1000px;
    min-height: 120px;
  }
  #sangpinadd .body .el-form-item .body_pic_box ul{
    list-style-type: none;
    overflow: hidden;
  }
  #sangpinadd .body .el-form-item .body_pic_box ul li{
    width: 140px;
    height: 170px;
    padding: 10px;
    float: left;
    position: initial;
    box-sizing: border-box;
  }
  #sangpinadd .body .el-form-item .body_pic_box ul li .pic_li_cha{
    height: 20px;
    line-height: 20px;
    width: 20px;
    background: #FFFFFF;
    border-radius: 10px;
    border: 1px solid #E2E2E2;
    text-align: center;
    position: relative;
    top:10px;
    right: -10px;
    float: right;
    z-index: 10;
  }
  #sangpinadd .body .el-form-item .body_pic_box ul li .pic_li_cha:hover{
    box-shadow: 0 2px 4px 0 rgba(0,0,0,.12), 0 0 6px 0 rgba(0,0,0,.04);
  }
  #sangpinadd .body .el-form-item .body_pic_box ul li .goods-img-add-contant {
      display: inline-block;
      background: #FFFFFF;
      border: 1px dashed #E3E2E5;
      border-radius: 4px;
      width: 120px;
      height: 120px;
      text-align: center;
      margin-top: 20px;
  }
  #sangpinadd .body .el-form-item .body_pic_box ul li  .goods-img-add-contant .goods-img-add-div {
      margin-top: 35px;
      display: inline-block;
  }
  #sangpinadd .body .el-form-item .body_pic_box ul li  .goods-img-add-contant .goods-img-add-div i {
      color: #B2AEBC;
      font-size: 20px;
  }
  #sangpinadd .body .el-form-item .body_pic_box ul li  .goods-img-add-contant .goods-img-add-div p {
      font-size: 12px;
      color: #595961;
      margin-top: -10px;
  }

  #sangpinadd #addimg_dialog .el-dialog{
    border-radius: 8px;
  }
  #sangpinadd #addimg_dialog .el-dialog .addimg_left{
    width: 30%;
    height: 600px;
    box-sizing: border-box;
    float: left;
    padding: 10px;
    border-right: 1px solid #CCCCCC;
  }
  #sangpinadd #addimg_dialog .el-dialog .addimg_right{
    width: 70%;
    height: 600px;
    box-sizing: border-box;
    float: left;
    overflow:auto;
  }
  #sangpinadd #addimg_dialog .el-dialog .addimg_right ul{
    list-style-type: none;
  }
  #sangpinadd #addimg_dialog .el-dialog .addimg_right ul li{
    width: 33%;
    height: 215px;
    float: left;
    padding-left: 10px;
    padding-bottom: 10px;
    position: relative;
    box-sizing: border-box;
  }
  #sangpinadd #addimg_dialog .el-dialog .addimg_right ul li .addimg_right_mubu{
    width: 100%;
    height: 215px;
    position: absolute;
    top: 0;
    right: 0;
    z-index: 100;
    padding-left: 10px;
    padding-bottom: 10px;
    box-sizing: border-box;
  }
  #sangpinadd #addimg_dialog .el-dialog .addimg_right ul li .addimg_right_mubu .addimg_right_mubu_box{
    background-color: rgba(0,0,0,0.5);
    width: 100%;
    height: 207px;
    line-height: 207px;
    text-align: center;
    border-radius: 4px;
  }
  #sangpinadd #addimg_dialog .el-dialog .addimg_right ul li .addimg_right_mubu .addimg_right_mubu_box .el-image img{
    display:inline-block;
    vertical-align:middle;
  }
  #sangpinadd #addimg_dialog .el-dialog .addimg_button{
    width: 100%;
    height: 60px;
    line-height: 60px;
    overflow: hidden;
    text-align: right;
  }
</style>
