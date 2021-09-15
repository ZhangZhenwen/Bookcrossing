<template>
  <el-container class="container">
    <el-aside class="aside">
      <el-menu
        :default-active="activeIndex"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
        class="menu"
      >
        <el-menu-item class="menu-item" index="bookType">
          <span class="menu-font">图书类型管理</span>
        </el-menu-item>
        <el-menu-item class="menu-item" index="announcement">
          <span class="menu-font">公告管理</span>
        </el-menu-item>
        <el-menu-item class="menu-item" index="news">
          <span class="menu-font">新闻管理</span>
        </el-menu-item>
        <el-menu-item class="menu-item" index="comment">
          <span class="menu-font">留言管理</span>
        </el-menu-item>
        <el-menu-item class="menu-item" index="user">
          <span class="menu-font">用户管理</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main>
      <router-view />
    </el-main>
  </el-container>
</template>

<script lang="ts">
import router from "@/router";

export default {
  name: "Index",

  setup() {
    const activeIndex = "1";
    const handleSelect = (path: string) => {
      router.push({
        name: upperFirstChar(path),
        params: {
          url: path,
        },
      });
    };

    const upperFirstChar = (str: string) => {
      return str.replace(str[0], str[0].toUpperCase());
    };

    return {
      activeIndex,
      handleSelect,
    };
  },
};
</script>

<style scoped>
.menu-font {
  font-size: 18px;
}

.container {
  height: 100%;
}

.aside {
  height: 100%;
}

.menu {
  height: 900px;
}

.menu-item {
  height: 80px;
  line-height: 85px;
}
</style>
