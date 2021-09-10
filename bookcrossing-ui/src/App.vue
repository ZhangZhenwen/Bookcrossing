<template>
  <TopNav />
  <router-view />
  <Footer />
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";
import TopNav from "@/components/TopNav.vue";
import Footer from "@/components/Footer.vue";

@Options({
  components: {
    TopNav,
    Footer,
  },
})
export default class App extends Vue {}
</script>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  font-size: 16px;
  color: #2c3e50;
}

* {
  margin: 0;
  padding: 0;
  border: 0;
}
</style>
