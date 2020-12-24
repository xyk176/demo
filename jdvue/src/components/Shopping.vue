<template>
  <div style="overflow: hidden;position: relative;">
    <el-container>
      <el-header>Header</el-header>
      <el-main>
        <el-row>
          <el-col :span="4">
            <div class="Left_div">
              <el-menu default-active="2" class="el-menu-vertical-demo" style=" max-width: 250px; min-height: 600px;">
                <el-menu-item v-for="(i,index) in goods_type" :key="i.ccyid" :index="i.ccyname">
                  <div class="Goods_Div" @click="s_goods(i.ccyid)">
                    <img :src="i.ccytopid" class="img_div" />
                    <span class="font_span">{{i.ccyname}}</span>
                  </div>
                </el-menu-item>
              </el-menu>
            </div>
          </el-col>
          <el-col :span="20">
            <div class="goodslist_div" v-if="goods_list.length>0">
              <div v-show="goods_show">
                <el-row>
                  <el-col :span="5" v-for="(o, index) in goods_list" :key="o.comid" style="margin-left: 37px; margin-top: 10px;">
                    <el-card :body-style="{ padding: '0px' }">
                      <img :src="o.pics[0].pic.picpath" class="image">
                      <div style="padding: 14px;">
                        <span>{{o.comname}}</span>
                        <el-button type="text" class="button" @click="goods_xiangqing(o.comid)">查看详情</el-button>
                        <div class="bottom clearfix">
                          <span style="font-weight: 600;color: red;font-size: 16px;">￥{{o.comsameprice}}</span>
                          <el-tag class="addCart_tag" size="small" type="danger">加入购物车</el-tag>
                        </div>
                      </div>
                    </el-card>
                  </el-col>
                </el-row>
                <div class="Page_div">
                  <!-- 分页-->
                  <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="current"
                    :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
                  </el-pagination>
                </div>
              </div>
              <div v-show="!goods_show">
                <!-- 商品详情区 -->
                <div style="display: inline-block;">
                  <el-image style="width: 496px; height: 463px;border-radius: 17px;" title="点击查看更多图片" :src="url"
                    :preview-src-list="img_list">
                  </el-image>
                </div>
                <div class="goodsXinXi_div">

                </div>
                <el-row :gutter="20">
                  <el-col :span="11">
                    <div>
                      <fieldset style="border-radius: 10px;">
                        <legend style="margin-left: 25px;">商品参数</legend>
                        <el-tag type="success" v-for="i in goods_ShuXin" style="margin: 10px;">
                          {{i.cpr.cprname}}
                        </el-tag>
                      </fieldset>
                    </div>
                  </el-col>
                  <el-col :span="13">
                    <div>
                      <fieldset style="border-radius: 10px;">
                        <legend style="margin-left: 25px;">商品属性</legend>
                        <el-tag type="success" v-for="i in goods_property" style="margin: 10px;">
                          {{i.cpr.cpyname}}
                        </el-tag>
                      </fieldset>
                    </div>
                  </el-col>
                </el-row>
              </div>
            </div>
            <div class="hidden_div" v-if="goods_list.length==0">
              <span style="font-size: 18px;font-weight: 600;">还没有商品哟~</span>
            </div>
          </el-col>
        </el-row>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  import "../../static/css/Shopping.css";
  export default {
    data() {
      return {
        goods_type: [], //所有商品类型
        goods_list: [], //一个商品类型---所有商品
        goods_show: false, //商品列表界面  商品详情界面   切换
        type_id: 0, //商品分类ID
        pageSize: 8,
        current: 0,
        total: 0,
        url: "",
        img_list: [], //商品详情图
        activeName:"1",//展示商品参数  折叠面板
        goods_property:[],//商品参数
        goods_ShuXin:[],//商品属性
      }
    },
    methods: {
      goods_xiangqing(goodsID) { //根据商品id  查看商品详细信息
        this.goods_show = false; //商品列表隐藏  商品详细信息界面显示
        let param = {
          goodsID: goodsID
        };
        this.$axios.post("/shopping/s_GoodsXiangQing", param)
          .then(res => {
            this.url = res.data.objs[0].pics[0].pic.picpath;
            for (let i = 0; i < res.data.objs[0].pics.length; i++) {
              this.img_list.push(res.data.objs[0].pics[i].pic.picpath)
            }
            console.log("商品所有信息--", res.data.objs);
            this.goods_ShuXin = res.data.objs[0].cprs;
            this.goods_property = res.data.objs[0].cpys;
            console.log("商品参数--",this.goods_property);
          })
      },
      S_GoodsType() { //查询所有商品分类
        this.$axios.post('shopping/s_GoodsType')
          .then(res => {
            this.goods_type = res.data.objs; //拿到所有商品分类
            console.log("查看多有商品分类--", res.data.objs);
          })
      },
      s_goods(type_id) {
        this.goods_show = true; //商品列表显示
        this.type_id = type_id; //拿到商品分类id  去查询该分类的所有商品
        let param = {
          goodsTypeID: type_id,
          pageNo: this.current,
          pageSize: this.pageSize
        }
        this.$axios.post("/shopping/s_Goods", param)
          .then(res => {
            this.goods_list = res.data.obj.list; //拿到该商品分类的  所有商品
            this.total = res.data.obj.total;
            console.log("该商品分类的所有商品--", this.goods_list, "数量==", this.total);
          })
      },
      handleCurrentChange(current) { //当前第几页
        this.current = current;
        this.s_goods(this.type_id);

      },
      handleSizeChange(pageSize) { //每页多少条
        this.pageSize = pageSize;
        this.s_goods(this.type_id);
      },
    },
    created() {
      this.S_GoodsType();
    }
  }
</script>

<style scoped="scoped">
  .el-col-5:hover {
    box-shadow: 2px 2px 5px #000;
    ;
  }

  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 205px;
    height: 205px;
    display: block;
    padding-left: 10px;
    padding-top: 10px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .el-menu-item:focus,
  .el-menu-item:hover {
    outline: 0;
    background-color: #CCC6C6;
    border-radius: 17px;
  }

  .el-menu-item {
    margin-top: 3px;
    margin-bottom: 3px;
  }

  .el-menu {
    border-radius: 17px;
  }

  .el-header,
  .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-main {
    min-height: 600px;
    background-color: #E9EEF3;
    color: #333;

  }
</style>
