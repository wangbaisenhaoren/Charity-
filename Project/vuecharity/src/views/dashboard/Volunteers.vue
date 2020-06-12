<template>
    <div>
        <div>
            <el-table
                    :data="volunteers"
                    stripe
                    style="width: 100%">
                <el-table-column
                        prop="volunteerId"
                        label="ID"
                        width="50">
                </el-table-column>
                <el-table-column
                        prop="user.username"
                        label="UserName"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="user.gender"
                        label="Gender"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="user.mail"
                        label="Email"
                        width="200">
                </el-table-column>
                <el-table-column
                        prop="user.telephone"
                        label="Telephone"
                        width="150">
                </el-table-column>
                <el-table-column
                        label="Contact">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                type="info"
                                @click="sendMessage(scope.row)">Message</el-button>
                        <el-button
                                size="mini"
                                type="danger"
                                @click="sendEmail(scope.row)">Email</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <el-dialog
                title="Tips"
                :visible.sync="messageDialog"
                width="400px">
            <el-form class="messageForm" :model="messageForm" label-width="80px" label-position="left">
                <el-form-item prop="telephone" label="Telephone">
                    <el-input type="text" v-model="messageForm.phoneNumber" disabled="true"></el-input>
                </el-form-item>
                <el-form-item prop="text" label="Text">
                    <el-input
                            type="textarea"
                            :rows="5"
                            placeholder="Please input the content..."
                            v-model="messageForm.text">
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-button @click="messageDialog = false">Cancel</el-button>
                    <el-button type="primary" @click="doSendMessage">Send</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
        <el-dialog
                title="Tips"
                :visible.sync="emailDialog"
                width="400px">
            <el-form class="emailForm" :model="emailForm" label-width="80px" label-position="left">
                <el-form-item prop="email" label="Email">
                    <el-input type="text" v-model="emailForm.toMailAddress" disabled="true"></el-input>
                </el-form-item>
                <el-form-item prop="subject" label="Subject">
                    <el-input type="text" v-model="emailForm.subject"></el-input>
                </el-form-item>
                <el-form-item prop="content" label="Content">
                    <el-input
                            type="textarea"
                            :rows="5"
                            placeholder="Please input the content..."
                            v-model="emailForm.content">
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-button @click="emailDialog = false">Cancel</el-button>
                    <el-button type="primary" @click="doSendEmail">Send</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                user: JSON.parse(window.sessionStorage.getItem("user")),
                charity: '',
                volunteers: [],
                messageDialog:false,
                emailDialog:false,
                messageForm: {
                    phoneNumber:'',
                    text:''
                },
                emailForm: {
                    subject: '',
                    toMailAddress: '',
                    content: ''
                }
            }
        },
        mounted() {
            this.getCharityId();
        },
        methods: {
            getCharityId() {
                this.getRequest("/charity?userId=" + this.user.userId).then(resp=>{
                    if (resp) {
                        this.initVolunteers(resp.charityId)
                    }
                })
            },
            initVolunteers(charityId) {
                this.getRequest("/user-volunteers?charityId=" + charityId).then(resp=>{
                    if (resp) {
                        this.volunteers = resp;
                    }
                })
            },
            sendMessage(data) {
                this.messageDialog = true;
                this.messageForm.phoneNumber = data.user.telephone;
                this.sendMessage();
            },
            sendEmail(data) {
                this.emailDialog = true;
                this.emailForm.toMailAddress = data.user.mail;
                this.sendEmail();
            },
            doSendMessage() {
                this.$confirm('Do you wanna send message?', 'Tips', {
                    confirmButtonText: 'Confirm',
                    cancelButtonText: 'Cancel',
                    type: 'warning'
                }).then(() => {
                    this.postRequest('/message', this.messageForm).then(resp => {
                        if (resp) {
                            this.messageForm.phoneNumber = '';
                            this.messageForm.text = '';
                            this.messageDialog = false;
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: 'Cancel'
                    });
                });
            },
            doSendEmail() {
                this.$confirm('Do you wanna send email?', 'Tips', {
                    confirmButtonText: 'Confirm',
                    cancelButtonText: 'Cancel',
                    type: 'warning'
                }).then(() => {
                    this.postRequest('/email', this.emailForm).then(resp => {
                        if (resp) {
                            this.emailForm.subject = '';
                            this.emailForm.content = '';
                            this.emailDialog = false;
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: 'Cancel'
                    });
                });
            }
        }
    }
</script>

<style>

</style>