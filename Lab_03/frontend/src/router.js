import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from './pages/Login';
import Main from './pages/Main';
import About from './pages/About';

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/login',
        component: Login
    }, {
        path: '/main',
        component: Main,
        children: [
            {
                path: '/about',
                name: 'about',
                component: About
            }
        ]
    }
];

const router = new VueRouter({
    routes: routes,
    mode: 'history'
});
  
  
  export default router;