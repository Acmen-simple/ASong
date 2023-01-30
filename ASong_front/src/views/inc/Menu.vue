<template>
  <el-menu default-active="0" class="el-menu-demo" mode="horizontal" background-color="#17b3a3" text-color="white" active-text-color="black" @select="handleSelect" style="width:100%">

    <router-link to="/">
      <el-menu-item index="0">首页</el-menu-item>
    </router-link>

    <el-sub-menu index="2">
      <template #title>关于我们</template>

      <router-link to="Information">
        <el-menu-item index="2-1">协会简章</el-menu-item>
      </router-link>

      <router-link to="Constitution">
        <el-menu-item index="2-2">协会章程</el-menu-item>
      </router-link>

      <router-link to="Orgnization">
        <el-menu-item index="2-3">组织机构</el-menu-item>
      </router-link>

      <router-link to="Thing">
        <el-menu-item index="2-4">大事记</el-menu-item>
      </router-link>

      <router-link to="Patener">
        <el-menu-item index="2-5">合作伙伴</el-menu-item>
      </router-link>

      <router-link to="Us">
        <el-menu-item index="2-6">关于我们</el-menu-item>
      </router-link>
    </el-sub-menu>

    <el-sub-menu index="3">
      <template #title>资源库</template>

      <router-link to="WildAnimalInfo">
        <el-menu-item index="3-1">野生动物知识</el-menu-item>
      </router-link>

      <router-link to="Publish">
        <el-menu-item index="3-2">出版物</el-menu-item>
      </router-link>

      <router-link to="AnimalImage">
        <el-menu-item index="3-3">野生动物影像欣赏</el-menu-item>
      </router-link>

      <router-link to="AnimalVideo">
        <el-menu-item index="3-3">野生动物图片欣赏</el-menu-item>
      </router-link>

      <router-link to="AnimalData">
        <el-menu-item index="3-4">野生动物资料库</el-menu-item>
      </router-link>

    </el-sub-menu>
    <el-sub-menu index="4">
      <template #title>新闻</template>

      <router-link to="AssociationDynamics">
        <el-menu-item index="4-1">协会动态</el-menu-item>
      </router-link>

      <router-link to="NewsReport">
        <el-menu-item index="4-2">新闻报道</el-menu-item>
      </router-link>

      <router-link to="AssociationNotice">
        <el-menu-item index="4-3">协会公告</el-menu-item>
      </router-link>

      <router-link to="PartyBuilding">
        <el-menu-item index="4-3">党建强会</el-menu-item>
      </router-link>

    </el-sub-menu>
    <el-sub-menu index="5">
      <template #title>专题活动</template>
      <router-link to="Propaganda">
        <el-menu-item index="5-1">科普宣传</el-menu-item>
      </router-link>

      <router-link to="Volunteer">
        <el-menu-item index="5-2">志愿者行动</el-menu-item>
      </router-link>

      <router-link to="PandaProtect">
        <el-menu-item index="5-3">大熊猫保护工作</el-menu-item>
      </router-link>

      <router-link to="ActivityReview">
        <el-menu-item index="5-3">专题活动-专题回顾</el-menu-item>
      </router-link>

    </el-sub-menu>
    <el-sub-menu index="6">
      <template #title>生态法制</template>
      <router-link to="Legal">
        <el-menu-item index="6-1">法律法规</el-menu-item>
      </router-link>

      <router-link to="Case">
        <el-menu-item index="6-2">案例精选</el-menu-item>
      </router-link>
      
      
    </el-sub-menu>

    <router-link to="places">
      <el-menu-item index="7">各地协会</el-menu-item>
    </router-link>

    <router-link to="natural">
      <el-menu-item index="8">自然生态百科</el-menu-item>
    </router-link>

  </el-menu>
</template>

<script> 

export default {
  name: "Menu",
  data() {
    return {

    }
  },
  methods: {
    handleSelect() {
      console.log("菜单")
    }
  }

}


</script>

<style >
</style>