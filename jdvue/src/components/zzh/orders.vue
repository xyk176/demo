<template>
  <div>
    <!-- <el-button type="primary" @click="clearInsert">新增</el-button> -->
    <span style="font-weight: 600;">订单列表</span>
    <div class="div1">

    </div><br/>
    <el-table :data="orders" style="width: 100%">
      <el-table-column prop="oId" label="ID"></el-table-column>
      <el-table-column prop="oDate" label="下单时间"></el-table-column>
      <el-table-column prop="customer.cname" label="下单用户"></el-table-column>
      <el-table-column prop="pay" label="支付方式"></el-table-column>
      <el-table-column prop="price" label="金额"></el-table-column>
      <el-table-column prop="ortype" label="订单状态"></el-table-column>
      <el-table-column label="操作" width="300px">
        <template slot-scope="ss">
          <el-button size="mini" @click="updateAdisdelete(ss.row)">删除</el-button>
          <el-button size="mini" @click="update(ss.$index,ss.row)">编辑</el-button>
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
         total:0
      }
    },
    methods:{
      selectOrders(){
        let param = {
          cid:1,
          ortype:this.ortype,
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
      }
    },
    created(){
      this.selectOrders();
    }
  }
</script>

<style>
  .div1{
    border: 1px solid #EAEAEA;
    width: 100%;
    height: 50px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  }
</style>
