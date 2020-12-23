<template>
  <div id="inventory">
    <div  class="font">入库单-{{bename}}</div>
    <div class="body">
      <div class="shangping_jiansuo">
        <div style="font-size:18px ;">基本信息</div>
      <el-form >
        <el-row :span="24" style="margin-bottom: 10px;" v-if="bename=='采购入库'">
          <el-col :span="12"   style="text-align: center;">
              <el-form-item label="供应商名称:" label-width="30%">
                <el-select style="margin-right: 15px;float: left;width: 240px;" v-model="suname" placeholder="请选择">
                     <el-option
                       v-for="item in supplier"
                       :key="item.suid"
                       :label="item.suname"
                       :value="item.suid">
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
          <el-table-column prop="product.lname" label="单品名称">

          </el-table-column>
          <el-table-column prop="product.lguige" label="单品规格"></el-table-column>
          <el-table-column prop="product.ldanwei" label="单位"></el-table-column>
          <el-table-column label="入库数量">
              <template slot-scope="scope">
                <el-input-number
                  style="width:150px"
                  v-model.number="scope.row.libecount"
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
        <el-button type="primary" @click="beputnew">确认入库</el-button>
        <router-link to="beput">

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
            suname:'',
            bedate:'',
            beremark:'',
            lname:'',
            bename:this.$route.params.clas,
            current: 1,
            pageSize: 3,
            total: 0,
            splist:[],
            beputxq:[],
            supplier:[]
        }
      },
      methods:{
        beputnew(){
          console.log(this.beputxq)
          console.log(this.bename)
          console.log(this.beremark)
          if(!this.bename){
            this.bename='其他出库'
          }
          let b={
             beclass:this.bename,
             beremark:this.beremark,
             supplier:{
               suid:this.suname},
             beputxqs:this.beputxq
          }
          console.log(b);
          this.$axios.put("beput/insert",b)
            .then(r=>{
              if(r.status===200){
                console.log('date',r.data)
                if(r.data>0){
                  alert("入库成功")
                }
              }
          })
        },
        deleteshop(index,row){
        this.beputxq.splice(index,1);
        },
        pushshoplist(index,row){
          row.libecount=1;
          var json = {
            libecount:row.libecount,
            product:{
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
                    if(row.lid==this.beputxq[i].lid){
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
            this.$axios.post("supplier/selectNewBeput")
            .then(r=>{
              this.supplier=r.data
            })
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
