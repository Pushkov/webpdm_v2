<template>
    <div>
        <b-navbar toggleable="lg" type="dark" variant="secondary">
            <b-navbar-brand>
                <i class="material-icons">face</i>
                <span v-if="isAuthenticated">  {{getUsername}}</span>
            </b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                    <b-nav-item href="#">
                        <router-link to="/pdm">
                            Стартовая
                        </router-link>
                    </b-nav-item>
                    <b-nav-item href="#">
                        <router-link to="/pdm/title">
                            Титульный список
                        </router-link>
                    </b-nav-item>
                    <b-nav-item href="#">
                        <router-link to="/pdm/plans">
                            Планы УПиР
                        </router-link>
                    </b-nav-item>
                    <b-nav-item href="#">
                        <router-link to="/pdm/projects">
                            Проекты
                        </router-link>
                    </b-nav-item>
                    <b-nav-item href="#">
                        <router-link to="/pdm/documents">
                            Документы
                        </router-link>
                    </b-nav-item>
                    <b-nav-item href="#">
                        <router-link to="/pdm/users">
                            Пользователи
                        </router-link>
                    </b-nav-item>
                </b-navbar-nav>

                <b-dropdown text="Меню" right variant="outline-light" class="ml-auto col-xl-1">
                    <b-dropdown-item href="#">
                            User data
                    </b-dropdown-item>
                    <b-dropdown-divider></b-dropdown-divider>
                    <b-dropdown-item>
                        <router-link to="/pdm/login">
                            login
                        </router-link>
                    </b-dropdown-item>
                    <b-dropdown-item>
                        <router-link to="/pdm/index">
                            Index
                        </router-link>
                    </b-dropdown-item>
                    <b-dropdown-item>
                        <router-link to="/pdm/admin">
                            Admin
                        </router-link>
                    </b-dropdown-item>
                    <b-dropdown-item @click="signout">
                        LogOut
                    </b-dropdown-item>
                </b-dropdown>
            </b-collapse>
        </b-navbar>
    </div>
</template>

<script>
    import {mapGetters} from 'vuex'
    import {mapActions} from "vuex";
    // import {AXIOS} from "../components/axios-export";
    export default {
        name: 'navbar',
        computed: {
            ...mapGetters([
                'getUsername',
                'getPosition',
                'isAuthenticated'
            ])
        },
        methods: {
            ...mapActions([
                'AUTH_LOGOUT'
            ]),
            signout() {
                // AXIOS.post('/auth/logout');
                this.AUTH_LOGOUT();
                this.$router.push("/login");
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

    nav {
        margin: auto;
        background-color: #2c3e50;
    }
</style>
