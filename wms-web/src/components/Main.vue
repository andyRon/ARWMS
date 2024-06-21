<template>
  <div>
    <div style="margin-bottom: 5px;">
      <el-input v-model="name" @keyup.enter.native="loadPost" placeholder="请输入名字" suffix-icon="el-icon-search" style="width: 200px"></el-input>
      <el-select v-model="sex" filterable placeholder="请选择性别" style="margin-left: 5px;">
        <el-option
          v-for="item in sexs"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>

      <el-button type="primary" style="margin-left: 5px;" @click="loadPost">查询</el-button>
      <el-button type="success" @click="resetParam">重置</el-button>
      <el-button type="primary" style="margin-left: 5px;" @click="add">新增</el-button>
    </div>
    <el-table :data="tableData"
              :header-cell-style="{background: '#f3f6fd', color: '#555'}"
              border
      >
      <el-table-column prop="id" label="ID" width="60">
      </el-table-column>
      <el-table-column prop="no" label="账号" width="180">
      </el-table-column>
      <el-table-column prop="name" label="姓名" width="180">
      </el-table-column>
      <el-table-column prop="age" label="年龄" width="80">
      </el-table-column>
      <el-table-column
          prop="sex"
          label="性别"
          width="80">
        <template slot-scope="scope">
          <el-tag
              :type="scope.row.sex === 1 ? 'primary' : 'success'"
              disable-transitions>{{scope.row.sex === 1 ? '男' : '女'}}</el-tag>
        </template>
      </el-table-column>

      <el-table-column prop="phone" label="电话" width="180">
      </el-table-column>
      <el-table-column prop="roleId" label="角色" width="180">
        <template slot-scope="scope">
          <el-tag
              :type="scope.row.roleId === 0 ? 'danger' : (scope.row.roleId === 1 ? 'primary' : 'success')"
              disable-transitions>{{scope.row.roleId === 0 ? '超级管理员' : (scope.row.roleId  === 1 ? '管理员' : '普通账号')}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="operate" label="操作" width="180">
        <template slot-scope="scope">
          <el-button type="success" size="small" @click="mod(scope.row)">编辑</el-button>

          <el-popconfirm
            title="确定删除吗？"
            style="margin-left: 5px;"
            @confirm="del(scope.row.id)"
          >
            <el-button type="danger" size="small" slot="reference">删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[5, 10, 20]"
        :page-size="pageSize"
        layout="total,sizes,prev,pager,next,jumper"
        :total="total"
    >
    </el-pagination>

    <el-dialog
      title="提示"
      :visible.sync="centerDialogVisible"
      width="30%"
      center>
      <el-form ref="form" :model="form" label-width="80px" :rules="rules">
        <el-form-item label="账号" prop="no">
          <el-input v-model="form.no"></el-input>
        </el-form-item>
        <el-form-item label="名字" prop="name">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio-group v-model="form.sex">
            <el-radio label="1">男</el-radio>
            <el-radio label="0">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="form.phone"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="centerDialogVisible = false">取消</el-button>
        <el-button @click="save" type="primary">确定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
// import scoped from "vue/packages/compiler-sfc/src/stylePlugins/scoped";

export default {
  name: "Main",
  data() {
    let checkAge = (rule, value, callback) => {
      if(value>150){
        callback(new Error('年龄输入过大'));
      }else{
        callback();
      }
    };
    let checkDuplicate =(rule,value,callback)=>{
      if(this.form.id){
        return callback();
      }
      this.$axios.get(this.$httpUrl+"/user/findByNo?no="+this.form.no).then(res=>res.data).then(res=>{
        if(res.code != 200){
          callback()
        }else{
          callback(new Error('账号已经存在'));
        }
      })
    };

    return {
      tableData: [],
      pageNum: 1,
      pageSize: 5,
      total: 0,
      name: '',
      sex: '',
      sexs: [
        {
          value: '1',
          label: '男'
        },
        {
          value: '0',
          label: '女'
        }
      ],
      centerDialogVisible: false,
      form: {
        id: '',
        name: '',
        no: '',
        password: '',
        age: '',
        sex: '0',
        phone: '',
        roleId: '1'
      },
      rules: {
        no: [
          {required: true, message: '请输入账号', trigger: 'blur'},
          {min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur'},
          {validator:checkDuplicate,trigger: 'blur'}
        ],
        name: [
          {required: true, message: '请输入名字', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur'}
        ],
        age: [
          {required: true, message: '请输入年龄', trigger: 'blur'},
          {min: 1, max: 3, message: '长度在 1 到 3 个位', trigger: 'blur'},
          {pattern: /^([1-9][0-9]*){1,3}$/,message: '年龄必须为正整数字',trigger: "blur"},
          {validator:checkAge,trigger: 'blur'}
        ],
        phone: [
          {required: true,message: "手机号不能为空",trigger: "blur"},
          {pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/, message: "请输入正确的手机号码", trigger: "blur"}
        ]
      }
    }
  },
  methods: {
    // scoped,
    loadGet() {
      this.$axios.get(this.$httpUrl + '/user/list').then(res => res.data).then(res => {
        this.tableData = res
      })
    },
    loadPost() {
      this.$axios.post(this.$httpUrl + '/user/listPage', {
        pageSize: this.pageSize,
        pageNum: this.pageNum,
        param: {
          name: this.name,
          sex: this.sex
        }
      }).then(res => res.data).then(res => {
        if (res.code === 200) {
          this.tableData = res.data
          this.total = res.total
        } else {
          alert("获取数据失败")
        }

      })
    },
    handleSizeChange(val) {
      this.pageSize = val
      this.pageNum  = 1
      this.loadPost()
    },
    handleCurrentChange(val) {
      this.pageNum = val
      this.loadPost()
    },
    resetParam() {
      this.name = ''
      this.sex = ''
    },
    add() {
      this.centerDialogVisible = true
      this.$nextTick(() => {
        this.resetForm()
      })
    },
    save() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          if (this.form.id) {
            this.doMod()
          } else {
            this.doSave()
          }
        } else {
          console.log('error submit!!');
          return false;
        }
      })
    },
    doSave() {
      this.$axios.post(this.$httpUrl + '/user/save', this.form).then(res => res.data).then(res => {
        if (res.code === 200) {
          this.$message({
            message: '操作成功',
            type: 'success'
          });
          this.centerDialogVisible = false
          this.loadPost()
          this.resetForm()
        } else {
          this.$message({
            message: '操作失败',
            type: 'error'
          });
        }
      })
    },
    doMod() {
      this.$axios.post(this.$httpUrl + '/user/update', this.form).then(res => res.data).then(res => {
        if (res.code === 200) {
          this.$message({
            message: '操作成功',
            type: 'success'
          });
          this.centerDialogVisible = false
          this.loadPost()
          this.resetForm()
        } else {
          this.$message({
            message: '操作失败',
            type: 'error'
          });
        }
      })
    },
    resetForm() {
      this.$refs.form.resetFields();
    },
    mod(row) {
      // 先显示表单，然后再异步地加载表单数据；
      // 这样如果再关闭表单，表单的值就会回到初始空值
      // 如果赋值在前，打开表达在后，那么之后在关闭表单是，表单里的值就是赋值的值
      this.centerDialogVisible = true
      this.$nextTick(() => { // 异步
        this.form.id = row.id
        this.form.no = row.no
        this.form.name = row.name
        this.form.password = ''
        this.form.age = row.age + ''
        this.form.sex = row.sex + ''
        this.form.phone = row.phone
        this.form.roleId = row.roleId
      })
    },
    del(id) {
      console.log(id)
      this.$axios.get(this.$httpUrl + '/user/del?id=' + id, this.form).then(res => res.data).then(res => {
        if (res.code === 200) {
          this.$message({
            message: '操作成功',
            type: 'success'
          });
          this.centerDialogVisible = false
          this.loadPost()
        } else {
          this.$message({
            message: '操作失败',
            type: 'error'
          });
        }
      })
    }
  },
  beforeMount() {
    // this.loadGet()
    this.loadPost()
  }
}
</script>

<style scoped>

</style>
