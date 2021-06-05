import Vue from 'vue'
import Router from 'vue-router'
import store from './vuex/store'

Vue.use(Router)

const ifAuthenticated = (to, from, next) => {

    if (store.getters.isAuthenticated) {
        localStorage.removeItem('path-to');
        next();
        return;
    }else {
        localStorage.setItem('path-to', to.path);
        next("/pdm/login");
    }
};

export default new Router({
    mode: 'history',
    routes: [
        {
            path:'/',
            redirect:'/pdm/index',
            component: () => import("./views/IndexPage"),
            beforeEnter: ifAuthenticated
        },
        {
            path:'/pdm',
            redirect:'/pdm/index',
            component: () => import("./views/IndexPage"),
            beforeEnter: ifAuthenticated
        },
        {
            path: '/pdm/login',
            component: () => import("./views/LoginPage"),
        },
        {
            path: '/pdm/index',
            component: () => import("./views/IndexPage"),
            beforeEnter: ifAuthenticated
        },
        {
            path: '/pdm/title',
            component: () => import("./views/TitlePage"),
            beforeEnter: ifAuthenticated
        },
        {
            path: '/pdm/plans',
            component: () => import("./views/PlansPage"),
            beforeEnter: ifAuthenticated
        },
        {
            path: '/pdm/projects',
            component: () => import("./views/ProjectsPage"),
            beforeEnter: ifAuthenticated
        },
        {
            path: '/pdm/documents',
            component: () => import("./views/DocumentsPage"),
            beforeEnter: ifAuthenticated
        },
        {
            path: '/pdm/users',
            component: () => import("./views/UsersPage"),
            beforeEnter: ifAuthenticated
        },


        {
            path: '/pdm/admin',
            component: () => import("./views/AdminPage"),
            beforeEnter: ifAuthenticated
        },
        {
            path: '/pdm/error',
            component: () => import("./views/ErrorPage"),
            beforeEnter: ifAuthenticated
        },
        {
            path: '/pdm/success',
            component: () => import("./views/IndexPage"),
            beforeEnter: ifAuthenticated
        }
    ]
})