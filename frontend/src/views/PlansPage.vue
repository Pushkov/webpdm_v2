<template>
    <div>
        <navbar/>
        <PlansHeader
                @selectMonth="selectMonth"
                @selectYear="selectYear"
                @selectBuro="selectBuro"
                @getCurrentPlan="getCurrentPlan"
        />

        <component
                :is="sortComponent"
                :first="nextPath"
                :ppList="PLANPOINTS"
        ></component>
    </div>
</template>

<script>
    import {mapActions, mapGetters} from 'vuex';
    import Navbar from "@/components/navbar";
    import PlansHeader from "../components/plans/PlansHeader";
    import PlanPointByBuro from "../components/plans/PlanPointByBuro";
    import PlanPointByYear from "../components/plans/PlanPointByYear";
    import PlanPointByMonth from "../components/plans/PlanPointByMonth";
    import PlanPointList from '../components/plans/PlanPointList';


    export default {
        name: "PlansPage",
        components: {
            PlanPointByBuro,
            PlanPointByYear,
            PlanPointByMonth,
            PlanPointList,
            PlansHeader,
            Navbar
        },
        computed: {
            ...mapGetters([
                'SORTING_BY',
                'PLANPOINTS',
                'GET_PLANPOINTS_BY_BURO_AND_DATE'
            ]),
            sortComponent() {
                if (this.sortingPath === 'b')
                    return 'PlanPointByBuro'
                if (this.sortingPath === 'm')
                    return 'PlanPointByMonth'
                if (this.sortingPath === 'y')
                    return 'PlanPointByYear'
                return 'PlanPointList'

            },
            sortingPath() {
                return this.SORTING_BY.substr(0, 1);
            },
            nextPath() {
                return this.SORTING_BY.substr(1, this.SORTING_BY.length - 1);
            }
        },
        methods: {
            ...mapActions([
                'SET_SORTING_BY',
                'GET_ALL_BUROS',
                'GET_ALL_PLANPOINTS'
            ]),
            selectMonth(month) {
                console.log('m ' + month);
            },
            selectYear(year) {
                console.log('y ' + year);
            },
            selectBuro(buroId) {
                console.log('b ' + buroId);
            },
            getCurrentPlan(){
                // this.GET_PLANPOINTS_BY_BURO_AND_DATE();
                console.log('current - ')
            }
        },
        mounted() {
            this.GET_ALL_BUROS();
            this.GET_ALL_PLANPOINTS();
        }
    }
</script>

<style scoped>

</style>