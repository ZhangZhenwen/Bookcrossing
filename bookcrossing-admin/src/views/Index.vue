<template>
  <el-container class="container">
    <el-header>
      <img
          class="indexImage"
          src="../assets/images/bookcrossing-logo.png"
          alt="Bookcrossing"
      />
      <h1 style="padding: 15px 190px 15px 0">图书管理系统后台管理</h1>
    </el-header>
    <el-container>
      <el-aside class="aside">
        <el-menu
            :default-active="activeIndex"
            @select="handleSelect"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            class="menu"
        >
          <el-menu-item class="menu-item" index="book">
            <span class="menu-font">图书管理</span>
          </el-menu-item>
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
    <el-footer style="padding: 0">
      <div id="footer">
        <div class="row">
          <div class="col-sm-4 my-2">
          </div>
        </div>
      </div>
    </el-footer>
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
  height: 820px;
}

.menu-item {
  height: 80px;
  line-height: 85px;
}

.indexImage {
  width: 186px;
  height: 52px;
  margin: 0 20px 0 0;
  float: left;
}

#footer {
  padding: 14px 40px;
  background-color: hsl(40, 15%, 25%) !important;
  color: rgba(255, 255, 255, .4);
  height: 60px;
}

.row {
  display: flex;
  flex-wrap: wrap;
  margin: 0 -15px;
}

.col-sm-4 {
  flex: 0 0 33.3%;
  max-width: 33.3%;
}

.my-2 {
  margin-top: .5rem !important;
}
</style>
