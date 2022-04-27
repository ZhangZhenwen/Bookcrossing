<template>
  <div id="main">
    <el-space class="content">
      <div>
        <el-card class="left-card">
          <el-table :data="books" @row-click="goDetail">
            <el-table-column label="图书编号" prop="bookNo" />
            <el-table-column label="图书名称" prop="name" />
            <el-table-column label="图书作者" prop="author" />
            <el-table-column label="图书类型" prop="type" />
            <el-table-column label="图书状态" prop="status" />
            <el-table-column label="上传日期" prop="createDate" />
          </el-table>
        </el-card>
      </div>
      <div>
        <el-card class="right-card">
          <template #header>
            <h1>公告</h1>
          </template>
          <ul>
            <li v-for="item in announcements">{{item.title}}</li>
          </ul>
        </el-card>
        <el-card class="right-card">
          <template #header>
            <h1>新闻</h1>
          </template>
          <ul>
            <li v-for="item in news">{{item.title}}</li>
          </ul>
        </el-card>
      </div>
    </el-space>
  </div>
</template>

<script lang="ts">
import {inject, onMounted, ref} from "vue";
import {AjaxResult, PageData, Announcement, News, Book} from "@/assets/js";
import {useRouter} from "vue-router";

export default {
  name: "Main",

  setup() {
    const api: any = inject("$api");
    const news = ref();
    const announcements = ref();
    const books = ref();
    const router = useRouter();

    const getNewsList = () => {
      api
        .get("/news/list")
        .then((res: AjaxResult<PageData<News>>) => {
          news.value = res.data.content;
        });
    };

    const getAnnouncementList = () => {
      api
        .get("/announcement/list")
        .then((res: AjaxResult<PageData<Announcement>>) => {
          announcements.value = res.data.content;
        });
    };

    const getBookList = () => {
      api
        .get("/book/list")
        .then((res: AjaxResult<PageData<Book>>) => {
          books.value = res.data.content
        });
    };

    const goDetail = (row: any) => {
      router.push({
        name: "Detail",
        params: {
          bookId: row.bookId,
        }
      });
    };

    onMounted(() => {
      getBookList();
      getAnnouncementList();
      getNewsList();
    });

    return {
      books,
      news,
      announcements,
      goDetail,
    }
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

.content {
  width: 800px;
  margin: 0 500px;
}

.right-card {
  width: 300px;
  height: 300px;
}

.left-card {
  height: 700px;
}
</style>