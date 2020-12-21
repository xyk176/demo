import Vue from 'vue'
import Router from 'vue-router'

/* 商品模块导航 */
import ShangpinNavigation from '@/components/ShangpinNavigation'

/* 库存 */
import inventory from '@/components/xyk/inventory'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'ShangpinNavigation',
      component: ShangpinNavigation,
      children:[
        {
          path: '/inventory',
          name: 'inventory',
          component: inventory
        }
      ]
    }

  ]
})
