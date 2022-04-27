<template>
  <div id="nav" class="fixed-top">
    <router-link to="/">
      <img
        class="indexImage"
        src="../assets/images/bookcrossing-logo.png"
        alt="Bookcrossing"
      />
    </router-link>
    <el-menu mode="horizontal" class="left-menu fl" router="true">
      <el-menu-item index="/main">
        <span class="menu-font">书与人</span>
      </el-menu-item>
      <el-menu-item index="/main">
        <span class="menu-font">公告</span>
      </el-menu-item>
      <el-menu-item index="/main">
        <span class="menu-font">新闻</span>
      </el-menu-item>
    </el-menu>
    <div v-if="loginStatus" class="fr" style="padding-top: 6px">
      <el-button type="success" @click="goUser">个人中心</el-button>
    </div>
    <el-space v-else class="fr" style="padding-top: 6px">
      <el-button @click="goRegister">注册</el-button>
      <el-button type="primary" @click="goLogin">登录</el-button>
    </el-space>
  </div>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";

@Options({
  data() {
    return {
      activeIndex: 1,
    };
  },
  methods: {
    goRegister() {
      this.$router.push("register");
    },
    goLogin() {
      this.$router.push("login");
    },
    goUser() {
      this.$router.push("user");
    }
  },
  computed: {
    loginStatus: function () {
      let token = localStorage.getItem("token");
      return this.$store.getters.getLoginStatus || (token != null && token != "");
    }
  }
})
export default class TopNav extends Vue {}
</script>

<style scoped>
#nav {
  padding: 8px 16px;
  height: 52px;
  text-align: start;
}

.indexImage {
  width: 186px;
  height: 52px;
  margin: 0 20px 0 0;
  float: left;
}

.fixed-top {
  position: fixed;
  top: 0;
  right: 0;
  left: 0;
  z-index: 1030;

  background-color: rgba(255, 255, 255, 0.94);
  box-shadow: 0 4px 5px rgb(0 0 0 / 30%);
}

.left-menu {
  width: 400px;

  /*background-color: rgba(255, 255, 255, 0.94);*/
  /*box-shadow: 0 4px 5px rgb(0 0 0 / 30%);*/
}
</style>
