<template>
    <div class="userForm">
        <el-form label-position='left'  label-width="80px" style="width: 300px">
            <el-form-item label="Username: ">
                <el-input v-model="user.username" size="small" readonly></el-input>
            </el-form-item>
            <el-form-item label="Charity: ">
                <el-select v-model="value" placeholder="Please choose">
                    <el-option
                            v-for="item in charities"
                            :label="item.charityName"
                            :value="item.charityId">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="applyVolunteer">Apply</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "Register",
        data() {
            return {
                user: JSON.parse(window.sessionStorage.getItem("user")),
                value: '',
                charities: '',
                form: {
                    userId: '',
                    charityId: '',
                    username: '',
                    charityName: ''
                }
            }
        },
        mounted() {
            this.initCharities();
        },
        methods: {
            initCharities() {
                this.getRequest("/charities").then(resp=>{
                    if (resp) {
                        this.charities = resp;
                    }
                })
            },
            initForm() {
                this.form.userId = '';
                this.form.charityId = '';
                this.form.username = '';
                this.form.charityName = '';
            },
            applyVolunteer() {
                this.$confirm('Do you wanna apply volunteer?', 'Tips', {
                    confirmButtonText: 'Confirm',
                    cancelButtonText: 'Cancel',
                    type: 'info'
                }).then(() => {
                    this.user.roleId = 2;
                    this.putRequest('/user', this.user);
                    this.form.userId = this.user.userId;
                    this.form.charityId = this.value;
                    this.form.username = this.user.username;
                    this.charities.forEach(item=>{
                        if (item.charityId === this.value) {
                            this.form.charityName = item.charityName;
                        }
                    })
                    this.postRequest('/volunteer', this.form).then(resp => {
                        if (resp) {
                            this.initForm();
                            this.$router.replace("/home");
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: 'Apply successfully!'
                    });
                });
            }
        }
    }
</script>

<style scoped>

</style>