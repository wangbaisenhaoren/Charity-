<template>
    <div>
        <el-form label-position='left' ref="form" :model="form" label-width="100px" style="width: 300px">
            <el-form-item label="CharityName: ">
                <el-input v-model="form.charityName" size="small"></el-input>
            </el-form-item>
            <el-form-item label="Address: ">
                <el-input v-model="form.address" size="small"></el-input>
            </el-form-item>
            <el-form-item label="PostCode: ">
                <el-input v-model="form.postcode" size="small"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="doApply">Apply</el-button>
                <el-button @click="cancel">Cancel</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "ApplyCharity",
        data() {
            return {
                user: JSON.parse(window.sessionStorage.getItem("user")),
                form: {
                    charityName: '',
                    address: '',
                    postcode: ''
                }
            }
        },
        methods: {
            doApply() {
                this.$confirm('Do you wanna apply charity?', 'Tips', {
                    confirmButtonText: 'Confirm',
                    cancelButtonText: 'Cancel',
                    type: 'info'
                }).then(() => {
                    this.user.roleId = 4;
                    this.putRequest('/user', this.user);
                    this.postRequest('/apply', this.form).then(resp => {
                        if (resp) {
                            this.$router.replace("/home");
                            this.initForm();
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: 'Apply successfully!'
                    });
                });
            },
            cancel() {
                alert(this.user)
            }
        }
    }
</script>

<style scoped>

</style>