<%@page import="com.oa.service.impl.TypeServiceimpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/otherReset.css">
<link rel="stylesheet" href="../css/kxzf.css">
<title>款项支付</title>
<script type="text/javascript"
	src="/oa/src/main/webapp/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "post",
			url : "baoXiao/tylist.action",
			success : function(result) {
				var html = "<option value='0'>-申请种类-</option>";
				// 将集合遍历到一个html字符串中
				$.each(result.list, function(i, data) {
					html += "<option value='" + data.bid + "'>" + data.bname
							+ "</option>";
				});
				$("#type").html(html);
			}
		});
	});
</script>
</head>
<body>
	<div class="box50">
		<div class="topTitle">报销列表</div>
		<table class="kxzf">
			<tr class="first">
				<th>编号</th>
				<th>报销科目</th>
				<th>申请人</th>
				<th>申请时间</th>
				<th>申请金额</th>
				<th>审核状态</th>
			</tr>
			<tr class="onFocus">
				<td>0</td>
				<td><select id="type">
						<option>/</option>
				</select></td>
				<td>张三</td>
				<td>2018-20-50</td>
				<td>99999</td>
				<td>审核中</td>
			</tr>
		</table>
	</div>
	<div class="box50 bxinfo">
		<div class="topTitle">报销单详情</div>
		<div>
			申请单编号：<span>0</span>
		</div>
		<div>
			申请人员：<span>大壮</span>
		</div>
		<div>
			报销科目：<span>科目一</span>
		</div>
		<div>
			申请时间：<span>2018-08-08</span>
		</div>
		<div>
			申请金额：<span>999999</span>
		</div>
		<div class="yt">
			用途：
			<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius,
				neque. Quis, ipsum expedita in non soluta labore placeat tempore
				corporis vitae provident qui dolore rem. A, dolorum error? Amet,
				est.</p>
		</div>
		<div class="btnBox">
			<button class="btntf t">通过</button>
			<button class="btntf f">驳回</button>
		</div>

	</div>

</body>
</html>