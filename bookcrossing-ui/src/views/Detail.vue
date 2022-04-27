<template>
  <div id="main">
    <div>
      <el-card>
        <el-page-header @back="goBack" content="详情页面" />
      </el-card>
    </div>
    <el-divider>图书详情</el-divider>
    <div class="description">
      <el-card>
        <el-descriptions column="1" class="description">
          <el-descriptions-item label="图书编号">{{ book.bookNo }}</el-descriptions-item>
          <el-descriptions-item label="图书名称">{{ book.name }}</el-descriptions-item>
          <el-descriptions-item label="图书作者">{{ book.author }}</el-descriptions-item>
          <el-descriptions-item label="上传时间">{{ book.createDate }}</el-descriptions-item>
        </el-descriptions>
      </el-card>
    </div>
    <div v-if="flag">
      <el-button type="success" disabled>已申请</el-button>
    </div>
    <div v-else>
      <el-button v-if="book.status === '1'" type="primary" @click="handleCrossing">申请漂流</el-button>
      <el-button v-else-if="book.status === '2'" type="danger" disabled>已出借</el-button>
      <el-button v-else type="danger" disabled>不可借</el-button>
    </div>
    <el-divider>书评区</el-divider>
    <div>
      <el-table :data="comments">
        <el-table-column label="内容" prop="content" />
        <el-table-column label="评论时间" prop="createDate" />
      </el-table>
      <el-input type="textarea" v-model="comment" />
      <el-button type="success" @click="handleSubmit">发布评论</el-button>
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
      type: "",
      status: "",
      createDate: ""
    });
    const comments = ref();
    const comment = ref<string>();
    const flag = ref<boolean>();

    const getBookInfo = () => {
      api
        .get("book/" + props.bookId)
        .then((res: AjaxResult<Book>) => {
          book.value = res.data;
          getComments();
          getStatus();
        });
    };

    const getStatus = () => {
      api
        .post("crossInfo/checkApply", {bookId: props.bookId})
        .then((res: AjaxResult<boolean>) => {
          flag.value = res.data;
        })
    }

    const getComments = () => {
      api
        .get("comment/list", {parentId: props.bookId, type: "5", status: "0"})
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
      flag,
      goBack,
      handleSubmit,
      handleCrossing,
    }
  }
};
</script>

<style scoped>
#main {
  padding-top: 115px;
  min-height: 87vh;
  overflow: hidden;
  text-overflow: ellipsis;

  margin: 0 300px;
}

.description {
  font-size: 20px;
}
</style>
