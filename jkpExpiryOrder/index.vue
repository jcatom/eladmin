<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container">
      <div v-if="crud.props.searchToggle">
        <!-- 搜索 -->
        <label class="el-form-item-label">兑奖状态</label>
        <el-input v-model="query.status" clearable placeholder="兑奖状态" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <rrOperation :crud="crud" />
      </div>
      <!--如果想在工具栏加入更多按钮，可以使用插槽方式， slot = 'left' or 'right'-->
      <crudOperation :permission="permission" />
      <!--表单组件-->
      <el-dialog :close-on-click-modal="false" :before-close="crud.cancelCU" :visible.sync="crud.status.cu > 0" :title="crud.status.title" width="500px">
        <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="text" @click="crud.cancelCU">取消</el-button>
          <el-button :loading="crud.status.cu === 2" type="primary" @click="crud.submitCU">确认</el-button>
        </div>
      </el-dialog>
      <!--表格渲染-->
      <el-table ref="table" v-loading="crud.loading" :data="crud.data" size="small" style="width: 100%;" @selection-change="crud.selectionChangeHandler">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="orderNo" label="订单编号" />
        <el-table-column prop="expiryUserId" label="兑奖用户ID" />
        <el-table-column prop="ticketPhotoUrl" label="即开票图片地址" />
        <el-table-column prop="status" label="兑奖状态">
          <template slot-scope="scope">
            {{ dict.label.expiry_status[scope.row.status] }}
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label=" 创建时间" />
        <el-table-column v-if="checkPer(['admin','jkpExpiryOrder:edit','jkpExpiryOrder:del'])" label="操作" width="150px" align="center">
          <template slot-scope="scope">
            <udOperation
              :data="scope.row"
              :permission="permission"
            />
          </template>
        </el-table-column>
      </el-table>
      <!--分页组件-->
      <pagination />
    </div>
  </div>
</template>

<script>
import crudJkpExpiryOrder from '@/api/jkpExpiryOrder'
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import rrOperation from '@crud/RR.operation'
import crudOperation from '@crud/CRUD.operation'
import udOperation from '@crud/UD.operation'
import pagination from '@crud/Pagination'

const defaultForm = { id: null, orderNo: null, expiryUserId: null, ticketPhotoUrl: null, status: null, createTime: null, updateTime: null }
export default {
  name: 'JkpExpiryOrder',
  components: { pagination, crudOperation, rrOperation, udOperation },
  mixins: [presenter(), header(), form(defaultForm), crud()],
  dicts: ['expiry_status'],
  cruds() {
    return CRUD({ title: '即开票订单管理', url: 'api/jkpExpiryOrder', idField: 'id', sort: 'id,desc', crudMethod: { ...crudJkpExpiryOrder }})
  },
  data() {
    return {
      permission: {
        add: ['admin', 'jkpExpiryOrder:add'],
        edit: ['admin', 'jkpExpiryOrder:edit'],
        del: ['admin', 'jkpExpiryOrder:del']
      },
      rules: {
        id: [
          { required: true, message: '订单ID不能为空', trigger: 'blur' }
        ],
        orderNo: [
          { required: true, message: '订单编号不能为空', trigger: 'blur' }
        ],
        expiryUserId: [
          { required: true, message: '兑奖用户ID不能为空', trigger: 'blur' }
        ],
        ticketPhotoUrl: [
          { required: true, message: '即开票图片地址不能为空', trigger: 'blur' }
        ],
        status: [
          { required: true, message: '兑奖状态不能为空', trigger: 'blur' }
        ],
        createTime: [
          { required: true, message: ' 创建时间不能为空', trigger: 'blur' }
        ]
      },
      queryTypeOptions: [
        { key: 'status', display_name: '兑奖状态' }
      ]
    }
  },
  methods: {
    // 钩子：在获取表格数据之前执行，false 则代表不获取数据
    [CRUD.HOOK.beforeRefresh]() {
      return true
    }
  }
}
</script>

<style scoped>

</style>
