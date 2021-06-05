<template>
    <div class="row pt-2 px-5">
        <div class="col text-right">
            <button
                    class="btn btn-outline-secondary h-100 w-50"
                    @click="getCurrentPlan"
            >
                Текущий
            </button>
        </div>
        <div class="col">
            <label>Год: </label>
            <select
                    class="m-0 form-control"
                    @change="selectYear"
                    :value="CURRENT_YEAR"
            >
                <option
                        v-for="y in YEARS"
                        :key="y.value"
                        :value="y.value"
                >
                    {{y.name}}
                </option>
            </select>
            <input
                    type="radio"
                    name="sorting"
                    class="m-2"
                    v-model='sortBy'
                    :value="'ymbe'"
            ><span
                class="m-2 sel_span"
                @click="setSortingBy('ymbe')"
        >Сортировка по годам</span>
        </div>
        <div class="col">
            <label>Месяц:</label>
            <select
                    class="m-0 form-control"
                    @change="selectMonth"
                    :value="CURRENT_MONTH"
            >
                <option
                        v-for="m in MONTHES"
                        :key="m.value"
                        :value="m.value"
                >
                    {{m.name}}
                </option>
            </select>
            <input
                    type="radio"
                    name="sorting"
                    class="m-2"
                    v-model='sortBy'
                    :value="'mbye'"
            ><span
                class="m-2 sel_span"
                @click="setSortingBy('mbye')"
        >Сортировка по месяцам</span>

        </div>
        <div class="col">
            <label>Бюро:</label>
            <select
                    class="m-0 form-control"
                    @change="selectBuro"
            >
                <option
                        v-for="m in BUROS"
                        :key="m.id"
                        :value="m.id"
                >
                    {{m.name}}
                </option>
            </select>
            <input
                    type="radio"
                    name="sorting"
                    class="m-2"
                    v-model='sortBy'
                    :value="'byme'"
            ><span
                class="m-2 sel_span"
                @click="setSortingBy('byme')"
        >Сортировка по бюро</span>

        </div>
        <div class="col text-left">
            <button
                    class="btn btn-outline-secondary h-100 w-50"
                    @click="setSortingBy('e')"
            >Все
            </button>
        </div>
    </div>
</template>

<script>
    import {mapActions, mapGetters} from 'vuex'

    export default {
        name: "PlansHeader",
        data(){
            return{
            }
        },
        computed: {
            ...mapGetters([
                'MONTHES',
                'CURRENT_MONTH',
                'YEARS',
                'CURRENT_YEAR',
                'SORTING_BY',
                'BUROS'
            ]),
            sortBy:{
                get: function () {
                    return this.SORTING_BY
                },
                set: function (sort) {
                    return this.SET_SORTING_BY(sort)
                }
            }
        },
        methods: {
            ...mapActions([
                'SET_CURRENT_MONTH',
                'SET_SORTING_BY',
                'GET_PLANPOINTS_BY_BURO_AND_DATE'

            ]),
            selectMonth(e) {
                this.$emit('selectMonth',e.target.value);
            },
            selectYear(e) {
                this.$emit('selectYear',e.target.value);
            },
            selectBuro(e){
                this.$emit('selectBuro',e.target.value);
            },
            setSortingBy(sort){
                this.SET_SORTING_BY(sort);
            },
            getCurrentPlan(){
                this.$emit('getCurrentPlan');
            }
        },
        mounted() {
            if(localStorage.getItem('pp-sortBy'))
                this.SET_SORTING_BY(localStorage.getItem('pp-sortBy'));

        }
    }
</script>

<style scoped>

.sel_span:hover{
    cursor: pointer;
}

</style>