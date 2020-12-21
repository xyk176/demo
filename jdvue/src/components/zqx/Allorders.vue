<template>
  <div id="shangpinnavigation">
      <h2 style="font-size: 5px;margin-left: 20px;margin-top: 10px">订单列表</h2>
      <div class="head" id="he">
        <div class="small">
          &nbsp;&nbsp;&nbsp;
          <span>下单时间：</span>
          <el-date-picker
            size="mini"
            v-model="value1"
            type="datetime"
            placeholder="选择日期时间"
            style="margin-top: 10px;width: 175px"
          >
          </el-date-picker>
          &nbsp;&nbsp;&nbsp;
          <span>配送方式：</span>
          <el-select v-model="value" placeholder="请选择" size="mini" style="width: 100px">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          &nbsp;&nbsp;&nbsp;
          <span>支付方式：</span>
          <el-select v-model="value2" placeholder="请选择" size="mini" style="width: 100px">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          &nbsp;&nbsp;&nbsp;
          <span>订单状态：</span>
          <el-select v-model="value3" placeholder="请选择" size="mini" style="width: 100px">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          <el-button icon="el-icon-search" circle size="mini"></el-button>
        </div>
        <div style="margin-top: 15px;width: 99%;margin-left: 7px">
          <el-table
            :data="tableData"
            stripe
            style="width: 100%">
            <el-table-column
              prop="date"
              label="日期"
              width="180">
            </el-table-column>
            <el-table-column
              prop="name"
              label="姓名"
              width="180">
            </el-table-column>
            <el-table-column
              prop="address"
              label="地址">
            </el-table-column>
          </el-table>
        </div>
      </div>
  </div>
</template>

<script>
export default {
name: "Allorders",
  data(){
  return{
    tableData: [{
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    }, {
      date: '2016-05-04',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1517 弄'
    }, {
      date: '2016-05-01',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1519 弄'
    }, {
      date: '2016-05-03',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1516 弄'
    }],
    value1: '',
    options:[{
      value: '选项1',
      label: '黄金糕'
    }, {
      value: '选项2',
      label: '双皮奶'
    }, {
      value: '选项3',
      label: '蚵仔煎'
    }, {
      value: '选项4',
      label: '龙须面'
    }, {
      value: '选项5',
      label: '北京烤鸭'
    }],
    value: '',
    value2:'',
    value3:''
    }
  },
  methods:{

  },
  created() {
  }
}
</script>

<style>
#shangpinnavigation .head{
  margin-left: 5px;
  margin-top: 10px;
  width: 99%;
  height: 450px;
  background: #F2F2F6;
  border-radius: 6px;
  border: 1px solid #E2E2E2;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.12),0 0 6px 0 rgba(0,0,0,.04);
}
#he .small{
  margin-top: 5px;
  margin-left: 5px;
  width: 99%;
  height: 50px;
  background: #FFFFFF;
  border-radius: 6px;
  border: 1px solid #E2E2E2;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.12),0 0 6px 0 rgba(0,0,0,.04);
}

</style>
