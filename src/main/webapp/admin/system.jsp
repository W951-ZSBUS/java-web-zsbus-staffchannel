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
		<script type="text/javascript" src="ckfinder/ckfinder.js"></script>
		<script type="text/javascript" src="js/ckeditor/ckeditor.js"></script>
		<script type="text/javascript" src="js/ckeditor/adapters/jquery.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#system_systemContent").ckeditor(); 
				
				$("#dg_list").datagrid({
				    onSelect : function(rowIndex, rowData) {
					    var content = $("#system_content");
					    content.panel({content:rowData.systemContent});
				    }
				});	
			});
			
			function add() {
				$("#dlg_manager").dialog("open");
				$("#fm_manager").form("clear");
				$("#system_systemContent").val("");
			}
			
			function edit() {
				var row = $("#dg_list").datagrid("getSelected");
				if (row == null) {
					funtl_easyui_dialog.info("请选择一条记录");
				} else {
					$("#dlg_manager").dialog("open");
					$("#system_systemId").val(row.systemId);
					$("#system_systemTitle").val(row.systemTitle);
					$("#system_systemContent").val(row.systemContent);
					$("#system_systemCreatedate").val(row.systemCreatedate);
					$("#system_systemCreatename").val(row.systemCreatename);
				}
			}
			
			function del() {
				var row = $("#dg_list").datagrid("getSelected");
				if (row == null) {
					funtl_easyui_dialog.info("请选择一条记录");
				} else {
					funtl_easyui_dialog.confirm("确定要删除这条记录吗？", function() {
						var data = {
							"system.systemId" : row.systemId
						};
						funtl_easyui_ajax.post("staffchannel/System/action/delete", data, function(data) {
							if (data.message == null || data.message.length == 0) {
								$("#dg_list").datagrid("reload");
								var content = $("#system_content");
								content.panel({content:" "});
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
			    	if ($("#system_systemId").val() == "") {
			    		$("#fm_manager").attr("action", "staffchannel/System/action/insert");
			    	} else {
			    		$("#fm_manager").attr("action", "staffchannel/System/action/update");
			    	}
			    	
			    	funtl_easyui_form.submit("fm_manager", function(data) {
						if (data.message == null || data.message.length == 0) {
							$("#fm_manager").form("clear");
							$("#dlg_manager").dialog("close");
							$("#dg_list").datagrid("reload");
							var content = $("#system_content");
							content.panel({content:" "});
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
	
	<body class="easyui-layout" data-options="fit:true">
		<div data-options="region:'west',title:'制度列表'" style="width:500px;">
			<table id="dg_list" class="easyui-datagrid" data-options="rownumbers:true,singleSelect:true,pagination:true,pageSize:50,url:'staffchannel/System/action/query',toolbar:'#dg_list_toolbar',onLoadError:funtl_easyui_ajax.onLoadError">
				<thead>
		  			<tr>
		  				<th data-options="field:'systemTitle'">制度标题</th>
		  				<th data-options="field:'systemCreatedate', formatter:funtl_easyui_formatter.datetime">创建时间</th>
		  				<th data-options="field:'systemCreatename'">创建者</th>
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
		   		$("#dg_list").height($(document).height() * 0.96);
		   	</script>
		</div>
		
		<div id="system_content" class="easyui-panel" data-options="region:'center',title:'制度内容',collapsible:false" style="font-size:16px;padding:10px;word-wrap:break-word;">
		</div>
	   	
	   	<div id="dlg_manager" class="easyui-dialog" style="width:800px;height:auto;padding:10px; top:50px" data-options="title:'管理',buttons:dlgManagerBtn,modal:true,closed:true,maximizable:true">
	   		<form id="fm_manager" method="post" action="">
	   			<input id="system_systemId" type="hidden" name="system.systemId" />
	   			<table align="center" style="width:100%;">
	   				<tr>
		    			<td align="right">制度标题</td>
		    			<td><input id="system_systemTitle" class="easyui-validatebox" type="text" name="system.systemTitle" data-options="required:true" style="width:80%;"></input></td>
		    		</tr>
	   				<tr>
		    			<td align="right">制度内容</td>
		    			<td colspan="5">
		    				<textarea id="system_systemContent" name="system.systemContent" style="width:80%;"></textarea>
		    			</td>
		    		</tr>
	   			</table>
	   		</form>
	   	</div>
	</body>
</html>