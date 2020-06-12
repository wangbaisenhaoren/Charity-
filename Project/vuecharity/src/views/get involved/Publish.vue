<template>
    <div>
        <el-form label-position='left' ref="form" :model="form" label-width="100px" style="width: 300px">
            <el-form-item label="ProjectName: ">
                <el-input v-model="form.projectName" size="small" placeholder="Project Name"></el-input>
            </el-form-item>
            <el-form-item label="ExpireDate: " prop="termOfValidity" class="labelTitle" label-width="100px" >
                <el-date-picker
                        style="width: 200px;"
                        v-model="form.expireDate"
                        align="right"
                        type="date"
                        placeholder="Choose Date"
                        value-format="yyyy-MM-dd"
                        :picker-options="pickerOptions">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="Money: ">
                <el-input v-model="form.targetMoney" size="small" placeholder="Target money"></el-input>
            </el-form-item>
            <el-form-item label="Description: ">
                <el-input type="textarea" :rows="8" v-model="form.description" size="small" placeholder="Please input the content..."></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="doCreate">Create</el-button>
                <el-button @click="cancel">Cancel</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>

<script>
    export default {
        name: "Publish",
        data() {
            return {
                user: JSON.parse(window.sessionStorage.getItem("user")),
                form: {
                    userId: '',
                    charityId: '',
                    projectName: '',
                    createDate: '',
                    expireDate: '',
                    targetMoney: '',
                    totalMoney: '',
                    status: '',
                    description: '',
                    link: ''
                },
                pickerOptions: {
                    disabledDate(time) {
                        return time.getTime() < Date.now();
                    },
                    shortcuts: [{
                        text: 'One week',
                        onClick(picker) {
                            const date = new Date();
                            date.setTime(date.getTime() + 3600 * 1000 * 24 * 7);
                            picker.$emit('pick', date);
                        }
                    }, {
                        text: 'One month',
                        onClick(picker) {
                            const date = new Date();
                            date.setTime(date.getTime() + 3600 * 1000 * 24 * 30);
                            picker.$emit('pick', date);
                        }
                    }, {
                        text: 'Three months',
                        onClick(picker) {
                            const date = new Date();
                            date.setTime(date.getTime() + 3600 * 1000 * 24 * 90);
                            picker.$emit('pick', date);
                        }
                    }]
                }
            }
        },
        mounted() {
            this.getCharityId();
        },
        methods: {
            doCreate() {
                this.$confirm('Do you wanna create the project?', 'Tips', {
                    confirmButtonText: 'Confirm',
                    cancelButtonText: 'Cancel',
                    type: 'info'
                }).then(() => {
                    this.form.userId = this.user.userId;
                    this.form.createDate = this.formatDate(new Date());
                    this.form.totalMoney = 0;
                    this.form.status = "0";
                    this.form.link = "https://twitter.com/intent/tweet?text=" + this.form.projectName;
                    this.postRequest('/project', this.form).then(resp => {
                        if (resp) {
                            this.$router.replace("/home");
                            this.initForm();
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: 'Publish successfully!'
                    });
                });
            },
            initForm() {
                this.form.userId = '';
                this.form.charityId = '';
                this.form.projectName = '';
                this.form.createDate = '';
                this.form.expireDate = '',
                this.form.money = '';
                this.form.status = '';
                this.form.description = '';
            },
            getCharityId() {
                this.getRequest("/charity?userId=" + this.user.userId).then(resp=>{
                    if (resp) {
                        this.form.charityId = resp.charityId;
                    }
                })
            },
            cancel() {
                // alert(this.formatDate(new Date()))
            },
            formatDate(date) {
                let y = date.getFullYear();
                let m = date.getMonth() + 1;
                m = m < 10 ? '0' + m : m;
                let d = date.getDate();
                d = d < 10 ? ('0' + d) : d;
                return y + '-' + m + '-' + d;
            }
        }
    }
</script>

<style scoped>

</style>
