import Vue from 'vue'
import Router from 'vue-router'

/* 商品模块导航 */
import ShangpinNavigation from '@/components/ShangpinNavigation'
/* 商品列表 */
import Sangpinindex from '@/components/shangpin/Sangpinindex'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'ShangpinNavigation',
      component: ShangpinNavigation,
      children:[
        {
          path: '/',
          name: 'Sangpinindex',
          component: Sangpinindex,
        }
      ]
    }
  ]
})
