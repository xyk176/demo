<template>
  <div id="inventory">
    <div  class="font">供应商-新增供应商</div>
    <div class="body">
      <div class="shangping_jiansuo">
        <div style="font-size:18px ;">基本信息</div>
      <el-form >
        <el-row :span="24" style="margin-bottom: 10px;">
          <el-col :span="12"   style="text-align: center;">
              <el-form-item label="供应商名称:" label-width="30%">
                <el-input v-model="supplier.suname"></el-input>
              </el-form-item>
          </el-col>
          <el-col :span="12"   style="text-align: center;">
              <el-form-item label="单位电话:" label-width="30%">
                <el-input v-model="supplier.suphone"></el-input>
              </el-form-item>
          </el-col>
        </el-row>
        <el-row :span="24" style="margin-bottom: 10px;">
          <el-col :span="12"   style="text-align: center;">
              <el-form-item label="地区:" label-width="30%">
               <v-distpicker :province="supplier.susheng"
                             :city="supplier.sushi"
                             :area="supplier.suqu"
                             @selected="onSelected">
               </v-distpicker>
              </el-form-item>
          </el-col>
        </el-row>
        <el-row :span="24" style="margin-bottom: 10px;">
          <el-col :span="12"   style="text-align: center;">
              <el-form-item label="联系人:" label-width="30%">
                <el-input v-model="supplier.sulxr"></el-input>
              </el-form-item>
          </el-col>
          <el-col :span="12"   style="text-align: center;">
              <el-form-item label="联系电话:" label-width="30%">
                <el-input v-model="supplier.sulxrphone"></el-input>
              </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      </div>
      <div class="shangping_jiansuo">
          <el-form >
            <el-row :span="24" style="margin-bottom: 10px;">
              <el-col :span="12"   style="text-align: center;">
                  <el-form-item label="qq:" label-width="30%">
                    <el-input v-model="supplier.suqq"></el-input>
                  </el-form-item>
              </el-col>
              <el-col :span="12"   style="text-align: center;">
                  <el-form-item label="微信:" label-width="30%">
                    <el-input v-model="supplier.suwx"></el-input>
                  </el-form-item>
              </el-col>
            </el-row>
            <el-row :span="24" style="margin-bottom: 10px;">
              <el-col :span="12"   style="text-align: center;">
                  <el-form-item label="邮箱:" label-width="30%">
                    <el-input v-model="supplier.suemail"></el-input>
                  </el-form-item>
              </el-col>
              <el-col :span="12"   style="text-align: center;">
                  <el-form-item label="传真:" label-width="30%">
                    <el-input v-model="supplier.sufax"></el-input>
                  </el-form-item>
              </el-col>
            </el-row>
          </el-form>

      </div>
      <el-button @click="insert">添加</el-button>
      <router-link to="supplier">
        <el-button>取消</el-button>
      </router-link>
      </div>
  </div>
</template>

<script>
  export default {
      data(){
        return {
            supplier:{}
        }
      },
      methods:{
        insert(){
          console.log(this.supplier);
          if(this.supplier.suname==null || this.supplier.suname==''){
            alert("请填写供应商名称")
          }else{
            this.$axios.put("supplier/insert",this.supplier)
            .then(r=>{
                if(r.data>0){
                  alert("新增供应商成功");
                }
            })
          }
        },
        onSelected(data) {
          this.supplier.susheng = data.province.value
          this.supplier.sushi = data.city.value
          this.supplier.suqu = data.area.value
        },
      },
      mounted(){

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
