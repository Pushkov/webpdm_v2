import {AXIOS} from "@/components/axios-export"

const userStore = {
    state: {
        users: [],
        currentUser: Object,
        isUserListPaged: true,
        pageInUserList: 0,
        pagesInUserList: 1,
        offsetInUserList: 3,
        countUsers: 0
    },
    getters: {
        USERS: state => state.users,
        CURRENT_USER: state => state.currentUser,
    },
    actions: {
        CLEAR_USERS_LIST: ({commit}) => {
            commit('SET_USERS', []);
        },
        GET_ALL_USERS: async ({commit, getters}) => {
            await AXIOS.get('/users',
                {
                    headers:
                        {'Authorization': getters.getToken}
                }
            )
                .then(responce => {
                    commit('SET_USERS', responce.data);
                })
                .catch(() => {
                    }
                )
        },
        CREATE_USER: ({getters}, user) => {
            AXIOS.post('/users',
                {
                    'id': user.id,
                    'login': user.login,
                    'firstName': user.firstName,
                    'lastName': user.lastName
                },
                {
                    headers:
                        {'Authorization': getters.getToken}
                }
            ).then(() => {
                // this.dispatch('GET_ALL_USERS');
            })

        },
        UPDATE_USER: ({getters}, user) => {
            AXIOS.put('/users/' + user.id,
                {
                    'id': user.id,
                    'login': user.login,
                    'firstName': user.firstName,
                    'lastName': user.lastName
                },
                {
                    headers:
                        {'Authorization': getters.getToken}
                }
            ).then(() => {
                // console.log(user);
                // this.dispatch('GET_ALL_USERS');
            })

        },
        DELETE_USER: ({getters}, user) => {
            AXIOS.delete('/users/' + user.id,
                {
                    headers:
                        {'Authorization': getters.getToken}
                }
            ).then(() => {
                // console.log(user);

            })

        }
    },
    mutations: {
        SET_USERS: (state, users) => {
            state.users = [];

            state.users = users;
        },
    }
};

export default userStore;