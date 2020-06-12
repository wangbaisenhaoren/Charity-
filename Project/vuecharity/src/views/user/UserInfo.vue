<template>
    <div>
        <el-form label-position='left' ref="form" label-width="80px" style="width: 300px">
            <el-form-item label="Username: ">
                <el-input v-model="user.username" size="small" readonly>
                </el-input>
            </el-form-item>
            <el-form-item label="Email: ">
                <el-input v-model="user.mail" size="small" readonly>
                </el-input>
            </el-form-item>
            <el-form-item label="Telephone: ">
                <el-input v-model="user.telephone" size="small" readonly>
                </el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="doUpdate">Update</el-button>
            </el-form-item>
        </el-form>

        <el-dialog
                title="Update information"
                :visible.sync="userVisible"
                width="400px">
            <div>
                <el-form label-width="130px" label-position="left">
                    <el-form-item label="Username">
                        <el-input type="text" v-model="user.username"></el-input>
                    </el-form-item>
                    <el-form-item label="Email">
                        <el-input type="text" v-model="user.mail"></el-input>
                    </el-form-item>
                    <el-form-item label="Telephone">
                        <el-input type="text" v-model="user.telephone"></el-input>
                    </el-form-item>
                </el-form>
            </div>
            <span slot="footer" class="dialog-footer">
        <el-button @click="userVisible = false">Cancel</el-button>
        <el-button type="primary" @click="updateUser">Confirm</el-button>
      </span>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                user: JSON.parse(window.sessionStorage.getItem("user")),
                userVisible: false
            }
        },
        methods: {
            doUpdate() {
                this.userVisible = true;
            },
            initForm() {
                this.form.phoneNumber = '';
                this.form.text = '';
            },
            updateUser() {
                this.$confirm('Do you wanna update the information?', 'Update', {
                    confirmButtonText: 'Continue',
                    cancelButtonText: 'Cancel',
                    type: 'info'
                }).then(() => {
                    this.putRequest('/user', this.user);
                    window.sessionStorage.setItem("user", JSON.stringify(this.user));
                    this.userVisible = false;
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: 'The transaction is cancelled!'
                    });
                });
            }
        }
    }
</script>

<style>

</style>