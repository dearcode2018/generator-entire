package com.hua.modular.sysrole.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 角色222
 *
 * @author qianye.zheng
 * @Date 2019-06-05 19:54:53
 */
@TableName("sys_role")
public class SysRoleModel extends Model<SysRoleModel> {

    private static final long serialVersionUID = 1L;

	
		     /**
		     * Id
		     * 
		     */
			@TableId(value = "id",type = IdType.AUTO)
			private Integer id;
		
		     /**
		     * 角色名称
		     * 
		     */
			@TableField(value="role_name")
			private String roleName;
		
		     /**
		     * 备注
		     * 
		     */
			@TableField(value="remark")
			private String remark;
		
		     /**
		     * 创建者ID
		     * 
		     */
			@TableField(value="create_user_id")
			private Integer createUserId;
		
		     /**
		     * 创建时间
		     * 
		     */
			@TableField(value="create_time")
			private Date createTime;
		
    
		     /**
		     * 获取: Id
		     * 
		     */
		    public Integer getId() {
			return id;
		    }
		     /**
		     * 设置: Id
		     * 
		     */
		    public void setId(Integer id) {
			this.id = id;
		    }
		     /**
		     * 获取: 角色名称
		     * 
		     */
		    public String getRoleName() {
			return roleName;
		    }
		     /**
		     * 设置: 角色名称
		     * 
		     */
		    public void setRoleName(String roleName) {
			this.roleName = roleName;
		    }
		     /**
		     * 获取: 备注
		     * 
		     */
		    public String getRemark() {
			return remark;
		    }
		     /**
		     * 设置: 备注
		     * 
		     */
		    public void setRemark(String remark) {
			this.remark = remark;
		    }
		     /**
		     * 获取: 创建者ID
		     * 
		     */
		    public Integer getCreateUserId() {
			return createUserId;
		    }
		     /**
		     * 设置: 创建者ID
		     * 
		     */
		    public void setCreateUserId(Integer createUserId) {
			this.createUserId = createUserId;
		    }
		     /**
		     * 获取: 创建时间
		     * 
		     */
		    public Date getCreateTime() {
			return createTime;
		    }
		     /**
		     * 设置: 创建时间
		     * 
		     */
		    public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		    }
       
 
   

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
