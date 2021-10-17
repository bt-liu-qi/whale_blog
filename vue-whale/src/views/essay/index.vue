<template>
  <div class="app-container">
    <el-card style="padding:5px">
      <div class="query">
        <el-form :model="query" :size="mini" :inline="true">
          <el-form-item label="标题" >
            <el-input v-model="query.title" height="20"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card>
      <el-table
        v-loading="listLoading"
        :data="list"
        element-loading-text="Loading"
        border
        fit
        highlight-current-row
        tooltip-effect="dark"
      >
        <el-table-column align="center" label="ID" width="95">
          <template slot-scope="scope">
            {{ scope.$index }}
          </template>
        </el-table-column>
        <el-table-column label="标题" width="180" show-overflow-tooltip>
          <template slot-scope="scope">
            {{ scope.row.title }}
          </template>
        </el-table-column>
        <el-table-column label="作者" width="110" align="center">
          <template slot-scope="scope">
            <span>{{ scope.row.author }}</span>
          </template>
        </el-table-column>
        <el-table-column label="分类" width="110" align="center">
          <template slot-scope="scope"> {{ scope.row.className }} 级 </template>
        </el-table-column>
        <el-table-column label="封面" width="110" align="center">
          <template slot-scope="scope">
              <img :src="scope.row.coverUrl"/>
          </template>
        </el-table-column>
        <el-table-column label="状态" width="110" align="center">
          <template slot-scope="scope">
            <el-tag>{{
              scope.row.status == "1" ? "发布" : "未发布"
            }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="发布时间" width="110" align="center" show-overflow-tooltip>
          <template slot-scope="scope"> {{ scope.row.createTime }}</template>
        </el-table-column>
        <el-table-column
          align="center"
          prop="created_at"
          label="操作"
          width="200"
        >
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small"
              >查看</el-button
            >
            <el-button @click="handleEdit(scope.row)" type="text" size="small"
              >编辑</el-button
            >
            <el-button
              @click="handleDeleted(scope.row)"
              type="text"
              size="small"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="query.current"
        :page-sizes="[100, 200, 300, 400]"
        :page-size="query.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="query.total"
      >
      </el-pagination>
    </el-card>
    <!-- <el-card>
         <div class="block">
   
  </div>
    </el-card> -->
    <el-dialog title="编辑" :visible.sync="dialogTableVisible">
      <edit ref="edit" @editClosed="editClosed" v-bind:model="model" />
    </el-dialog>
  </div>
</template>

<script>
import { getList, deleted } from "@/api/essay";
import edit from "@/views/essay/edit.vue";
export default {
  components: {
    edit: edit,
  },
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: "success",
        draft: "gray",
        deleted: "danger",
      };
      return statusMap[status];
    },
  },
  data() {
    return {
      list: null,
      listLoading: true,
      dialogTableVisible: false,
      current: 1,
      model: {},
      query: {
          total: 0,
          current: 1,
          pageSize: 10
      },
    };
  },
  mounted() {
    // var that = this;
    // setInterval(() => {
    //   this.fetchData();
    // }, 3000);
  },
  created() {
    this.fetchData();
  },
  methods: {
    handleDeleted(row) {
      deleted([row.id]).then((res) => {
        this.fetchData();
      });
    },
    editClosed() {
      this.dialogTableVisible = false;
      this.fetchData()
    },

    handleEdit(row) {
      this.model = row;
      this.dialogTableVisible = true;
    },
    fetchData() {
      this.listLoading = true;
      getList().then((response) => {
        this.list = response.data.records;
        this.listLoading = false;
        this.query.current = response.data.current
        this.query.total = response.data.total
      });
    },
  },
};
</script>

<style scoped>
    .query{
        margin-top: 5px;
        height: 25px;
        
    }
</style>