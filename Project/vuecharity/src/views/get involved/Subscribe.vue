<template>
    <div>
        <div>
            <el-table
                    :data="charities"
                    stripe
                    size="small"
                    style="width: 800px">
                <el-table-column
                        prop="charityId"
                        label="ID"
                        width="60">
                </el-table-column>
                <el-table-column
                        prop="charityName"
                        label="Charity Name"
                        sortable
                        width="200">
                </el-table-column>
                <el-table-column
                        prop="address"
                        label="Address"
                        sortable
                        width="200">
                </el-table-column>
                <el-table-column
                        prop="postcode"
                        label="PostCode"
                        sortable
                        width="100">
                </el-table-column>
                <el-table-column
                        label="Get Involved">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                type="primary"
                                @click="subscribeCharity(scope.row)">Subscribe</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <el-dialog
                title="Subscribe the charity"
                :visible.sync="subscribeVisible"
                :before-close="handleClose"
                width="400px">
            <div>
                <el-form class="payForm" ref="form" :model="subscribeForm" label-width="130px" label-position="left">
                    <el-form-item
                            prop="money"
                            label="Money"
                            :rules="[
                                { type: 'number', message: 'The input must be the number', trigger: 'blur' },
                                { required: true, message: 'Please input the money', trigger: 'blur'},
                            ]">
                        <el-input type="text" v-model.number="subscribeForm.money" placeholder="10"></el-input>
                    </el-form-item>
                    <el-form-item
                            prop="cycle"
                            label="Cycle"
                            :rules="[
                                { type: 'number', message: 'The input must be the number', trigger: 'blur' },
                                { required: true, message: 'Please input the circle', trigger: 'blur'},
                            ]">
                        <el-input type="text" v-model="subscribeForm.cycle" placeholder="12"></el-input>
                    </el-form-item>
                    <el-form-item label="Frequency">
                        <el-select v-model="subscribeForm.frequency" placeholder="Frequency">
                            <el-option label="Monthly" value="MONTH"></el-option>
                            <el-option label="Yearly" value="YEAR"></el-option>
                        </el-select>
                    </el-form-item>
                </el-form>
            </div>
            <span slot="footer" class="dialog-footer">
        <el-button @click="subscribeVisible = false">Cancel</el-button>
        <el-button type="primary" @click="checkout">Confirm</el-button>
      </span>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "Subscribe",
        data() {
            return {
                user: JSON.parse(window.sessionStorage.getItem("user")),
                charities:[],
                subscriptions:[],
                subscribeVisible: false,
                tag: false,
                subscribeForm: {
                    charityId:'',
                    userId:'',
                    frequency:'',
                    cycle:'',
                    money:'',
                    date:''
                },
            }
        },
        mounted() {
            this.initCharities();
            this.initSubscriptions();
        },
        methods: {
            initCharities() {
                this.getRequest("/charities").then(resp=>{
                    if (resp) {
                        this.charities = resp;
                    }
                })
            },
            initSubscriptions() {
                this.getRequest("/subscriptions?userId=" + this.user.userId).then(resp=>{
                    if (resp) {
                        this.subscriptions = resp;
                    }
                })
            },
            subscribeCharity(data) {
                this.subscribeVisible = true;
                this.subscribeForm.charityId = data.charityId;
                this.subscriptions.forEach(item=>{
                    if (item.charityId === data.charityId) {
                        this.subscribeForm = item;
                        this.tag = true;
                    }
                })
            },
            checkout() {
                this.subscribeForm.userId = this.user.userId;
                this.subscribeForm.date = this.formatDate(new Date());
                if (this.tag) {
                    this.putRequest("/subscription", this.subscribeForm);
                } else {
                    this.postRequest("/subscription", this.subscribeForm);
                }
                this.postRequest('/agreement', this.subscribeForm).then(resp => {
                    this.See(resp)
                });
            },
            See (e) {
                window.location.href = e
            },
            formatDate(date) {
                let y = date.getFullYear();
                let m = date.getMonth() + 1;
                m = m < 10 ? '0' + m : m;
                let d = date.getDate();
                d = d < 10 ? ('0' + d) : d;
                return y + '-' + m + '-' + d;
            },
            handleClose(done) {
                this.$confirm('Cancel subscribe？')
                    .then(_ => {
                        done();
                        this.subscribeForm = [];
                        this.tag = false;
                    })
                    .catch(_ => {});
            }
        }
    }
</script>

<style>

</style>
