<template>
  <div id="inventory">

    <div  class="font">库存控制</div>
    <div class="body">
      <div class="shangping_jiansuo">

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
          <el-button @click="shezhi=true">批量设置</el-button>
      </div>
      <div class="shangping_jiansuo">
       <el-table
           ref="multipleTable"
           :data="inventorylist"
           tooltip-effect="dark"
           style="width: 100%"
           @selection-change="handleSelectionChange">
           <el-table-column
                 type="selection"
                 width="55">
               </el-table-column>
          <el-table-column prop="product.lname" label="单品名称">

          </el-table-column>
          <el-table-column prop="product.lguige" label="单品规格"></el-table-column>
          <el-table-column prop="product.ldanwei" label="单位"></el-table-column>
          <el-table-column prop="inentity" label="实物库存"></el-table-column>
          <el-table-column prop="maxcount" label="可超卖数量">

          </el-table-column>
        </el-table>


        <div class="block">
          <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="current"
                         :page-sizes="[ 5,8,13]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
          </el-pagination>
        </div>
        </div>
        <el-dialog title="批量设置" :visible.sync="shezhi">
              <el-input-number
                style="width:150px"
                v-model.number="maxcount"
                :min="1"
                :placeholder="1+''"
              ></el-input-number>
              <div slot="footer" class="dialog-footer">
                <el-button @click="shezhi = false">取 消</el-button>
                <el-button type="primary" @click="maxpl">确 定</el-button>
              </div>
            </el-dialog>
      </div>
  </div>
</template>

<script>
  export default {
      data(){
        return {
            maxcount:0,
            shezhi:false,
            multipleSelection: [],
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
        toggleSelection(rows) {
                if (rows) {
                  rows.forEach(row => {
                    this.$refs.multipleTable.toggleRowSelection(row);
                  });
                } else {
                  this.$refs.multipleTable.clearSelection();
                }
              },
              handleSelectionChange(val) {
                this.multipleSelection = val;
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
          maxpl(){

            if(this.multipleSelection.length<1){
              alert("请选择单品");
            }else if(this.maxcount<0){
              alert("请输入正确的数量");
            }else {
                console.log(this.multipleSelection);
                this.$axios.put("inventory/updatemaxcount",{
                    maxcount:this.maxcount,
                    inventory:this.multipleSelection
                  })
                .then(r=>{
                  if(r.data>0){
                    alert("修改成功")
                    this.shezhi=false;
                    this.inventory();
                  }else{
                    alert("修改失败")
                  }
                })
            }

          }
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
