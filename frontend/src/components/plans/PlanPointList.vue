<template>
    <div class="mt-4 ml-3" v-if="ppList.length !== 0">
        <p
        v-for="pp in ppList"
        :key="pp.id"
        >{{getMonth(pp.startDate)}} *** {{getYear(pp.startDate)}}</p>
    </div>
    <div v-else> ничего нет </div>
</template>

<script>
    export default {
        name: "PlanPointList",
        props:{
            ppList:{
                type: Array,
                default: () => {
                    return []
                }
            }
        },
        methods:{
            getMonth: date => {
                const d = new Date(date);
                return d.getMonth();

            },
            getYear(date){
                const d = new Date(date);
                return d.getFullYear();
            }
        }
    }
</script>

<style scoped>

</style>