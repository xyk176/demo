<template>
  <div>
      <div style="padding: 20px;">门店库存</div>
      <div style="margin: 15px;">

        <el-input style="width: 180px;"  placeholder="请输入内容"  class="input-with-select float">
          <el-button class="float" slot="append" icon="el-icon-search"></el-button>
        </el-input>
        <el-select class="float"style="margin-right: 15px;" v-model="value" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.value"
              :value="item.value">
            </el-option>
          </el-select>
      </div>
       <el-table
            :data="inventorylist"
            style="width: 100%;padding: 15px;">
            <el-table-column prop="product.lname" label="单品名称"></el-table-column>
            <el-table-column prop="product.lguige" label="单品规格"></el-table-column>
            <el-table-column prop="product.ldanwei" label="单位"></el-table-column>
            <el-table-column prop="inentity" label="实物库存"></el-table-column>
            <el-table-column prop="inoccupy" label="占用库存"></el-table-column>
            <el-table-column prop="inusable" label="可用库存"></el-table-column>
            <el-table-column prop="product.lchengben" label="成本"></el-table-column>
            <el-table-column label="操作">
              <el-button>查看出入库明细</el-button>
            </el-table-column>
          </el-table>
  </div>
</template>

<script>
  export default {
      data(){
        return {
            inventorylist:[],
            value:'单品名称',
            options: [{
                      value: '单品名称'
                    }, {
                      value: '单品条码'
                    }]
        }
      },
      methods:{
          inventory(){
              this.$axios.post("inventory/selectAndproductAll")
              .then(r=>{
                if(r.status===200){
                  console.log(r.data)
                  this.inventorylist=r.data
                }
              })
          }
      },
      mounted(){
        this.inventory();
      }
  }
</script>

<style>
  .float{
    float: right;
  }
</style>
