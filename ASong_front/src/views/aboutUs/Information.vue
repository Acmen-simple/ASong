<template>
  <div class="topStyle">
    <el-image style="width: 100%; height:350px" :src="url" />
  </div>
  <div class="centerStyle">
    <el-container>
      <el-aside width="33%">Aside</el-aside>
      <el-divider direction="vertical" style="height:25em" />
      <el-main>
        <div>
          协会简介
        </div>
        <el-divider style="border-color:aqua" />
        <div class="contentStyle">
          <div>
            <el-image src="http://www.cwca.org.cn/ckeditor/userfiles/files/20151009-CWCA.png" style="width:100px;height:100px"></el-image>
          </div>
          <h2></h2>
        </div>
      </el-main>
    </el-container>
  </div>

</template>

<script> 

import request from '../../../request';

export default {
  name: "Information",
  data() {
    return {
      url: 'http://www.cwca.org.cn/aboutus/benner.jpg',
      dataForm: {}
    }
  },
  methods: {
    getData() {
      request({
        url: '/api/usController/page',
        method: "POST",
      }).then(res => {
        this.dataForm = res.data.records[0];
        console.log({
            msg:"formInfor",
            data: this.dataForm
        })
      })

    }
  },
  created() {
    this.getData();
  }
}

</script>

<style scoped>
.topStyle {
  height: 350px;
  width: 100%;
  padding: 0;
}

.centerStyle {
  width: 100%;
  height: 400px;
  background-color: aliceblue;
}
.contentStyle{
 display: flex;
 flex-direction: column;
 align-items: center;
}
</style>