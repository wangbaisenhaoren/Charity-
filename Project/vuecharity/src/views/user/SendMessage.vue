<template>
    <div>
        <el-form label-position='left' ref="form" :model="form" label-width="80px" style="width: 300px">
            <el-form-item label="Telephone: ">
                <el-input v-model="form.phoneNumber" size="small">
                    <template slot="prepend">+44</template>
                </el-input>
            </el-form-item>
            <el-form-item label="Content: ">
                <el-input
                        type="textarea"
                        :rows="5"
                        placeholder="Please input the content..."
                        v-model="form.text">
                </el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="doSend">Send</el-button>
                <el-button >Clear</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "SendMessage",
        data() {
            return {
                form: {
                    phonerNumber: '',
                    text: ''
                }
            }
        },
        methods: {
            doSend() {
                this.postRequest('/message', this.form).then(resp => {
                    if (resp) {
                        this.initForm();
                    }
                })
            },
            initForm() {
                this.form.phoneNumber = '';
                this.form.text = '';
            }
        }
    }
</script>

<style scoped>

</style>