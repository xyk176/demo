<template>
  <div id="shangpinnavigation">
    <h2 style="font-size: 5px;margin-left: 20px;margin-top: 10px">订单列表</h2>
    <div class="head" id="he">
      <div class="small">
        &nbsp;&nbsp;&nbsp;
        <span>配送方式：</span>
        <el-select v-model="value" placeholder="请选择" size="mini" style="width: 100px;margin-top: 10px">
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
            v-for="item in optionss"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        &nbsp;&nbsp;&nbsp;
        <span>订单状态：</span>
        <el-select v-model="value3" placeholder="请选择" size="mini" style="width: 100px">
          <el-option
            v-for="item in optionsss"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        &nbsp;&nbsp;&nbsp;
        <!--          <span>商品名称：</span>
                  <el-select v-model="value4" placeholder="请选择" size="mini" style="width: 100px">
                    <el-option
                      v-for="item in options"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>-->
        <el-button icon="el-icon-search" circle size="mini" @click="loadata"></el-button>
      </div>
      <div style="margin-top: 15px;width: 99%;margin-left: 7px">
        <el-table
          :data="tableData"
          stripe
          style="width: 100%">
          <el-table-column
            prop="oDate"
            label="下单时间"
            width="180">
          </el-table-column>
          <el-table-column
            prop="customer.cname"
            label="下单用户">
          </el-table-column>
          <el-table-column
            prop="address.adarea"
            label="收货地址">
          </el-table-column>
          <el-table-column
            prop="pay"
            label="支付方式">
          </el-table-column>
          <el-table-column
            prop="price"
            label="支付金额">
          </el-table-column>
          <el-table-column
            prop="orsip"
            label="发货方式">
          </el-table-column>
          <el-table-column
            prop="remarks"
            label="订单备注">
          </el-table-column>
          <el-table-column
            prop="ortype"
            label="订单状态">
          </el-table-column>
          <el-table-column
            label="操作">
            <template slot-scope="scope">
              <el-button icon="el-icon-search" circle size="mini" @click="xq(scope.row)"></el-button>
              <el-button icon="el-icon-edit" circle size="mini" @click="xg(scope.row)"></el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div class="block">
        <el-pagination
          @current-change="handleCurrentChange"
          @size-change="handleSizeChange"
          :current-page="page"
          :page-size="size"
          :page-sizes="[1,2,3,4]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="totals"
        >
        </el-pagination>
      </div>
    </div>

    <el-dialog title="详情" :visible.sync="infos">
      <!--      <el-table
            :data="info"
            stripe
            style="width: 100%">
              <el-table-column
                prop="com.comname"
                label="商品">
              </el-table-column>
              <el-table-column
                prop="coms"
                label="购买数量">
              </el-table-column>
              <el-table-column
                prop="comprice"
                label="购买总价">
              </el-table-column>
            </el-table>-->
      <div style="width: 95%;">
        <span>商品</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span>购买数量</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span>购买总价</span>
      </div>
      <div style="width: 95%;" v-for="i in info">
        <div style="width: 35%;float: left">{{ i.com.comname }}</div>
        <div style="width: 20%;margin-left: 35px;float: left">{{ i.coms }}</div>
        <div style="width: 20%;margin-left: 65px;float: left">{{ i.comprice }}</div>
      </div>
    </el-dialog>

    <el-dialog title="更改发货" :visible.sync="xx">
      <el-form :model="gg">
        <el-form-item label="发货方式">
          <el-select v-model="gg.orsip" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "Allorders",
  data() {
    return {
      gg:{},
      xx:false,
      infos: false,
      totals: 0,
      page: 1,
      size: 3,
      tableData: [],
      value1: '',
      options: [{
        value: '不限',
        label: '不限'
      }, {
        value: '顺丰',
        label: '顺丰'
      }, {
        value: '韵达',
        label: '韵达'
      }, {
        value: '天天',
        label: '天天'
      }, {
        value: '申通',
        label: '申通'
      }, {
        value: '中通',
        label: '中通'
      }],
      optionss: [{
        value: '微信',
        label: '微信'
      }, {
        value: '支付宝',
        label: '支付宝'
      }],
      optionsss: [{
        value: '未付款',
        label: '未付款'
      }, {
        value: '已完成',
        label: '已完成'
      }],
      value: '',
      value2: '',
      value3: '',
      value4: '',
      info: {},
      oiid:[]
    }
  },
  methods: {
    loadata() {
      this.$axios.post("order/all", {
        pageno: this.page,
        size: this.size,
        ortype: this.value3,
        orsip: this.value,
        pay: this.value2
      }).then((res) => {
        this.tableData = res.data.list;
        for (const a of this.tableData) {
          a.oDate = this.$Dateformat(a.oDate, "yyyy-mm-dd HH:MM:ss")
        }
        this.totals = res.data.total;
        this.value = '';
        this.value2 = '';
        this.value3 = '';
        console.log("jakk", this.tableData)
      })
    },
    handleCurrentChange(val) {
      this.page = val;
      this.$axios.post("order/all", {
        pageno: this.page,
        size: this.size,
        ortype: this.value3,
        orsip: this.value,
        pay: this.value2
      })
        .then((res) => {
          this.size = res.data.pageSize;
          this.tableData = res.data.list;
          for (const a of this.tableData) {
            a.oDate = this.$Dateformat(a.oDate, "yyyy-mm-dd HH:MM:ss");
          }
          this.totals = res.data.total;
          console.log(this.tableData);
        })
    }, handleSizeChange(val) {
      this.size = val;
      this.$axios.post("order/all", {
        pageno: this.page,
        size: this.size,
        ortype: this.value3,
        orsip: this.value,
        pay: this.value2
      })
        .then((res) => {
          this.size = res.data.pageSize;
          this.tableData = res.data.list;
          for (const a of this.tableData) {
            a.oDate = this.$Dateformat(a.oDate, "yyyy-mm-dd HH:MM:ss");
          }
          this.totals = res.data.total;
          console.log(this.tableData);
        })
      console.log(`每页 ${val} 条`);
    },
    xq(r) {
      this.info = r.orderinfos
      console.log("当前行", this.info)
      this.infos = true;
      this.$axios.put("order/selectcompic", this.info).then((res)=>{
        console.log(res.data);
      })
      console.log(this.oiid);
    },
    xg(r){
      this.gg=r;
      console.log(r);
      this.xx=true;
    }
  },
  created() {
    this.loadata()
  }
}
</script>

<style>
#shangpinnavigation .head {
  margin-left: 5px;
  margin-top: 10px;
  width: 99%;
  height: 450px;
  background: #F2F2F6;
  border-radius: 6px;
  border: 1px solid #E2E2E2;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .12), 0 0 6px 0 rgba(0, 0, 0, .04);
}

#he .small {
  margin-top: 5px;
  margin-left: 5px;
  width: 99%;
  height: 50px;
  background: #FFFFFF;
  border-radius: 6px;
  border: 1px solid #E2E2E2;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .12), 0 0 6px 0 rgba(0, 0, 0, .04);
}

</style>
