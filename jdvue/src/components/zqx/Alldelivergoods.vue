<template>
  <div id="shangpinnavigation">
    <div class="body">
      <h2 style="font-size: 5px;margin-left: 20px;margin-top: 10px">发货</h2>
      <div class="head">
        <div class="small">
          &nbsp;&nbsp;&nbsp;
          <span>配送方式：</span>
          <el-select v-model="value" placeholder="请选择" style="width: 150px;margin-top: 8px" size="mini">
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
          <el-button icon="el-icon-search" circle size="mini" @click="loadata"></el-button>
        </div>
        <div style="margin-top: 15px;width: 99%;margin-left: 7px">
          <el-table
            ref="multipleTable"
            :data="tableData"
            tooltip-effect="dark"
            style="width: 100%"
            @selection-change="handleSelectionChange">
            <el-table-column
              type="selection"
              width="55">
            </el-table-column>
            <el-table-column
              label="下单时间"
              width="160">
              <template slot-scope="scope">{{ scope.row.oDate }}</template>
            </el-table-column>
            <el-table-column
              prop="customer.cname"
              label="下单用户"
              width="120">
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
              label="订单状态"
              show-overflow-tooltip>
            </el-table-column>
            <el-table-column
              label="操作">
              <template slot-scope="scope">
                <el-button icon="el-icon-search" circle size="mini" @click="xq(scope.row)"></el-button>
                <el-button circle size="mini" @click="xg(scope.row)">发货</el-button>
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
      <el-dialog title="商品发货" :visible.sync="xx">
        <el-form :model="gg">
          <el-form-item label="下单时间">
            <span>{{gg.oDate}}</span>
          </el-form-item>
          <el-form-item label="下单用户">
            <span>{{gg.cname}}</span>
          </el-form-item>
          <el-form-item label="收货地址用户">
            <span>{{gg.adprovince}}&nbsp;&nbsp;&nbsp;&nbsp;{{gg.adcity}}&nbsp;&nbsp;&nbsp;&nbsp;{{gg.adarea}}&nbsp;&nbsp;&nbsp;&nbsp;{{gg.addetailed}}</span>
          </el-form-item>
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
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="ty">确 定</el-button>
        </div>
      </el-dialog>
    </div>

    <el-dialog title="详情" :visible.sync="infos">
      <el-table
        :data="info"
        stripe
        style="width: 100%">
        <el-table-column
          prop="comname"
          label="商品">
        </el-table-column>
        <el-table-column>
          <template slot-scope="scope">
            <img :src="scope.row.picpath" style="width: 50px;height: 50px">
          </template>
        </el-table-column>
        <el-table-column
          prop="cprname"
          label="商品参数">
        </el-table-column>
        <el-table-column
          prop="cpyname"
          label="商品属性">
        </el-table-column>
        <el-table-column
          prop="coms"
          label="购买数量">
        </el-table-column>
        <el-table-column
          prop="comprice"
          label="购买总价">
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "Alldelivergoods",
  data() {
    return {
      info: [],
      infos: false,
      totals: 0,
      page: 1,
      size: 3,
      tableData: [],
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
      value: '',
      value2:'',
      oId2:'',
      gg:{},
      xx:false
    }
  },
  methods: {
    handleSelectionChange(val) {
      this.multipleSelection = val;
      console.log(this.multipleSelection);
    },
    loadata() {
      this.$axios.post("order/wei", {
        pageno: this.page,
        size: this.size,
        orsip: this.value,
        pay: this.value2
      }).then((res) => {
        console.log(res)
        this.tableData = res.data.list;
        for (const a of this.tableData) {
          a.oDate = this.$moment(a.oDate).format("YYYY-MM-DD HH:mm:ss")
        }
        this.totals = res.data.total;
        this.value = '';
        this.value2 = '';
        console.log("jakk", this.tableData)
      })
    },
    handleCurrentChange(val) {
      this.page = val;
      this.$axios.post("order/wei", {
        pageno: this.page,
        size: this.size,
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
      this.$axios.post("order/wei", {
        pageno: this.page,
        size: this.size,
        orsip: this.value,
        pay: this.value2
      })
        .then((res) => {
          this.size = res.data.pageSize;
          this.tableData = res.data.list;
          for (const a of this.tableData) {
            a.oDate =this.$moment(a.oDate).format("YYYY-MM-DD HH:mm:ss")
          }
          this.totals = res.data.total;
          console.log(this.tableData);
        })
      console.log(`每页 ${val} 条`);
    },
    xg(r) {
      console.log(r.oId);
      this.xx = true;
      this.oid2=r.oId;
      this.$axios.post("order/seorder",{oId:this.oid2}).then((res)=>{
        console.log(res.data)
        this.gg=res.data;
        this.gg.oDate=this.$Dateformat(this.gg.oDate,"yyyy-mm-dd HH:MM:ss")
      })
    },
    xq(r) {
      this.oid=r.oId;
      console.log("当前行", this.oid)
      this.infos = true;
      this.$axios.post("order/selectcompic", {oId:this.oid}).then((res) => {
        console.log(res.data);
        this.info=res.data;
      })
    },
    ty(){
      console.log(this.gg)
      this.$axios.post("order/uporder",{
        oId:this.gg.oId,
        oDate:this.gg.oDate,
        pay:this.gg.pay,
        price:this.gg.price,
        orsip:this.gg.orsip,
        remarks:this.gg.remarks
      }).then((res)=>{
        this.loadata();
        this.xx=false;
      })
    }
  },
  created() {
    this.loadata();
  }
}
</script>

<style scoped>
#shangpinnavigation .body {
  width: 100%;
  height: 500px;
  background: #FFFFFF;
  border-radius: 6px;
  border: 1px solid #E2E2E2;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .12), 0 0 6px 0 rgba(0, 0, 0, .04);
  float: left;
}

.head {
  margin-left: 5px;
  margin-top: 10px;
  width: 99%;
  height: 91%;
  background: #F2F2F6;
  border-radius: 6px;
  border: 1px solid #E2E2E2;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .12), 0 0 6px 0 rgba(0, 0, 0, .04);
}

.right {
  width: 13%;
  height: 500px;
  background: #FFFFFF;
  border-radius: 6px;
  border: 1px solid #E2E2E2;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .12), 0 0 6px 0 rgba(0, 0, 0, .04);
  float: right;
}

.small {
  margin-top: 5px;
  margin-left: 5px;
  width: 99%;
  height: 10%;
  background: #FFFFFF;
  border-radius: 6px;
  border: 1px solid #E2E2E2;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .12), 0 0 6px 0 rgba(0, 0, 0, .04);
}

</style>
