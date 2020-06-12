<template>
    <div>
        <el-form :rules="rules" ref="loginForm" :model="loginForm" class="loginContainer">
            <h3 class="loginTitle">Login</h3>
            <el-form-item prop="username">
                <el-input type="text" v-model="loginForm.username" auto-complete="off" placeholder="Please enter username"></el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input type="password" v-model="loginForm.password" auto-complete="off" placeholder="Please enter password"></el-input>
            </el-form-item>
            <el-button type="primary" style="width: 40%; margin-left: 30px" @click="submitLogin">Submit</el-button>
            <el-button type="danger" style="width: 40%;" @click="submitVisitor">Visitor</el-button>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                loginForm: {
                    username: 'zzhou',
                    password: '123'
                },
                checked:true,
                rules: {
                    username: [{required: true, message:'username', trigger:'blur'}],
                    password: [{required: true, message:'password', trigger:'blur'}]
                }
            }
        },
        methods: {
            submitLogin() {
                this.$refs.loginForm.validate((valid) => {
                    if (valid) {
                        this.postKeyValueRequest('/doLogin', this.loginForm).then(resp => {
                            if (resp) {
                                window.sessionStorage.setItem("user", JSON.stringify(resp.obj))
                                this.$router.replace('/home')
                            }
                        })
                    } else {
                        return false;
                    }
                })
            },
            submitVisitor() {
                this.$router.replace('/home');
            }
        }
    }
</script>

<style>
    .loginContainer {
        border-radius: 15px;
        background-clip: padding-box;
        margin: 180px auto;
        width: 350px;
        padding: 15px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }
    .loginTitle {
        margin: 15px auto 20px auto;
        text-align: center;
        color: #505458;
    }
    .loginRemember {
        text-align: left;
        margin: 0px 0px 15px 0px;
    }
</style>
