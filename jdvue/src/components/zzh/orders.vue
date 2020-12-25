<template>
  <div>
    <span style="font-weight: 600;">订单列表</span><br/><br/>
    <div class="order_div1">
      配送方式:<el-select v-model="fangshi" placeholder="配送方式" clearable style="width: 200px;">
        <el-option v-for="item in options1" :key="item.value" :label="item.label" :value="item.label"></el-option>
      </el-select>
      订单状态:<el-select v-model="ortype" placeholder="订单状态" clearable style="width: 200px;">
        <el-option v-for="item in options2" :key="item.value" :label="item.label" :value="item.label"></el-option>
      </el-select>
      <el-button type="infor" icon="el-icon-search" @click="selectOrders"></el-button>
    </div><br/>
    <el-table :data="orders" style="width: 100%">
      <el-table-column prop="oId" label="ID"></el-table-column>
      <el-table-column prop="oDate" label="下单时间"></el-table-column>
      <el-table-column prop="customer.cname" label="下单用户"></el-table-column>
      <el-table-column prop="pay" label="支付方式"></el-table-column>
      <el-table-column prop="price" label="金额"></el-table-column>
      <el-table-column prop="orsip" label="配送方式"></el-table-column>
      <el-table-column prop="ortype" label="订单状态"></el-table-column>
      <el-table-column label="操作" width="300px">
        <template slot-scope="ss">
          <!-- <el-button size="mini" @click="updateAdisdelete(ss.row)">删除</el-button> -->
          <el-button size="mini" @click="orderxq(ss.$index,ss.row)">详情</el-button>
          <el-button v-if="ss.row.adisdefault=='否'" size="mini" @click="updateAdisdefault(ss.row)">设为默认</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- current-page	当前页数，支持 .sync 修饰符-->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="current"
      :page-sizes="[1, 2, 4, 8]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
  </div>
</template>

<script>
  export default {
    data() {
      return {
         orders:[],
         ortype:'',
         current:1,
         pageSize:2,
         total:0,
         fangshi:'',
         options1: [{
           value: '1',
           label: '不限'
         }, {
           value: '2',
           label: '顺丰'
         }, {
           value: '3',
           label: '韵达'
         }, {
           value: '4',
           label: '天天'
         }, {
           value: '5',
           label: '申通'
         }, {
           value: '6',
           label: '中通'
         }],
         options2: [{
           value: '1',
           label: '未发货'
         }, {
           value: '2',
           label: '已发货'
         },{
           value: '3',
           label: '已完成'
         }],
      }
    },
    methods:{
      selectOrders(){
        let param = {
          cid:sessionStorage.getItem('cid3'),
          ortype:this.ortype,
          orsip:this.fangshi,
          no:this.current,
          size:this.pageSize
        };
        this.$axios.post("address/selectOrders",param)
        .then(r=>{
          if(r.data){
            this.orders = r.data.obj.list;
            this.total = r.data.obj.total;
            console.log(r);
          }
        })
      },
      handleCurrentChange(pagerindex){
        //参数是当前页码
        this.current = pagerindex;
        this.selectOrders();
      },
      /* pageSize 改变时会触发*/
      handleSizeChange(pagesize){
        this.pageSize=pagesize;
        this.selectOrders();
      },
      /**
       * 查看订单详情
       */
      orderxq(index,row){
        this.$router.push({
          path:'/orderxq',
          query:{
            oId:row.oId
          }
        })
      }
    },
    created(){
      this.selectOrders();
    }
  }
</script>

<style scoped="scoped">
  .order_div1{
    border: 1px solid #EAEAEA;
    width: 100%;
    height: 50px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  }
</style>
