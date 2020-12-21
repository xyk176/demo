import Vue from 'vue'
import Router from 'vue-router'

/* 商品模块导航 */
import Navigation from '@/components/Navigation'
import Allorders from "../components/zqx/Allorders"
import Alldelivergoods from "../components/zqx/Alldelivergoods"
/* 商品列表 */
import Sangpinindex from '@/components/shangpin/Sangpinindex'

import danpinliebiao from '@/components/danpinliebiao'

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
           },
        {
          path: '/',
          name: 'Sangpinindex',
          component: Sangpinindex,
        }
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
