<template>
    <div>
        <navbar/>
        <div class="jumbotron">
            AdminPage
        </div>
    </div>
</template>

<script>
    import Navbar from "@/components/navbar";
    import {mapActions, mapGetters} from 'vuex'

    export default {
        name: "AdminPage",
        data() {
            return {
                isNicModal: false
            }
        },
        components: {
            Navbar
        },
        computed: {
            ...mapGetters([
            ])
        },
        methods: {
            ...
                mapActions([
                ])
        }
    }
</script>

<style scoped>
</style>