<template>
    <div class="h-screen bg-yellow-200">
        <NavBlank/>
        <div class="container" style="margin-top: 10%">
            <div class="jumbotron">

                <form class="form-inline justify-content-center">
                    <h1>Error</h1>
                </form>

            </div>
        </div>
    </div>
</template>

<script>

    import NavBlank from "@/components/nav_blank";
    import {mapActions} from "vuex";

    export default {
        name: "ErrorPage",
        components: {NavBlank},
        methods: {
            ...mapActions([
            ])
        }
    }
</script>

<style scoped>

</style>