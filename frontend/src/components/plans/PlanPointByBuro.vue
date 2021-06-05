<template>
    <div class="">
        <div
                v-for="buro in BUROS"
                :key="buro.id"
                class=""
        >
            <div class="mt-4 ml-3 accordion-item" v-if="sortedList(buro).length !== 0">
                <span class="accordion-item-head" @click="accordion">    {{buro.name}}    </span>
                <div class="accordion-item-body">
                    <component
                            :is="sortComponent"
                            :first="nextPath"
                            :ppList="sortedList(buro)"
                    ></component>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import {mapGetters} from 'vuex'

    export default {
        name: 'PlanPointByBuro',
        components: {
            PlanPointByMonth: () => import('./PlanPointByMonth'),
            PlanPointByYear: () => import('./PlanPointByYear'),
            PlanPointList: () => import('./PlanPointList'),
        },
        props: {
            first: {
                type: String,
                default: 'e'
            },
            ppList: {
                type: Array,
                default: () => {
                    return []
                }
            }
        },
        computed: {
            ...mapGetters([
                'BUROS'
            ]),
            sortComponent() {
                if (this.sortingPath === 'm')
                    return 'PlanPointByMonth'
                if (this.sortingPath === 'y')
                    return 'PlanPointByYear'
                return 'PlanPointList'
            },
            sortingPath() {
                return this.first.substr(0, 1);
            },
            nextPath() {
                return this.first.substr(1, this.first.length - 1);
            },
        },
        methods: {
            accordion: function (event) {
                // Раскомментировать, если нужно, чтобы закрывались остальные пункты при открытии текущего
                //   var matches = document.querySelectorAll('.accordion-item-head');
                //   for(var i = 0; i < matches.length; i++) {
                //       matches[i].classList.remove('active');
                //    }
                event.target.classList.toggle('active');
            },
            sortedList(buro) {
                return this.ppList.filter(x => x.buro.id === buro.id)
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