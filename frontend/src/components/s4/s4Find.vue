<template>
    <div>
        <div class="row my-1 mx-2">
            <div class="col-2 mr-2 "><h5>Обозначение:</h5></div>
            <b-input
                    ref="find_designation"
                    @focus="SET_DESIGNATION_ERROR(false)"
                    class="col-sm text-secondary bg-light border rounded-lg"
                    :class="dangerclass"
                    v-model="findDesignation"/>
            <b-button
                    class="col-2 ml-5"
                    @click="findByDesignation"
            >ИСКАТЬ
            </b-button>
        </div>
    </div>
</template>

<script>
    import {mapGetters,mapActions} from 'vuex'

    export default {
        name: "s4Find",
        data(){
          return {
              findDesignation:""
          }
        },
        computed:{
            ...mapGetters([
                'DESIGNATION_ERROR'
            ]),
            dangerclass(){
                return this.DESIGNATION_ERROR ?'border border-danger' : '';
            }
        },
        methods:{
            ...mapActions([
                'SET_DESIGNATION_ERROR',
                'FIND_IN_S4_BY_DESIGNATION'
            ]),
            findByDesignation(){
                console.log("s4 find - " + this.findDesignation);
                this.FIND_IN_S4_BY_DESIGNATION(this.findDesignation);
            }
        }
    }
</script>

<style scoped>

</style>