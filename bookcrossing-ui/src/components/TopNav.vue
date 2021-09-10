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
      <el-sub-menu index="1">
        <template #title><span class="menu-font">书与人</span></template>
        <el-menu-item index="1-1">
          <span class="menu-font">Book Map</span>
        </el-menu-item>
        <el-menu-item index="1-2">
          <span class="menu-font">搜寻</span>
        </el-menu-item>
        <el-menu-item index="1-3">
          <span class="menu-font">猎书</span>
        </el-menu-item>
        <el-menu-item index="1-4">
          <span class="menu-font">会员</span>
        </el-menu-item>
      </el-sub-menu>
      <el-menu-item index="2">
        <span class="menu-font">公告</span>
      </el-menu-item>
      <el-menu-item index="3">
        <span class="menu-font">新闻</span>
      </el-menu-item>
    </el-menu>
    <div class="fr" style="padding-top: 6px">
      <el-button @click="goRegister">注册</el-button>
      <el-button type="primary" @click="goLogin">登录</el-button>
    </div>
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
      this.$router.push("register")
    },
    goLogin() {
      this.$router.push("login")
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
