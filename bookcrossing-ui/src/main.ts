import { createApp } from 'vue'
import App from './App.vue'
import store from './store'
import api from './request'

const app = createApp(App).use(store)

// app.config.globalProperties.$api = api

app.provide('$api', api)

app.mount('#app')
