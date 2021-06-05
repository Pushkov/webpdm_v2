<template>
    <div class=" w-75 m-auto">
        <NicModal
                v-if="isModalShow"
                :popup-title="getModalTitle"
                @closeNicModal="modalCLose"
                @confirmBtnAction="modalSuccess"
        >
            <UserViewModal
                    ref="userView"
                    v-if="!setEdit"
                    :item="item"
                    @returnUser='returnUser'

            />
            <UserAdminModal
                    ref="userAdmin"
                    v-if="setEdit"
                    :item="item"
                    @returnUser='returnUser'
            />
            <UserInfoTableFooter
                    slot="footer"
                    :is-admin="getPosition === 'ADMIN'"
                    :is-edit="setEdit"
                    @editItem="editItem"
                    @modalClose="modalCLose"
                    @saveUser='saveUser'
                    @deleteUser='deleteUser'
            />
        </NicModal>

        <table v-if="getPosition === 'ADMIN'" class="table table-hover border-top-0  text-left">
            <tr>
                <td>
                    <button
                            class="nic-btn-cansel text-black btn btn-outline-secondary rounded-lg"
                            @click="createUser"
                    >
                        Создать пользователя
                    </button>
                </td>
            </tr>
        </table>
        <table class="table table-hover table-bordered text-center">
            <thead class="thead-light">
            <th>Id</th>
            <th>Учетная запись</th>
            <th>Имя</th>
            <th>Должность</th>
            <th>Дата рождения</th>
            </thead>
            <tbody>
            <UserInfoTable
                    v-for="user of getUsers"
                    :user="user"
                    :key="user.id"
                    @modalShow="modalShow(user)"
            />
            </tbody>
        </table>
        <nic-pagination
                v-if="pages > 1"
                :page="page"
                :pages="pages"
                @selectPage="setPage"
        />
    </div>
</template>

<script>
    import UserInfoTable from "./UserInfoTable";
    import NicModal from "@/components/modals/nic-modal"
    import {mapGetters, mapActions} from 'vuex'
    import UserViewModal from "./UserViewModal";
    import UserAdminModal from "./UserAdminModal";
    import UserInfoTableFooter from "./UserInfoTableFooter";
    import NicPagination from "../nic-pagination";

    export default {
        name: "UsersList",
        components: {
            NicPagination,
            UserInfoTableFooter,
            UserAdminModal,
            UserViewModal,
            UserInfoTable,
            NicModal
        },
        data() {
            return {
                isModalShow: false,
                item: {},
                isEdit: false,

                page: 0,
                pages: 1,
                isUpdated: true
            }
        },
        computed: {
            ...mapGetters([
                'getToken',
                'getPosition',
                'USERS'
            ]),
            getModalTitle() {
                return this.isEdit ?
                    'Редактирование данных пользователя: ' + this.item.lastName + ' ' + this.item.firstName
                    :
                    'Информация о пользователе: ' + this.item.lastName + ' ' + this.item.firstName;
            },
            setEdit() {
                return this.isEdit;
            },
            getUsers() {
                return this.USERS
            }

        },
        watch: {
            USERS: {
                handler() {
                    if (!this.isUpdated){
                        this.GET_ALL_USERS();
                        this.isUpdated = true;
                    }
                },
                deep: true
            }
        },
        methods: {
            ...mapActions([
                'CLEAR_USERS_LIST',
                'GET_ALL_USERS',
                'CREATE_USER',
                'UPDATE_USER',
                'DELETE_USER'
            ]),
            modalShow(item) {
                this.item = item;
                this.isModalShow = true;
                this.isEdit = false;
            },
            modalCLose() {
                this.isModalShow = false;
            },
            modalSuccess() {
            },
            editItem(isEdit) {
                this.isEdit = isEdit;
            },
            setPage(page) {
                this.page = page;
            },
            createUser() {
                this.modalShow({});
                this.isEdit = true;

            },
           async saveUser() {
                this.$refs.userAdmin.returnUser()
                if (this.item.id === undefined)
                    this.CREATE_USER(this.item);
                else
                    this.UPDATE_USER(this.item);
                this.modalCLose();
               await this.updateUsersList();
            },
            async deleteUser() {
                 this.$refs.userView.returnUser()
                this.DELETE_USER(this.item);
                this.modalCLose();
               await this.updateUsersList();
            },
            returnUser(user) {
                this.item = user;
            },
            async updateUsersList() {
                this.isUpdated = false;
                await this.GET_ALL_USERS();
            }
        },
        mounted() {
            this.GET_ALL_USERS();
        }
    }
</script>

<style scoped>

</style>