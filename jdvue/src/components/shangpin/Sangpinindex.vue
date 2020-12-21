<template>
  <div id="sangpinindex">
  sssssss
  </div>
</template>

<script>
  export default {
   data(){
     return{

     }
   },
   methods:{
    selectall(){
      this.$axios.post('textcoller/selectall')
      .then(r=>{
        
      }).catch(function(e){
          console.log("报错了，错误信息：",e);
      });
    }
   },
   mounted(){
    this.selectall();
   }
  }
</script>

<style>
</style>
