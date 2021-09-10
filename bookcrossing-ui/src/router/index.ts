import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Index from "../views/Index.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "Index",
    component: Index,
  },
  {
    path: "/register",
    name: "Register",
    component: () =>
      import("../views/Register.vue")
  },
  {
    path: "/login",
    name: "Login",
    component: () =>
        import("../views/Login.vue")
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
