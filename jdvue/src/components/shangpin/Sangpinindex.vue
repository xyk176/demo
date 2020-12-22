<template>
  <div id="sangpinindex">
    <div class="title">
      商品库列表
    </div>
    <div class="body">
      <div class="shangping_jiansuo" >
        <el-row>
          <el-col :span="3" style="padding-right: 1px;">
            <el-select v-model="jiansuo.ptjiansuo.tiaojian" placeholder="请选择" size="small">
              <el-option label="商品名称" value="comname"></el-option>
              <el-option label="商品条码" value="combarcode"></el-option>
              <el-option label="商品编号" value="comid"></el-option>
            </el-select>
          </el-col>
          <el-col :span="5">
            <el-input placeholder="请输入内容" size="small" v-model="jiansuo.ptjiansuo.canshu" class="input-with-select">
              <el-button slot="append" icon="el-icon-search" @click="pt_jiansuo()"></el-button>
            </el-input>
          </el-col>
        </el-row>
        <el-divider></el-divider>
        <el-row>
          <el-col :span="2" style="text-align: center;color: #595961;line-height: 32px;text-align: left;padding-left: 10px;">
            快捷操作
          </el-col>
          <el-col :span="10">
            <router-link to="/Sangpinadd">
              <el-button size="small">新增商品</el-button>
            </router-link>
            <el-button size="small">批量可售</el-button>
            <el-button size="small">批量禁售</el-button>
          </el-col>
        </el-row>
      </div>
      <div class="shangping_table" >
        <el-table  ref="multipleTable" :data="comlist" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="55"></el-table-column>
          <el-table-column label="商品名称">
            <template slot-scope="scope">
              <div class="shangping_table_name">
                <el-row>
                  <div style="float: left;height: 36px;width: 36px;overflow: hidden;border-radius: 6px;"><img :src="scope.row.pics[0].pic.picpath"  width="36px"/></div>
                  <div style="float: left;height: 36px;line-height: 36px;margin-left: 15px;">{{scope.row.comname}}</div>
                </el-row>
              </div>
            </template>
          </el-table-column>
          <el-table-column label="商品条码" prop="combarcode" width="150"  align="center"></el-table-column>
          <el-table-column label="价格" width="90">
            <template slot-scope="scope">
              ￥{{scope.row.comsameprice}}
            </template>
          </el-table-column>
          <el-table-column label="销量" prop="comsalesvolume" width="80"  align="center"></el-table-column>
          <el-table-column label="创建时间" width="150" align="center">
            <template slot-scope="scope">
              {{scope.row.comdata|dateYMDHMSFormat3}}
            </template>
          </el-table-column>
          <el-table-column label="可售状态" width="120" align="center">
            <template slot-scope="scope">
              <el-switch v-model="scope.row.comsalesstatus" active-color="#ff4949" inactive-color="#13ce66" active-value="1" inactive-value="0"></el-switch>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="120" align="center">
            <template slot-scope="scope">
              <el-button type="text" size="small">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
        @size-change="pageChange"
        @current-change="pageChange"
        :current-page="page.current"
        :page-size="page.size"
        :total="page.total"
        layout="total, prev, pager, next, jumper"
        style="text-align: center;margin-top: 10px;" >
        </el-pagination>
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
          tiaojian:'comname',
          canshu:''
        }
       },
       page:{
         current:0,
         total:0,
         size:5
       },
       comlist:[],
       multipleSelection: []
     }
   },
   methods:{
    selectall(){
      let pream={
        tiaojian:this.jiansuo.ptjiansuo.tiaojian,
        canshu:this.jiansuo.ptjiansuo.canshu,
        current:this.page.current,
        size:this.page.size
      }
      this.$axios.post('commoditycomtroller/selectall_pttiaojian',pream)
      .then(r=>{
          this.comlist=r.data.list;
          this.page.total=r.data.total;
          this.page.current = r.data.pageNum;
      }).catch(function(e){
          console.log("报错了，错误信息：",e);
      });
    },
    pageChange(v){
      this.page.current=v;
      this.selectall();
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    pt_jiansuo(){
      this.page.current=0;
      this.selectall();
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
    border-radius: 6px;
    padding: 10px;
    background: #FFFFFF;
    box-sizing: border-box;
    padding-top: 20px;
    padding-bottom: 20px;
  }
  #sangpinindex .body .shangping_table{
    margin-top: 10px;
    padding: 10px;
    background: #FFFFFF;
    border-radius: 6px;
  }
</style>
