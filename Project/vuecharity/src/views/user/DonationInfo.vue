<template>
    <div>
        <div>
            <el-table
                    :data="donations"
                    stripe
                    style="width: 1000px">
                <el-table-column
                        prop="donationId"
                        label="Donation Id"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="projectName"
                        label="Project Name"
                        width="200">
                </el-table-column>
                <el-table-column
                        prop="money"
                        label="Money"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="date"
                        label="Date">
                </el-table-column>
            </el-table>
        </div>
        <div style="margin-top: 10px">
            <el-button type="primary" @click="createPDF">
                Export
            </el-button>
        </div>
    </div>
</template>

<script>
    import jsPDF from "jspdf";

    export default {
        name: "DonationInfo",
        data() {
            return {
                user: JSON.parse(window.sessionStorage.getItem("user")),
                donations: []
            }
        },
        mounted() {
            this.initDonations();
        },
        methods: {
            initDonations() {
                this.getRequest("/donation?userId=" + this.user.userId).then(resp=>{
                    if (resp) {
                        this.donations = resp;
                    }
                })
            },
            createPDF() {
                const pdf = new jsPDF();
                let header = ["Donation Id", "Project Name", "Money", "Date"];
                let headerConfig = header.map(key=>({
                    'name': key,
                    'prompt': key,
                    'width':50,
                    'align':'center',
                    'padding':0}));
                let data = [{id: 1, name: "Peter"},{id: 2, name: "Chris"}];
                let exportData = [];
                this.donations.forEach(item=>{
                    let project = {"Donation Id": item.donationId, "Project Name": item.projectName,
                        "Money": item.money, "Date":item.date}
                    exportData.push(project);
                })
                pdf.table(30, 30, exportData, headerConfig);
                pdf.save("donations.pdf");
            },
        }
    }
</script>

<style>

</style>
