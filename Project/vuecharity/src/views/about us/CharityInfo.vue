<template>
  <div>
    <el-row>
      <el-col :span="7" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 4: 0">
        <el-card :body-style="{ padding: '5px' }">
          <img src="https://www.macmillan.org.uk/_images/Mac_Diagnosis_MAC_CampaignPage1300x460_General_tcm9-356507.jpg" class="image">
          <div style="padding: 14px;">
            <div class="charityTitle">Macmillan Cancer Support</div>
            <div class="charityContent">
              We provide physical, financial and emotional support to help you live life as fully as you can.
            </div>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
<!--              <el-button @click="click1" type="text" class="button">D</el-button>-->
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="7" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 4 : 0"style="margin-left: 5px">
        <el-card :body-style="{ padding: '5px' }">
          <img src="https://www.sja.org.uk/globalassets/small-pod-block-images/images-showing-volunteers/community-first-responders.jpg?preset=680_425&anchor=middlecenter" class="image">
          <div style="padding: 14px;">
            <div class="charityTitle">St. John Ambulance</div>
            <div class="charityContent">
              We are St John Ambulance, the charity for health and first aid in your community.
            </div>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
<!--              <el-button @click="click2" type="text" class="button">more details</el-button>-->
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="7" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 4 : 0"style="margin-left: 5px">
        <el-card :body-style="{ padding: '5px' }">
          <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTtrRqJnZYOo2mk8yJ6wAFD8HEDSUYdSQdHtTPoMKzJDpktlkkk&usqp=CAU" class="image">
          <div style="...">
            <div class="charityTitle">Great Ormond Street Hospital</div>
            <div class="charityContent">
              Most of the children we care for are referred from other hospitals throughout the UK and overseas. You can also visit the publications section.
            </div>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
<!--              <el-button @click="click3" type="text" class="button">more details</el-button>-->
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="7" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 4 : 0"style="margin-left: 5px">
        <el-card :body-style="{ padding: '0px' }">
          <img src="https://www.bhf.org.uk/-/media/new-site-images/landing-page-images/information-support-lpc5-risk-factors-blood-pressure-570x380.png?mh=380&la=en&h=380&w=570&mw=570&hash=FACDBAB11C9AEF48C900D40854586E9554C433B9" class="image2">
          <div style="padding: 14px;">
            <div class="charityTitle">GBritish Heart Foundation</div>
            <div class="charityContent">
              Celebrate our carers
              Every Thursday we're showing extra gratitude to anyone working around the clock to support our vulnerable community.
            </div>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
<!--              <el-button @click="click4" type="text" class="button">more details</el-button>-->
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="7" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 4 : 0"style="margin-left: 5px">
        <el-card :body-style="{ padding: '5px' }">
          <img src="https://www.cancerresearchuk.org/sites/all/themes/custom/cruk/cruk-logo.svg" class="image2">
          <div style="padding: 14px;">
            <div class="charityTitle">Cancer Research UK</div>
            <div class="charityContent">
              People affected by cancer are at the heart of everything we do.To ensure they get the support they need during these unprecedented times.
            </div>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
<!--              <el-button @click="click5" type="text" class="button">more details</el-button>-->
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="7" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 4 : 0"style="margin-left: 5px">
        <el-card :body-style="{ padding: '5px' }">
          <img src="https://www.guidedogs.org.uk/-/media/Project/GuideDogs/GuideDogsDotOrg/guide-dogs-logo-yellow.png?h=130&w=300&hash=4FD9D2114CFEEF3E323A906122E4C029" class="image2">
          <div style="padding: 14px;">
            <div class="charityTitle">Guide Dogs </div>
            <div class="charityContent">
              Guide Dogs has a long history of providing guide dogs for people, and we are pleased to offer guide dogs to young people.
            </div>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
<!--              <el-button @click="click6" type="text" class="button">more details</el-button>-->
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
      click1(){
        this.$router.replace('charityinfo/macmillan')
      },
      click2(){
        this.$router.replace('charityinfo/ambulance')
      },
      click3(){
        this.$router.replace('charityinfo/ormond')
      },
      click4(){
        this.$router.replace('charityinfo/heart')
      },
      click5(){
        this.$router.replace('charityinfo/cancer')
      },
      click6(){
        this.$router.replace('charityinfo/dogs')
      },
    },
    created() {
      this.getTime();
    }
  }
</script>

<style>
  .charityTitle {
    margin-bottom: 10px;
    text-align: center;
  }

  .charityContent {
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
    width: 500px;
    height:300px;
    margin-top: 20px;
    zoom:0.5
  }
  .image2 {
    width: 500px;
    height:300px;
    margin-top: 20px;
    zoom:0.5
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }
  .button {
    padding: 0;
    float: right;
  }
</style>

