<template>
  <div>
    <el-form ref="form" :model="model" label-width="80px">
      <el-form-item label="标题">
        <el-input v-model="model.title"></el-input>
      </el-form-item>
       <el-form-item label="排序">
        <el-input type="number" v-model="model.sortId"></el-input>
      </el-form-item>
       <el-form-item label="级别">
        <el-input type="number" v-model="model.level"></el-input>
      </el-form-item>
       <el-form-item label="链接">
        <el-input  v-model="model.url"></el-input>
      </el-form-item>
       <el-form-item label="链接类型">
        <el-input type="number" v-model="model.urlType"></el-input>
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