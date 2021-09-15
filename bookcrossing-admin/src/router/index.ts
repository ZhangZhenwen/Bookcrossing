import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Index from "@/views/Index.vue";
import Announcement from "@/views/Announcement.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "Index",
    component: Index,
    children: [
      {
        path: "announcement",
        name: "Announcement",
        component: () => import("@/views/Announcement.vue"),
        props: true,
      },
      {
        path: "news",
        name: "News",
        component: () => import("@/views/News.vue"),
        props: true,
      },
      {
        path: "user",
        name: "User",
        component: () => import("@/views/User.vue"),
        props: true,
      },
      {
        path: "comment",
        name: "Comment",
        component: () => import("@/views/Comment.vue"),
        props: true,
      },
      {
        path: "bookType",
        name: "BookType",
        component: () => import("@/views/BookType.vue"),
        props: true,
      },
    ],
  },
  {
    path: "/login",
    name: "Login",
    component: () => import("@/views/Login.vue")
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
