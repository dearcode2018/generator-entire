<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="名称"></el-input>
    </el-form-item>
    <el-form-item label="简称" prop="shortname">
      <el-input v-model="dataForm.shortname" placeholder="简称"></el-input>
    </el-form-item>
    <el-form-item label="全称" prop="fullname">
      <el-input v-model="dataForm.fullname" placeholder="全称"></el-input>
    </el-form-item>
    <el-form-item label="省份" prop="province">
      <el-input v-model="dataForm.province" placeholder="省份"></el-input>
    </el-form-item>
    <el-form-item label="邮政编码" prop="postalcode">
      <el-input v-model="dataForm.postalcode" placeholder="邮政编码"></el-input>
    </el-form-item>
    <el-form-item label="状态" prop="status">
		<el-radio-group v-model="dataForm.status">
			<el-radio :label="1">有效</el-radio>
			<el-radio :label="0">无效</el-radio>			
		</el-radio-group>
    </el-form-item>
    <el-form-item label="地理" prop="geography">
	   <el-checkbox-group v-model="dataForm.geography">
			<el-checkbox label="1">平原</el-checkbox>	
			<el-checkbox label="2">丘陵</el-checkbox>	
			<el-checkbox label="3">多山</el-checkbox>		
			<el-checkbox label="4">高原</el-checkbox>			
			<el-checkbox label="5">盆地</el-checkbox>						
	   </el-checkbox-group>
    </el-form-item>
    <el-form-item label="类型" prop="type">
		<el-select v-model="dataForm.type" placeholder="请选择">
			<el-option value="1" label="直辖市" />
			<el-option value="2" label="首府" />	
			<el-option value="3" label="地级市" />			
			<el-option value="4" label="县级市" />							
		</el-select>	
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          name: '',
          shortname: '',
          fullname: '',
          province: '',
          postalcode: '',
		  // 数字不用能单引号包围，否则无法识别该值
          status: 1,
		  // 复选框需要声明为数组类型，否则将出现勾选一个出现全部勾选
		  // 出现的值等于对应的lable则选中
          geography: ['2'],
		  // 要用单引号包围
          type: '3'
        },
        dataRule: {
          name: [
            { required: true, message: '名称不能为空', trigger: 'blur' }
          ],
          shortname: [
            { required: false, message: '简称能为空', trigger: 'blur' }
          ],
          fullname: [
            { required: false, message: '全称能为空', trigger: 'blur' }
          ],
          province: [
            { required: false, message: '省份能为空', trigger: 'blur' }
          ],
          postalcode: [
            { required: false, message: '邮政编码能为空', trigger: 'blur' }
          ],
          status: [
            { required: false, message: '状态能为空', trigger: 'blur' }
          ],
          geography: [
            { required: false, message: '地理', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类型不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/generator/city/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.city.name
                this.dataForm.shortname = data.city.shortname
                this.dataForm.fullname = data.city.fullname
                this.dataForm.province = data.city.province
                this.dataForm.postalcode = data.city.postalcode
                this.dataForm.status = data.city.status
				// 拆分为字符串数组即可自动勾选选项(数据库存储的是逗号隔开的)
                this.dataForm.geography = data.city.geography.split(',')
				// 变为字符串，页面自动选择下拉框选项
                this.dataForm.type = data.city.type + ''
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/city/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'shortname': this.dataForm.shortname,
                'fullname': this.dataForm.fullname,
                'province': this.dataForm.province,
                'postalcode': this.dataForm.postalcode,
                'status': this.dataForm.status,
				// 用逗号将数组元素拼接成一个字符串
                'geography': this.dataForm.geography.join(','),
                'type': this.dataForm.type
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
