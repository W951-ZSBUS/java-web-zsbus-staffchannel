<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<jsp:include page="/resources.jsp" />
		<script type="text/javascript">
			function add() {
				var branch = $("#tree_list").datagrid("getSelected");
				if (branch == null) {
					funtl_easyui_dialog.info("请选择部门");
				} else {
					$("#dlg_manager").dialog("open");
					$("#fm_manager").form("clear");
					$("#staff_branchName").val(branch.branchName);
					$("#staff_branchId").val(branch.branchId);
				}
			}
			
			function edit() {
				var row = $("#dg_list").datagrid("getSelected");
				if (row == null) {
					funtl_easyui_dialog.info("请选择一条记录");
				} else {
					$("#dlg_manager").dialog("open");
					
					$("#staff_branchName").val(row.branchName);
					$("#staff_branchId").val(row.branchId);
					
					$("#staff_staffId").val(row.staffId);
					$("#staff_staffNo").val(row.staffNo);
					$("#staff_staffName").val(row.staffName);
					$("#staff_staffSex").combobox("setValue", row.staffSex);
					$("#staff_staffBirthdate").datebox("setValue",row.staffBirthdate);
					$("#staff_staffAge").val(row.staffAge);
					$("#staff_staffEntrydate").datebox("setValue",row.staffEntrydate);
					$("#staff_staffPolitical").combobox("setValue", row.staffPolitical);
					$("#staff_staffMarriage").combobox("setValue", row.staffMarriage);
					$("#staff_staffDeparture").val(row.staffDeparture);
					$("#staff_staffAddress").val(row.staffAddress);
					$("#staff_staffRemark").val(row.staffRemark);
					$("#staff_staffCreatename").val(row.staffCreatename);
					$("#staff_staffCreatedate").val(row.staffCreatedate);
				}
			}
			
			function del() {
				var row = $("#dg_list").datagrid("getSelected");
				if (row == null) {
					funtl_easyui_dialog.info("请选择一条记录");
				} else {
					funtl_easyui_dialog.confirm("确定要删除这条记录吗？", function() {
						var data = {
							"staff.staffId" : row.staffId
						};
						funtl_easyui_ajax.post("staffchannel/Staff/action/delete", data, function(data) {
							if (data.message == null || data.message.length == 0) {
								$("#dg_list").datagrid("reload");
								funtl_easyui_dialog.info("数据已删除");
							} else {
								funtl_easyui_dialog.info(data.message);
							}
						});
					});
				}
			}
			
			function move() {
				var row = $("#dg_list").datagrid("getSelected");
				if (row == null) {
					funtl_easyui_dialog.info("请选择一条记录");
				} else {
					$("#dlg_branch").dialog("open");
				}
			}
			
			function resetpwd() {
				var row = $("#dg_list").datagrid("getSelected");
				if (row == null) {
					funtl_easyui_dialog.info("请选择一条记录");
				} else {
					funtl_easyui_dialog.confirm("确定要重置密码吗？", function() {
						var data = {
							"staff.staffId" : row.staffId
						};
						funtl_easyui_ajax.post("staffchannel/Staff/action/updateResetPassWord", data, function(data) {
							if (data.message == null || data.message.length == 0) {
								$("#dg_list").datagrid("reload");
								funtl_easyui_dialog.info("密码已重置为123456");
							} else {
								funtl_easyui_dialog.info(data.message);
							}
						});
					});
				}
			}
			
			var dlgManagerBtn = [{
			    text:"保存",
			    iconCls:"icon-ok",
			    handler:function() {
			    	if ($("#staff_staffId").val() == "") {
			    		$("#fm_manager").attr("action", "staffchannel/Staff/action/insert");
			    	} else {
			    		$("#fm_manager").attr("action", "staffchannel/Staff/action/update");
			    	}
			    	
			    	funtl_easyui_form.submit("fm_manager", function(data) {
						if (data.message == null || data.message.length == 0) {
							$("#fm_manager").form("clear");
							$("#dlg_manager").dialog("close");
							$("#dg_list").datagrid("reload");
							funtl_easyui_dialog.info("数据已保存");
						} else {
							funtl_easyui_dialog.info(data.message);
						}
					});
			    }
			},{
			    text:"取消",
			    iconCls:"icon-cancel",
			    handler:function() {
			    	$("#dlg_manager").dialog("close");
			    }
			}];
			
			var dlgBranchBtn = [{
			    text:"保存",
			    iconCls:"icon-ok",
			    handler:function() {
			    	var newBranchId = $("#staff_newBranchId").combobox("getValue");
			    	var row = $("#dg_list").datagrid("getSelected");
			    	var data = {
			    		"staff.staffId" : row.staffId,
						"staff.branch.branchId" : newBranchId
					};			    	
			    	funtl_easyui_ajax.post("staffchannel/Staff/action/updateBranch", data, function(data) {
						if (data.message == null || data.message.length == 0) {
							$("#dlg_branch").dialog("close");
							$("#dg_list").datagrid("reload");
							funtl_easyui_dialog.info("数据已保存");
						} else {
							funtl_easyui_dialog.info(data.message);
						}
					});
			    }
			},{
			    text:"取消",
			    iconCls:"icon-cancel",
			    handler:function() {
			    	$("#dlg_branch").dialog("close");
			    }
			}];
		</script>
		<title><%=System.getProperty("systemName") %></title>
	</head>
	
	<body class="easyui-layout" data-options="fit:true">
		<div data-options="region:'west',title:'部门列表'" style="width:180px;">
			<table id="tree_list" class="easyui-treegrid" 
				data-options="
					idField:'branchId',
					treeField:'branchName',
					rownumbers:true,
					singleSelect:true,
					url:'staffchannel/Branch/action/queryTreeArrayByPid',
					onLoadError:funtl_easyui_ajax.onLoadError,
					onClickRow:function(row) {
						if (row.branchPid == '0') {
							$('#dg_list').datagrid({url:'staffchannel/Staff/action/query'});
						} else {
							$('#dg_list').datagrid({url:'staffchannel/Staff/action/queryByBranch()?branchId=' + row.branchId});
						}
						$('#dg_list').datagrid('reload');
					}
				">
				<thead>
		  			<tr>
		  				<th data-options="field:'branchName'">部门名称</th>
		  			</tr>
	  			</thead>
			</table>
		</div>
		
		<div data-options="region:'center',title:'员工列表'">
			<table id="dg_list" class="easyui-datagrid" data-options="rownumbers:true,singleSelect:true,pagination:true,pageSize:50,url:'staffchannel/Staff/action/query',toolbar:'#dg_list_toolbar',onLoadError:funtl_easyui_ajax.onLoadError">
				<thead>
		  			<tr>
		  				<th data-options="field:'staffNo'">员工工号</th>
		  				<th data-options="field:'staffName'">员工姓名</th>
		  				<th data-options="field:'staffSex', formatter:funtl_easyui_formatter.sex">员工性别</th>
		  				<th data-options="field:'staffBirthdate'">员工出生日期</th>
		  				<th data-options="field:'staffAge'">员工年龄</th>
		  				<th data-options="field:'staffEntrydate'">员工入职日期</th>
		  				<th data-options="field:'staffPolitical', formatter:funtl_easyui_formatter.political">员工政治面貌</th>
		  				<th data-options="field:'staffMarriage', formatter:funtl_easyui_formatter.marriage">员工婚姻</th>
		  				<th data-options="field:'staffDeparture'">员工祖籍</th>
		  				<th data-options="field:'staffAddress'">员工住址</th>
		  				<th data-options="field:'staffRemark'">备注</th>
		  				<th data-options="field:'staffCreatename'">创建人</th>
		  				<th data-options="field:'staffCreatedate', formatter:funtl_easyui_formatter.datetime">创建日期</th>
		  			</tr>
	  			</thead>
			</table>
			<div id="dg_list_toolbar" style="padding:5px;height:auto">
		   		<div style="margin-bottom:5px">
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="add();">新增</a>
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="del();">删除</a>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="edit();">编辑</a>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-move',plain:true" onclick="move();">移动</a>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="resetpwd();">重置密码</a>
				</div>
		   	</div>
			<script>
		   		$("#dg_list").height($(document).height() * 0.96);
		   	</script>
		</div>
	   	
	   	<div id="dlg_manager" class="easyui-dialog" style="width:800px;height:auto;padding:10px" data-options="title:'管理',buttons:dlgManagerBtn,modal:true,closed:true,maximizable:true">
	   		<form id="fm_manager" method="post" action="">
	   			<input id="staff_staffId" type="hidden" name="staff.staffId" />
	   			<table align="center" style="width:100%;">
	   				<tr>
	   					<td align="right">部门名称</td>
	   					<td colspan="5">
	   						<input id="staff_branchName" class="easyui-validatebox" type="text" name="" data-options="required:true" readonly="readonly" style="width:80%;"></input>
	   						<input id="staff_branchId" type="hidden" name="staff.branch.branchId" />
	   					</td>
		   			</tr>
	   				<tr>
		    			<td align="right">员工工号</td>
		    			<td><input id="staff_staffNo" class="easyui-validatebox" type="text" name="staff.staffNo" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
	   				<tr>
		    			<td align="right">员工姓名</td>
		    			<td><input id="staff_staffName" class="easyui-validatebox" type="text" name="staff.staffName" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
	   				<tr>
		    			<td align="right">员工性别</td>
		    			<td><select id="staff_staffSex" class="easyui-combobox" type="text" name="staff.staffSex" data-options="required:true" style="width:80%;">
		    					<option value="0">男</option>
		    					<option value="1">女</option>
		    				</select>
		    			</td>
		    		</tr>
	   				<tr>
		    			<td align="right">员工出生日期</td>
		    			<td><input id="staff_staffBirthdate" class="easyui-datebox" type="text" name="staff.staffBirthdate" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
	   				<tr>
		    			<td align="right">员工入职日期</td>
		    			<td><input id="staff_staffEntrydate" class="easyui-datebox" type="text" name="staff.staffEntrydate" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
	   				<tr>
		    			<td align="right">员工政治面貌</td>
		    			<td><select id="staff_staffPolitical" class="easyui-combobox" type="text" name="staff.staffPolitical" data-options="required:true" style="width:80%;">
		    					<option value="0">群众</option>
		    					<option value="1">团员</option>
		    					<option value="2">党员</option>
		    				</select>
		    			</td>
		    		</tr>
	   				<tr>
		    			<td align="right">员工婚姻情况</td>
		    			<td><select id="staff_staffMarriage" class="easyui-combobox" type="text" name="staff.staffMarriage" data-options="required:true" style="width:80%;">
		    					<option value="0">未婚</option>
		    					<option value="1">已婚</option>
		    					<option value="2">离婚</option>
		    				</select>
		    			</td>
		    		</tr>
	   				<tr>
		    			<td align="right">员工祖籍</td>
		    			<td><input id="staff_staffDeparture" class="easyui-validatebox" type="text" name="staff.staffDeparture" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
	   				<tr>
		    			<td align="right">员工住址</td>
		    			<td><input id="staff_staffAddress" class="easyui-validatebox" type="text" name="staff.staffAddress" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
	   				<tr>
		    			<td align="right">备注</td>
		    			<td><input id="staff_staffRemark" type="text" name="staff.staffRemark" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
	   			</table>
	   		</form>
	   	</div>
	   	
	   	<div id="dlg_branch" class="easyui-dialog" style="width:400px;height:auto;padding:10px" data-options="title:'管理',buttons:dlgBranchBtn,modal:true,closed:true,maximizable:true">
	   		<table align="center" style="width:100%;">
	   			<tr>
	   				<td align="right">选择新部门</td>
	   				<td><input class="easyui-combobox" id="staff_newBranchId" data-options="valueField:'branchId',textField:'branchName',url:'staffchannel/Branch/action/queryTreeArray'" /></td>
	   			</tr>
	   		</table>
	   	</div>
	</body>
</html>