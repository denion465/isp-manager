import Vue from 'vue'
import App from './App.vue'
import router from './router'

// Element
import ElementUI from 'element-ui';
import './styles/element-variables.scss';
import locale from 'element-ui/lib/locale/lang/pt-br';

Vue.config.productionTip = false

Vue.use(ElementUI, {locale});

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
