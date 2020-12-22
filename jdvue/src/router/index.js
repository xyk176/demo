import Vue from 'vue'
import Router from 'vue-router'

/* 商品模块导航 */
import Navigation from '@/components/Navigation'
/*订单管理*/
import Allorders from "../components/zqx/Allorders";
/*发货管理*/
import Alldelivergoods from "../components/zqx/Alldelivergoods";
/* 商品列表 */
import Sangpinindex from '@/components/shangpin/Sangpinindex'
/* 商品新增 */
import Sangpinadd from '@/components/shangpin/Sangpinadd'

/* 单品列表 */
import danpinliebiao from '@/components/danpinliebiao'
/* 单品分类 */
import danpinfenlei from '@/components/danpinfenlei'

/* 库存 */
import inventory from '@/components/xyk/inventory'
/*前台登录页面*/
import login from '@/components/zzh/login'
/*收货地址列表*/
import address from '@/components/zzh/address'
import outandinput from '@/components/xyk/outandinput'
import beput from '@/components/xyk/beput'
import output from '@/components/xyk/output'
import checks from '@/components/xyk/checks'
import supplier from '@/components/xyk/supplier'
import maxcount from '@/components/xyk/maxcount'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/address',
      name: 'address',
      component: address
    },
    {
      path: '/',
      name: 'Navigation',
      component: Navigation,
      children:[
          {
            path: '/liebiao',
            name: 'danpinliebiao',
            component: danpinliebiao,
           },
        {
          path: '/Sangpinindex',
          name: 'Sangpinindex',
          component: Sangpinindex,
        },
        {
          path: '/Sangpinadd',
          name: 'Sangpinadd',
          component: Sangpinadd,
        },
        {
          path: '/Allorders',
          name: 'Allorders',
          component: Allorders
        },
        {
          path: '/Alldelivergoods',
          name: 'Alldelivergoods',
          component: Alldelivergoods
        }
        ,{
          path: '/inventory',
          name: 'inventory',
          component: inventory
        }
        ,{
          path: '/outandinput',
          name: 'outandinput',
          component: outandinput
        },{
          path: '/beput',
          name: 'beput',
          component: beput
        },{
          path: '/output',
          name: 'output',
          component: output
        },{
          path: '/checks',
          name: 'checks',
          component: checks
        },{
          path: '/supplier',
          name: 'supplier',
          component: supplier
        },{
          path: '/maxcount',
          name: 'maxcount',
          component: maxcount
        },{
            path: '/fenlei',
            name: 'danpinfenlei',
            component: danpinfenlei,
        }
      ]
    }
  ]
})
