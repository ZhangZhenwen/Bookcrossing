<template>
  <div id="main" class="container-fluid">
    <el-space wrap class="content">
      <div class="left-menu">
        <el-card>
          <template #header>
            <div>
              <h2>用户资料</h2>
            </div>
          </template>
          <img src="https://zhenwen66.cn/cloud/download?url=/2022/05/04/93998e90-330b-43a7-94f2-85e9cb3029f1.jpg"
               class="user-avater">
          <div><span class="user-info-font">用户名: {{ user.username }}</span></div>
          <div><span class="user-info-font">邮箱号: {{ user.email }}</span></div>
          <div><span class="user-info-font">手机号: {{ user.tel }}</span></div>
          <div>
            <el-button @click="handleUserEdit">编辑资料</el-button>
            <el-button type="danger" @click="handleLogout">退出登录</el-button>
          </div>
        </el-card>
        <el-card>
          <img src="../assets/images/cross_pic.jpg"
               class="image">
        </el-card>
      </div>


      <div class="right-menu">
        <el-card class="table-card">
          <template #header>
            <h1 style="display: inline-block">拥有的图书列表</h1>
            <el-button
              type="success"
              @click="handleBookAdd"
              style="float: right"
            >上传图书</el-button
            >
          </template>
          <el-table :data="bookList" @row-dblclick="goDetail">
            <el-table-column label="图书编号" prop="bookNo" />
            <el-table-column label="图书名称" prop="name" />
            <el-table-column label="图书作者" prop="author" />
            <el-table-column label="图书类型" prop="type" />
            <el-table-column label="图书状态" prop="status" />
            <el-table-column label="上传时间" prop="createDate" />
            <el-table-column label="操作" width="200px">
              <template #default="scope">
                <el-button size="mini" @click="handleBookEdit(scope.row)"
                  >编辑</el-button
                >
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleBookDelete(scope.row)"
                  >下架</el-button
                >
              </template>
            </el-table-column>
          </el-table>
        </el-card>
        <el-card class="table-card">
          <template #header>
            <h1>申请图书的列表</h1>
          </template>
          <el-table :data="applyList">
            <el-table-column label="图书编号" prop="bookNo" />
            <el-table-column label="图书名称" prop="name" />
            <el-table-column label="图书作者" prop="author" />
            <el-table-column label="上传时间" prop="createDate" />
            <el-table-column label="申请人" prop="username" />
            <el-table-column label="申请时间" prop="updateDate" />
            <el-table-column label="操作" width="200px">
              <template #default="scope">
                <el-button
                  type="success"
                  size="mini"
                  @click="agreeApply(scope.row)"
                  >同意</el-button
                >
                <el-button
                  size="mini"
                  type="danger"
                  @click="refuseApply(scope.row)"
                  >拒绝</el-button
                >
              </template>
            </el-table-column>
          </el-table>
        </el-card>
        <el-card class="table-card">
          <template #header>
            <h1>漂流信息</h1>
          </template>
          <el-table :data="crossInfoList">
            <el-table-column label="图书编号" prop="bookNo" />
            <el-table-column label="图书名称" prop="name" />
            <el-table-column label="图书作者" prop="author" />
            <el-table-column label="上传时间" prop="createDate" />
            <el-table-column label="漂流状态" prop="status" />
            <el-table-column label="更新时间" prop="updateDate" />
          </el-table>
        </el-card>
      </div>
    </el-space>
  </div>

  <el-dialog title="用户资料修改" v-model="userFormVisible" width="30%">
    <el-form v-model="userForm">
      <el-form-item label="用户名">
        <el-input v-model="userForm.username" />
      </el-form-item>
      <el-form-item label="邮箱号">
        <el-input v-model="userForm.email" />
      </el-form-item>
      <el-form-item label="手机号">
        <el-input v-model="userForm.tel" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="userFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleSubmit">确 定</el-button>
      </span>
    </template>
  </el-dialog>

  <el-dialog title="图书信息" v-model="bookFormVisible" width="30%">
    <el-form v-model="bookForm">
      <el-form-item label="图书编号">
        <el-input v-model="bookForm.bookNo" />
      </el-form-item>
      <el-form-item label="图书名">
        <el-input v-model="bookForm.name" />
      </el-form-item>
      <el-form-item label="作者名称">
        <el-input v-model="bookForm.author" />
      </el-form-item>
      <el-form-item label="图书简介">
        <el-input v-model="bookForm.introduction" />
      </el-form-item>
      <el-form-item label="图书类型">
        <el-select v-model="bookForm.type">
          <el-option
            v-for="item in bookTypes"
            :key="item.bookTypeId"
            :label="item.typeName"
            :value="item.bookTypeId">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="图书状态">
        <el-select v-model="bookForm.status">
          <el-option
              v-for="item in bookStatus"
              :key="item.status"
              :label="item.statusName"
              :value="item.status">
          </el-option>
        </el-select>
      </el-form-item>
      <el-upload
          ref="upload"
          class="upload-demo"
          :headers="headers"
          action="/api/upload_book_pdf"
          :limit="1"
          :on-success="uploadPdf"
      >
        <el-button type="primary">
          选择文件
        </el-button>
        <template #tip>
          <div class="el-upload__tip text-red">
            limit 1 file, new file will cover the old file
          </div>
        </template>
      </el-upload>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="bookFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleSubmit">确 定</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script lang="ts">
