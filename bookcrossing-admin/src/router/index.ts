import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Index from "@/views/Index.vue";

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
      },
      {
        path: "news",
        name: "News",
        component: () => import("@/views/News.vue"),
      },
      {
        path: "user",
        name: "User",
        component: () => import("@/views/User.vue"),
      },
      {
        path: "comment",
        name: "Comment",
        component: () => import("@/views/Comment.vue"),
      },
      {
        path: "bookType",
        name: "BookType",
        component: () => import("@/views/BookType.vue"),
      },
      {
        path: "book",
        name: "Book",
        component: () => import("@/views/Book.vue"),
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
