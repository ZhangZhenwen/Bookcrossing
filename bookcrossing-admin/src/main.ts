import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import ElementPlus from "element-plus";
import "element-plus/lib/theme-chalk/index.css";
import api from "./request";
import "@/assets/common.css";

const app = createApp(App);
app.use(store);
app.use(router);
app.use(ElementPlus);
app.provide("$api", api);
app.mount("#app");
