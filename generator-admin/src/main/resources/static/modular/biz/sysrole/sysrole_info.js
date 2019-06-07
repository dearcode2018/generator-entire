/**
 * 初始化角色222详情对话框
 */
var SysRoleInfoDlg = {
    SysRoleInfoData : {}
};

/**
 * 清除数据
 */
SysRoleInfoDlg.clearData = function() {
    this.SysRoleInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SysRoleInfoDlg.set = function(key, val) {
    this.SysRoleInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SysRoleInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SysRoleInfoDlg.close = function() {
    parent.layer.close(window.parent.SysRole.layerIndex);
}

/**
 * 收集数据
 */
SysRoleInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
SysRoleInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/SysRole/add", function(data){
        Feng.success("添加成功!");
        window.parent.SysRole.table.refresh();
        SysRoleInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.SysRoleInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SysRoleInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/SysRole/update", function(data){
        Feng.success("修改成功!");
        window.parent.SysRole.table.refresh();
        SysRoleInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.SysRoleInfoData);
    ajax.start();
}

$(function() {

});
