<template>
  <div id="shangpinnavigation">
    <div class="body">
      <h2 style="font-size: 5px;margin-left: 20px;margin-top: 10px">单品库列表</h2>
      <div class="head">
        <div class="small">
          &nbsp;&nbsp;&nbsp;
          <el-select v-model="value" placeholder="请选择" style="width: 150px;margin-top: 8px" size="mini">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          <div>
            <el-button plain size="mini" style="margin-top: 18px;margin-left: 14px;">新增单品</el-button>
            <el-button plain size="mini">导入单品</el-button>
            <el-button plain size="mini">导入修改</el-button>
            <el-button plain size="mini">导出单品</el-button>
            <el-button plain size="mini">修改分类</el-button>
            <el-button plain size="mini">删除</el-button>
          </div>
        </div>
        <div style="margin-top: 15px;width: 99%;margin-left: 7px">
          <el-table
            :data="tableData"
            stripe
            style="width: 100%"
            @selection-change="handleSelectionChange">
            <el-table-column
             type="selection"
              width="180">
            </el-table-column>
            <el-table-column
              prop="lname"
              label="单品名称"
              width="180">
            </el-table-column>
            <el-table-column
              prop="name"
              label="单品图片"
              width="180">
            </el-table-column>
            <el-table-column
              prop="ldanwei"
              label="单品单位">
            </el-table-column>
            <el-table-column
              prop="cname"
              label="单品分类">
            </el-table-column>
            <el-table-column
              prop="lchengben"
              label="单品成本">
            </el-table-column>
            <el-table-column label="操作">
                  <template slot-scope="scope">
                    <!-- <el-button
                      size="mini"
                      type="danger"
                      @click="handleDelete(scope.$index, scope.row)">删除</el-button> -->
                    <el-link icon="el-icon-edit">编辑</el-link>
                  </template>
                </el-table-column>
          </el-table>
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
    tableData: [],
    multipleSelection: [],
    options: [{
      value: '选项1',
      label: '黄金糕'
    }, {
      value: '选项2',
      label: '双皮奶'
    }, {
      value: '选项3',
      label: '蚵仔煎'
    }, {
      value: '选项4',
      label: '龙须面'
    }, {
      value: '选项5',
      label: '北京烤鸭'
    }],
    value: ''
    }
  },
  methods:{
      load(){
        this.$axios.post("/product/all")
        .then((res)=>{
          this.tableData=res.data;
          console.log("单品列表",this.tableData)
        })
      }

      ,handleSelectionChange(val) {
        this.multipleSelection = val;
      }
  },
  mounted() {
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
  margin-top: 5px;
  margin-left: 5px;
  width: 99%;
  height: 20%;
  background: #FFFFFF;
  border-radius: 6px;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.12),0 0 6px 0 rgba(0,0,0,.04);
}

</style>
