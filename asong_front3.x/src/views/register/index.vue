<template>
  <div class="rgall">
    <div class="formbox">
      <el-form style=" display:flex; flex-direction: column; align-items: center;" label-position="top" :rules="rules" ref="formData" :model="formData">
        <el-form-item>
          <h2>注册页面</h2>
        </el-form-item>
        <el-form-item label="账号：" prop="account">
          <el-input v-model="formData.account" placeholder="请输入账号" clearable></el-input>
        </el-form-item>
        <el-form-item label="用户名：" prop="userName">
          <el-input v-model="formData.userName" placeholder="请输入用户名" clearable></el-input>
        </el-form-item>
        <el-form-item label="手机号：" prop="userTel">
          <el-input v-model="formData.userTel" placeholder="请输入手机号" clearable></el-input>
        </el-form-item>
        <el-form-item label="密码：" prop="password">
          <el-input v-model="formData.password" placeholder="请输入密码" clearable type="password"></el-input>
        </el-form-item>
        <!-- <el-form-item label="确认密码：" prop="againPassword">
          <el-input v-model="formData.againPassword" placeholder="请再次输入密码" clearable type="password"></el-input>
        </el-form-item> -->
        <el-form-item>
          <el-button type="success" @click="success(formData)">确定</el-button>
          <el-button @click="reset()">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>


<script> 
import request from '../../../request';

export default {
  components: {},
  data() {
    return {
      formData: {
        account: '',
        userTel: '',
        password: '',
        userName: '',
      },

      rules: {
        account: [
          { required: true, message: '请输入账号', tigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', tigger: 'blur' },
          { min: 6, max: 15, tigger: 'blur', message: '密码必须在6-15之间，并且是中文或英文或符号' }
        ],
        againPassword: [
          { required: true, message: '请输入密码', tigger: 'blur' },
          { min: 6, max: 15, tigger: 'blur', message: '密码必须在6-15之间，并且是中文或英文或符号' }
        ],
        userTel: [
          { required: true, message: '请输入电话', tigger: 'blur' }
        ],
        userName: [
          { required: true, message: '请输入用户名', tigger: 'blur' }
        ]
      },
      telphone: '',//用于手机号验证
    }
  },
  methods: {
    reset() {
      this.formData.account = '';
      this.formData.password = '';
      this.formData.userTel = '';
      this.formData.userName = '';

    },
    success(formData) {
      this.getCode(); //验证手机号
      if (this.telphone == '0') {
        this.$refs.formData.validate((valid) => {
          request.post('/api/logincontroller/add', this.formData).then(res => {
            if (res.code == '0') {
              this.$message({
                message: "注册成功",
                type: 'success'
              })
              this.$router.push('/')
            } else {
              this.$message({
                message: res.msg,
                type: 'danger'
              })
            }
          })
        })
      }
    },
    //验证手机号
    getCode() {
      let tel = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
      if (!tel.test(this.formData.userTel)) {
        this.$message({
          message: '电话号码输入错误，请重新输入',
          type: 'warning',
        })
        this.formData.userTel = '';
        this.telphone = '1'
      } else {
        this.telphone = '0'
      }
    },

  }
}

</script>

<style>
.rgall {
  height: 913px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.formbox {
  background-color: white;
  width: 500px;
  height: 480px;
  border-radius: 20px;
  box-shadow: 5px 5px 10px 10px grey;
}
</style>