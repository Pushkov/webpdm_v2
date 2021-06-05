<template>
    <div class="container-fluid">
        <div
                v-if="pages > 1 && pages < 5"
                class="row"
        >
            <div class="col-sm">
            </div>
            <div class="col-auto row">
                <div
                        class="col m-2 btn btn-outline-secondary"
                        @click="prevPage"
                ><i class="material-icons">keyboard_arrow_left</i>
                </div>
                <div
                        class="col m-2 btn btn-outline-secondary"
                        v-for="(p,index) in pages"
                        :key="index"
                        @click="selectPage(index)"
                >
                    {{p}}
                </div>
                <div
                        class="col m-2 btn btn-outline-secondary"
                        @click="nextPage"
                >
                    <i class="material-icons">keyboard_arrow_right</i>
                </div>
            </div>
            <div class="col-sm">
            </div>
        </div>
        <div
                v-if="pages >= 5"
                class="row"
        >
            <div class="col-sm">
            </div>
            <div class="col-auto row">
                <div
                        class="col m-2 btn btn-outline-secondary"
                        @click="prevPage"
                ><i class="material-icons">keyboard_arrow_left</i>
                </div>
                <div
                        v-if="page > 1"
                        class="col m-2 "
                >
                    ...
                </div>
                <div
                        v-if="page > 0"
                        class="col m-2 btn btn-outline-secondary"
                        @click="selectPage(page -1)"
                >
                    {{Number.parseInt(currentPage) - 1}}
                </div>
                <input
                        class=" col m-2 form-control"
                        @keydown.enter.capture="selectPage2"
                        :value="currentPage"/>
                <div
                        v-if="page < pages - 1"
                        class="col m-2 btn btn-outline-secondary"
                        @click="selectPage(page + 1)"
                >
                    {{Number.parseInt(currentPage) + 1}}
                </div>
                <div
                        v-if="page < pages - 2"
                        class="col m-2 "
                >
                    ...
                </div>
                <div
                        class="col m-2 btn btn-outline-secondary"
                        @click="nextPage"
                >
                    <i class="material-icons">keyboard_arrow_right</i>
                </div>
            </div>
            <div class="col-sm">
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "nic-pagination",
        props: {
            page: {
                type: Number,
                default: 0
            },
            pages: {
                type: Number,
                default: 1
            }
        },
        computed:{
            currentPage() {
                return this.page + 1 ;
            },
        },
        methods: {
            selectPage2() {
                let index = Number.parseInt(document.querySelector('input').value)
                this.$emit('selectPage', index);
            },
            selectPage(index) {
                this.$emit('selectPage', index);
            },
            prevPage() {
                let index = this.page - 1;
                if (index < 0)
                    index = 0;
                this.$emit('selectPage', index)
            },
            nextPage() {
                let index = this.page + 1;
                if (index >= this.pages - 1)
                    index = this.pages - 1 ;
                this.$emit('selectPage', index)
            }
        }
    }
</script>

<style scoped>

</style>