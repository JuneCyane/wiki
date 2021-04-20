<template>
  <a-layout>
    <a-layout-sider width="200" style="background: #fff">
      <a-menu>
        <a-sub-menu key="sub1">
          <template #title>
            <span><user-outlined/>subnav 111</span>
          </template>
          <a-menu-item key="1">option1</a-menu-item>
          <a-menu-item key="2">option2</a-menu-item>
          <a-menu-item key="3">option3</a-menu-item>
          <a-menu-item key="4">option4</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub2">
          <template #title>
            <span><laptop-outlined/>subnav 2</span>
          </template>
          <a-menu-item key="5">option5</a-menu-item>
          <a-menu-item key="6">option6</a-menu-item>
          <a-menu-item key="7">option7</a-menu-item>
          <a-menu-item key="8">option8</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub3">
          <template #title>
            <span><notification-outlined/>subnav 3</span>
          </template>
          <a-menu-item key="9">option9</a-menu-item>
          <a-menu-item key="10">option10</a-menu-item>
          <a-menu-item key="11">option11</a-menu-item>
          <a-menu-item key="12">option12</a-menu-item>
        </a-sub-menu>
      </a-menu>
    </a-layout-sider>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
      <pre>
{{ ebooks }}

{{ ebooks2 }}
      </pre>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef} from 'vue';
import axios from 'axios';

export default defineComponent({
  name: 'Home',
  setup() {
    console.log("setup");
    //响应式数据
    const ebooks = ref();
    const ebooks1 = reactive({books: []});

    onMounted(() => {
      //初始化函数建议写在生命周期里
      console.log("onMounted");
      axios.get("http://localhost:8880/ebook/list?name=Spring").then((response) => {
        const data = response.data;
        //对应的电子书列表
        ebooks.value = data.content;
        ebooks1.books = data.content;
        console.log(response);
      });
    });
    //最后把ebooks的数据return回去
    return {
      ebooks,

      ebooks2: toRef(ebooks1,"books")
    }
  }
})
</script>
