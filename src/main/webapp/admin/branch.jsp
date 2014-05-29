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
				var row = $("#dg_list").datagrid("getSelected");
				if (row == null) {
					funtl_easyui_dialog.info("请选择上级部门");
				} else {
					$("#dlg_manager").dialog("open");
					$("#fm_manager").form("clear");
					$("#branch_branchPTitle").val(row.branchName);
					$("#branch_branchPid").val(row.branchId);
				}
			}
			
			function edit() {
				var row = $("#dg_list").datagrid("getSelected");
				if (row == null) {
					funtl_easyui_dialog.info("请选择一条记录");
				} else {
					$("#dlg_manager").dialog("open");
					
					if(row.branchPid != '0'){
						var parent = $("#dg_list").treegrid("getParent", row.branchId);
						$("#branch_branchPTitle").val(parent.branchName);
						$("#branch_branchPid").val(parent.branchId);
					}
					else {
						$("#branch_branchPTitle").val("顶级");
						$("#branch_branchPid").val("0");
					}
					
					$("#branch_branchId").val(row.branchId);
					$("#branch_branchNo").val(row.branchNo);
					$("#branch_branchName").val(row.branchName);
					$("#branch_branchManager").val(row.branchManager);
					$("#branch_branchSummary").val(row.branchSummary);
					$("#branch_branchPhone").val(row.branchPhone);
					$("#branch_branchEmail").val(row.branchEmail);
					$("#branch_branchRemark").val(row.branchRemark);
					$("#branch_branchCreatename").val(row.branchCreatename);
					$("#branch_branchCreatedate").val(row.branchCreatedate);
				}
			}
			
			function del() {
				var row = $("#dg_list").datagrid("getSelected");
				if (row == null) {
					funtl_easyui_dialog.info("请选择一条记录");
				} else {
					funtl_easyui_dialog.confirm("确定要删除这条记录吗？", function() {
						var data = {
							"branch.branchId" : row.branchId
						};
						funtl_easyui_ajax.post("staffchannel/Branch/action/delete", data, function(data) {
							if (data.message == null || data.message.length == 0) {
								$("#dg_list").treegrid("reload");
								funtl_easyui_dialog.info("数据已删除");
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
			    	if ($("#branch_branchId").val() == "") {
			    		$("#fm_manager").attr("action", "staffchannel/Branch/action/insert");
			    	} else {
			    		$("#fm_manager").attr("action", "staffchannel/Branch/action/update");
			    	}
			    	
			    	funtl_easyui_form.submit("fm_manager", function(data) {
						if (data.message == null || data.message.length == 0) {
							$("#fm_manager").form("clear");
							$("#dlg_manager").dialog("close");
							$("#dg_list").treegrid("reload");
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
		</script>
		<title><%=System.getProperty("systemName") %></title>
	</head>
	
	<body>
		<table id="dg_list" class="easyui-treegrid" 
			data-options="
				idField:'branchId',
				treeField:'branchName',
				rownumbers:true,
				singleSelect:true,
				url:'staffchannel/Branch/action/queryTreeArrayByPid',
				toolbar:'#dg_list_toolbar',
				onLoadError:funtl_easyui_ajax.onLoadError
			">
			<thead>
	  			<tr>
	  				<th data-options="field:'branchNo'">部门编号</th>
	  				<th data-options="field:'branchName'">部门名称</th>
	  				<th data-options="field:'branchManager'">部门主管</th>
	  				<th data-options="field:'branchSummary'">部门简介</th>
	  				<th data-options="field:'branchPhone'">部门电话</th>
	  				<th data-options="field:'branchEmail'">部门邮箱</th>
	  				<th data-options="field:'branchRemark'">备注</th>
	  				<th data-options="field:'branchCreatename'">创建人</th>
	  				<th data-options="field:'branchCreatedate', formatter:funtl_easyui_formatter.datetime">创建日期</th>
	  			</tr>
  			</thead>
		</table>
		<div id="dg_list_toolbar" style="padding:5px;height:auto">
	   		<div style="margin-bottom:5px">
		  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="add();">新增</a>
		  		<a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="del();">删除</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="edit();">编辑</a>
			</div>
	   	</div>
		<script>
	   		$("#dg_list").height($(document).height() * 0.98);
	   	</script>
	   	
	   	<div id="dlg_manager" class="easyui-dialog" style="width:500px;height:auto;padding:10px" data-options="title:'管理',buttons:dlgManagerBtn,modal:true,closed:true,maximizable:true">
	   		<form id="fm_manager" method="post" action="">
	   			<input id="branch_branchId" type="hidden" name="branch.branchId" />
	   			<table align="center" style="width:100%;">
	   				<tr>
	   					<td align="right">上级部门</td>
	   					<td colspan="5">
	   						<input id="branch_branchPTitle" class="easyui-validatebox" type="text" name="" data-options="required:true" readonly="readonly" style="width:80%;"></input>
	   						<input id="branch_branchPid" type="hidden" name="branch.branchPid" />
	   					</td>
	   				</tr>
	   				<tr>
		    			<td align="right">部门编号</td>
		    			<td><input id="branch_branchNo" class="easyui-validatebox" type="text" name="branch.branchNo" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
	   				<tr>
		    			<td align="right">部门名称</td>
		    			<td><input id="branch_branchName" class="easyui-validatebox" type="text" name="branch.branchName" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
	   				<tr>
		    			<td align="right">部门主管</td>
		    			<td><input id="branch_branchManager" class="easyui-validatebox" type="text" name="branch.branchManager" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
	   				<tr>
		    			<td align="right">部门电话</td>
		    			<td><input id="branch_branchPhone" type="text" name="branch.branchPhone" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
	   				<tr>
		    			<td align="right">部门邮箱</td>
		    			<td><input id="branch_branchEmail" type="text" name="branch.branchEmail" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
		    		<tr>
		    			<td align="right">部门简介</td>
		    			<td><textarea id="branch_branchSummary" type="text" name="branch.branchSummary" data-options="required:true" style="width:80%;resize:none;"></textarea></td>
		    		</tr>
	   				<tr>
		    			<td align="right">部门备注</td>
		    			<td><textarea id="branch_branchRemark" type="text" name="branch.branchRemark" data-options="required:true" style="width:80%;resize:none;"></textarea></td>
		    		</tr>
	   			</table>
	   		</form>
	   	</div>
	</body>
</html>