<template>
  <div id="main" class="container">
    <!-- Account:LogIn -->
    <div class="row">
      <div id="content" class="col-sm-12 col-lg-9">
        <h1 class="capitalize">
          登入
        </h1>
        <p>
          請輸入你的電郵地址和密碼。 如果你沒有帳戶， <a href="/register">Join</a>
        </p>
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
  props: {},

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
      password: [{required: true, message: "邮箱不能为空", trigger: "blur"}],
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
        api.post("/login", form.value).then((res: any) => {
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
}

.container {
  max-width: 1140px;
  width: 100%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}

.h1, .h2, .h3, .h4, .h5, h1, h2, h3, h4, h5 {
  font-family: "IBM Plex Sans Condensed", "IBM Plex Sans", -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
  opacity: .7;
  font-weight: 700;
}

.row {
  display: -ms-flexbox;
  display: flex;
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
  margin-right: -15px;
  margin-left: -15px;
}

.col-lg-9 {
  flex: 0 0 75%;
  max-width: 75%;

  position: relative;
  width: 100%;
  min-height: 1px;
  padding-right: 15px;
  padding-left: 15px;
}

.col-sm-12 {
  position: relative;
  width: 100%;
  min-height: 1px;
  padding-right: 15px;
  padding-left: 15px;
}

.capitalize {
  text-transform: capitalize;
}

p {
  margin-top: 0;
  margin-bottom: 1rem;
}

.h1, h1 {
  font-size: 2.5rem;
}

.h1, .h2, .h3, .h4, .h5, .h6, h1, h2, h3, h4, h5, h6 {
  margin-bottom: .5rem;
  line-height: 1.2;
  color: inherit;
}

.form {
  width: 500px;
}
</style>