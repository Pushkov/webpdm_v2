<template>
    <div>
        <div class="accordion" role="tablist">
            <b-card no-body class="mb-1">
                <b-card-header header-tag="header" class="p-0" role="tab">
                    <b-button block v-b-toggle.accordion-1 variant="secondary"><h5>Поиск файла</h5></b-button>
                </b-card-header>
                <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
                    <b-card-body>
                        <s4-find/>
                    </b-card-body>
                </b-collapse>
            </b-card>

            <b-card no-body class="mb-1">
                <b-card-header header-tag="header" class="p-0" role="tab">
                    <b-button block v-b-toggle.accordion-2 variant="secondary"><h5>Регистрация файла</h5></b-button>
                </b-card-header>
                <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
                    <b-card-body>
                        <s4-register/>
                    </b-card-body>
                </b-collapse>
            </b-card>
        </div>




    </div>
</template>

<script>
    import S4Find from "./s4Find";
    import S4Register from "./s4Register";
    export default {
        name: "s4Page",
        components: {S4Register, S4Find}
    }
</script>

<style scoped>

</style>