<template>
  <div class="wcall">
    <el-container>
      <el-header>
        <h1>网上购物商城</h1>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu default-active="2" class="el-menu-vertical-demo">
            <el-sub-menu index="1">
              <template #title>
                <el-icon>
                  <location />
                </el-icon>
                <span>Navigator One</span>
              </template>
              <el-menu-item-group title="Group One">
                <el-menu-item index="1-1">item one</el-menu-item>
                <el-menu-item index="1-2">item two</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="Group Two">
                <el-menu-item index="1-3">item three</el-menu-item>
              </el-menu-item-group>
              <el-sub-menu index="1-4">
                <template #title>item four</template>
                <el-menu-item index="1-4-1">item one</el-menu-item>
              </el-sub-menu>
            </el-sub-menu>
            <el-menu-item index="2">
              <el-icon>
                <icon-menu />
              </el-icon>
              <span>Navigator Two</span>
            </el-menu-item>
            <el-menu-item index="3" disabled>
              <el-icon>
                <document />
              </el-icon>
              <span>Navigator Three</span>
            </el-menu-item>
            <el-menu-item index="4">
              <el-icon>
                <setting />
              </el-icon>
              <span>Navigator Four</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main>主体</el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script> 
export default {
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
  background-color: #b3c0d1;
  text-align: center;
}
.el-aside {
  background-color: #d3dce6;
  height: 853px;
  width: 200px;
}
.el-main {
  background-image: url("../assets/玫瑰与落日.jpg");
  background-size: cover;
}
</style>