<template>
  <div style="overflow: hidden;position: relative;">
    <el-container>
      <el-header>
        <span @click="tiaozhuan">
        <el-avatar  style="float: right;position: relative;top:10px " src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
        </span>
        <el-tag @click="s_carts" style="float: right;position: relative;top:15px;left: -15px;">查看购物车</el-tag>
      </el-header>
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

                        <div class="bottom clearfix">
                          <span style="font-weight: 600;color: red;font-size: 16px;">￥{{o.comsameprice}}</span>
                          <el-button type="text" class="button" @click="goods_xiangqing(o.comid)">查看详情</el-button>
                          <!-- <el-tag class="addCart_tag" size="small" type="danger">加入购物车</el-tag> -->
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
                <el-row :gutter="10">
                  <el-col :span="11">
                    <div style="display: inline-block;">
                      <el-image style="width: 496px; height: 463px;border-radius: 17px;" title="点击查看更多图片" :src="url"
                        :preview-src-list="img_list">
                      </el-image>
                    </div>
                  </el-col>
                  <el-col :span="12">
                    <div class="goodsXinXi_div">
                      <el-row :gutter="20">
                        <el-col>
                          <div>
                            <fieldset style="border-radius: 10px;">
                              <legend style="margin-left: 25px;">商品参数</legend>
                              <el-tag type="success" v-for="(i,index) in goods_ShuXin" :key="index" style="margin: 10px;">
                                {{i.cpr.cprname}}
                              </el-tag>
                            </fieldset>
                          </div>
                        </el-col>
                        <el-col>
                          <div style="margin-top: 30px;">
                            <fieldset style="border-radius: 10px;">
                              <legend style="margin-left: 25px;">商品属性</legend>
                              <el-tag type="success" v-for="(i,index) in goods_property" :key="index" style="margin: 10px;">
                                {{i.cpy.cpyname}}
                              </el-tag>
                            </fieldset>
                          </div>
                        </el-col>
                        <el-col>
                          <div style="margin-top: 30px;">
                            <fieldset style="border-radius: 10px;">
                              <legend style="margin-left: 25px;">基本参数</legend>
                              <el-tag type="danger" style="margin: 10px;">
                                名称：{{goodsXinxi.comname}}
                              </el-tag>
                              <el-tag type="info" style="margin: 10px;">
                                价格：{{goodsXinxi.commarketprice}}
                              </el-tag>
                              <el-tag type="success" style="margin: 10px;">
                                重量：{{goodsXinxi.comweight}}
                              </el-tag>
                            </fieldset>
                          </div>
                        </el-col>
                      </el-row>
                      <el-input-number v-model="num" :min="1" :max="10" class="num_button" style="margin-top: 30px;">
                      </el-input-number>
                      <el-button @click="add_cart">加入购物车</el-button>
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
    <el-drawer :visible.sync="cart_show" :size="size" :with-header="false">
      <el-table ref="multipleTable" :data="cartData" tooltip-effect="dark" style="width: 100%;text-align: center;"
        @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55">
        </el-table-column>
        <el-table-column label="商品图片" width="120">
          <template slot-scope="scope">
            <img :src="scope.row.com.pics[0].pic.picpath" style="width: 120px;height: 120px;">
          </template>
        </el-table-column>
        <el-table-column label="商品名称" width="120">
          <template slot-scope="scope">{{ scope.row.com.comname }}</template>
        </el-table-column>
        <el-table-column label="价格" width="120">
          <template slot-scope="scope">{{ scope.row.com.commarketprice }}</template>
        </el-table-column>
        <el-table-column label="数量" width="150">
          <template slot-scope="scope">
            <el-input-number v-model="scope.row.number" size="mini" :min="1" :max="10">
            </el-input-number>
          </template>
        </el-table-column>
        <el-table-column label="删除" width="120">
          <template slot-scope="scope">
            <el-tag type="danger" size="mini" @click="delete_cart(scope.row.shid)">删除</el-tag>
          </template>
        </el-table-column>
      </el-table>
      <div>
        <el-button type="danger" plain @click="d_piliang" :disabled="Chebox.length>0?false:true">批量删除</el-button>
        <el-button type="success" plain @click="add_DingDan" :disabled="Chebox.length>0?false:true">确认订单</el-button>
      </div>
    </el-drawer>
    <el-drawer :visible.sync="left_show" :size="size2" :with-header="false" direction="ltr">
      <div style="padding: 35px;">
        <h4>地址选择：</h4>
        <el-select v-model="add_choose" placeholder="请选择" style="width: 315px;">
          <el-option v-for="(i,index) in address_list" :key="index" :label="i.adprovince + i.adcity+i.adarea+i.addetailed"
            :value="i.adid">
            <span style="float: left">{{ i.addetailed }}</span>
            <span style="float: right; color: #8492a6; font-size: 13px">{{ i.adprovince + i.adcity+i.adarea}}</span>
            <!-- i.adprovince + i.adcity+i.adarea+i.addetailed -->
          </el-option>
        </el-select>
        <h4 style="margin-top: 20px;">支付方式：</h4>
        <el-switch style="display: block" v-model="payfor" active-color="#13ce66" inactive-color="#ff4949" @change="change_pay"
          active-text="支付宝" inactive-text="微信">
        </el-switch>
        <img src="../../static/image/wei.png" v-if="wei_zhi==true">
        <img src="../../static/image/zhi.png" v-if="wei_zhi==false">
        <h4 style="margin-top: 20px;">备注</h4>
        <textarea v-model="beizhu" cols="42"></textarea>
        <h4 style="margin-top: 20px;">
          应付金额：
          <span style="color: red;">{{all_money}}</span>
        </h4>
        <el-button type="success" style="margin-top: 20px;float: right;" @click="tijiao">提交订单</el-button>
      </div>
    </el-drawer>
  </div>
