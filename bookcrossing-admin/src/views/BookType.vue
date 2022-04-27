<template>
  <el-table ref="table" :data="data" class="main-table">
    <el-table-column type="selection" />
    <el-table-column prop="typeCode" label="图书类型编号" />
    <el-table-column prop="typeName" label="图书类型名称" />
    <el-table-column prop="createDate" label="创建时间" />
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

  <el-dialog title="图书类型" width="500px" v-model="formVisible">
    <el-form :model="formData">
      <el-form-item label="类型代码">
        <el-input v-model="formData.typeCode" />
      </el-form-item>
      <el-form-item label="类型名称">
        <el-input v-model="formData.typeName" />
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker
          v-model="formData.createDate"
          type="datetime"
          placeholder="选择创建时间"
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

interface BookType {
  bookTypeId: Number;
  typeCode: String;
  typeName: String;
  createDate: String;
}

export default {
  name: "DataTable",
  props: {
    url: String,
  },

  setup(props: { url: string }) {
    const formVisible = ref(false);
    let formFunc = "";
    let pageCount = ref();
    const formData = ref<BookType>({
      bookTypeId: 0,
      typeCode: "",
      typeName: "",
      createDate: "",
    });
    const api: any = inject("$api");

    const data = ref();
    const getList = (page: number) => {
      api
        .get(props.url + "/list", {page: page, size: 10})
        .then((res: AjaxResult<PageData<BookType>>) => {
          data.value = res.data.content;
          pageCount.value = res.data.totalPages;
        });
    };

    const handleAdd = () => {
      formVisible.value = true;
      formData.value = {
        bookTypeId: 0,
        typeCode: "",
        typeName: "",
        createDate: "",
      };
      formFunc = "add";
    };

    const handleEdit = (row: BookType) => {
      formData.value = row;
      formVisible.value = true;
      formFunc = "edit";
    };

    const handleDelete = (row: BookType) => {
      ElMessageBox.confirm("此操作将永远删除该数据！", "警告", {
        confirmButtonText: "删除",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          api
            .del(props.url + "/delete", row.bookTypeId)
            .then((res: AjaxResult<object>) => {
              ElMessage.success({
                type: "success",
                message: res.msg,
              });
            });

          getList(1);
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
            .post(props.url + "/add", formData.value)
            .then((res: AjaxResult<string>) => {
              ElMessage.success({
                type: "success",
                message: res.msg,
              });
            });
          break;
        case "edit":
          api
            .put(props.url + "/edit", formData.value)
            .then((res: AjaxResult<string>) => {
              ElMessage.success({
                type: "success",
                message: res.msg,
              });
            });
          break;
      }

      getList(1);
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

<style scoped></style>
