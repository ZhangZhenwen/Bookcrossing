<template>
  <div id="main" class="container">
    <!-- Membership:Join -->
    <div class="row">
      <div id="content" class="col-sm-12 col-lg-9">
        <h1>加入書遊記</h1>
        <p>
          <strong
            >你即將與來自世界各地超過1,925,263名的愛書同好聚在一起…</strong
          >
        </p>
        &nbsp;
        <p><strong>這就是書遊記的宗旨…</strong></p>
        &nbsp;
        <p>
          我們是一個愛書人的社群，喜歡與他人分享我們的書籍。只需要簡單的手續，為你的書貼上一張書遊記標籤，然後將書本“漂遊”出去。隨後登入網站，看看它們被誰發現，去了世界哪個角落。
        </p>
        &nbsp;
        “追隨”書本在世界各地的旅程，看著它們開創自己的生活，既有趣又帶勁。誰知道它們會到哪裡去，被誰發現之後，回到這裡輸入你在<strong>標籤</strong>上寫下的編號…
        <p></p>
        <div id="dProfileMain">
          <div id="dBookShelfHolder">
            <div class="bookShelf" style="padding-top: 10px"></div>
          </div>
        </div>
      </div>
      <div class="form">
        <el-form ref="formRef" :model="form" :rules="rules">
          <el-form-item label="用户名称" prop="username">
            <el-input v-model="form.username" />
          </el-form-item>
          <el-form-item label="邮箱地址" prop="email">
            <el-input v-model="form.email" />
          </el-form-item>
          <el-form-item label="账号密码" prop="password">
            <el-input type="password" v-model="form.password" />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">立即注册</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { ref, unref, inject, reactive } from "vue";
import { ElMessage } from "element-plus";
import { useRouter } from "vue-router";

interface UserData {
  username: string;
  password: string;
  email: string;
}

export default {
  name: "Register",

  props: {},

  setup() {
    const router = useRouter();
    const api: any = inject("$api");
    const form = ref<UserData>({
      username: "",
      password: "",
      email: "",
    });
    const formRef = ref();
    const rules = {
      username: [
        { required: true, message: "用户名不能为空", trigger: "blur" },
      ],
      email: [
        { required: true, message: "邮箱不能为空", trigger: "blur" },
        { type: "email", message: "邮箱格式不正确", trigger: "blur" },
      ],
      password: [{ required: true, message: "邮箱不能为空", trigger: "blur" }],
    };

    const goLogin = () => {
      router.push("/login");
    }

    const onSubmit = async () => {
      const validate = unref(formRef);
      if (!validate) {
        return;
      }

      try {
        await validate.validate();
        api.post("/register", form.value).then((res: any) => {
          console.log(res);
          ElMessage.success({
            message: res.msg,
            type: "success",
          });
        });
        goLogin();
      } catch (e) {}
    };

    return {
      form,
      formRef,
      rules,
      onSubmit,
    };
  },
};
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

#content {
  margin-bottom: 1.5em;
}

p {
  margin-top: 0;
  margin-bottom: 1rem;
}

.h1,
h1 {
  font-size: 2.5rem;
  line-height: 1.2;
  color: inherit;
  margin-bottom: 0.5rem;
}

.form {
  width: 500px;
}
</style>
