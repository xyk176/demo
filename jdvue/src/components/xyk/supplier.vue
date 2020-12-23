<template>
  <div id="inventory">

    <div  class="font">供应商</div>
    <div class="body">
      <div class="shangping_jiansuo">
        <router-link to="suppliernew">
          <el-button style="float: left;">添加供应商</el-button>
        </router-link>
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
      <div class="shangping_jiansuo">
       <el-table
          :data="inventorylist"
          style="width: 100%;">
          <el-table-column prop="suid" label="编号"></el-table-column>
          <el-table-column prop="suname" label="供应商名称"></el-table-column>
          <el-table-column prop="suphone" label="单位电话"></el-table-column>
          <el-table-column prop="sulxr" label="联系人"></el-table-column>
          <el-table-column prop="sulxrphone" label="联系电话"></el-table-column>
          <el-table-column label="操作">
            <el-button >删除</el-button>
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
            nameandtiao:'',
            current: 1,
            pageSize: 5,
            total: 0,
            inventorylist:[],
            value:'供应商名称',
            options: [{
                      value: '供应商名称'
                    }, {
                      value: '联系人'
                    },{
                      value: '联系电话'
                    }, {
                      value: '编号'
                    }]
        }
      },
      methods:{
          inventory(){
            let param;
            if(this.value=='供应商名称'){
                  param={
                        no: this.current,
                        size: this.pageSize,
                        suname:this.nameandtiao,
                        sulxr:'',
                        sulxrphone:'',
                        suid:'',
                  }
             }else if(this.value=='联系人'){
                  param={
                        no: this.current,
                        size: this.pageSize,
                        suname:'',
                        sulxr:this.nameandtiao,
                        sulxrphone:'',
                        suid:'',
                  }
             }else if(this.value=='联系电话'){
                param={
                        no: this.current,
                        size: this.pageSize,
                        suname:'',
                        sulxr:'',
                        sulxrphone:this.nameandtiao,
                        suid:'',
                }
             }else if(this.value=='编号'){
                param={
                        no: this.current,
                        size: this.pageSize,
                        suname:'',
                        sulxr:'',
                        sulxrphone:'',
                        suid:this.nameandtiao,
                }
             }
               console.log(param)
                this.$axios.post("supplier/selectAll",param)
                .then(r=>{
                  if(r.status===200){
                    console.log(r.data.list)
                    this.inventorylist=r.data.list
                    this.total=r.data.total
                  }
              })
          },
          sousuo(){
            let param;
            if(this.value=='供应商名称'){
                  param={
                        no: this.current,
                        size: this.pageSize,
                        suname:this.nameandtiao,
                        sulxr:'',
                        sulxrphone:'',
                        suid:'',
                  }
             }else if(this.value=='联系人'){
                  param={
                        no: this.current,
                        size: this.pageSize,
                        suname:'',
                        sulxr:this.nameandtiao,
                        sulxrphone:'',
                        suid:'',
                  }
             }else if(this.value=='联系电话'){
                param={
                        no: this.current,
                        size: this.pageSize,
                        suname:'',
                        sulxr:'',
                        sulxrphone:this.nameandtiao,
                        suid:'',
                }
             }else if(this.value=='编号'){
                param={
                        no: this.current,
                        size: this.pageSize,
                        suname:'',
                        sulxr:'',
                        sulxrphone:'',
                        suid:this.nameandtiao,
                }
             }
               console.log(param)
                this.$axios.post("supplier/selectAll",param)
                .then(r=>{
                  if(r.status===200){
                    console.log(r.data.list)
                    this.inventorylist=r.data.list
                    this.total=r.data.total
                  }
              })
          },
          handleSizeChange(val) {
          this.pageSize = val;
          console.log(`每页 ${val} 条`);
          this.inventory();
          },
          handleCurrentChange(val) {
            this.current = val;
            console.log(`当前页: ${val}`);
            this.inventory();
          },
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
