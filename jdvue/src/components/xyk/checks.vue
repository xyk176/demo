<template>
  <div id="beput">
      <div  class="font">库存盘点</div>
      <div class="body">
        <div class="shangping_jiansuo">
           <span style="float: left;height: 40;line-height: 40px;margin-right: 5px;">单据时间</span>
          <el-date-picker
            style="margin-right: 15px;width: 240px;float: left;"
            v-model="value2"
            type="datetimerange"
            :picker-options="pickerOptions"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            @change="sousuo">
          </el-date-picker>
          <el-input style="width: 240px;" v-model="nameandtiao" placeholder="请输入内容"  class="input-with-select float">
            <el-button @click="sousuo" class="float" slot="append" icon="el-icon-search">搜索</el-button>
          </el-input>
          <el-select class="float"style="margin-right: 15px;width: 120px;" v-model="value" placeholder="单据编号">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.value"
                :value="item.value">
              </el-option>
            </el-select>
        </div>
        <div class="beput_button">
        <router-link to="checksnew">
            <el-button style="float: left;">新建盘点</el-button>
        </router-link>
        </div>
        <div class="shangping_jiansuo">
         <el-table
            :data="checkslist"
            style="width: 100%;">
            <el-table-column prop="cheid" label="单据编号"></el-table-column>
            <el-table-column prop="chedate" label="单据时间"></el-table-column>
            <el-table-column  label="盘点状态">
              <template slot-scope="scope">
                <span v-if="scope.row.chestate==1" >完成</span>
                <span v-else-if="scope.row.chestate==0" >进行中</span>
              </template>
            </el-table-column>
            <el-table-column prop="chebecount" label="盘盈数量"></el-table-column>
            <el-table-column prop="chelosecoubt" label="盘亏数量"></el-table-column>
            <el-table-column prop="cheremark" label="备注"></el-table-column>
            <el-table-column  label="操作">
              <template slot-scope="scope">
                <el-button @click="checkxq(scope.row.cheid)">详情</el-button>
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
         pickerOptions: {
          shortcuts: [{
            text: '最近一周',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近一个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近三个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit('pick', [start, end]);
            }
          }]
      },
      value2: [new Date(2020, 11, 15, 10, 10), new Date(2020, 11, 29, 10, 10)],
            nameandtiao:'',
            current: 1,
            pageSize: 5,
            total: 0,
            checkslist:[],
            value:'单据编号',
            options: [{
                      value: '单据编号'
                    }, {
                      value: '单品名称'
                    }, {
                      value: '单品条码'
                    }],
        }
      },
      methods:{
        checkxq(id){
          console.log(id);
          this.$router.push({
                  name:'checksxq',
                  params: {
                      id:id,
                },
           })
        },
          checks(){
            let param;
            if(this.value=='单据编号'){
                  param={
                      no: this.current,
                      size: this.pageSize,
                      cheid:this.nameandtiao,
                      lname:'',
                      ltiaoma:'',
                      date1:this.value2[0],
                      date2:this.value2[1]
                  }
             }else if(this.value=='单品名称'){
                param={
                      no: this.current,
                      size: this.pageSize,
                      cheid:'',
                      lname:this.nameandtiao,
                      ltiaoma:'',
                      date1:this.value2[0],
                      date2:this.value2[1]

                }
             }else if(this.value=='单品条码'){
                param={
                      no: this.current,
                      size: this.pageSize,
                      cheid:'',
                      lname:'',
                      ltiaoma:this.nameandtiao,
                      date1:this.value2[0],
                      date2:this.value2[1]

                }
             }
               console.log('param',param)
                this.$axios.post("checks/selectAndproduct",param)
                .then(r=>{
                  if(r.status===200){
                    console.log(r.data.list)
                    this.checkslist=r.data.list
                    this.total=r.data.total
                  }
              })
          },
          sousuo(){
            if(this.value2){
              let param;
            if(this.value=='单据编号'){
                  param={
                      no: this.current,
                      size: this.pageSize,
                      cheid:this.nameandtiao,
                      lname:'',
                      ltiaoma:'',
                      date1:this.value2[0],
                      date2:this.value2[1]
                  }
             }else if(this.value=='单品名称'){
                param={
                      no: this.current,
                      size: this.pageSize,
                      cheid:'',
                      lname:this.nameandtiao,
                      ltiaoma:'',
                      date1:this.value2[0],
                      date2:this.value2[1]

                }
             }else if(this.value=='单品条码'){
                param={
                      no: this.current,
                      size: this.pageSize,
                      cheid:'',
                      lname:'',
                      ltiaoma:this.nameandtiao,
                      date1:this.value2[0],
                      date2:this.value2[1]

                }
             }
                 console.log('param',param)
                  this.$axios.post("checks/selectAndproduct",param)
                  .then(r=>{
                    if(r.status===200){
                      console.log(r.data.list)
                      this.checkslist=r.data.list
                      this.total=r.data.total
                    }
                })
            }else{
              alert("请选择时间范围");
            }
          },
          handleSizeChange(val) {
          this.pageSize = val;
          console.log(`每页 ${val} 条`);
          this.checks();
          },
          handleCurrentChange(val) {
            this.current = val;
            console.log(`当前页: ${val}`);
            this.checks();
          },
      },
      mounted(){
        this.checks();
      }
  }
</script>

<style>

  #beput .body{
    margin-left: 10px;
    margin-right: 10px;
    border-radius: 5px;
    padding: 10px;
    background: #F2F2F6;
  }
  #beput .body .beput_button{
      width: 100%;
      padding: 30px;
      background: #FFFFFF;
      box-sizing: border-box;
      padding-bottom: 20px;
  }
  #beput .body .shangping_jiansuo{
    width: 100%;
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
