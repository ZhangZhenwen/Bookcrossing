<template>
  <div id="main" class="container-fluid">
    <div id="home-splash">
      <div id="found-a-book" class="text-center"></div>
      <h1 class="text-center">欢迎莅临世界的图书馆！</h1>
      <div id="endorsements" class="row">
        <div class="col">
          <ul>
            <li><em>爱书，就让它走</em>－－《纽约时报》</li>
            <li><em>一个难以置信的全球性社会学实验</em>－－《爱书杂志》</li>
            <li><em>现代版瓶中信</em>－－《三藩市（旧金山）纪事报》</li>
          </ul>
        </div>
      </div>
      <div id="home-lede" class="row">
        <div class="col-sm-12 col-md-10 offset-md-1">
          寻找书籍、分享书本、遇见爱书同好，是如此地简单。
        </div>
      </div>
      <div class="container-fluid">
        <div id="big-buttons" class="row my-4">
          <div class="col-sm-12 col-md-10 offset-md-1">
            <div class="row">
              <div class="col-lg-4">
                <router-link
                  to="/"
                  class="btn btn-outline-primary btn-lg btn-block my-2"
                  >关于我們</router-link
                >
              </div>
              <div class="col-lg-4">
                <router-link
                  to="/main"
                  class="btn btn-outline-primary btn-lg btn-block my-2"
                  >如何书游</router-link
                >
              </div>
              <div class="col-lg-4">
                <router-link
                  to="/register"
                  class="btn btn-outline-primary btn-lg btn-block my-2"
                  >注册 <i class="fas fa-smile-beam"></i
                ></router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div id="fb-likes">
        <div
          class="fb-like"
          data-href="https://www.facebook.com/BookCrossingOfficial"
          data-width="260"
          data-layout="standard"
          data-colorscheme="dark"
          data-action="like"
          data-size="large"
          data-show-faces="true"
          data-share="true"
        ></div>
      </div>
    </div>
    <div
      class="expanded-width"
      style="background-color: white; margin-bottom: -22px"
    >
      <h2 class="home-h2 text-center mt-0 pt-4">BookCrossing 傳媒中心</h2>
      <div id="press-logos">
        <img
          src="https://d3nc0ar6dmrp7n.cloudfront.net/press-logos-750x388.jpg"
        />
      </div>
    </div>
    <div class="row my-3">
      <div class="col-sm-4 offset-sm-4">
        <a href="/register" class="btn btn-primary btn-lg btn-block"
          >註冊 <i class="fas fa-smile-beam"></i
        ></a>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
export default {
  name: "Index",
};
</script>

<style scoped>
#main {
  padding-top: 90px;
}

.container-fluid {
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}

#home-splash {
  width: auto;
  min-height: 600px;
  margin-top: -22px;
  margin-left: -15px;
  margin-right: -15px;
  padding: 12px 15px 1rem;
  background-color: hsl(40, 15%, 25%);
  background-image: url(../assets/images/park-bench-dark.jpg);
  background-size: cover;
  background-position: bottom center;
  color: rgba(255, 255, 255, 0.8);
}

#home-splash h1 {
  font-size: 3rem;
  font-size: 7vw;
  color: rgba(255, 255, 255, 0.8);
  opacity: 1;
  font-weight: 700;
  text-shadow: 4px 4px 15px rgb(0 0 0 / 40%);
}

#found-a-book {
  height: 137px;
}

.small {
  padding-top: 64px;
  font-size: 80%;
  font-weight: 400;
}

#home-lede {
  font-size: 1.3rem;
  line-height: 1.5;
  padding-left: 15px;
  padding-right: 15px;
}

.offset-md-1 {
  margin-left: 8.333333%;
}

.col-md-10 {
  flex: 0 0 83.333333%;
  max-width: 83.333333%;
}

.row {
  display: -ms-flexbox;
  display: flex;
  margin-right: -15px;
  margin-left: -15px;
}

#endorsements {
  text-align: center;
  margin: 20px auto;
}

#endorsements ul {
  margin: 0;
  padding: 0;
}

#endorsements li {
  font-size: 0.9rem;
  text-align: center;
  padding: 0 24px;
  width: 240px;
  display: inline-block;
  margin-bottom: 1.1em;
}

#endorsements em {
  font-size: 1.1rem;
  line-height: 1.2;
  font-weight: 600;
  display: block;
  font-style: italic;
}

.col {
  flex-basis: 0;
  flex-grow: 1;
  max-width: 100%;
}

.my-4 {
  margin-top: 1.5rem !important;
}

.col-lg-4 {
  -ms-flex: 0 0 33.333333%;
  flex: 0 0 33.333333%;
  max-width: 33.333333%;
  position: relative;
  width: 100%;
  min-height: 1px;
  padding-right: 15px;
  padding-left: 15px;
}

#home-splash #big-buttons .btn {
  color: white;
  border-color: white;
}
.btn:not(:disabled):not(.disabled) {
  cursor: pointer;
}

.my-2 {
  margin-bottom: 0.5rem !important;
}

.my-2 {
  margin-top: 0.5rem !important;
}
.btn-block {
  display: block;
}
.btn-group-lg > .btn,
.btn-lg {
  padding: 0.5rem 1rem;
  font-size: 1.25rem;
  line-height: 1.5;
  border-radius: 0.3rem;
}
.btn-outline-primary {
  color: #007bff;
  background-color: transparent;
  background-image: none;
  border-color: #007bff;
}

.btn {
  font-weight: 400;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  user-select: none;
  border: 1px solid transparent;
  border-radius: 0.25rem;
  transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out,
    border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

.expanded-width {
  margin-left: -15px;
  margin-right: -15px;
}

.pt-4,
.py-4 {
  padding-top: 1.5rem !important;
}
.mt-0,
.my-0 {
  margin-top: 0 !important;
}

#press-logos {
  position: relative;
  width: 100%;
  height: auto;
  max-width: 750px;
  margin: 0 auto;
}

img {
  vertical-align: middle;
  border-style: none;
}

h2.home-h2 {
  text-align: center;
  font-size: 4vw;
  margin-top: 40px;
}

.h1,
.h2,
.h3,
.h4,
.h5,
h1,
h2,
h3,
h4,
h5 {
  font-family: "IBM Plex Sans Condensed", "IBM Plex Sans", -apple-system,
    BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif,
    "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
  opacity: 0.7;
  font-weight: 700;
}

.mb-3,
.my-3 {
  margin-bottom: 1rem !important;
}
.mt-3,
.my-3 {
  margin-top: 1rem !important;
}

.offset-sm-4 {
  margin-left: 33.333333%;
}

.col-sm-4 {
  -ms-flex: 0 0 33.333333%;
  flex: 0 0 33.333333%;
  max-width: 33.333333%;
  position: relative;
  width: 100%;
  min-height: 1px;
  padding-right: 15px;
  padding-left: 15px;
}

.btn:not(:disabled):not(.disabled) {
  cursor: pointer;
}
.btn-group-lg > .btn,
.btn-lg {
  padding: 0.5rem 1rem;
  font-size: 1.25rem;
  line-height: 1.5;
  border-radius: 0.3rem;
}
.btn-primary {
  color: #fff;
  background-color: #007bff;
  border-color: #007bff;
}
</style>
