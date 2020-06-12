<template>
    <div>
        <el-container>
            <el-header class="homeHeader">
                <div class="title">Charity Center</div>
                <div v-if="user != null" style="display:inline-flex">
                    <div style="margin-right: 10px">
                        <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                    </div>
                    <div style="margin-top: 10px">
                        <el-dropdown class="userInfo" @command="userCommandHandler">
                      <span class="el-dropdown-link user">
                        {{user.username}}<i class="el-icon-arrow-down el-icon--right"></i>
                      </span>
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item command="userInfo">User Info</el-dropdown-item>
                                <div v-if="user.roleId != 4">
                                    <el-dropdown-item command="donationInfo">Donation Info</el-dropdown-item>
                                </div>
                                <el-dropdown-item command="sendMessage">Send Message</el-dropdown-item>
                                <el-dropdown-item command="sendEmail">Send Email</el-dropdown-item>
                                <div v-if="user.roleId == 3">
                                    <el-dropdown-item command="applyVolunteer">Apply Volunteer</el-dropdown-item>
                                </div>
                                <div v-if="user.roleId != 4">
                                    <el-dropdown-item command="applyCharity">Apply Charity</el-dropdown-item>
                                </div>
                                <el-dropdown-item divided command="logOut">Log Out</el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
                    </div>
                </div>
                <div v-else>
                    <el-dropdown class="userInfo" @command="visitorCommandHandler">
                        <div>
                            <span class="el-dropdown-link user">
                                <span>visitor</span>
                                <i class="el-icon-arrow-down el-icon--right"></i>
                            </span>
                        </div>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item command="register">Register</el-dropdown-item>
                            <el-dropdown-item command="login">Login</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </div>
            </el-header>

            <el-container>
                <el-aside width="200px">
                    <el-menu @select="menuClick" unique-opened collapse-transition>
                        <el-menu-item index="home">
                            <i class="el-icon-location"></i>
                            <span slot="title">home</span>
                        </el-menu-item>

                        <el-submenu v-if="user != null && user.roleId==4" index="dashboard">
                            <template slot="title" >
                                <i class="el-icon-copy-document"></i>
                                <span>dashboard</span>
                            </template>
                            <el-menu-item index="donations">donations</el-menu-item>
                            <el-menu-item index="volunteers">volunteers</el-menu-item>
                        </el-submenu>

                        <el-submenu index="2">
                            <template slot="title">
                                <i class="el-icon-chat-line-square"></i>
                                <span>news</span>
                            </template>
                            <el-menu-item index="announcement">announcement</el-menu-item>
                            <el-menu-item index="charitynews">charity news</el-menu-item>
                            <el-menu-item index="activity">Activity</el-menu-item>
                        </el-submenu>

                        <el-submenu index="3" v-if="user!=null">
                            <template slot="title">
                                <i class="el-icon-coin"></i>
                                <span>get involved</span>
                            </template>
                            <div v-if="user.roleId==4">
                                <el-menu-item index="publish">Publish</el-menu-item>
                            </div>
                            <el-menu-item index="subscribe">Subscribe</el-menu-item>
                            <el-menu-item index="projects">Projects</el-menu-item>
                        </el-submenu>

                        <el-submenu index="4">
                            <template slot="title">
                                <i class="el-icon-s-custom"></i>
                                <span>about us</span>
                            </template>
                            <el-menu-item index="ourpeople">our people</el-menu-item>
                            <el-menu-item index="charityInfo">charity info</el-menu-item>
                        </el-submenu>

                        <el-menu-item index="contact">
                            <i class="el-icon-phone-outline"></i>
                            <span slot="title">contact us</span>
                        </el-menu-item>

                    </el-menu>

                </el-aside>
                <el-main>
                    <el-breadcrumb separator-class="el-icon-arrow-right" v-if="this.$router.currentRoute.path!=='/home'" style="padding-bottom: 20px">
                        <el-breadcrumb-item :to="{ path: '/home' }">Home</el-breadcrumb-item>
                        <el-breadcrumb-item>{{this.$router.currentRoute.name}}</el-breadcrumb-item>
                    </el-breadcrumb>
                    <template v-if="this.$router.currentRoute.path==='/announcement'">
                        <el-carousel :interval="4000" type="card" height="bannerHeight+'px'">
                            <el-carousel-item v-for="item in imagesbox" :key="item.id">
                                <el-row>
                                    <el-col :span="24" class="banner_img">
                                        <img ref="bannerHeight" :src="item.idView" class="bannerImg" @load="imgLoad">
                                    </el-col>
                                </el-row>
                                <!--              <el-carousel-item v-for="item in 6" :key="item">-->
                                <h3 class="medium">{{ item }}</h3>
                            </el-carousel-item>
                        </el-carousel>
                    </template>
                    <div class="homeWelcome" v-if="this.$router.currentRoute.path==='/home'">
                        Welcome to the Charity Center!
                    </div>
                    <router-view/>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "Home",
        data() {
            return {
                user: JSON.parse(window.sessionStorage.getItem("user")),
                // bannerHeight: "",
                imagesbox: [{id: 0, idView: require("../assets/images/home_1.jpg")},
                    {id: 1, idView: require("../assets/images/home_2.jpg")},
                    {id: 2, idView: require("../assets/images/home_3.jpg")},
                    {id: 3, idView: require("../assets/images/home_4.jpg")},
                    {id: 4, idView: require("../assets/images/home_5.jpg")}],
                note: {
                    backgroundImage: "url(" + require("../assets/images/home_1.jpg") + ") ",
                    backgroundPosition: "center center",
                    backgroundRepeat: "no-repeat",
                    backgroundSize: "cover"
                }
            }
        },
        mounted(){
            this.imgLoad();
            window.addEventListener('resize', ()=> {
                this.bannerHeight = this.$refs.bannerHeight[0].height
                this.imgLoad();
            },false)
        },
        methods: {
            imgLoad(){
                this.$nextTick(()=>{
                    this.bannerHeight=this.$refs.bannerHeight[0].height
                })
            },
            menuClick(index){
                this.$router.push(index);
            },
            userCommandHandler(cmd) {
                if (cmd === 'logOut') {
                    this.$confirm('Whether to log out of the account?', 'prompt', {
                        confirmButtonText: 'Yes',
                        cancelButtonText: 'No',
                        type: 'warning'
                    }).then(() => {
                        this.getRequest("/logout");
                        window.sessionStorage.removeItem("user")
                        this.$router.replace("/");
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: 'Cancel log out'
                        });
                    });
                }
                if (cmd === 'userInfo') {
                    this.$router.replace('userinfo');
                }
                if (cmd === 'donationInfo') {
                    this.$router.push('donationinfo');
                }
                if (cmd === 'sendMessage') {
                    this.$router.push('sendmessage');
                }
                if (cmd === 'sendEmail') {
                    this.$router.push('sendemail');
                }
                if (cmd === 'applyVolunteer') {
                    this.$router.push('applyvolunteer');
                }
                if (cmd === 'applyCharity') {
                    this.$router.push('applycharity');
                }
            },
            visitorCommandHandler(cmd) {
                if (cmd === 'register') {
                    this.$router.push('register');
                }
                if (cmd === 'login') {
                    this.$router.replace("/");
                }
            }
        }
    }
</script>

<style>
    .homeWelcome{
        text-align: center;
        font-size: 30px;
        font-family: "Times New Roman";
        color: #409eff;
        padding-top: 50px;
    }
    .homeHeader{
        background-color: #396f80;
        display: flex;
        align-items: center;
        justify-content:space-between;
        padding: 0px 15px;
        box-sizing:border-box;
    }
    .homeHeader .title{
        font-size: 30px;
        font-family: Calibri;
        color: aliceblue;
    }
    .homeHeader .user{
        font-family: Calibri;
        color: aliceblue;
    }
    .homeHeader .userInfo{
        cursor: pointer;
    }
    .el-carousel__item h3 {
        color: #475669;
        font-size: 15px;
        opacity: 0.25;
        line-height: 200px;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    }
    img{
        height: 100%;
        width: 100%;
        object-fit: contain;
    }
</style>
