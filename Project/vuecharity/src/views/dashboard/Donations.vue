<template>
    <div>
        <el-table
                :data="projects"
                stripe
                size="small"
                @expand-change="expandChange"
                style="width: 1000px">
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-table
                            :data="userDonations"
                            stripe
                            border
                            style="width: 750px">
                        <el-table-column
                                prop="donationId"
                                label="Id"
                                width="50">
                        </el-table-column>
                        <el-table-column
                                prop="user.username"
                                label="Username"
                                width="100">
                        </el-table-column>
                        <el-table-column
                                prop="money"
                                label="Money"
                                width="100">
                        </el-table-column>
                        <el-table-column
                                prop="user.telephone"
                                label="Telephone"
                                width="130">
                        </el-table-column>
                        <el-table-column
                                prop="date"
                                label="Date"
                                width="130">
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
                </template>
            </el-table-column>
            <el-table-column
                    prop="projectId"
                    label="ID"
                    width="50">
            </el-table-column>
            <el-table-column
                    prop="projectName"
                    label="Project Name"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="createDate"
                    label="Create Date"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="expireDate"
                    label="Expire Date"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="targetMoney"
                    label="Target Money"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="totalMoney"
                    label="Total Money"
                    width="100">
            </el-table-column>
            <el-table-column
                    label="Status"
                    width="120">
                <template slot-scope="scope">
                    <el-tag size="small" type="info" v-if="scope.row.status==1">Finish</el-tag>
                    <el-tag size="small" type="success" v-else>In progress</el-tag>
                </template>
            </el-table-column>
            <el-table-column
                    label="Calculate">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            type="primary"
                            @click="calculateDonations(scope.row)">Donations</el-button>
                </template>
            </el-table-column>
        </el-table>
        <div>
            <el-button @click="createPDF" type="primary" style="margin-top: 10px">
                Export
            </el-button>
        </div>
        <div>
            <div class="line">
                <chart ref="chart1" :options="orgOptions" :auto-resize="true"></chart>
            </div>
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
    import jsPDF from 'jspdf'
    import 'jspdf-autotable'
    export default {
        data() {
            return {
                user: JSON.parse(window.sessionStorage.getItem("user")),
                orgOptions: {},
                projects: [],
                donations: [],
                userDonations: [],
                date:[],
                money:[],
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
            createPDF() {
                const pdf = new jsPDF();
                let header = ["Id", "Project Name", "Expire Date", "Target Money", "Total Money"];
                let headerConfig = header.map(key=>({ 'name': key,
                    'prompt': key,
                    'width':50,
                    'align':'center',
                    'padding':0}));
                let data = [{id: 1, name: "Peter"},{id: 2, name: "Chris"}];
                let exportData = [];
                this.projects.forEach(item=>{
                    let project = {"Id": item.projectId, "Project Name": item.projectName,
                        "Expire Date": item.expireDate, "Target Money":item.targetMoney,"Total Money": item.totalMoney}
                    exportData.push(project);
                })
                pdf.table(10, 30, exportData, headerConfig);
                pdf.save("projects.pdf");
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
            },
            expandChange(row, expandedRows) {
                this.getRequest("/user-donations?projectId=" + row.projectId).then(resp=>{
                    if (resp) {
                        this.userDonations = resp;
                    }
                })
            },
            getCharityId() {
                this.getRequest("/charity?userId=" + this.user.userId).then(resp=>{
                    if (resp) {
                        this.initProjects(resp.charityId)
                    }
                })
            },
            initProjects(charityId) {
                this.getRequest("/charity-projects?charityId=" + charityId).then(resp=>{
                    if (resp) {
                        this.projects = resp;
                    }
                })
            },
            calculateDonations(data) {
                this.getRequest("/project-donations?projectId=" + data.projectId).then(resp=>{
                    if (resp) {
                        this.donations = resp;
                        this.date = [];
                        this.money = [];
                        resp.forEach(item=>{
                            this.date.push(item.date);
                            this.money.push(item.money);
                        })
                        this.drawLine();
                    }
                })
            },
            drawLine() {
                this.orgOptions = {
                    xAxis: {
                        name: 'Date',
                        type: 'category',
                        data: this.date,
                    },
                    yAxis: {
                        name: 'Money',
                        type: 'value'
                    },
                    series: [{
                        data: this.money,
                        type: 'line',
                        smooth: true
                    }]
                }
            }
        }
    }
</script>

<style >

</style>
