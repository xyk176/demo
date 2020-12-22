// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

Vue.config.productionTip = false

/* element-ui导入 */
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)

/* utilsTwo引用 */
import axios from './utils/utilsTwo'
Vue.prototype.$axios = axios;
import qs from 'qs'
Vue.prototype.$qs=qs;
import VDistpicker from 'v-distpicker';
Vue.component('v-distpicker', VDistpicker);

/* font-awesome导入 */
import 'font-awesome/css/font-awesome.min.css'

/* moment导入 */
import moment from 'moment'
Vue.use(require('vue-moment'));
Vue.prototype.moment = moment

//日期转换
import Dateformat from './utils/dateFormat.js'
Vue.prototype.$Dateformat = Dateformat


Vue.filter('dateYMDHMSFormat1', function(dateStr, pattern = 'YYYY年MM月DD日') {
  if(!dateStr) return '';
  return moment(dateStr).format(pattern);
})

Vue.filter('dateYMDHMSFormat2', function(dateStr, pattern = 'YYYY年MM月DD日 HH时mm分ss秒') {
  if(!dateStr) return '';
  return moment(dateStr).format(pattern);
})

Vue.filter('dateYMDHMSFormat3', function(dateStr, pattern = 'YYYY-MM-DD HH:mm:ss') {
  if(!dateStr) return '';
  return moment(dateStr).format(pattern);
})

Vue.filter('dateYMDHMSFormat4', function(dateStr, pattern = 'YYYY年MM月DD日 HH:mm') {
  if(!dateStr) return '';
  return moment(dateStr).format(pattern);
})


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
