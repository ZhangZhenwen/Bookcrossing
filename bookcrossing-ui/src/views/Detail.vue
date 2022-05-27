<template>
  <div class="bg">
  <div id="main">
    <div>
      <el-card>
        <el-page-header @back="goBack" content="详情页面" />
      </el-card>
    </div>
    <el-divider>图书详情</el-divider>
    <div class="description">
      <el-card>
        <el-row>
          <el-col :span="16" style="padding: 0 100px">
            <el-descriptions column="1" class="description">
              <el-descriptions-item label="图书介绍"><p style="line-height: 40px">{{ book.introduction }}</p></el-descriptions-item>
            </el-descriptions>
          </el-col>
          <el-col :span="8">
            <el-card :body-style="{ padding: '0px' }">
              <img
                  src="../assets/images/book_pic.jpg"
                  class="image"
              />
              <el-descriptions column="1" class="description">
                <el-descriptions-item label="图书编号">{{ book.bookNo }}</el-descriptions-item>
                <el-descriptions-item label="图书名称">{{ book.name }}</el-descriptions-item>
                <el-descriptions-item label="图书作者">{{ book.author }}</el-descriptions-item>
                <el-descriptions-item label="上传时间">{{ book.createDate }}</el-descriptions-item>
              </el-descriptions>
            </el-card>
          </el-col>
        </el-row>
      </el-card>
    </div>
    <div>
      <el-button v-if="book.status === '1'" type="primary" @click="handleCrossing">申请漂流</el-button>
      <el-button v-else-if="book.status === '2'" type="danger" disabled>已漂流</el-button>
      <el-button v-else-if="book.status === '3'" type="primary" @click="viewPdf">下载</el-button>
      <el-button v-else-if="book.status === '4'" type="primary">已申请</el-button>
      <el-button v-else type="danger" disabled>不可漂流</el-button>
    </div>
    <el-divider>书评区</el-divider>

    <div>
      <el-card>
        <el-table :data="comments" :row-style="{height: '100px'}">
          <el-table-column label="用户名" width="200px" prop="username" />
          <el-table-column label="内容" prop="content" />
          <el-table-column label="评论时间" width="150px" prop="createDate" />
        </el-table>
        <el-input type="textarea" v-model="comment" />
        <el-button type="success" @click="handleSubmit">发布评论</el-button>
      </el-card>
    </div>
  </div>
  </div>
</template>

<script lang="ts">
import {useRouter} from "vue-router";
import {inject, onMounted, ref} from "vue";
import {AjaxResult, Book, PageData, Comment} from "@/assets/js";
import {ElMessage} from "element-plus";

export default {
  name: "Detail",

  props: {
    bookId: Number,
  },

  setup(props: {bookId: number}) {
    const api: any = inject("$api");
    const router = useRouter();
    const book = ref<Book>({
      bookId: props.bookId,
      bookNo: "",
      name: "",
      author: "",
      introduction: "",
      type: "",
      status: "",
      createDate: "",
      pdfName: "",
      pdfUrl: "",
    });
    const comments = ref();
    const comment = ref<string>();
    let isViewPdf = false;

    const viewPdf = () => {
      window.open(book.value.pdfUrl)
    }

    const getBookInfo = () => {
      api
        .get("book/detail", {id: props.bookId})
        .then((res: AjaxResult<Book>) => {
          book.value = res.data;
          getComments();
        });
    };

    const getComments = () => {
      api
        .get("comment/vo", {parentId: props.bookId, type: "5", status: "0"})
        .then((res: AjaxResult<PageData<Comment>>) => {
          comments.value = res.data.content;
        });
    };

    const handleSubmit = () => {
      const content = comment.value;
      const parentId = props.bookId;
      const type = "5";
      const status = "0";

      api
        .post("comment/add", {parentId: parentId, content: content, type: type, status: status})
        .then((res: AjaxResult<Comment>) => {
          ElMessage.success({
            message: "评论成功！",
            type: "success"
          });

          getComments();
        });

      comment.value = "";
    };

    const handleCrossing = () => {
      api
        .post("crossInfo/handle", {bookId: props.bookId})
        .then((res: AjaxResult<any>) => {
          ElMessage.success({
            message: "申请成功！",
            type: "success"
          });
          getBookInfo();
        });
    };

    const goBack = () => {
      router.back();
    };

    onMounted(() => {
      getBookInfo();
    })

    return {
      book,
      comment,
      comments,
      isViewPdf,
      goBack,
      handleSubmit,
      handleCrossing,
      viewPdf,
    }
  }
};
</script>

<style scoped>
.bg {
  background-image: url("../assets/images/detail-back.jpeg");
  background-size: 100% 100%;

}

#main {
  padding-top: 115px;
  min-height: 87vh;
  overflow: hidden;
  text-overflow: ellipsis;
  background-color: white;
  margin: 0 300px;
}

.description {
  font-size: 20px;
}

.image {
  width: 100%;
  display: block;
}
</style>
