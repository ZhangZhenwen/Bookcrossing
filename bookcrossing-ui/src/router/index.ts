import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Index from "@/views/Index.vue";

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
      import("@/views/Register.vue")
  },
  {
    path: "/login",
    name: "Login",
    component: () =>
        import("@/views/Login.vue")
  },
  {
    path: "/user",
    name: "User",
    component: () =>
        import("@/views/User.vue")
  },
  {
    path: "/main",
    name: "Main",
    component: () => import("@/views/Main.vue")
  },
  {
    path: "/detail",
    name: "Detail",
    component: () => import("@/views/Detail.vue"),
    props: true
  },
  {
    path: "/view",
    name: "View",
    component: () => import("@/views/ViewPDF.vue"),
    props: true,
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
