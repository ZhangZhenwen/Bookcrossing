<template>
  <div id="main" class="container">
    <!-- Account:LogIn -->
    <div>
      <div id="content">
        <h1>
          登入
        </h1>
        <div class="form">
          <el-form ref="formRef" :model="form" :rules="rules">
            <el-form-item label="邮箱地址" prop="email">
              <el-input v-model="form.email" />
            </el-form-item>
            <el-form-item label="账号密码" prop="password">
              <el-input type="password" v-model="form.password" />
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">登录</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { ref, unref, inject, reactive } from "vue";
import { ElMessage } from "element-plus";
import { useRouter } from "vue-router";

interface LoginForm {
  password: string;
  email: string;
}

export default {
  name: "Login",

  setup() {
    const router = useRouter();
    const api: any = inject("$api");
    const form = ref<LoginForm>({
      email: "",
      password: "",
    });
    const formRef = ref();
    const rules = {
      email: [
        {required: true, message: "邮箱不能为空", trigger: "blur"},
        {type: "email", message: "邮箱格式不正确", trigger: "blur"},
      ],
      password: [{required: true, message: "密码不能为空", trigger: "blur"}],
    };

    const goIndex = () => {
      router.push("/");
    }

    const onSubmit = async () => {
      const validate = unref(formRef);
      if (!validate) {
        return;
      }

      try {
        await validate.validate();
        api.post("/admin/login", form.value).then((res: any) => {
          console.log(res);
          localStorage.setItem("token", res.token)
          ElMessage.success({
            message: res.msg,
            type: "success",
          });
          goIndex();
        });
      } catch (e) {
      }
    };

    return {
      form,
      formRef,
      rules,
      onSubmit,
    };
  }
}
</script>

<style scoped>
#main {
  padding-top: 115px;
  min-height: 87vh;
  overflow: hidden;
  text-overflow: ellipsis;
  width: 500px;
}

.container {
  max-width: 1140px;
  width: 100%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}

.form {
  width: 500px;
}
</style>