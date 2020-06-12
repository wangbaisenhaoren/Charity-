<template>
    <div class="userForm">
        <el-form label-position='left' ref="form" :model="form" label-width="80px" style="width: 300px">
            <el-form-item label="Username: ">
                <el-input v-model="form.username" size="small"></el-input>
            </el-form-item>
            <el-form-item label="Gender: ">
                <el-radio-group v-model="form.gender">
                    <el-radio label="Male"></el-radio>
                    <el-radio label="Female"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="Password: ">
                <el-input type="password" v-model="form.password" size="small" show-password></el-input>
            </el-form-item>
            <el-form-item label="Telephone: ">
                <el-input v-model="form.telephone" size="small">
                    <template slot="prepend">+44</template>
                </el-input>
            </el-form-item>
            <el-form-item label="Mail: ">
                <el-input v-model="form.mail" size="small" placeholder="myname@example.com"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="doRegister">Register</el-button>
                <el-button @click="cancel">Cancel</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "Register",
        data() {
            return {
                form: {
                    username: '',
                    gender: '',
                    password: '',
                    telephone: '',
                    mail: ''
                }
            }
        },
        methods: {
            doRegister() {
                this.postRequest('/register', this.form).then(resp => {
                    if (resp) {
                        this.$router.replace("/home");
                        this.initForm();
                    }
                })
            },
            initForm() {
                this.form.name = '';
                this.form.gender = '';
                this.form.password = '';
                this.form.telephone = '';
                this.form.mail = '';
            },
            cancel() {
                this.$confirm('Do you wanna cancel the registration?', 'Tips', {
                    confirmButtonText: 'Confirm',
                    cancelButtonText: 'Cancel',
                    type: 'warning'
                }).then(() => {
                    this.$router.replace("/home");
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: 'Cancel the registration!'
                    });
                });
            }
        }
    }
</script>

<style scoped>

</style>