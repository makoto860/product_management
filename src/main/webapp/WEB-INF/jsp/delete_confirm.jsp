<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>商品削除確認</title>
</head>
<body>
    <h1>商品削除確認</h1>
    <p>以下の商品を削除してもよろしいですか？</p>
    <table border="1">
        <tr>
            <th>商品ID</th>
            <td><s:property value="product.id"/></td>
        </tr>
        <tr>
            <th>商品名</th>
            <td><s:property value="product.name"/></td>
        </tr>
        <tr>
            <th>価格</th>
            <td><s:property value="product.price"/> 円</td>
        </tr>
        <tr>
            <th>在庫数</th>
            <td><s:property value="product.stock"/></td>
        </tr>
    </table>
    <s:form action="productDelete" method="post">
        <s:hidden name="id" value="%{id}"/>
        <s:submit value="削除する"/>
    </s:form>
    <a href="product.action">キャンセル</a>
</body>
</html>