import {AjaxResult, Book, BookType, PageData} from "@/assets/js";
import { inject, ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import { ElMessage, ElMessageBox } from "element-plus";

interface User {
  userId: Number;
  username: String;
  email: String;
  tel: String;
}

export default {
  name: "User",

  setup() {
    let submitFunc: String = "";
    const user = ref<User>({
      userId: 0,
      username: "",
      email: "",
      tel: "",
    });
    const api: any = inject("$api");
    const router = useRouter();
    const store = useStore();

    const bookFormVisible = ref<boolean>();
    const bookForm = ref<Book>({
      bookId: 0,
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

    const userFormVisible = ref<boolean>();
    const userForm = ref<User>({
      userId: 0,
      username: "",
      email: "",
      tel: "",
    });
    const headers = ref({Authorization: localStorage.getItem("token")});
    const bookTypes = ref();
    const bookStatus = [{"status": "0", "statusName": "上传中"},
      {"status": "1", "statusName": "可漂流"},
      {"status": "2", "statusName": "已漂流"}]
    const bookList = ref();
    const crossInfoList = ref();
    const applyList = ref();

    const goDetail = (row: any) => {
      router.push({
        name: "Detail",
        params: {
          bookId: row.bookId,
        }
      });
    }

    const uploadPdf = (res: AjaxResult<string>) => {
      bookForm.value.pdfUrl = res.data
      console.log(bookForm.value.pdfUrl)
    }

    const getUserInfo = () => {
      api.get("/getInfo").then((res: AjaxResult<User>) => {
        user.value = res.data;
        getCrossInfoList();
        getApplyList();
        getBookTypes();
      });
    };

    const getBookList = () => {
      api
        .get("/book/vo", { userId: user.value.userId })
        .then((res: AjaxResult<PageData<object>>) => {
          bookList.value = res.data.content;
        });
    };

    const getCrossInfoList = () => {
      api
        .get("/crossInfo/user_vo", { userId: user.value.userId })
        .then((res: AjaxResult<PageData<object>>) => {
          crossInfoList.value = res.data.content;
        });
    };

    const getApplyList = () => {
      api
        .get("/crossInfo/applyList")
        .then((res: AjaxResult<PageData<object>>) => {
          applyList.value = res.data.content;
        });
    };

    const getBookTypes = () => {
      api
        .get("bookType/list")
        .then((res: AjaxResult<PageData<BookType>>) => {
          bookTypes.value = res.data.content;
          getBookList();
        });
    };

    const agreeApply = (row: any) => {
      api
        .post("crossInfo/agree", row)
        .then((res: AjaxResult<boolean>) => {
          ElMessage.success({
            message: "同意漂流成功！图书已经出发！",
            type: "success",
          });
          getApplyList();
          getBookList();
        });
    };

    const refuseApply = (row: any) => {
      api
        .post("crossInfo/refuse", row)
        .then((res: AjaxResult<boolean>) => {
          ElMessage.success({
            message: "拒绝漂流成功！",
            type: "success",
          });
          getApplyList();
        });
    };

    const handleBookAdd = () => {
      console.log(bookFormVisible);
      bookFormVisible.value = true;
      submitFunc = "book.add";
    };

    const handleBookEdit = (row: Book) => {
      bookFormVisible.value = true;
      bookForm.value = row;
      submitFunc = "book.edit";
    };

    const handleBookDelete = (row: Book) => {
      ElMessageBox.confirm("此操作将永远删除该数据！", "警告", {
        confirmButtonText: "删除",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          api.post("/book/delete", row.bookId)
              .then((res: AjaxResult<object>) => {
            ElMessage.success({
              type: "success",
              message: res.msg,
            });
            getBookList();
          });
        })
        .catch(() => {
          ElMessage.info({
            type: "info",
            message: "已取消删除",
          });
        });
    };

    const handleUserEdit = () => {
      userFormVisible.value = true;
      userForm.value = user.value;
      submitFunc = "user.edit";
    };

    const handleSubmit = () => {
      let func: Array<String> = submitFunc.split(".");
      let url = "/" + func[0] + "/" + func[1];
      switch (func[0]) {
        case "user":
          api.post(url, userForm.value).then((res: AjaxResult<User>) => {
            ElMessage.success({
              message: res.msg,
              type: "success",
            });
            user.value = res.data;
          });
          break;
        case "book":
          switch (func[1]) {
            case "add":
              api.post(url, bookForm.value).then((res: AjaxResult<string>) => {
                ElMessage.success({
                  message: res.msg,
                  type: "success",
                });
                getBookList();
              });
              break;

            case "edit":
              api.post(url, bookForm.value).then((res: AjaxResult<string>) => {
                ElMessage.success({
                  message: res.msg,
                  type: "success",
                });
                getBookList();
              });
              break;
          }
          break;

      }

      userFormVisible.value = false;
      bookFormVisible.value = false;
    };

    const handleLogout = () => {
      api.post("/logout").then(() => {
        localStorage.removeItem("token");
        store.commit("setLoginStatus", false);
        ElMessage.success({
          message: "退出登录成功！",
          type: "success",
        });
        goIndex();
      });
    };

    const goIndex = () => {
      router.push("/");
    };

    onMounted(() => {
      getUserInfo();
    });

    return {
      headers,
      user,
      userFormVisible,
      userForm,
      bookFormVisible,
      bookForm,
      bookList,
      bookStatus,
      bookTypes,
      crossInfoList,
      applyList,

      goDetail,

      agreeApply,
      refuseApply,

      handleBookAdd,
      handleBookEdit,
      handleBookDelete,
      uploadPdf,

      handleUserEdit,
      handleSubmit,
      handleLogout,
    };
  },
};
</script>

<style scoped>
.left-menu {
  position: fixed;
  bottom: 110px;
}

.right-menu {
  margin-left: 260px;;
}

#main {
  padding-top: 90px;
}

.container-fluid {
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}

.user-info-font {
  line-height: 50px;
  font-size: 18px;
}

.content {
  margin: 0 220px;
  min-height: 900px;
}

.table-card {
  width: 1150px;
}

.user-avater {
  width: 200px;
  display: block;
}

.image {
  width: 200px;
  display: block;
}
</style>
