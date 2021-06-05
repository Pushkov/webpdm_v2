<template>
    <div>
        <navbar/>
        <div class="jumbotron">
            <h4>Token: {{getToken}}</h4>
            <br/>
<s4-page/>
        </div>
    </div>
</template>

<script>
    import Navbar from "@/components/navbar";
    import {mapActions, mapGetters} from 'vuex'
    import S4Page from "../components/s4/s4Page";


    export default {
        name: "IndexPage",
        data() {
            return {
                isNicModal: false
            }
        },
        components: {
            S4Page,
            Navbar
        },
        computed: {
            ...mapGetters([
                'getToken'
            ])
        },
        methods: {
            ...mapActions([
                    'AUTH_LOGOUT'
                ]),

        },
        mounted() {
            if(!this.getToken || this.getToken === ''){
                this.$router.push('/login');
                // console.log('not est token')
            }
        }
    }
</script>

<style scoped>
</style>