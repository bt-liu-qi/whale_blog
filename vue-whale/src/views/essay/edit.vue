<template>
  <div>
    <el-form ref="form" :model="model" label-width="80px">
      <el-form-item label="标题">
        <el-input v-model="model.title"></el-input>
      </el-form-item>
       <el-form-item label="作者">
        <el-input  v-model="model.author"></el-input>
      </el-form-item>
       <el-form-item label="分类">
        <el-input  v-model="model.className"></el-input>
      </el-form-item>
       <el-form-item label="状态">
        <el-input  v-model="model.url"></el-input>
      </el-form-item>
       <el-form-item label="发布时间">
        <el-input v-model="model.urlType"></el-input>
      </el-form-item>
       <el-form-item label="css样式">
        <el-input v-model="model.cssClass"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit(model)">立即提交</el-button>
        <el-button @click="editCloss">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {update} from '@/api/navigationBar'
export default {
  props: {
    model: Object,
    required: true,
  },
  data() {
    return {
      
    };
  },
  methods:{
      onSubmit(){
        update({...this.model}).then(res => {
            this.$emit("editClosed")
        })
      },
      editCloss(){
          this.$emit("editClosed")
      }
  }
};
</script>

<style>
</style>