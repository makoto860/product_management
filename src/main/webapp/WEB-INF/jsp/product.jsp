 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>商品管理</title>
</head>
<body>
    <h1>商品一覧</h1>
    <table border="1">
        <tr>
            <th>商品ID</th>
            <th>商品名</th>
            <th>価格</th>
			<th>予約日時</th>
            <th>在庫数</th>
			<th>説明</th>
            <th>操作</th>
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
                    <s:form action="productEdit" method="post">
                        <s:hidden name="id" value="%{#product.id}"/>
                        <s:submit value="編集"/>
                    </s:form>
                </td>
            </tr>
        </s:iterator>
    </table>
    <s:form action="productCreate" method="get">
        <s:submit value="新規商品登録"/>
    </s:form>
</body>
</html>
