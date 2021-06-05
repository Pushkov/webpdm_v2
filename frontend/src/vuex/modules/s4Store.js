import {AXIOS} from "@/components/axios-export"

const s4Store = {
    state: {
        designation_error: false

    },
    getters: {
        DESIGNATION_ERROR: state => state.designation_error
    },
    actions: {
        SET_DESIGNATION_ERROR:({commit}, isError) =>{
            commit('SET_DESIGNATION_ERROR', isError);
        },

        FIND_IN_S4_BY_DESIGNATION: async ({commit, getters}, des) => {
            if (des !== '') {
                commit('SET_DESIGNATION_ERROR', false);
                await AXIOS.get('/s4/' + des,
                    {
                        headers:
                            {'Authorization': getters.getToken}
                    }
                )
                    .then(responce => {
                        const responceData = responce.data;

                        var binaryString = window.atob(responceData['fileBody']);
                        var binaryLen = binaryString.length;
                        var bytes = new Uint8Array(binaryLen);
                        for (var i = 0; i < binaryLen; i++) {
                            var ascii = binaryString.charCodeAt(i);
                            bytes[i] = ascii;
                        }
                        var blob = new Blob([bytes]);
                        var link = document.createElement('a');
                        link.href = window.URL.createObjectURL(blob);
                        var fileName = responceData['fileName'];
                        link.download = fileName;
                        link.click();
                    })
                    .catch(() => {
                        console.log("axios error");
                        commit('SET_DESIGNATION_ERROR', true);
                        }
                    )
            } else {
                commit('SET_DESIGNATION_ERROR', true);
            }

        }
    },
    mutations: {
        SET_DESIGNATION_ERROR: (state, isError) => {
            state.designation_error = isError;
        },

    }
};

export default s4Store;