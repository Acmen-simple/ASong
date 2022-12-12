<template>
  <div class="fpall">
    <div class="formbox">
      <el-form style=" display:flex; flex-direction: column; align-items: center;" label-position="top" :rules="rules" ref="formData" :model="formData">
        <el-form-item>
          <h2>找回密码</h2>
        </el-form-item>
        <el-form-item label="账号：" prop="account">
          <el-input v-model="formData.account" placeholder="请输入账号" clearable></el-input>
        </el-form-item>
        <el-form-item label="手机号：" prop="userTel">
          <el-input v-model="formData.userTel" placeholder="请输入绑定手机号" clearable></el-input>
        </el-form-item>
        <el-form-item label="密码：" prop="password">
          <el-input v-model="formData.password" placeholder="请重新输入密码" clearable></el-input>
        </el-form-item>
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
      },
      rules: {
        account: [
          { required: true, message: '请输入账号', tigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', tigger: 'blur' },
          { min: 6, max: 15, tigger: 'blur', message: '密码必须在6-15之间，并且是中文或英文或符号' }
        ],
        userTel: [
          { required: true, message: '请输入电话', tigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    reset() {
      this.account = "";
      this.userTel = "";
      this.password = "";
    },
    success(formData) {
      this.$refs.formData.validate((valid) => {
        request.post('/api/logincontroller/findone?oneaccount=' + this.formData.account)
          .then(res => {
            console.log(res)
            console.log(res.data[0].id);
            if (this.formData.account != "" && this.formData.password != "" && this.formData.userTel != "") {
              if (res.data.length != 0) {
                if (this.formData.userTel == res.data[0].userTel) {
                  request({
                    params:{
                      account: this.formData.account,
                      password: this.formData.password,
                    },
                    url:'/api/logincontroller/forgetpw',
                    method:"POST",
                  })
                    .then(res2 => {
                      if (res2.code == '0') {
                        this.$message({
                          type: 'success',
                          message: '修改成功',
                        })
                      } else{
                        console.log(res2);
                      }
                    })
                  this.$router.push({ path: '/' })
                } else {
                  this.$message({
                    type: 'warning',
                    message: '手机号错误，请重新输入',
                  })
                }
              } else {
                this.$message({
                  type: 'warning',
                  message: '账号错误，请重新输入',
                })
              }
            }
          })
      })
    }

  }
}

</script>

<style>
.fpall {
  height: 913px;
  width: 100%;
  background-image: "https://imgse.com/i/z2JEIU";
  display: flex;
  justify-content: center;
  align-items: center;
}
.formbox {
  background-color: white;
  width: 500px;
  height: 380px;
  border-radius: 20px;
  box-shadow: 5px 5px 10px 10px grey;
}
</style>