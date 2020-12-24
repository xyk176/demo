<template>
  <div id="sangpinadd">
    <div class="title">
      单品库列表<span style="font-size: 14px;font-weight: bold;"> - 新增单品</span>
    </div>

    <el-form :model="comentity"  ref="comentity" label-width="100px" class="demo-ruleForm">
      <div class="body">

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
      <!-- 新增商品新增选择图片 -->
      <el-dialog title="选择图片" id="addimg_dialog" width="60%" :visible.sync="tanchuang.isxuanzeimg" :close-on-click-modal="false" top="20px">
          <div class="addimg_left">
            <div style="margin-bottom: 15px;font-weight: 600;">图片分组</div>
            <el-tree :data="picshuju.picsg_list" :props="deProps" @node-click="pic_handleNodeClick"></el-tree>
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
      tanchuang:{isxuanzeimg:false},
      /* 选择商品图片所需参数 */
      picshuju:{
        pic_list:[],
        picsg_list:[],
        pic_xuan:[]
      },
      options: [],
      defaultPropss: {
        children: 'sorts',
        label: 'cname',
        value: 'cid2',
        checkStrictly: true
      },
      deProps: {
        children: 'children',
        label: 'label'
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

      comentity:{
        ltiaoma:'',//单品条码
        lname:'',//单品名称
        lguige:'',//单品规格
        cid2:0,//单品分类id
        lchengben:null,//单品成本
        pics:[],
        picturetopro:[

        ]
      },
      kucun:{},
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
      /* 新增单品*/
      savedanpin(){
       this.comentity.ldanwei=this.ldanwei;//单品单位
       this.comentity.prs = {cid2:this.comentity.cid2};


        this.comentity.pics.forEach(i=>{
          this.comentity.picturetopro.push({
            ptpiszhu:i.ptciszhu,
            picture:i
          })
        });

        this.$axios.put("/picturetopro/add",this.comentity).then((res)=>{
          console.log("新增的单品：",this.comentity);
          //跳转页面
          this.$router.push({path:'/liebiao'})
        })
         console.log("新增的图片",this.comentity)

        /* this.$axios.put("/picturetopro/add",this.picturetopro).then((res)=>{
          console.log("新增的图片",this.picturetopro)
        }) */

      }
      ,/* 选择的图片移除操作 */
      pic_deleteRow(index) {
        this.comentity.pics.splice(index, 1);
        if(this.comentity.pics.length>0){
          this.comentity.pics.forEach((v,i)=>{
            if(i==0){
              v.ptciszhu=1;
            }
          })
        }
      }
      /* 商品新增选择图片弹窗显示方法 */
      ,xuanze_pic(){
        this.tanchuang.isxuanzeimg=true;
        this.pic_selectAll();
      }
      ,/* 查询全部图片并进行处理 */
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
