<template>
  <div id="inventory">
    <div  class="font">入库单-{{bename}}详情</div>
    <div class="body">
      <div class="shangping_jiansuo">
        <div style="font-size:18px ;">基本信息</div>
      <el-form >
        <el-row :span="24" style="margin-bottom: 10px;" v-if="suname!=''">
          <el-col :span="12"   style="text-align: center;">
              <el-form-item label="订单:" label-width="30%">
                <el-input style="width: 240px;" v-model="suname" :disabled="true"/>
              </el-form-item>
          </el-col>
        </el-row>

        <el-row :span="24">
          <el-col :span="12"   style="text-align: center;">
              <el-form-item label="出库时间:" label-width="30%">
                <el-input style="width: 240px;" v-model="bedate" :disabled="true"/>
              </el-form-item>
          </el-col>
        </el-row>
        <el-row :span="24">
          <el-col :span="12"   style="text-align: center;">
              <el-form-item label="备注:" label-width="30%">
                <el-input style="width: 240px;" type="textarea" v-model="beremark" :disabled="true"/>
              </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      </div>
      <div class="shangping_jiansuo">
       <el-table
          :data="beputxqlist"
          style="width: 100%;">
          <el-table-column prop="sproduct.lname" label="单品名称">

          </el-table-column>
          <el-table-column prop="sproduct.lguige" label="单品规格"></el-table-column>
          <el-table-column prop="sproduct.ldanwei" label="单位"></el-table-column>
          <el-table-column prop="outxqcount" label="出库数量"></el-table-column>
        </el-table>


        </div>
      </div>
  </div>
</template>

<script>
  export default {
      data(){
        return {
            suname:'',
            bedate:'',
            beremark:'',
            beid:this.$route.params.id,
            bename:this.$route.params.clas,
            // current: 1,
            // pageSize: 5,
            // total: 0,
            beputxqlist:[],
        }
      },
      methods:{
          inventory(){
            let param={
                        // no: this.current,
                        // size: this.pageSize,
                        outid:this.$route.params.id
                  }
               console.log(param)
                this.$axios.post("output/selectoutxq",param)
                .then(r=>{
                  if(r.status===200){
                    console.log('date',r.data)
                    this.beputxqlist=r.data[0].outputxqs;
                    if(r.data[0].orderss!=null){
                      this.suname=r.data[0].orderss.pay;
                    }
                    this.bedate=r.data[0].outdate;
                    this.beremark=r.data[0].outremark;
                  }
              })
          },
          // sousuo(){
          //   let param;
          //   if(this.value=='单品名称'){
          //         param={
          //               no: 1,
          //               size: this.pageSize,
          //               lname:this.nameandtiao,
          //               ltiaoma:'',
          //         }
          //    }else if(this.value=='单品条码'){
          //         param={
          //               no: 1,
          //               size: this.pageSize,
          //               lname:'',
          //               ltiaoma:this.nameandtiao,
          //         }
          //      }
          //      console.log(param)
          //       this.$axios.post("inventory/selectAndproductAll",param)
          //       .then(r=>{
          //         if(r.status===200){
          //           console.log(r.data.list)
          //           this.beputxqlist=r.data.list
          //           this.total=r.data.total
          //         }
          //     })
          // },
          // handleSizeChange(val) {
          // this.pageSize = val;
          // console.log(`每页 ${val} 条`);
          // this.inventory();
          // },
          // handleCurrentChange(val) {
          //   this.current = val;
          //   console.log(`当前页: ${val}`);
          //   this.inventory();
          // },
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
