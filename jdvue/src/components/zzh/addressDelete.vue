<template>
  <div>
    <el-table :data="address" style="width: 100%">
      <el-table-column prop="adid" label="ID"></el-table-column>
      <el-table-column prop="adprovince" label="省"></el-table-column>
      <el-table-column prop="adcity" label="市"></el-table-column>
      <el-table-column prop="adarea" label="县/区"></el-table-column>
      <el-table-column prop="addetailed" label="详细地址"></el-table-column>
      <el-table-column label="详细地址">
        <template slot-scope="ss">
          <span v-if="ss.row.adisdefault=='是'" style="color: #0074D9;font-weight: 700;">默认地址</span>
          <span v-if="ss.row.adisdefault=='否'">普通地址</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="300px">
        <template slot-scope="ss">
          <el-button size="mini" @click="updateAdisdelete1(ss.row)">恢复</el-button>
          <el-button size="mini" @click="deleteAddress(ss.row)">彻底删除</el-button>
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
      return{
         address:[],
         current:1,
         pageSize:2,
         total:0
      }
    },
    methods:{
      selectAddress(){
         let param = {
           cid:1,
           no:this.current,
           size:this.pageSize
         };
         this.$axios.post("address/selectByCidAll1",param)
           .then(r=>{
             if (r.data){
               this.address = r.data.obj.list;
               this.total = r.data.obj.total;
               console.log(r);
             }
           })
      },
      handleCurrentChange(pagerindex){
        //参数是当前页码
        this.current = pagerindex;
        this.selectAddress();
      },
      /* pageSize 改变时会触发*/
      handleSizeChange(pagesize){
        this.pageSize=pagesize;
        this.selectAddress();
      },
      /**
       * 恢复地址
       */
      updateAdisdelete1(row){
        let param = {
          adid:row.adid
        };
        this.$axios.post("address/updateAdisdelete1",param)
        .then(r=>{
          if(r.data){
            this.address = r.data.objs;
            console.log(r);
            this.selectAddress();
          }
        })
      },
      /**
       * 删除收货地址（物理删除）
       */
      deleteAddress(row){
        let param = {
          adid:row.adid
        };
        this.$axios.post("address/deleteAddress",param)
        .then(r=>{
          if(r.data){
            this.address = r.data.objs;
            console.log(r);
            this.selectAddress();
          }
        })
      }
    },
    created(){
      this.selectAddress();
    }
  }
</script>

<style>
</style>
