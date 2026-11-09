 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>商品管理</title>
</head>
<body>
	<s:actionmessage/>
    <h1>商品一覧</h1>
    <table border="1">
        <tr>
            <th>商品ID</th>
            <th>商品名</th>
            <th>価格</th>
			<th>予約日時</th>
            <th>在庫数</th>
			<th>説明</th>
			<th>詳細</th>
        </tr>
        <s:iterator value="productList" var="product">
            <tr>
                <td><s:property value="#product.id"/></td>
                <td><s:property value="#product.name"/></td>
                <td><s:property value="#product.price"/></td>
				<td><s:property value="#product.reservation"/></td>
                <td><s:property value="#product.stock"/></td>
				<td><s:property value="#product.caption"/></td>
				<td>
				    <s:a action="productDetail">
						<s:param name="id" value="%{#product.id}"/>
						詳細
					</s:a>
				</td>
				<td>
				    <s:a action="productEdit">
				        <s:param name="id" value="%{#product.id}"/>
				        編集
				    </s:a>
				</td>
				<td>
				    <s:a action="productDeleteConfirm">
				        <s:param name="id" value="%{#product.id}"/>
				        削除
				    </s:a>
				</td>
            </tr>
        </s:iterator>
    </table>
	<a href="new_product.action">新規商品登録</a>
</body>
</html>
