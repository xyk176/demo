<template>
  <div id="shangpinnavigation">
    <div class="body">
      <h2 style="font-size: 5px;margin-left: 20px;margin-top: 10px">单品库列表</h2>
      <div class="head">
        <div class="small">
          &nbsp;&nbsp;&nbsp;
            <el-cascader
                :options="options"
                :props="defaultPropss"
                @change="changea"
                clearable
                style="width: 150px;margin-top: 8px"
                size="mini"></el-cascader>
            </el-option>
          <div style="margin-bottom: 10px;">
            <router-link to="danpinadd" tag="span">
              <el-button plain size="mini" style="margin-top: 18px;margin-left: 14px;">新增单品</el-button>
            </router-link>

            <el-button plain size="mini">导入单品</el-button>
            <el-button plain size="mini">导入修改</el-button>
            <el-button plain size="mini">导出单品</el-button>
            <el-button plain size="mini" @click="xiugai()">修改分类</el-button>
            <el-button plain size="mini" @click="delect()">删除</el-button>
          </div>
        </div>



        <div style="margin-top: 15px;width: 99%;margin-left: 7px">
          <el-table
            :data="tableData"
            stripe
            style="width: 100%"
            @selection-change="handleSelectionChange">
             <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column label="单品图片">
              <template slot-scope="scope">
                <img :src="scope.row.picpath"  width="36px"/>
              </template>
            </el-table-column>
            <el-table-column
              prop="lname"
              label="单品名称"
              width="180">
            </el-table-column>

            <el-table-column
              prop="ltiaoma"
              label="单品条码"
              width="180">
            </el-table-column>
            <el-table-column
              prop="lguige"
              label="单品规格"
              width="180">
            </el-table-column>
            <el-table-column
              prop="ldanwei"
              label="单品单位">
            </el-table-column>
            <el-table-column
              prop="cname"
              label="单品分类">
            </el-table-column>
            <el-table-column
              prop="cid2"
              label="单品分类">
            </el-table-column>
            <el-table-column
              prop="lchengben"
              label="单品成本">
            </el-table-column>
            <el-table-column label="操作" width="120" align="center">
              <template slot-scope="scope">
                <router-link to="danpinamend" tag="span">
                    <el-button type="text" size="small" @click="getbianji(scope.row)">编辑</el-button>
                </router-link>
              </template>
            </el-table-column>

          </el-table>
        </div>
        <!-- 分页-->
        <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="currentPage4"
              :page-sizes="[5, 10, 50, 100]"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
            </el-pagination>

        <!-- 修改分类的弹出框-->
        <el-dialog title="修改分类" :visible.sync="seen" style="height: 500px;">
              <el-cascader
                  :options="options"
                  :props="defaultPropss"
                  @change="changea"
                  clearable>
              </el-cascader>
              <p>
                <div style="height: 220px;"></div>
              <el-button plain @click="changea2()">确认选择</el-button>
              <router-link to="/liebiao" tag="span">
                <el-button plain>取消</el-button>
              </router-link>
              </p>
        </el-dialog>


      </div>
    </div>

  </div>
</template>

<script>
export default {
name: "Allorders",
  data(){
  return{
    tableData: [],
    currentPage4:1,
    pageSize:5,
    total:0,
    options: [],
    defaultPropss: {
      children: 'sorts',
      label: 'cname',
      value: 'cid2',
      checkStrictly: true
    },
    value: '',
    cfid:null,//分类主键
    dels:[],
    seen:false
    }
  },
  methods:{
    changea(e){
      this.cfid=e[e.length-1];
      console.log("分类id",this.cfid)
      let param={
        id:this.cfid,
        no:this.currentPage4,
        size:this.pageSize
      }
      this.$axios.post("/product/all",param)
      .then((res)=>{
        this.tableData=res.data.list;
        this.total = res.data.total;
        console.log("单品：",this.tableData)
      })
      .catch(function(e){
          console.log("报错了，错误信息：",e);
      });
    }
    ,load(){
      let param={
        id:this.cfid,
        no:this.currentPage4,
        size:this.pageSize
      }
      this.$axios.post("/product/all",param)
      .then((res)=>{
        this.tableData=res.data.list;
        this.total = res.data.total;
        console.log("单品：",this.tableData)
      })
      .catch(function(e){
          console.log("报错了，错误信息：",e);
      });
    }
    ,loadData(){
      this.$axios.post("/sort/all")
      .then((res)=>{
        this.options=res.data;
        console.log("所有分类",this.options)
      }).catch(function(e){
          console.log("报错了，错误信息：",e);
      });
    }

    ,handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageSize=val;
      this.load();
    }
    ,handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.currentPage4=val;
      this.load();
    }
    //修改
    ,getbianji(r){
      console.log(r);
      this.$router.push({path:'/danpinamend',query:{params:r}})
    }
    //选中表格的值
    ,handleSelectionChange(r){
      this.dels=r;
      console.log("选中的值",this.dels)
    }
    ,dele(r){
      this.$axios.post("/product/delete",r).then((res)=>{
        // alert("单品删除成功")
      })
      this.$axios.post("/product/delete2",r).then((res)=>{
        // alert("库存删除成功")
      })
    }
    ,delect(){
      this.dels.forEach(res=>{
        this.dele(res);
      })
      this.load();
    }

    ,xiugai2(r){
      this.$axios.post("/product/delectfenlei",r)
    }
    ,xiugai(){
      // this.dels.forEach(r=>{
      //   this.xiugai2(r)
      // })
      // this.load();
      this.seen=true
    }

  },

  created() {
    this.load();
    this.loadData();
    this.handleSelectionChange();
  }
}
</script>

<style scoped>
#shangpinnavigation .body{
  width: 100%;
  /* height: 600px; */
  background: #FFFFFF;
  border-radius: 6px;
  border: 1px solid #E2E2E2;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.12), 0 0 6px 0 rgba(0,0,0,.04);
  float: left;
}

.head{
  margin-left: 5px;
  margin-top: 10px;
  width: 99%;
  height: 91%;
  background: #F2F2F6;
  border-radius: 6px;
  border: 1px solid #E2E2E2;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.12),0 0 6px 0 rgba(0,0,0,.04);
}
.right{
  width: 13%;
  background: #FFFFFF;
  border-radius: 6px;
  border: 1px solid #E2E2E2;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.12),0 0 6px 0 rgba(0,0,0,.04);
  float: right;
}
.small{
  margin-top: 5px;
  margin-left: 5px;
  width: 99%;
  height: 22%;
  background: #FFFFFF;
  border-radius: 6px;
  border: 1px solid #E2E2E2;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.12),0 0 6px 0 rgba(0,0,0,.04);
}

</style>
