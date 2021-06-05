<template>
    <tr
            @click="userInModal"
    >
        <td>{{user.id}}</td>
        <td>{{user.login}}</td>
<!--        <td>{{user.lastName}}</td>-->
        <td>{{user.firstName}}</td>
        <td>{{user.positionName}}</td>
        <td>{{user.birthday}}</td>
    </tr>
</template>

<script>

    export default {
        name: "UserInfoTable",
        props: {
            user: {
                type: Object,
                default: () => {
                    return {}
                }
            }
        },
        methods: {
            userInModal(user) {

                this.$emit('modalShow', user);
            }
        },
    }
</script>

<style scoped>

</style>