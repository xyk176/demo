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
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
      </div>
  </div>
</template>

<script>
  export default {
      data(){
        return {

        }
      },
      methods:{

      },
      mounted(){

      }
  }
</script>

<style>
  .float{
    float: right;
  }
</style>
