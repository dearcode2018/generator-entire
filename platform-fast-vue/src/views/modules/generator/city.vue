<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" @input="getDataList()" clearable></el-input>		
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()" type="info">查询</el-button>
        <el-button v-if="isAuth('generator:city:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('generator:city:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
		<!-- @input 监听 输入框、下拉框的变化，调用搜索方法刷新视图即可 -->
		<el-select v-model="dataForm.type" placeholder="请选择" @input="getDataList()">
			<!--参数为空不用定义 -->			
			<el-option label="类型" />			
			<el-option value="1" label="直辖市" />
			<el-option value="2" label="首府" />	
			<el-option value="3" label="地级市" />			
			<el-option value="4" label="县级市" />							
		</el-select>	
		<el-select v-model="dataForm.status" placeholder="请选择" @input="getDataList()">
			<!--参数为空不用定义 -->		
			<el-option label="状态" />	
			<el-option value="1" label="有效" />
			<el-option value="0" label="无效" />						
		</el-select>		  
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="id"
        header-align="center"
        align="center"
        label="主键">
      </el-table-column>
      <el-table-column
        prop="name"
        header-align="center"
        align="center"
        label="名称">
      </el-table-column>
      <el-table-column
        prop="shortname"
        header-align="center"
        align="center"
        label="简称">
      </el-table-column>
      <el-table-column
        prop="fullname"
        header-align="center"
        align="center" width="200"
        label="全称">
      </el-table-column>
      <el-table-column
        prop="province"
        header-align="center"
        align="center"
        label="省份">
      </el-table-column>
      <el-table-column
        prop="postalcode"
        header-align="center"
        align="center"
        label="邮政编码">
      </el-table-column>
      <el-table-column
        prop="status"
        header-align="center"
        align="center"
        label="状态">
      <template slot-scope="scope">
        <!-- 随便你自定义，通过（scope.row）拿到当前行数据-->
		<div v-if="scope.row.status==1">有效</div>
		<div v-else-if="scope.row.status==0">无效</div>		
		<div v-else>未知</div>				
      </template>		
      </el-table-column>
      <el-table-column
        prop="type"
        header-align="center"
        align="center"
        label="类型">
      <template slot-scope="scope">
        <!-- 随便你自定义，通过（scope.row）拿到当前行数据-->
		<div v-if="scope.row.type==1">直辖市</div>
		<div v-else-if="scope.row.type==2">首府</div>
		<div v-else-if="scope.row.type==3">地级市</div>		
		<div v-else-if="scope.row.type==4">县级市</div>				
		<div v-else>未知</div>				
      </template>			
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './city-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/generator/city/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key,
			'status': this.dataForm.status,
			'type': this.dataForm.type 
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },  
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/generator/city/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    },
	// 地理位置
	geography(array) {
		var result = "";
		array.forEach(item => {
			if (1 == item)
			{
				result += "平原";
			} else if (2 == item)
			{
				result += "丘陵";
			} else if (3 == item)
			{
				result += "多山";
			} else if (4 == item)
			{
				result += "高原";
			} else if (5 == item)
			{
				result += "盆地";
			}
		});

		return result;
	}
  }
  
  function a() {
	return "啊"
  }
</script>
