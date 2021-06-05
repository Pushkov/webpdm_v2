<template>
    <div>
        <navbar/>
        Users page
        <hr/>
        <UsersList/>
        <hr/>
    </div>
</template>

<script>
    import Navbar from "@/components/navbar";
    import {mapActions, mapGetters} from "vuex";
    import UsersList from "../components/users/UsersList";

    export default {
        name: "Users",
        components: {
            UsersList,
            Navbar
        },
        computed: {
            ...mapGetters([

                'getToken'
            ])
        },
        methods:{
            ...mapActions([
                'AUTH_LOGOUT'
            ]),
        },
        mounted() {
        }
    }
</script>

<style scoped>

</style>