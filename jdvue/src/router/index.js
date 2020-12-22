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
/* 单品列表 */
import danpinliebiao from '@/components/danpinliebiao'
/* 单品分类 */
import danpinfenlei from '@/components/danpinfenlei'

import inventory from '@/components/xyk/inventory'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Navigation',
      component: Navigation,
      children:[
          {
            path: '/liebiao',
            name: 'danpinliebiao',
            component: danpinliebiao,
           },{
            path: '/fenlei',
            name: 'danpinfenlei',
            component: danpinfenlei,
           },{
            path: '/',
            name: 'Sangpinindex',
            component: Sangpinindex,
            },{
            path: '/Allorders',
            name: 'Allorders',
            component: Allorders
            },{
              path: '/Alldelivergoods',
              name: 'Alldelivergoods',
              component: Alldelivergoods
            },{
              path: '/inventory',
              name: 'inventory',
              component: inventory
            }
      ]
    }
  ]
})
