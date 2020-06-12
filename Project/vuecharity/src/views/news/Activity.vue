<template>
  <div>
    <el-row>
      <el-col :span="8" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 3 : 0" style="width: 30%">
        <el-card :body-style="{ padding: '5px' }" >
          <img src="https://pennyappeal.org/storage/app/media/zakat-workshops/web-banner.jpg" class="image">
          <div style="padding: 14px;">
            <div class="activityTitle">Zakat Workshops</div>
            <div class="activityContent">
              Penny Appeal is running free workshops across the UK to serve the 3rd pillar of Islam.
            </div>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="8" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 3 : 0"style="margin-left: 10px;width: 30%" >
        <el-card :body-style="{ padding: '5px' }">
          <img src="https://pennyappeal.org/storage/app/media/Challenges/2020/tough-mudder/websitepagebanner.jpg" class="image">
          <div style="padding: 14px;">
            <div class="activityTitle">Touch Mudder</div>
            <div class="activityContent">
              This isn't just your average race. This is a challenge for champions and Team Orange.
            </div>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="8" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 3 : 0" style="margin-left: 10px;width: 30%">
        <el-card :body-style="{ padding: '5px' }">
          <img src="https://pennyappeal.org/storage/app/media/Challenges/2020/asics-london-10k/web-banner-1500-x-350-asics-london-10k-dec-19.jpg" class="image">
          <div style="padding: 14px;">
            <div class="activityTitle">London 10K</div>
            <div class="activityContent">
              Walk, jog or run the iconic British 10k with #TeamOrange
            </div>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

  </div>
</template>

<script>
    export default {
      data() {
        return {
          currentDate: ''
        };
      },
      methods: {
        getTime:function(){
          var _this = this;
          let yy = new Date().getFullYear();
          let mm = new Date().getMonth()+1;
          let dd = new Date().getDate();
          _this.currentDate = yy+'-'+mm+'-'+dd;
        },
      },
      created() {
        this.getTime();
      }
    }
</script>

<style>
  .activityTitle {
    margin-bottom: 10px;
    text-align: center;
  }

  .activityContent {
    text-align: center;
  }

  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
    text-align: center;
  }

  .image {
    width: 100%;
    margin-top: 20px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }
</style>
