<template>
  <div id="inventory">
    <div  class="font">库存盘点-新增盘点</div>
    <div class="body">
      <div class="shangping_jiansuo">
        <div style="font-size:18px ;">基本信息</div>
      <el-form >
        <el-row :span="24">
          <el-col :span="12"   style="text-align: center;">
              <el-form-item label="备注:" label-width="30%">
                <el-input  style="margin-right: 15px;float: left;width: 240px;"  type="textarea" v-model="beremark" />
              </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      </div>
      <div class="shangping_jiansuo">

        <el-input style="width: 240px;" v-model="lname" placeholder="请输入内容"  class="input-with-select float">
          <el-button @click="sousuo" class="float" slot="append" icon="el-icon-search">搜索</el-button>
        </el-input>
       <el-table
          :data="splist"
          style="width: 100%;">
          <el-table-column prop="lname" label="单品名称">

          </el-table-column>
          <el-table-column prop="lguige" label="单品规格"></el-table-column>
          <el-table-column prop="ldanwei" label="单位"></el-table-column>
          <el-table-column label="添加">
              <template slot-scope="scope">
                <el-button @click="pushshoplist(scope.$index,scope.row)" >添加</el-button>
              </template>
          </el-table-column>
        </el-table>
        <div class="block">
          <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="current"
                         :page-sizes="[ 3,4,5]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
          </el-pagination>
        </div>
       <el-table
          :data="beputxq"
          style="width: 100%;">
          <el-table-column prop="product.lname" label="单品名称">

          </el-table-column>
          <el-table-column prop="product.lguige" label="单品规格"></el-table-column>
          <el-table-column prop="product.ldanwei" label="单位"></el-table-column>
          <el-table-column prop="inentity" label="实物库存"></el-table-column>
          <el-table-column label="盘点数量">
              <template slot-scope="scope">
                <el-input-number
                  style="width:150px"
                  v-model.number="scope.row.chexqcount"
                  :min="0"
                  :placeholder="1+''"
                ></el-input-number>
              </template>
          </el-table-column>
          <el-table-column prop="cheblcount" label="盈亏数量">
                <template slot-scope="scope">
                  {{scope.row.cheblcount=scope.row.chexqcount-scope.row.inentity}}
                </template>
          </el-table-column>
          <el-table-column label="">
              <template slot-scope="scope">
                <el-button @click="deleteshop(scope.$index,scope.row)">移除</el-button>
              </template>
          </el-table-column>
        </el-table>
        <div style="margin-top: 20px;margin-left: auto;">
        <el-button type="primary" @click="beputnew">完成盘点</el-button>
        <router-link to="output">

          <el-button>取消</el-button>
        </router-link></div>
        </div>

      </div>
  </div>
</template>

<script>
  export default {
      data(){
        return {
            bedate:'',
            beremark:'',
            lname:'',
            current: 1,
            pageSize: 3,
            total: 0,
            splist:[],
            beputxq:[],
        }
      },
      methods:{
        beputnew(){
          console.log(this.beputxq)
          console.log(this.beremark)
          let ying=0;
          let kui=0;
          for(var i=0;i<this.beputxq.length;i++){
              if(this.beputxq[i].cheblcount>0){
                  ying+=this.beputxq[i].cheblcount;
              }else{
                  kui+=this.beputxq[i].cheblcount;
              }
          }
          console.log('盈',ying);
          console.log('亏',kui);
          let b={
             chebecount:ying,
             chelosecoubt:kui,
             cheremark:this.beremark,
             checkxqs:this.beputxq
          }
          console.log(b);
          this.$axios.put("checks/insert",b)
            .then(r=>{
              if(r.status===200){
                console.log('date',r.data)
                if(r.data>0){
                  alert("出库成功")
                }
              }
          })
        },
        deleteshop(index,row){
        this.beputxq.splice(index,1);
        },
        pushshoplist(index,row){
          console.log('单品',row);
          row.chexqcount=0;
          row.cheblcount=0;
          var json = {
            /* 单个的盘点的数量*/
            chexqcount:row.chexqcount,
            /* 盈亏数量，根据盘点数量减实物库存实时修改*/
            cheblcount:row.cheblcount,
            /* 实物库存*/
            inentity:row.inventorys[0].inentity,
            product:{

              inventorys:row.inventorys,
              lid:row.lid,
              lname:row.lname,
              lguige:row.lguige,
              ldanwei:row.ldanwei
            }
          }
          let t=true;
          if(this.beputxq.length==0){
            this.beputxq.push(json);
          }else{
            for(let j=0;j<1;j++){
              for(let i=0;i<this.beputxq.length;i++){
                    if(row.lid==this.beputxq[i].product.lid){
                      t=false;
                }
              }
            }
              if(t){
                this.beputxq.push(json);
              }else{
                alert("商品已添加")
              }
          }
          console.log(this.beputxq)
        },
          inventory(){
            let param={
                        no: this.current,
                        size: this.pageSize,
                        lname:this.lname
                  }
               console.log(param)
                this.$axios.post("product/page",param)
                .then(r=>{
                  if(r.status===200){
                    console.log('date',r.data)
                    this.splist=r.data.list;
                    this.total=r.data.total
                  }
              })
          },
          sousuo(){
            let param={
                        no: 1,
                        size: this.pageSize,
                        lname:this.lname
                  }
               console.log(param)
                this.$axios.post("product/page",param)
                .then(r=>{
                  if(r.status===200){
                    console.log(r.data.list)
                    this.splist=r.data.list;
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
