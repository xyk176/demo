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
import danpinliebiao from '@/components/danpin/danpinliebiao'
/* 单品分类 */
import danpinfenlei from '@/components/danpin/danpinfenlei'
/* 单品新增 */
import danpinadd from '@/components/danpin/danpinadd'
/* 单品修改 */
import danpinamend from '@/components/danpin/danpinamend'

/* 库存 */
import inventory from '@/components/xyk/inventory'
/*前台登录页面*/
import login from '@/components/zzh/login'
/*收货地址列表*/
import address from '@/components/zzh/address'
import outandinput from '@/components/xyk/outandinput'
import beput from '@/components/xyk/beput'
import beputxq from '@/components/xyk/beputxq'
import beputnew from '@/components/xyk/beputnew'
import output from '@/components/xyk/output'
import outputxq from '@/components/xyk/outputxq'
import checks from '@/components/xyk/checks'
import supplier from '@/components/xyk/supplier'
import suppliernew from '@/components/xyk/suppliernew'
import maxcount from '@/components/xyk/maxcount'
import addressDelete from '@/components/zzh/addressDelete'
import personalCenter from '@/components/zzh/personalCenter'
import orders from '@/components/zzh/orders'
import user from '@/components/zzh/user'

import Shopping from '@/components/Shopping'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/shopping',
      name: 'Shopping',
      component: Shopping
    },
    {
      path: '/personalCenter',
      name: 'personalCenter',
      component: personalCenter,
      children:[
        {
          path: '/address',
          name: 'address',
          component: address
        },
        {
          path: '/addressDelete',
          name: 'addressDelete',
          component: addressDelete
        },
        {
          path: '/orders',
          name: 'orders',
          component: orders
        },
        {
          path: '/user',
          name: 'user',
          component: user
        }
      ]
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
          path: '/beputxq',
          name: 'beputxq',
          component: beputxq
        },{
          path: '/beputnew',
          name: 'beputnew',
          component: beputnew
        },{
          path: '/output',
          name: 'output',
          component: output
        },{
          path: '/outputxq',
          name: 'outputxq',
          component: outputxq
        },{
          path: '/checks',
          name: 'checks',
          component: checks
        },{
          path: '/supplier',
          name: 'supplier',
          component: supplier
        },{
          path: '/suppliernew',
          name: 'suppliernew',
          component: suppliernew
        },{
          path: '/maxcount',
          name: 'maxcount',
          component: maxcount
        },{
            path: '/fenlei',
            name: 'danpinfenlei',
            component: danpinfenlei,
        },{
            path: '/danpinadd',
            name: 'danpinadd',
            component: danpinadd,
        },{
            path: '/danpinamend',
            name: 'danpinamend',
            component: danpinamend,
        }
      ]
    }
  ]
})