</template>

<script>
  import "../../static/css/Shopping.css";
  export default {
    data() {
      return {
        cid: 1, //客户ID
        goods_type: [], //所有商品类型
        goods_list: [], //一个商品类型---所有商品
        goods_show: false, //商品列表界面  商品详情界面   切换
        type_id: 0, //商品分类ID
        pageSize: 8, //一页多少条数据
        current: 0, //当前为多少页
        total: 0, //多少条数据
        url: "", //主图地址
        goodsXinxi: {}, //商品信息
        img_list: [], //商品详情图
        activeName: "1", //展示商品参数  折叠面板
        goods_property: [], //商品参数
        goods_ShuXin: [], //商品属性
        num: 1, //添加商品数量
        cartData: [], //客户的购物车
        cart_show: false, //购物车界面
        left_show: false, //支付界面
        size: "690px", //购物车界面宽度
        size2: "392px", //支付界面宽度
        Chebox: [], //复选框的值 --购物车选中
        address_list: [], //客户地址信息
        add_choose: "", //最终的地址选择
        payfor: "", //支付方式   支付宝  微信
        wei_zhi: false, //支付宝 微信 图片显示
        all_money: 0, //总积金额
        beizhu: "", //订单备注
        orderInfo: [], //订单详情
        shid_list:[],//所有确认提交订单的  购物车ID
      }
    },
    methods: {
      tiaozhuan() { //跳转到个人中心
      console.log("aaaaaa");
        this.$router.push({
          name:'user'
        })
      },
      tijiao() { //提交订单 --付钱
        let Orders = {
          address: {
            adid: this.add_choose //地址id
          },
          customer: {
            cid3: this.cid //客户id
          },
          pay: this.payfor ? "微信" : "支付宝",
          price: this.all_money,
          remarks: this.beizhu,
          oDate: this.moment().format("yyyy-MM-DD hh:mm:ss")
        }
        if(Orders.address.adid==null){
          this.$message({
            showClose: true,
            message: '请选择地址',
            type: 'danger',
            duration: 1000,
            center: true
          });
        }else{
          if(Orders.remarks==null){
            Orders.remarks = "无"
          }
          //console.log("提交订单参数--",Orders);
          this.$axios.put("/shopping/add_Order", Orders)
            .then(res => {
              console.log("提交订单之后返回信息--", res.data);
              let orderInfo = [];
              for (let i = 0; i < this.Chebox.length; i++) {
                orderInfo.push({
                  coms: this.Chebox[i].number,
                  comprice: this.Chebox[i].com.commarketprice,
                  com: {
                    comid: this.Chebox[i].com.comid
                  },
                  order: {
                    oId: res.data.obj.oId
                  }
                }, )
              }
              console.log("提交信息--商品详情==", orderInfo);
              this.$axios.put("/shopping/add_Orderinfo", orderInfo)
                .then(res => {
                    this.left_show = false;
                    this.up_ships();

                })
            })
        }
      },
      up_ships(){
        console.log("修改购物车状态--参数==",this.shid_list);
        let param = {shid_list:this.shid_list};
        this.$axios.put("/shopping/up_ships",this.shid_list)
        .then(res=>{
            this.s_carts(); //重新查询购物车
        })
      },
      change_pay() { //切换支付方式
        this.wei_zhi = !this.wei_zhi
      },
      d_piliang() { //批量删除
        let shid_list = [];
        for (let i = 0; i < this.Chebox.length; i++) {
          shid_list.push(this.Chebox[i].shid)
        }
        this.$axios.put("/shopping/d_Cart_ByID", shid_list)
          .then(res => {
            this.$message({
              showClose: true,
              message: '删除成功',
              type: 'error',
              duration: 1000,
              center: true
            });
            this.s_carts(); //重新查询购物车
          })
      },
      add_DingDan() {//展示支付界面
        this.left_show = true;
        let shid_list = [];
        let money = 0;
        for (let i = 0; i < this.Chebox.length; i++) {
          shid_list.push(this.Chebox[i].shid)
          money += this.Chebox[i].number * this.Chebox[i].com.commarketprice
        }
        console.log("添加订单，拿到全部购物车ID--", shid_list);
        this.shid_list = shid_list;
        this.all_money = money; //总计金额
      },
      delete_cart(shid) { //购物车中--删除一条购物车
        console.log("删除购物车的ID--", shid);
        let shid_list = [];
        shid_list.push(shid);
        let param = {
          shid: shid_list
        };
        console.log("返回参数==", param);
        this.$axios.put("/shopping/d_Cart_ByID", shid_list)
          .then(res => {
            this.$message({
              showClose: true,
              message: '删除成功',
              type: 'success',
              duration: 1000,
              center: true
            });
            this.s_carts(); //重新查询购物车
          })
      },
      handleSelectionChange(val) { //购物车界面   复选框
        this.Chebox = val; //把复选框的值存进Chebox
        console.log("复选框选中的值--", this.Chebox);
      },
      s_carts() { //查询购物车--根据客户ID
        this.cartData = [];
        this.cart_show = true;
        let param = {
          cid: this.cid
        };
        this.$axios.post("/shopping/s_Carts", param)
          .then(res => {
            if (res.data.objs.length > 0) {
              this.cartData = res.data.objs;
              this.address_list = res.data.objs[0].customer.address;
              /* for (let i = 0; i < this.address_list.length; i++) { //选择框  默认选中 默认地址
                if (this.address_list[i].adisdefault == "是") {
                  this.add_choose = this.address_list[i].adprovince + this.address_list[i].adcity +
                    this.address_list[i].adarea + this.address_list[i].addetailed
                }
              } */
              console.log("购物车信息--", res.data);
              console.log("地址信息--", this.address_list)
            }
          })
      },
      add_cart() { //添加购物车
        //console.log("商品信息==",this.goodsXinxi);
        let cart = {
          customer: {
            cid3: this.cid
          },
          com: {
            comid: this.goodsXinxi.comid
          },
          number: this.num
        }
        let param = {
          comid: this.goodsXinxi.comid
        };
        this.$axios.post("/shopping/s_oldShopping", param)
          .then(res => {
            console.log("购物车存在==", res.data);
            if (res.data.obj != null) {
              let p = {
                number: res.data.obj.number+this.num,
                shid: res.data.obj.shid
              };
              console.log("累加数量参数=====", p)
              this.$axios.post("/shopping/up_cartNum", p)
                .then(res => {
                  this.$message({
                    showClose: true,
                    message: '添加购物车成功',
                    type: 'success',
                    duration: 1000,
                    center: true
                  });
                  this.cart_show = true;//购物车界面显示
                  this.s_carts();//根据客户id 查询购物车
                })
            } else {
              this.$axios.put("/shopping/add_carts", cart)
                .then(res => {
                  console.log("添加购物车返回的商品信息==", res.data)
                  this.$message({
                    showClose: true,
                    message: '添加购物车成功',
                    type: 'success',
                    duration: 1000,
                    center: true
                  });
                  this.cart_show = true; //购物车界面显示
                  this.s_carts(); //根据客户id 查询购物车
                })
            }
          })
        console.log("商品参数==", cart);

      },
      goods_xiangqing(goodsID) { //根据商品id  查看商品详细信息
        this.goods_show = false; //商品列表隐藏  商品详细信息界面显示
        let param = {
          goodsID: goodsID
        };
        this.$axios.post("/shopping/s_GoodsXiangQing", param)
          .then(res => {
            this.url = res.data.objs[0].pics[0].pic.picpath; //展示的图片地址
            this.goodsXinxi = res.data.objs[0];
            for (let i = 0; i < res.data.objs[0].pics.length; i++) {
              this.img_list.push(res.data.objs[0].pics[i].pic.picpath)
            }
            console.log("商品所有信息--", res.data.objs);
            this.goods_ShuXin = res.data.objs[0].cprs;
            this.goods_property = res.data.objs[0].cpys;
            console.log("商品参数--", this.goods_property);
          })
      },
      S_GoodsType() { //查询所有商品分类
        this.$axios.post('shopping/s_GoodsType')
          .then(res => {
            this.goods_type = res.data.objs; //拿到所有商品分类
            //console.log("查看多有商品分类--", res.data.objs);
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
      this.cid = sessionStorage.getItem('cid3')
      this.S_GoodsType();
      let id = 1;
      this.s_goods(id);
    }
  }
</script>

<style>
  .has-gutter/deep/tr>th {
    text-align: center;
  }

  .el-table__row/deep/td {
    text-align: center;
  }
</style>
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
