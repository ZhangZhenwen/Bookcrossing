<template>
  <el-table ref="table" :data="data" class="main-table">
    <el-table-column type="selection" />
    <el-table-column prop="username" label="用户名" />
    <el-table-column prop="email" label="邮箱" />
    <el-table-column prop="tel" label="手机号" />
    <el-table-column prop="typeName" label="用户类型" />
    <el-table-column prop="statusName" label="用户状态" />
    <el-table-column label="操作">
      <template #default="scope">
        <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
        <el-button size="mini" type="danger" @click="handleDelete(scope.row)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>

  <el-pagination background layout="prev, pager, next"
                 @update:current-page="getList"
                 :page-count="pageCount"
                 :page-size="10"/>

  <el-dialog title="用户" width="500px" v-model="formVisible">
    <el-form :model="formData" label-position="right">
      <el-form-item label="用户名">
        <el-input v-model="formData.username" />
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="formData.email" />
      </el-form-item>
      <el-form-item label="手机号">
        <el-input v-model="formData.tel" />
      </el-form-item>
      <el-form-item label="用户类型">
        <el-select v-model="formData.type">
          <el-option
              v-for="(item, index) in userTypes"
              :key="index"
              :label="item"
              :value="index">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="用户状态">
        <el-select v-model="formData.status">
          <el-option
              v-for="(item, index) in userStatus"
              :key="index"
              :label="item"
              :value="index">
          </el-option>
        </el-select>
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

interface User {
  userId: Number;
  username: String;
  password: String;
  email: String;
  tel: String;
  type: String;
  status: String;
}

export default {
  name: "DataTable",

  setup() {
    const formVisible = ref(false);
    const formData = ref<User>({
      userId: 0,
      username: "",
      password: "",
      email: "",
      tel: "",
      type: "",
      status: ""
    });
    const api: any = inject("$api");

    const userTypes = ["管理员", "普通用户"]
    const userStatus = ["未审核", "审核中", "审核通过"]

    let pageCount = ref();
    const data = ref();

    const getList = (page: number) => {
      api.get("/user/list", {page: page, size: 10})
          .then((res: AjaxResult<PageData<User>>) => {
            data.value = res.data.content;
            pageCount.value = res.data.totalPages;
            changeInfo();
      });
    };

    const changeInfo = () => {
      for (let i = 0; i < data.value.length; i++) {
        data.value[i].typeName = userTypes[data.value[i].type]
        data.value[i].statusName = userStatus[data.value[i].status]
      }
    }

    const handleEdit = (row: User) => {
      formData.value = row;
      formVisible.value = true;
    };

    const handleDelete = (row: User) => {
      ElMessageBox.confirm("此操作将永远删除该数据！", "警告", {
        confirmButtonText: "删除",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          api
            .post("/user/delete", row.userId)
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

      api
        .post("/user/edit", formData.value)
        .then((res: AjaxResult<string>) => {
          ElMessage.success({
            type: "success",
            message: res.msg,
          });

          getList(1);
        });
    };

    onMounted(() => {
      getList(1);
    });

    return {
      data,
      pageCount,
      formVisible,
      formData,
      userStatus,
      userTypes,
      getList,
      handleEdit,
      handleDelete,
      handleSubmit,
    };
  },
};
</script>

<style scoped></style>
