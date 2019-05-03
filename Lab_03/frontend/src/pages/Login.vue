<template>
    <div id="login">
        <b-form @submit.prevent="onSubmit" class="center">
            <b-form-group id="login"
                          label-for="login"
                          label="Введите логин:">
                <b-form-input id="login"
                              v-model="form.username"
                              placeholder="Введите логин:"
                              required>
                </b-form-input>
            </b-form-group>
            <b-form-group id="password"
                          label="Введите пароль:"
                          label-for="password">
                <b-form-input id="password"
                              type="password"
                              v-model="form.password"
                              placeholder="Введите пароль:"
                              required>
                </b-form-input>
            </b-form-group>
            <b-button variant="ring" @click="onSubmit()">Войти</b-button>
        </b-form>
    </div>
</template>

<script>
    export default {
        name: 'Login',
        data() {
            return {
                form: {
                    username: '',
                    password: ''
                },
                error: ''
            }
        },
        methods: {
            onSubmit() {
                alert(JSON.stringify(this.form));
                this.$router.push("/main");
            }
        }
    }
</script>

<style scoped>
.center {
    width: 500px;
    border: 1px solid #CCCCCC;
    background-color: #f3f2f3;
    margin: auto;
    margin-top: 200px;
    padding: 20px;
}
</style>
