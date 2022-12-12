<template>

  <router-view />
</template>
<script> 
import request from '../request'
export default {
  data() {
    return {

    }
  },
  methods: {
    test() {
      request({
        url: '/api/knightcontroller/page',
        method: 'POST'
      }).then(res => {
        console.log(res)
      })
    }
  }
}

</script>

<style>
</style>
