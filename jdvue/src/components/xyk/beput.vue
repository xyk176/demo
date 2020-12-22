<template>
  <div id="beput">
      <div  class="font">入库单</div>
      <div class="body">
        <div class="shangping_jiansuo">
           <span style="float: left;height: 40;line-height: 40px;margin-right: 5px;">入库时间</span>
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
          <el-select style="margin-right: 15px;width: 120px;float: left;" clearable  v-model="beclass" @change="sousuo" placeholder="出入库类型">
              <el-option
                v-for="item in outclass"
                :key="item.value"
                :label="item.value"
                :value="item.value"
                >
              </el-option>
          </el-select>

          <el-select style="margin-right: 15px;width: 120px;float: left;" clearable  v-model="suname" @change="sousuo" placeholder="供应商名称">
              <el-option
                v-for="item in supplier"
                :key="item.value"
                :label="item.value"
                :value="item.value"
                >
              </el-option>
          </el-select>
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
        <div class="beput_button">

          <el-button style="float: left;">采购入库</el-button>
          <el-button style="float: left;">其他入库</el-button>
        </div>
        <div class="shangping_jiansuo">
         <el-table
            :data="beputlist"
            style="width: 100%;">
            <el-table-column prop="beid" label="入库单号"></el-table-column>
            <el-table-column prop="beclass" label="入库类型"></el-table-column>
            <el-table-column prop="bedate" label="入库时间"></el-table-column>
            <el-table-column prop="beremark" label="备注"></el-table-column>
            <el-table-column prop="yewuid" label="关联业务号">
            </el-table-column>
            <el-table-column  label="操作">
              <el-button>详情</el-button>
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
            beclass:'',
            suname:'',
            current: 1,
            pageSize: 5,
            total: 0,
            beputlist:[],
            value:'入库单号',
            options: [{
                      value: '入库单号'
                    }, {
                      value: '关联业务单号'
                    }],
            outclass: [{
                      value: '入库'
                    }, {
                      value: '采购入库'
                    }, {
                      value: '盘盈入库'
                    }, {
                      value: '其他入库'
                    }],
            supplier: [],
        }
      },
      methods:{
          beput(){
            let param;
            if(this.value=='入库单号'){
                  param={
                        no: this.current,
                        size: this.pageSize,
                        beclass:this.beclass,
                        beid:this.nameandtiao,
                        yewuid:'',
                        suname:this.suname,
                        date1:this.value2[0],
                        date2:this.value2[1]

                  }
             }else if(this.value=='关联业务单号'){
                param={
                      no: this.current,
                      size: this.pageSize,
                      beclass:this.beclass,
                      beid:'',
                      yewuid:this.nameandtiao,
                      suname:this.suname,
                      date1:this.value2[0],
                      date2:this.value2[1]

                }
             }
               console.log(param)
                this.$axios.post("beput/selectAll",param)
                .then(r=>{
                  if(r.status===200){
                    console.log(r.data.list)
                    this.beputlist=r.data.list
                    this.total=r.data.total
                  }
              })
          },
          sousuo(){
            if(this.value2){
              let param;
              if(this.value=='入库单号'){
                    param={
                          no: 1,
                          size: this.pageSize,
                          beclass:this.beclass,
                          beid:this.nameandtiao,
                          yewuid:'',
                          suname:this.suname,
                          date1:this.value2[0],
                          date2:this.value2[1]

                    }
               }else if(this.value=='关联业务单号'){
                  param={
                        no: 1,
                        size: this.pageSize,
                        beclass:this.beclass,
                        beid:'',
                        yewuid:this.nameandtiao,
                        suname:this.suname,
                        date1:this.value2[0],
                        date2:this.value2[1]

                  }
               }
                 console.log(param)
                  this.$axios.post("beput/selectAll",param)
                  .then(r=>{
                    if(r.status===200){
                      console.log(r.data.list)
                      this.beputlist=r.data.list
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
          this.beput();
          },
          handleCurrentChange(val) {
            this.current = val;
            console.log(`当前页: ${val}`);
            this.beput();
          },
      },
      mounted(){
        this.beput();
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
