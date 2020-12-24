<template>
  <div id="sangpinlable">
    <div class="title">
      商品标签
    </div>
    <div class="body">
      <div class="shangping_jiansuo" >
        <div style="float: left;">
          <el-button size="small" @click="cll_insert()"><i class="el-icon-plus" style="margin-right: 5px;"></i>新增标签</el-button>
        </div>
        <div style="width: 250px;float: right;">
          <el-input placeholder="请输入内容" size="small" v-model="jiansuo.canshu" class="input-with-select">
            <el-button slot="append" icon="el-icon-search" @click="selectCll()"></el-button>
          </el-input>
        </div>
      </div>
      <div class="shangping_table" >
        <el-table :data="clls" style="width: 100%">
            <el-table-column prop="cllname" label="标签名称"  width="150" align="center"></el-table-column>
            <el-table-column  label="标签绑定商品数"  align="center">
              <template slot-scope="scope">
                <span style="color: #3A8EE6;font-weight: 600;">{{scope.row.coms.length}}</span>
              </template>
            </el-table-column>
            <el-table-column  label="操作" width="100" align="center">
              <template slot-scope="scope">
                <el-button type="text" size="small" @click="cll_update(scope.row)">编辑</el-button>
              </template>
            </el-table-column>
          </el-table>
      </div>
    </div>

    <!-- 新增标签弹窗 -->
    <el-dialog id="addcll_dialog" title="新增标签" width="40%" :visible.sync="dialogFormVisible" :close-on-click-modal="false" @close="cll_guanbi()">
      <el-form :model="cll" :rules="rules" ref="cll" label-width="100px" class="demo-ruleForm">
        <el-form-item label="标签名称" prop="cllname">
          <el-input v-model="cll.cllname"></el-input>
        </el-form-item>
        <el-form-item style="text-align: right;">
          <el-button type="primary" @click="submitForm('cll')">确定</el-button>
          <el-button @click="cll_guanbi()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  export default {
   data(){
     return{
       dialogFormVisible:false,
      jiansuo:{
        canshu:''
      },
      clls:[],
      cll:{
        cllid:'',
        cllname:''
      },
      rules: {
        cllname: [
          { required: true, message: '请输入标签名称', trigger: 'blur' }
        ]
      }
     }
   },
   methods:{
    selectCll(){
      this.$axios.post('commoditycomtroller/selectallcll_tiaojian',{canshu:this.jiansuo.canshu})
      .then(r=>{
          this.clls=r.data;
      }).catch(function(e){
          console.log("报错了，错误信息：",e);
      });
    },
    cll_insert(){
      this.dialogFormVisible=true;
    },
    cll_remove(){
      this.cll={
        cllid:'',
        cllname:''
      }
    },
    cll_guanbi(){
      this.cll_remove();
      this.dialogFormVisible=false;
    },
    cll_update(v){
      this.cll.cllid=v.cllid;
      this.cll.cllname=v.cllname;
      this.dialogFormVisible=true;
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.put('commoditycomtroller/cll_insetupdate',this.cll)
          .then(r=>{
              if(r.data){
                this.$message({
                  message: '操作成功！',
                  type: 'success'
                });
                this.cll_guanbi();
                this.selectCll();
              }else{
                this.$message.error('操作失败！');
              }
          }).catch(function(e){
              console.log("报错了，错误信息：",e);
          });
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
   },
   mounted(){
    this.selectCll();
   }
  }
</script>

<style>
  #sangpinlable{
    padding: 10px;
  }
  #sangpinlable .title{
    height: 60px;
    line-height: 60px;
    font-size: 14px;
    color: #595961;
    font-weight: bold;
    padding-left: 10px;
  }
  #sangpinlable .body{
    border-radius: 5px;
    padding: 10px;
    background: #F2F2F6;
  }
  #sangpinlable .body .shangping_jiansuo{
    width: 100%;
    border-radius: 6px;
    padding: 10px;
    background: #FFFFFF;
    box-sizing: border-box;
    overflow: hidden;
  }
  #sangpinlable .body .shangping_table{
    width: 100%;
    margin-top: 10px;
    padding: 10px;
    background: #FFFFFF;
    border-radius: 6px;
  }
  #sangpinlable #addcll_dialog .el-dialog{
    border-radius: 8px;
  }
  #sangpinlable #addcll_dialog .el-dialog__body{
    padding: 10px 20px;
  }

</style>
