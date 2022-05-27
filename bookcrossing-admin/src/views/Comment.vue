<template>
  <el-table ref="table" :data="data" class="main-table">
    <el-table-column type="selection" />
    <el-table-column prop="name" label="目标" />
    <el-table-column prop="content" show-overflow-tooltip label="内容" />
    <el-table-column prop="type" label="评论类型" />
    <el-table-column prop="status" label="评论状态" />
    <el-table-column prop="createDate" label="创建时间" />
    <el-table-column prop="username" label="用户名称" />
    <el-table-column label="操作">
      <template #header>
        <el-button type="success" @click="handleAdd"> 添加 </el-button>
      </template>
      <template #default="scope">
        <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
        <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-pagination background layout="prev, pager, next"
                 @update:current-page="getList"
                 :page-count="pageCount"
                 :page-size="10"/>

  <el-dialog title="评论" width="500px" v-model="formVisible">
    <el-form :model="formData">
      <el-form-item label="父节点">
        <el-input v-model="formData.name" disabled />
      </el-form-item>
      <el-form-item label="内容">
        <el-input type="textarea" v-model="formData.content" />
      </el-form-item>
      <el-form-item label="评论类型">
        <el-select v-model="formData.type">
          <el-option
              v-for="(item, index) in commentTypes"
              :key="index"
              :label="item"
              :value="index">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="评论状态">
        <el-select v-model="formData.status">
          <el-option
              v-for="(item, index) in commentStatus"
              :key="index"
              :label="item"
              :value="index">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker
          v-model="formData.createDate"
          type="datetime"
          placeholder="选择创建时间"
          format="YYYY/MM/DD hh:mm:ss"
          value-format="YYYY-MM-DD hh:mm:ss"
        />
      </el-form-item>
    </el-form>

    <template #footer>
      <span class="dialog-footer">
        <el-button type="primary" @click="handleSubmit">确 定</el-button>
        <el-button @click="formVisible = false">取 消</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script lang="ts">
import { ref, inject, onMounted } from "vue";
import { ElMessageBox, ElMessage } from "element-plus";
import { AjaxResult, PageData } from "@/assets";

interface Comment {
  commentId: Number;
  name: String;
  content: String;
  type: String;
  status: String;
  createDate: String;
  userId: Number;
}

export default {
  name: "DataTable",

  setup() {
    const formVisible = ref(false);
    let formFunc = "";
    let pageCount = ref();
    const formData = ref<Comment>({
      commentId: 0,
      name: "",
      content: "",
      type: "",
      status: "",
      createDate: "",
      userId: 0,
    });
    const api: any = inject("$api");
    const commentTypes = ["未确定", "公告留言", "新闻留言", "图书漂流问题", "网站运维", "图书评论"]
    const commentStatus = ["根评论", "回复评论"]
    const data = ref();
    const getList = (page: number) => {
      api
        .get("/comment/vo", {page: page, size: 10})
        .then((res: AjaxResult<PageData<Comment>>) => {
          data.value = res.data.content;
          pageCount.value = res.data.totalPages;
        });
    };

    const handleAdd = () => {
      formVisible.value = true;
      formData.value = {
        commentId: 0,
        name: "",
        content: "",
        type: "",
        status: "",
        createDate: "",
        userId: 0,
      };
      formFunc = "add";
    };

    const handleEdit = (row: Comment) => {
      formData.value = row;
      formVisible.value = true;
      formFunc = "edit";
    };

    const handleDelete = (row: Comment) => {
      ElMessageBox.confirm("此操作将永远删除该数据！", "警告", {
        confirmButtonText: "删除",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          api
            .post("/comment/delete", row.commentId)
            .then((res: AjaxResult<object>) => {
              ElMessage.success({
                type: "success",
                message: res.msg,
              });

              getList(1);
            });
        })
        .catch(() => {
          ElMessage.info({
            type: "info",
            message: "已取消删除",
          });
        });
    };

    const handleSubmit = () => {
      formVisible.value = false;

      switch (formFunc) {
        case "add":
          api
            .post("/comment/add", formData.value)
            .then((res: AjaxResult<string>) => {
              ElMessage.success({
                type: "success",
                message: res.msg,
              });

              getList(1);
            });
          break;
        case "edit":
          api
            .post("/comment/edit", formData.value)
            .then((res: AjaxResult<string>) => {
              ElMessage.success({
                type: "success",
                message: res.msg,
              });

              getList(1);
            });
          break;
      }
    };

    onMounted(() => {
      getList(1);
    });

    return {
      data,
      pageCount,
      formVisible,
      formData,
      commentTypes,
      commentStatus,
      getList,
      handleAdd,
      handleEdit,
      handleDelete,
      handleSubmit,
    };
  },
};
</script>

<style scoped></style>
