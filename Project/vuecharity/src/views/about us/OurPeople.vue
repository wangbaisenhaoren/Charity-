<template>
  <el-container>
    <el-header class="header" style="width: 100%" stripe height="calc(100% - 60px)">What we do<br/>
      We are a charity website containing many charities. We help anyone, anywhere in the UK and around the world, get the support they need if crisis strikes.
    </el-header>
    <el-main class="main">
      <div class="demo-image__placeholder">
        <div class="block">
          <span class="demonstration"></span>
          <el-image style="width: 1000px; height: 500px"
                    :src="src1"
                    fit="fill"></el-image>
        </div>
      </div>
    </el-main>
  </el-container>

</template>

<script>
  export default {
    name: "Contact",
    data() {
      return {
        src1: 'https://th.bing.com/th/id/OIP.XWURqCcaxDu0AyZJMTA4GAHaE7?w=273&h=177&c=7&o=5&dpr=2&pid=1.7'
      }
    }
  }
</script>

<style scoped>
  .header{
    border-radius: 10px;
    background-color: rgba(56, 80, 121, 0.86);
    box-shadow: 0 30px 50px rgba(0, 0, 0, .12), 0 0 5px rgba(70, 71, 242, 0.47);
    text-align: center;
    font-size: 35px;
    color: #f8fffd;
  }
  .main{
    text-align: center;
  }

</style>
