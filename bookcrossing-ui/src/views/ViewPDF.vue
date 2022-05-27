<template>
  <div>
    <div class="div">
      <el-button @click="prev">上一页</el-button>
      <el-button @click="next">下一页</el-button>
      <el-button @click="zoomA">放大</el-button>
      <el-button @click="zoomB">缩小</el-button>
    </div>
    <vue-pdf-embed :source="source"
                   class="vue-pdf-embed"
                   :style="scaleFun"
                   :page="pageNum" />
  </div>
</template>

<script>
import VuePdfEmbed from "vue-pdf-embed";
import { createLoadingTask } from "vue3-pdfjs/esm"; // 获得总页数

export default {
  components: {
    VuePdfEmbed,
  },
  props: ["url"],
  data() {
    return {
      source: "http://localhost:8080/download?url=/2022/05/24/0_准考证.pdf",
      pageNum: 1,
      scale: 1,  // 缩放比例
      numPages: 0, // 总页数
    };
  },
  mounted() {
    const loadingTask = createLoadingTask(this.source);
    loadingTask.promise.then((pdf) => {
      this.numPages = pdf.numPages;
    });
  },
  computed: {
    scaleFun(index) { // 缩放
      var scale = this.scale;
      return `transform:scale(${scale})`;
    },
  },
  methods: {
    prev() {
      if (this.pageNum > 1) {
        this.pageNum -= 1;
      }
    },
    next() {
      if (this.pageNum < this.numPages) {
        this.pageNum += 1;
      }
    },
    zoomA() {
      this.scale += 0.1;
    },
    zoomB() {
      this.scale -= 0.1;
    },
  },
};
</script>

<style scoped>
.div {
  top: 0;
  position: fixed;
  z-index: 999;
}
.vue-pdf-embed {
  text-align: center;
}
</style>