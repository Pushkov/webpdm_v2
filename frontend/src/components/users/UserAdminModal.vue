<template>
    <div class="nic-popup-body container-fluid">
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2 ">Id:</div>
            <b-input
                    class="col-sm text-secondary bg-light border rounded-lg"
                    readonly
                    :value="item.id"/>
        </div>
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2 ">Учетная запись:</div>
            <b-input
                    class="col-sm text-secondary bg-light border rounded-lg"
                    :value="itemUser.login"
                    v-model="itemUser.login"
            />
        </div>
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2 ">Для пароля:</div>
            <b-input
                    class="col-sm text-secondary bg-light border rounded-lg"
            />
        </div>
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2 ">Имя:</div>
            <b-input
                    class="col-sm text-secondary bg-light border rounded-lg"
                    :value="itemUser.firstName"
                    v-model="itemUser.firstName"
            />
        </div>
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2">Фамилия:</div>
            <b-input
                    class="col-sm text-secondary bg-light border rounded-lg"
                    :value="item.lastName"/>
        </div>
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2">Buro:</div>
            <select
                    class="col-sm text-secondary bg-light border rounded-lg form-control"
            >
                <option
                        v-for="m in BUROS"
                        :key="m.id"
                        :value="m.id"
                >
                    {{m.name}}
                </option>
            </select>

        </div>
    </div>
</template>

<script>
    import {mapActions, mapGetters} from 'vuex';

    export default {
        name: "UserAdminModal",
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
        computed: {
            ...mapGetters([
                'BUROS'
            ])
        },
        methods: {
            ...mapActions([
                'GET_ALL_BUROS'
            ]),
            returnUser() {
                // console.log('returnUser');
                this.$emit('returnUser', this.itemUser);
            }
        },
        mounted() {
            if (this.BUROS.length === 0)
                this.GET_ALL_BUROS();
        }
    }
</script>

<style scoped>

</style>