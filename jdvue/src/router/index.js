import Vue from 'vue'
import Router from 'vue-router'

/* 商品模块导航 */
import ShangpinNavigation from '@/components/ShangpinNavigation'
import Allorders from "../components/zqx/Allorders";
import Alldelivergoods from "../components/zqx/Alldelivergoods";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'ShangpinNavigation',
      component: ShangpinNavigation,
      children:[

      ]
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
  ]
})
