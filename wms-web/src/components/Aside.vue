<template>
  <el-menu
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    default-active="/Home"
    style="height: 100%;"
    :collapse="isCollapse"
    :collapse-transition="false"
    router
  >
    <el-menu-item index="/Home">
      <i class="el-icon-s-home"></i><span slot="title">首页</span>
    </el-menu-item>
    <el-menu-item :index="'/' + item.menuClick" v-for="(item, i) in menu" :key="i">
      <i :class="item.menuIcon"></i>
      <span slot="title">{{item.menuName}}</span>
    </el-menu-item>

<!--    <el-menu-item index="/Admin">-->
<!--      <i class="el-icon-s-flag"></i>-->
<!--      <span slot="title">导航一</span>-->
<!--    </el-menu-item>-->

  </el-menu>
</template>

<script>
export default {
  name: "Aside",
  data() {
    return {
      // isCollapse: false,
      // menu: [
      //   {
      //     menuClick: 'Admin',
      //     menuName: '管理员管理',
      //     menuIcon: 'el-icon-s-custom'
      //   },
      //   {
      //     menuClick: 'User',
      //     menuName: '用户管理管理',
      //     menuIcon: 'el-icon-user-solid'
      //   }

      // ]
    }
  },
  props: {
    isCollapse: Boolean
  },
  computed: {
    'menu': {
      get() {
        console.log(this.$store)
        return this.$store.state.menu
      }
    }
  }

}
</script>

<style scoped>

</style>
