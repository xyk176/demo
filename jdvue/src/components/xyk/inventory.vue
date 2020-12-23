<template>
  <div id="inventory">

    <div  class="font">门店库存</div>
    <div class="body">
      <div class="shangping_jiansuo">
       <!-- <el-select style="margin-right: 15px;float: left;width: 120px;" v-model="value" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.value"
              :value="item.value">
            </el-option>
          </el-select> -->
        <el-input style="width: 240px;" v-model="nameandtiao" placeholder="请输入内容"  class="input-with-select float">
          <el-button @click="sousuo" class="float" slot="append" icon="el-icon-search">搜索</el-button>
        </el-input>
        <el-select class="float"style="margin-right: 15px;width: 120px;" v-model="value" placeholder="单品分类">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.value"
              :value="item.value">
            </el-option>
          </el-select>
      </div>
      <div class="shangping_jiansuo">
       <el-table
          :data="inventorylist"
          style="width: 100%;">
          <el-table-column prop="product.lname" label="单品名称">

          </el-table-column>
          <el-table-column prop="product.lguige" label="单品规格"></el-table-column>
          <el-table-column prop="product.ldanwei" label="单位"></el-table-column>
          <el-table-column prop="inentity" label="实物库存"></el-table-column>
          <el-table-column prop="inoccupy" label="占用库存"></el-table-column>
          <el-table-column prop="inusable" label="可用库存"></el-table-column>
          <el-table-column prop="product.lchengben" label="成本"></el-table-column>
          <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button @click="outandin(scope.row.product.lname)">查看出入库明细</el-button>
              </template>
          </el-table-column>
        </el-table>


        <div class="block">
          <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="current"
                         :page-sizes="[ 5,8,13]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
          </el-pagination>
        </div>
        </div>
      </div>
  </div>
</template>

<script>
  export default {
      data(){
        return {
            nameandtiao:'',
            current: 1,
            pageSize: 5,
            total: 0,
            inventorylist:[],
            value:'单品名称',
            options: [{
                      value: '单品名称'
                    }, {
                      value: '单品条码'
                    }]
        }
      },
      methods:{
          outandin(lname){
            console.log(lname);
            this.$router.push({
                name:'outandinput',
                params: { lname:lname },
             })
          },
          inventory(){
            let param;
            if(this.value=='单品名称'){
                  param={
                        no: this.current,
                        size: this.pageSize,
                        lname:this.nameandtiao,
                        ltiaoma:'',
                  }
             }else if(this.value=='单品条码'){
                  param={
                        no: this.current,
                        size: this.pageSize,
                        lname:'',
                        ltiaoma:this.nameandtiao,
                  }
               }
               console.log(param)
                this.$axios.post("inventory/selectAndproductAll",param)
                .then(r=>{
                  if(r.status===200){
                    console.log(r.data.list)
                    this.inventorylist=r.data.list
                    this.total=r.data.total
                  }
              })
          },
          sousuo(){
            let param;
            if(this.value=='单品名称'){
                  param={
                        no: 1,
                        size: this.pageSize,
                        lname:this.nameandtiao,
                        ltiaoma:'',
                  }
             }else if(this.value=='单品条码'){
                  param={
                        no: 1,
                        size: this.pageSize,
                        lname:'',
                        ltiaoma:this.nameandtiao,
                  }
               }
               console.log(param)
                this.$axios.post("inventory/selectAndproductAll",param)
                .then(r=>{
                  if(r.status===200){
                    console.log(r.data.list)
                    this.inventorylist=r.data.list
                    this.total=r.data.total
                  }
              })
          },
          handleSizeChange(val) {
          this.pageSize = val;
          console.log(`每页 ${val} 条`);
          this.inventory();
          },
          handleCurrentChange(val) {
            this.current = val;
            console.log(`当前页: ${val}`);
            this.inventory();
          },
      },
      mounted(){
        this.inventory();
      }
  }
</script>

<style>

  #inventory .body{
    margin-left: 10px;
    margin-right: 10px;
    border-radius: 5px;
    padding: 10px;
    background: #F2F2F6;
  }
  #inventory .body .shangping_jiansuo{
    width: 100%;

    border-radius: 5px;
    padding: 10px;
    background: #FFFFFF;
    box-sizing: border-box;
    padding-bottom: 20px;
  }
  .float{
    float: right;
  }
  .font{
    padding: 20px;
    font-size: 16px;
    color: #595961;
    font-weight: bold;
  }
</style>
