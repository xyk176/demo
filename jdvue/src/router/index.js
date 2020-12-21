import Vue from 'vue'
import Router from 'vue-router'

/* 商品模块导航 */
import Navigation from '@/components/Navigation'
/* 商品列表 */
import Sangpinindex from '@/components/shangpin/Sangpinindex'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Navigation',
      component: Navigation,
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
