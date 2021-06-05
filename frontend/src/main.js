import '@babel/polyfill'
import 'mutationobserver-shim'
import Vue from 'vue'
import './plugins/bootstrap-vue'
import App from './App.vue'
import router from './router'
import store from './vuex/store'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
// import axios from "axios";

Vue.config.productionTip = false

const token = localStorage.getItem('user-token')
if (token)
  console.log(" est token");
else
  console.log(" no token");


new Vue({
  router,
  render: h => h(App),
  store
}).$mount('#app')
