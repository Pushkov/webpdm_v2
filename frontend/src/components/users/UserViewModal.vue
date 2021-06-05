<template>
    <div class="nic-popup-body container-fluid">
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2 ">Id:</div>
            <b-input
                    class="col-sm text-secondary bg-light border rounded-lg"
                    readonly
                    :value="itemUser.id"
                    v-model="itemUser.id"
            />
        </div>
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2 ">Учетная запись:</div>
            <b-input
                    class="col-sm text-secondary bg-light border rounded-lg"
                    readonly
                    :value="item.login"/>
        </div>
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2 ">Имя:</div>
            <b-input
                    class="col-sm text-secondary bg-light border rounded-lg"
                    readonly
                    :value="item.firstName"/>
        </div>
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2">Фамилия:</div>
            <b-input
                    class="col-sm text-secondary bg-light border rounded-lg"
                    readonly
                    :value="item.lastName"/>
        </div>
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2">Buro:</div>
            <b-input
                    class="col-sm text-secondary bg-light border rounded-lg"
                    readonly
                    :value="(item.buro !== undefined) ? item.buro.name : 'пусто'"/>
        </div>
    </div>
</template>

<script>
    export default {
        name: "UserViewModal",
        data() {
            return {
                itemUser: {...this.item}
            }
        },
        props: {
            item: {
                type: Object,
                default: () => {
                    return {}
                }
            }
        },
        methods:{
        returnUser() {
            this.$emit('returnUser', this.itemUser);
        }
        }

    }
</script>

<style scoped>

</style>