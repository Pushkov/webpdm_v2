import {AXIOS} from "@/components/axios-export"

const buroStore = {
    state:{
        buroList:[]
    },
    getters:{
        BUROS: state => state.buroList,
    },
    actions:{
        GET_ALL_BUROS: ({commit, getters}) => {
            AXIOS.get('/buros',
                {
                    headers:
                        {'Authorization': getters.getToken}
                }
            )
                .then(responce => {
                    commit('SET_ALL_BUROS', responce.data);
                })
                .catch(() => {
                        // this.AUTH_LOGOUT();
                        // this.$router.push("/login")
                    }
                )
        }
    },
    mutations:{
        SET_ALL_BUROS: (state, buros) => {
            state.buroList = buros;
        },
    }
}

export default buroStore;