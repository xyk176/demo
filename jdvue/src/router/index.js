import Vue from 'vue'
import Router from 'vue-router'

import ShangpinNavigation from '@/components/ShangpinNavigation'/* 商品模块导航 */
import Shopping from '@/components/Shopping'/* 购物主页 */

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Shopping',
      component: Shopping,
      children:[

      ]
    },
    
  ]
})
