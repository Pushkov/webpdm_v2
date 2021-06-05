<template>
    <div class="h-screen bg-yellow-200">
        <NavBlank/>
        <div class="container" style="margin-top: 10%">
            <div class="jumbotron " :class="dangerclass">

                <form class="form-inline justify-content-center"  @submit.prevent="auth_login">
                    <label class="mr-lg-2">Пользователь:</label>
                    <input type="text" v-model="login" placeholder="ЛОГИН" class="form-control mr-lg-2">
                    <label class="mr-lg-2">Пароль:</label>
                    <input type="password" v-model="password" placeholder="ПАРОЛЬ" class="form-control mr-lg2-2">
                    <button type="submit" class="btn btn-secondary ml-lg-2">Вход</button>
                </form>
                <div v-if="authStatus === 'error'" class="text-center mt-5 ">
                    <h4 class="text-danger">Проверьте введенные данные </h4>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
    import {AXIOS} from "@/components/axios-export"
    import NavBlank from "@/components/nav_blank";
    import {mapGetters, mapActions} from 'vuex';

    export default {
        name: "LoginPage",
        data() {
            return {
                login: '',
                password: ''
            }
        },
        computed: {
            ...mapGetters([
                'isAuthenticated',
                'authStatus',
                'getToken'
            ]),
            dangerclass(){
                return this.authStatus === 'error' ? 'border border-danger' : '';
            }
        },
        components: {NavBlank},
        methods: {
            ...mapActions([
                'AUTH_LOGIN',
                'AUTH_ERROR'
            ]),


            auth_login() {
                AXIOS.post('/auth/login', {'login': this.login, 'password': this.password})
                    .then(responce => {
                            this.AUTH_LOGIN({
                                'token': responce.data.token,
                                'position': responce.data.position,
                                'login': responce.data.login
                            })
                        if(localStorage.getItem('path-to') && localStorage.getItem('path-to') !== '/login') {
                            const url = localStorage.getItem('path-to');
                            localStorage.removeItem('path-to');
                            this.$router.push(url);
                        }
                        else{
                            localStorage.removeItem('path-to');
                            this.$router.push('/');
                        }
                        }
                    )
                    .catch(() => {
                        this.AUTH_ERROR();
                        localStorage.removeItem('user-token');
                    }
                )
            },

        }
    }
</script>

<style scoped>

</style>