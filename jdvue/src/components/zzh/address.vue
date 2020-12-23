<template>
  <div>
    <el-button type="primary" @click="xinzeng = true">新增</el-button>
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
          <el-button size="mini" @click="">删除</el-button>
          <el-button size="mini" @click="update(ss.$index,ss.row)">编辑</el-button>
          <el-button v-if="ss.row.adisdefault=='否'" size="mini" @click="updateAdisdefault(ss.row)">设为默认</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--新增收货地址-->
    <el-dialog title="新增收货地址" :visible.sync="xinzeng">
      <el-form label-position="right" label-width="80px" :model="form">
        <v-distpicker :province="form.adprovince"
                      :city="form.adcity"
                      :area="form.adarea"
                      @selected="onSelected">
        </v-distpicker><br>
        <el-form-item label="详细地址">
          <el-input v-model="form.addetailed" style="width: 600px;"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="xinzeng = false">取 消</el-button>
        <el-button type="primary" @click="insertAddress">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 修改收货地址-->
    <el-dialog title="修改收货地址" :visible.sync="xiugai">
      <el-form label-position="right" label-width="80px" :model="form">
        <v-distpicker :province="form.adprovince"
                      :city="form.adcity"
                      :area="form.adarea"
                      @selected="onSelected">
        </v-distpicker><br>
        <el-form-item label="详细地址">
          <el-input v-model="form.addetailed" style="width: 600px;"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="xiugai = false">取 消</el-button>
        <el-button type="primary" @click="updateAddress">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    data() {
      return {
       address:[],
       form:{},
       xiugai:false,
       xinzeng:false
      }
    },
    methods:{
      selectAddress(){
         let param = {
           cid:1
         };
         this.$axios.post("address/selectByCidAll",param)
           .then(r=>{
             if (r.data){
               this.address = r.data.objs;
               console.log(r);
             }
           })
      },
      /**
       * 新增收货地址
       */
      insertAddress(){
        let param = {
          cid:1,
          adprovince:this.form.adprovince,
          adcity:this.form.adcity,
          adarea:this.form.adarea,
          addetailed:this.form.addetailed
        };
        this.$axios.post("address/isnertAddress",param)
        .then(r=>{
          this.address = r.data.objs;
          console.log(r);
          this.xinzeng = false;
          this.selectAddress();
        })
      },
      update($index,row){
        this.xiugai = true;
        this.form = {...row};
      },
      /**
       * 修改收货地址
       */
      updateAddress(){
        let param = {
          adid:this.form.adid,
          adprovince:this.form.adprovince,
          adcity:this.form.adcity,
          adarea:this.form.adarea,
          addetailed:this.form.addetailed
        };
        // let ppp = this.$qs.stringify(param);
        this.$axios.post("address/updateAddress",param)
        .then(r=>{
          if(r.data){
            this.address = r.data.objs;
            console.log(r);
            this.xiugai = false;
            this.selectAddress();
          }
        })
      },
      onSelected(data) {
        this.form.adprovince = data.province.value
        this.form.adcity = data.city.value
        this.form.adarea = data.area.value
      },
      /**
       * 设置默认地址
       */
      updateAdisdefault(row){
        let param = {
          adid:row.adid,
          cid:1
        };
        let ppp = this.$qs.stringify(param);
        this.$axios.post("address/updateAdisdefault",param)
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
