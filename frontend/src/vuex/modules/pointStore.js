import {AXIOS} from "@/components/axios-export"

const pointStore = {
    state:{
        planPoints:[]
    },
    getters:{
        PLANPOINTS: state => state.planPoints,
    },
    actions:{
        GET_ALL_PLANPOINTS: ({commit, getters}) => {
            AXIOS.get('/planpoints',
                {
                    headers:
                        {'Authorization': getters.getToken}
                }
            )
                .then(responce => {
                    commit('SET_PLANPOINTS', responce.data);
                })
                .catch(() => {
                        // this.AUTH_LOGOUT();
                        // this.$router.push("/login")
                    }
                )
        },
        GET_PLANPOINTS_BY_BURO_AND_DATE: ({commit, getters}, {buro_id,year,month}) => {
            AXIOS.get('/plans/' + buro_id + '/' + year + '/' + month,
                {
                    headers:
                        {'Authorization': getters.getToken}
                }
            )
                .then(responce => {
                    commit('SET_PLANPOINTS', responce.data);
                })
                .catch(() => {
                        // this.AUTH_LOGOUT();
                        // this.$router.push("/login")
                    }
                )
        },

    },
    mutations:{
        SET_PLANPOINTS: (state, points) => {
            state.planPoints = points;
        },
    }
}

export default pointStore;