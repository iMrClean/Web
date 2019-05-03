import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'

import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import router from './router'

Vue.config.productionTip = false;
Vue.use(VueRouter);
Vue.use(BootstrapVue);
Vue.use(VueResource);

new Vue({
    render: h => h(App),
    router,
    VueResource,
    data: {
    apiUrl: 'http://localhost:8080/api',
},
methods: {
    getHeaders() {
        return {
            "Content-Type": "application/json",
            "Authorization": localStorage.getItem('jwt')
        }
    }
}
}).$mount('#app');
