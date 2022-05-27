<template>
  <el-table ref="table" :data="data" class="main-table">
    <el-table-column type="selection" />
    <el-table-column prop="title" label="标题" width="300px" />
    <el-table-column prop="content" show-overflow-tooltip label="内容" />
    <el-table-column prop="createDate" label="创建时间" width="300px" />
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

  <el-dialog title="通知" width="500px" v-model="formVisible">
    <el-form :model="formData">
      <el-form-item label="标题">
        <el-input v-model="formData.title" />
      </el-form-item>
      <el-form-item label="内容">
        <el-input type="textarea" v-model="formData.content" />
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

interface Announcement {
  announcementId: Number;
  title: String;
  content: String;
  createDate: String;
}

export default {
  name: "DataTable",

  setup() {
    const formVisible = ref(false);
    let formFunc = "";
    let pageCount = ref();
    const formData = ref<Announcement>({
      announcementId: 0,
      title: "",
      content: "",
      createDate: "",
    });
    const api: any = inject("$api");

    const data = ref();
    const getList = (page: number) => {
      api
        .get("/announcement/list", {page: page, size: 10})
        .then((res: AjaxResult<PageData<Announcement>>) => {
          data.value = res.data.content;
          pageCount.value = res.data.totalPages;
        });
    };

    const handleAdd = () => {
      formVisible.value = true;
      formData.value = {
        announcementId: 0,
        title: "",
        content: "",
        createDate: "",
      };
      formFunc = "add";
    };

    const handleEdit = (row: Announcement) => {
      formData.value = row;
      formVisible.value = true;
      formFunc = "edit";
    };

    const handleDelete = (row: Announcement) => {
      ElMessageBox.confirm("此操作将永远删除该数据！", "警告", {
        confirmButtonText: "删除",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          api
            .post("/announcement/delete", row.announcementId)
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
      console.log(formData.value)
      switch (formFunc) {
        case "add":
          api
            .post("/announcement/add", formData.value)
            .then((res: AjaxResult<string>) => {
              ElMessage.success({
                type: "success",
                message: res.msg,
              });
              getList(1)
            });
          break;
        case "edit":
          api
            .post("/announcement/edit", formData.value)
            .then((res: AjaxResult<string>) => {
              ElMessage.success({
                type: "success",
                message: res.msg,
              });
              getList(1)
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
      getList,
      handleAdd,
      handleEdit,
      handleDelete,
      handleSubmit,
    };
  },
};
</script>

<style scoped>

</style>
