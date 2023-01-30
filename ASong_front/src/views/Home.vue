<template>
  <div class="wcall">
    <el-container>
      <el-header style="height:130px">
        <div>
          <h1>濒危动物救助</h1>
        </div>
        <div class="menu-style">
          <Menu></Menu>
        </div>
      </el-header>

      <el-main style="height:800px; padding: 0;">
        <router-view></router-view>
      </el-main>

      <el-footer style="flex">
        <div class="footer-style">
          <el-carousel trigger="click" style="width:100%" height="400px">
            <el-carousel-item v-for="item in 4" :key="item">
              <h3 class="small justify-center" text="2xl">{{ item }}</h3>
            </el-carousel-item>
          </el-carousel>
          <div footerText-style>
            <p>地址：北京和平里东街18号 | 邮政编码：100714 | 电话：010-84238313 | 传真：010-84239555</p>
          </div>
          <div>
            <p>2020 © 中国野生动物保护协会主办　京ICP备：05056968号</p>
          </div>
        </div>
      </el-footer>
    </el-container>
  </div>
</template>
  
  <script> 

import Menu from "./inc/Menu.vue"

export default {
  name: "Home",
  components: {
    Menu,
  },

  data() {
    return {


    }
  },
  methods: {


  }
}
  </script>
  
  <style scoped>
.wcall {
  height: 100%;
  width: 100%;
}
.el-header {
  background-color: #17b3a3;
  text-align: center;
}
.el-main {
  background-size: cover;
}

.el-footer {
  background-color: #b3c0d1;
  height: 400px;
  width: 100%;
}

.footer-style {
  display: flex;
  flex-direction: column;
  align-items: center;
  align-content: center;
}

</style>