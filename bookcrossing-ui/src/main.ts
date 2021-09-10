import { createApp } from "vue";
import App from "./App.vue";
import api from "./request";
import router from "./router";
import store from "./store";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import "./assets/css/common.less";

const app = createApp(App);

app.use(store);
app.use(router);
app.use(ElementPlus);
app.provide("$api", api);
app.mount("#app");
