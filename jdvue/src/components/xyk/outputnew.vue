<template>
  <div id="inventory">
    <div  class="font">出库单-新建出库单</div>
    <div class="body">
      <div class="shangping_jiansuo">
        <div style="font-size:18px ;">基本信息</div>
      <el-form >
        <el-row :span="24" style="margin-bottom: 10px;">
          <el-col :span="12"   style="text-align: center;">
              <el-form-item label="出库类型:" label-width="30%">
                <el-select style="margin-right: 15px;float: left;width: 240px;" v-model="suname" placeholder="请选择">
                     <el-option
                       v-for="item in supplier"
                       :key="item.suname"
                       :label="item.suname"
                       :value="item.suname">
                     </el-option>
                   </el-select>
              </el-form-item>
          </el-col>
        </el-row>
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
          <el-table-column prop="sproduct.lname" label="单品名称">

          </el-table-column>
          <el-table-column prop="sproduct.lguige" label="单品规格"></el-table-column>
          <el-table-column prop="sproduct.ldanwei" label="单位"></el-table-column>
          <el-table-column label="出库数量">
              <template slot-scope="scope">
                <el-input-number
                  style="width:150px"
                  v-model.number="scope.row.outxqcount"
                  :min="1"
                  :placeholder="1+''"
                ></el-input-number>
              </template>
          </el-table-column>
          <el-table-column label="">
              <template slot-scope="scope">
                <el-button @click="deleteshop(scope.$index,scope.row)">移除</el-button>
              </template>
          </el-table-column>
        </el-table>
        <div style="margin-top: 20px;margin-left: auto;">
        <el-button type="primary" @click="beputnew">确认出库</el-button>
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
            suname:'其他出库',
            bedate:'',
            beremark:'',
            lname:'',
            current: 1,
            pageSize: 3,
            total: 0,
            splist:[],
            beputxq:[],
            supplier:[
              {suname:'过期出库'},
              {suname:'报废出库'},
              {suname:'其他出库'},
            ]
        }
      },
      methods:{
        beputnew(){
          console.log(this.beputxq)
          console.log(this.suname)
          console.log(this.beremark)
          if(!this.suname){
            this.suname='其他出库'
          }
          let b={
             outclass:this.suname,
             outremark:this.beremark,
             outputxqs:this.beputxq
          }
          console.log(b);
          this.$axios.put("output/insert",b)
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
          row.outxqcount=1;
          var json = {
            outxqcount:row.outxqcount,
            sproduct:{
              lid:row.lid,
              lname:row.lname,
              lguige:row.lguige,
              ldanwei:row.ldanwei,
              inventorys:row.inventorys
            }
          }
          let t=true;
          if(this.beputxq.length==0){
            this.beputxq.push(json);
          }else{
            for(let j=0;j<1;j++){
              for(let i=0;i<this.beputxq.length;i++){
                    if(row.lid==this.beputxq[i].sproduct.lid){
                      t=false
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
