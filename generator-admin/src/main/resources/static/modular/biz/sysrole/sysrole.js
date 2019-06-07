/**
 * 角色222管理初始化
 */
var SysRole = {
    id: "SysRoleTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SysRole.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
	     {title: 'Id', field: 'id', align: 'center', valign: 'middle'},
	     {title: '角色名称', field: 'roleName', align: 'center', valign: 'middle'},
	     {title: '备注', field: 'remark', align: 'center', valign: 'middle'},
	     {title: '创建者ID', field: 'createUserId', align: 'center', valign: 'middle'},
	     {title: '创建时间', field: 'createTime', align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
SysRole.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        SysRole.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加角色222
 */
SysRole.openAddSysRole = function () {
    var index = layer.open({
        type: 2,
        title: '添加角色222',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/sysrole/goto_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看角色222详情
 */
SysRole.openSysRoleDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '角色222详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/sysrole/goto_update/' + SysRole.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除角色222
 */
SysRole.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/sysrole/delete", function (data) {
            Feng.success("删除成功!");
            SysRole.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("sysroleId",this.seItem.id);
        ajax.start();
    }
};

SysRole.formParams = function() {
    var queryData = {};
    return queryData;
};

/**
 * 查询角色222列表
 */
SysRole.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    SysRole.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = SysRole.initColumn();
    var table = new BSTable(SysRole.id, "/sysrole/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(SysRole.formParams());
    SysRole.table = table.init();
});
