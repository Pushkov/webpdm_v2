<template>
    <div class="">
        <div
                v-for="year in YEARS"
                :key="year.value"
        >
            <div v-if="year.value !== -1">
                <div class="mt-4 ml-3 accordion-item" v-if="sortedList(year.value).length !== 0">
                    <span class="accordion-item-head" @click="accordion">{{year.name}}</span>
                    <div class="accordion-item-body">
                        <component
                                :is="sortComponent"
                                :first="nextPath"
                                :ppList="sortedList(year.value)"
                        ></component>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import {mapActions, mapGetters} from 'vuex'

    export default {
        name:'PlanPointByYear',
        props: {
            first: {
                type: String,
                default: 'e'
            },
            ppList:{
                type: Array,
                default: () => {
                    return []
                }
            }
        },
        components: {

            PlanPointByBuro:() => import('./PlanPointByBuro'),
            PlanPointByMonth:() => import('./PlanPointByMonth'),
            PlanPointList:() => import('./PlanPointList'),
        },
        computed: {
            ...mapGetters([
                'YEARS'
            ]),
            sortComponent(){
                if(this.sortingPath === 'b')
                    return 'PlanPointByBuro'
                if(this.sortingPath === 'm')
                    return 'PlanPointByMonth'
                return 'PlanPointList'
            },
            sortingPath() {
                return this.first.substr(0, 1);
            },
            nextPath() {
                return this.first.substr(1, this.first.length - 1);
            }
        },
        methods: {
            ...mapActions([]),
            accordion: function (event) {
                //Раскомментировать, если нужно, чтобы закрывались остальные пункты при открытии текущего
                //   var matches = document.querySelectorAll('.accordion-item-head');
                //   for(var i = 0; i < matches.length; i++) {
                //       matches[i].classList.remove('active');
                //    }
                event.target.classList.toggle('active');
                // console.log('accord click' + event);
            },
            sortedList(year) {
                return this.ppList.filter(x => this.getYear(x.startDate) === year)
            },
            getYear(date){
                const d = new Date(date);
                return d.getFullYear();
            }
        },
    }
</script>

<style scoped>
    .accordion-item {
        position: relative;
    }

    .accordion-item-head {
        background-color: #dfdfdf;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
        cursor: pointer;
        padding: 10px;
    }


    .accordion-item-head:after {
        content: ' > ';
        display: block;
        height: 29px;
        position: absolute;
        right: 25px;
        transform: rotate(90deg) scaleY(2);
        top: 8px;
    }

    .accordion-item-head.active:after {
        content: ' < ';
    }


    .accordion-item-body {
        display: none;
    }

    .accordion-item-head.active + .accordion-item-body {
        display: block !important;
    }
</style>