<template>
  <div id="footer">
    <div class="row">
      <div class="col-sm-4 my-2">
<!--        <ul v-for="items in array" class="nav flex-column">-->
<!--          <li v-for="item in items" class="nav-item">-->
<!--            {{ item }}-->
<!--          </li>-->
<!--        </ul>-->
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";

@Options({
  data() {
    return {
      array: [
        ["关于我们", "关于我们", "关于我们", "关于我们"],
        ["关于我们", "关于我们", "关于我们", "关于我们"],
        ["关于我们", "关于我们", "关于我们", "关于我们"]
      ],
    };
  },
})
export default class Footer extends Vue {}
</script>

<style scoped>
#footer {
  padding: 14px 40px;
  background-color: hsl(40, 15%, 25%) !important;
  color: rgba(255, 255, 255, .4);
  height: 60px;
}

.row {
  display: flex;
  flex-wrap: wrap;
  margin: 0 -15px;
}

.col-sm-4 {
  flex: 0 0 33.3%;
  max-width: 33.3%;
}

.my-2 {
  margin-top: .5rem !important;
}

.nav {
  display: flex;
  flex-wrap: wrap;
  padding-left: 0;
  margin-bottom: 0;
  list-style: none;
}
</style>
