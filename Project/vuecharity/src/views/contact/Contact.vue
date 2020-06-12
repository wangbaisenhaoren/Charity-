<template>
  <el-container>
    <el-header class="header" style="width: 100%" stripe height="calc(100% - 60px)">Contact us<br/>
      Get in touch or try one of our popular topics to get a faster answer.
    </el-header>
    <el-main class="main">
      <br/><br/>
      <i class="el-icon-message"></i>Email:charity@sheffield.ac.uk
      <br/>
      <i class="el-icon-phone-outline"></i>
      Tel:07365272574
    </el-main>
  </el-container>

</template>

<script>
  export default {
    name: "Contact"
  }
</script>

<style scoped>
  .header{
    border-radius: 10px;
    background-color: #396f80;
    box-shadow: 0 30px 50px rgba(0, 0, 0, .12), 0 0 5px rgba(70, 71, 242, 0.47);
    text-align: center;
    font-size: 35px;
    color: #f8fffd;
  }
  .main{
    text-align: center;
    font-size:20px;
    color: #03e2ff;
  }

</style>
