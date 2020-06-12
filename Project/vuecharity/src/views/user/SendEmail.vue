<template>
    <div>
        <el-form label-position='left' ref="form" :model="form" label-width="80px" style="width: 300px">
            <el-form-item
                    label="Subject: "
                    :rules="[
                        { required: true, message: 'Please input the subject', trigger: 'blur'},
                     ]">
                <el-input v-model="form.subject" size="small">
                </el-input>
            </el-form-item>
            <el-form-item
                    label="Email: "
                    :rules="[
                        { required: true, message: 'Please input the email', trigger: 'blur'},
                     ]">
                <el-input v-model="form.toMailAddress" size="small">
                </el-input>
            </el-form-item>
            <el-form-item
                    label="Content: "
                    :rules="[
                        { required: true, message: 'Please input the content', trigger: 'blur'},
                     ]">
                <el-input
                        type="textarea"
                        :rows="7"
                        placeholder="Please input the content..."
                        v-model="form.content">
                </el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="doSend">Send</el-button>
                <el-button @click="clearForm">Clear</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "SendEmail",
        data() {
            return {
                form: {
                    subject: '',
                    toMailAddress: '',
                    content: ''
                }
            }
        },
        methods: {
            doSend() {
                var regEmail = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
                if (this.form.toMailAddress !== '' && !regEmail.test(this.form.toMailAddress)) {
                    this.$message({
                        message: 'Please input the correct email!',
                        type: 'error'
                    })
                    this.form.toMailAddress = ''
                } else {
                    this.postRequest('/email', this.form).then(resp => {
                        if (resp) {
                            this.initForm();
                        }
                    })
                }
            },
            clearForm() {
                this.initForm();
            },
            initForm() {
                this.form.subject = '';
                this.form.toMailAddress = '';
                this.form.content = '';
            },
        }
    }
</script>

<style scoped>

</style>
