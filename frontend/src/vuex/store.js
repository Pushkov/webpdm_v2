import Vue from 'vue'
import Vuex from 'vuex'
import app from "./modules/appStore"
import auth from "./modules/auth"
import plans from "./modules/planStore"
import users from "./modules/userStore"
import buros from "./modules/buroStore"
import points from './modules/pointStore'
import s4 from './modules/s4Store'

Vue.use(Vuex);

let store = new Vuex.Store({
    modules: {
        app,
        auth,
        plans,
        users,
        points,
        buros,
        s4
    },
    state: {
    },
    getters: {
    },
    mutations: {},
    actions: {}

});

export default store;