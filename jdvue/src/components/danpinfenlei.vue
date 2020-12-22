<template>
  <div id="shangpinnavigation">
    <div class="body">
      <h2 style="font-size: 5px;margin-left: 20px;margin-top: 10px" >单品库分类</h2>
      <div class="head">
        <div class="small">
          <div>
            <el-cascader-panel :options="options" :props="defaultProps"></el-cascader-panel>
          </div>

          <el-button plain @click="addBegin()">新增</el-button>

          <el-dialog :visible.sync="fenleishow">
            <span>请选择父级分类</span>
            <el-cascader
                :options="options"
                :props="defaultPropss"
                @change="changea"
                clearable></el-cascader>
            <el-input v-model="input" placeholder="请输入分类" @change="changea2" style="width: 300px;"></el-input>
            <el-button plain @click="changea2()">新增分类</el-button>

          </el-dialog>

        </div>
      </div>
    </div>
    <div class="right">

    </div>
  </div>
</template>

<script>
export default {
name: "Allorders",
  data(){
  return{
    options: [],
    optionss: [],
    defaultProps: {
      children: 'sorts',
      label: 'cname',

    },
    defaultPropss: {
      children: 'sorts',
      label: 'cname',
      value: 'cid2',
      checkStrictly: true
    },
    fenleishow:false,
    input:"",
    result:{
      cfid:0
    }
    }
  },
  methods:{
    changea(e){
      console.log("aaaaaaaa",e)
      this.result.cfid=e[e.length-1];
      console.log("新增的父级id",this.result.cfid)
    },
    changea2(){
      console.log(this.result)
      this.result.cname=this.input;
      console.log("新增的分类名称",this.result.cname)
      this.$axios.put("/sort/add",this.result)
      console.log("新增的数据",this.result)
      this.fenleishow=false;
    }
      ,load(){
        this.$axios.post("/sort/all")
        .then((res)=>{
          this.options=res.data;
          console.log("所有分类",this.options)
        })
      }
      ,addBegin(e){

        this.$axios.post("/sort/all")
        .then((res)=>{
          this.optionss=res.data;
          console.log(this.optionss)
        })
        this.fenleishow=true;
      }



  },
  created() {
    this.load();
  }
}
</script>

<style scoped>
#shangpinnavigation .body{
  width: 86%;
  height: 500px;
  background: #FFFFFF;
  border-radius: 6px;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.12), 0 0 6px 0 rgba(0,0,0,.04);
  float: left;
}

.head{
  margin-left: 5px;
  margin-top: 10px;
  width: 99%;
  height: 91%;
  background: #F2F2F6;
  border-radius: 6px;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.12),0 0 6px 0 rgba(0,0,0,.04);
  border: 0px solid #000000;
}
.right{
  width: 13%;
  height: 500px;
  background: #FFFFFF;
  border-radius: 6px;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.12),0 0 6px 0 rgba(0,0,0,.04);
  float: right;
}
.small{
  margin-top: 15px;
  margin-left: 5px;
  width: 99%;
  height: 100%;
  background: #FFFFFF;
  border-radius: 6px;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.12),0 0 6px 0 rgba(0,0,0,.04);
}

</style>
