const planStore = {
    state:{
        currentMonth: 1,
        currentYear: 2020,
        sortingBy: ''
    },
    getters:{
        CURRENT_MONTH: state => state.currentMonth,
        CURRENT_YEAR: state => state.currentYear,
        SORTING_BY: state => state.sortingBy
    },
    actions:{
        SET_CURRENT_MONTH: ({commit}, month) => {
            commit('SETCURRENTMONTH', month);
        },
        SET_SORTING_BY: ({commit}, sortBy) => {
            commit('SETSORTINGBY', sortBy);
            localStorage.setItem('pp-sortBy', sortBy);
        }
    },
    mutations:{
        SETCURRENTMONTH: (state, month) => {
            state.currentMonth = month
        },
        SETSORTINGBY: (state, sortBy) => {
            state.sortingBy = sortBy
        }
    }
};

export default planStore;