const appStore = {
    state:{
        monthes:[
            {name:'Все месяцы', value: -1},
            {name:'Январь', value: 0},
            {name:'Февраль', value: 1},
            {name:'Март', value: 2},
            {name:'Апрель', value: 3},
            {name:'Апрель', value: 4},
            {name:'Июнь', value: 5},
            {name:'Июль', value: 6},
            {name:'Август', value: 7},
            {name:'Сентябрь', value: 8},
            {name:'Октябрь', value: 9},
            {name:'Ноябрь', value: 10},
            {name:'Декабрь', value: 11},
        ],
        years:[],
        borderMonth: 2
    },
    getters:{
        MONTHES: state => state.monthes,
        YEARS(state){
            class yearInSelect{
                constructor(name,value) {
                    this.name = name;
                    this.value = value;
                }
            }
            state.years.push(
                new yearInSelect('Все года',-1)
            );
            let lastYear = new Date().getFullYear();
            if (new Date().getMonth() > state.borderMonth)
                lastYear ++;
            let firstYear = 2012;
            while (lastYear >= firstYear){
                state.years.push(
                    new yearInSelect(lastYear,lastYear)
                );
                lastYear--;
            }
            return state.years;
        },
    },
    actions:{


    },
    mutaions:{
    }
};

export default appStore;