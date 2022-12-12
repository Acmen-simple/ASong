<template>
  <div class="all">
    <!-- :class="form" label-position="top" style="background-color:white; height: 500px; width: 500px; display: flex; justify-content: center; align-items: center; flex-direction:column" -->
    <div class="formbox">
      <el-form style=" display:flex; flex-direction: column; align-items: center;" label-position="top" :rules="rules" ref="formData" :model="formData">
        <el-form-item>
          <span style="font-size: 20px; color:blue;">登录</span>
        </el-form-item>
        <el-form-item label="用户名:" prop="account">
          <el-input class="inputText" placeholder="请输入用户名" v-model="formData.account" style="width:400px;"></el-input>
        </el-form-item>
        <el-form-item label="密码:" prop="password">
          <el-input class="inputText" placeholder="请输入密码" type="password" v-model="formData.password" style="width:400px"></el-input>
        </el-form-item>
        <el-form-item label="验证码:" prop="code">
          <el-input class="inputText" placeholder="请输入验证码" type="text" v-model="formData.code" style="width:200px;height: 50px;"></el-input>
          <el-image :src="captchaImg" style="width:200px;height: 50px;" @click="update()"></el-image>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width:400px" @click="login(fromData)">登录</el-button>
        </el-form-item>

        <el-form-item style="display:flex">
          <el-link @click="forgetPw()" style="float:left">忘记密码</el-link>
          <el-link @click="register()" style="margin-left: 200px;">还没有账号？点击注册</el-link>
          <!-- <text @click="forgetpw()">忘记密码</text>|<span @click="register()">注册</span> -->
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script> 
import { thisExpression } from '@babel/types';
import { useRouter } from 'vue-router'
import request from '../../../request'

export default {
  data() {
    return {
      input: '',
      formData: [{
        account: '',
        password: '',
        code: '',
        token: ''
      }],
      rules: {
        account: [
          { required: true, message: '请输入账号', tigger: 'change' }
        ],
        password: [
          { required: true, message: '请输入密码', tigger: 'change' },
          { min: 6, max: 15, message: '请输入密码', tigger: 'change' }
        ],
        code: [
          { required: true, message: '请输入验证码', tigger: 'change' }
        ],
      },
      captchaImg: '',
      realcode: ''
    }
  },
  methods: {
    //登录方法
    login(formData) {
      this.$refs.formData.validate((valid) => {
        if (valid) {
          request({
            params: {
              account: this.formData.account,
              password: this.formData.password,
            },
            url: '/api/logincontroller/judge',
            method: 'POST'
          }).then((res) => {
            if (this.formData.code === this.realcode) {
              if (res.code === '0') {
                this.$message({
                  message: "登录成功",
                  type: 'success'
                });
                this.$router.push({ path: '/welcome' });
              } else {
                this.formData = [];
                this.$message({
                  message: "密码或账号错误，青重新输入",
                  type: 'warning'
                })
              }
            } else {
              this.$message({
                message: '验证码错误，请重新输入',
                type: 'warning'
              })
              this.getCaptcha();
              this.formData.code = '';
            }
          })
        }

      })
    },
    //跳转忘记密码页面
    forgetPw() {
      console.log("忘记密码");
      this.$router.push('/forgetpw');
    },
    //跳转注册页面
    register() {
      console.log("注册");
      this.$router.push('/register');
    },
    //验证码
    getCaptcha() {
      request.get('/api/logincontroller/captcha').then(res => {
        this.captchaImg = res.data.captchaImg;
        this.token = res.data.token;
        this.realcode = res.data.code;
      })
    },
    //刷新验证码
    update() {
      this.getCaptcha();
    }
  },
  created() {
    this.getCaptcha();
  }
}

</script>

<style>
.all {
  height: 913px;
  width: 100%;
  /* background-color: aqua; */
  background-image: url("../../assets/玫瑰与落日.jpg");
  background-size: cover;
  display: flex;
  justify-content: center;
  align-items: center;
  /* background-color: rgba(255, 255, 0, 0.5); */
  /* opacity: 0.5; */
}
.formbox {
  background-color: white;
  width: 500px;
  height: 400px;
  border-radius: 20px;
  box-shadow: 5px 5px 10px 10px grey;
}
</style>