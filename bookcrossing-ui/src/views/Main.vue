<template>
  <div id="main">
    <el-space class="content">
      <div>
        <el-card class="left-card">
          <el-card>
            <el-row :gutter="20">
            <span style="padding: 9px 20px">
              搜索图书
            </span>
              <span style="width: 700px; padding: 0 10px">
              <el-input
                  v-model="search"
                  placeholder="请输入完整图书名"
                  :prefix-icon="Search"
              />
            </span>
              <el-button type="primary" round :icon="Search" @click="getBookList">搜索</el-button>
            </el-row>
          </el-card>

          <el-table :data="books"
                    height="528px"
                    @row-click="goDetail"
                    stripe
                    :row-class-name="tableRowClassName">
            <el-table-column label="图书编号" prop="bookNo" />
            <el-table-column label="图书名称" prop="name" />
            <el-table-column label="图书作者" prop="author" />
            <el-table-column label="图书类型" prop="typeName" />
            <el-table-column label="图书状态" prop="statusName" />
            <el-table-column label="上传日期" prop="createDate" />
          </el-table>

          <el-pagination background layout="prev, pager, next"
                         @update:current-page="getBookList"
                         :page-count="pageCount"
                         :page-size="10"/>
        </el-card>
      </div>
      <div>
        <el-card class="right-card">
          <template #header>
            <h1>公告</h1>
          </template>
          <ul>
            <li style="padding: 5px 0" v-for="item in announcements" @click="viewNews(item)">{{item.title}}</li>
          </ul>
        </el-card>
        <el-card class="right-card">
          <template #header>
            <h1>新闻</h1>
          </template>
          <ul>
            <li style="padding: 5px 0" v-for="item in news" @click="viewNews(item)">{{item.title}}</li>
          </ul>
        </el-card>
      </div>
    </el-space>

    <el-dialog
        v-model="isView"
        title="浏览"
        width="30%">
      <h1>{{ viewData.title }}</h1>
      <p style="padding: 100px 0">{{ viewData.content }}</p>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="isView = false">取消</el-button>
        <el-button type="primary" @click="isView = false">确认</el-button>
      </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts">
import {inject, onMounted, ref} from "vue";
import {AjaxResult, PageData, Announcement, News, Book, BookType} from "@/assets/js";
import {useRouter} from "vue-router";
import { Search } from '@element-plus/icons-vue'
export default {
  setup() {
    const api: any = inject("$api");
    const news = ref();
    const announcements = ref();
    const books = ref();
    const search = ref();
    const router = useRouter();
    const bookTypes = ref();
    const bookStatus = ["上传中", "可漂流", "已漂流"]
    const pageCount = ref(1);
    const isView = ref(false);
    const viewData = ref();

    const viewNews = (data: any) => {
      isView.value = true;
      viewData.value = data;
    }

    const tableRowClassName = (row: any) => {
      if (row.status === 1) {
        return 'success-row'
      } else if (row.status === 3) {
        return 'warning-row'
      }
      return 'success-row'
    }

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

    const getBookList = (page: number) => {
      api
          .get("/book/list", {name: search.value, page: page, size: 10})
          .then((res: AjaxResult<PageData<Book>>) => {
            books.value = res.data.content;
            pageCount.value = res.data.totalPages;
            setBookInfo();
          });
    };

    const getBookTypeList = () => {
      api
          .get("/bookType/list")
          .then((res: AjaxResult<PageData<BookType>>) => {
            bookTypes.value = res.data.content;
            getBookList(1);
          });
    }

    const setBookInfo = () => {
      for (let i = 0; i < books.value.length; i++) {
        let key = books.value[i].type;
        let value = "";
        for (let j = 0; j < bookTypes.value.length; j++) {
          const bookTypeId = bookTypes.value[j].bookTypeId;
          if (key == bookTypeId) {
            value = bookTypes.value[j].typeName;
            break;
          }
        }
        books.value[i].typeName = value;
      }

      for (let i = 0; i < books.value.length; i++) {
        books.value[i].statusName = bookStatus[books.value[i].status]
      }
    }

    const goDetail = (row: any) => {
      router.push({
        name: "Detail",
        params: {
          bookId: row.bookId,
        }
      });
    };

    onMounted(() => {
      getBookTypeList();
      getAnnouncementList();
      getNewsList();
    });

    return {
      search,
      isView,
      viewNews,
      viewData,
      news,
      announcements,
      getBookList,
      pageCount,
      books,
      tableRowClassName,
      goDetail,
    }
  }
}
</script>

<style scoped>
#main {
  padding-top: 115px;
  min-height: 80vh;
  overflow: hidden;
  text-overflow: ellipsis;
  background-image: url("../assets/images/main_back.png");
}

.content {
  width: 800px;
  margin: 0 300px;
}

.right-card {
  width: 300px;
  height: 300px;
}

.left-card {
  height: 700px;
  width: 1000px;
  text-align: center;
}

.el-table .warning-row {
  --el-table-tr-bg-color: #fdf6ec;
}

.el-table .success-row {
  --el-table-tr-bg-color: #f0f9eb;
}
</style>