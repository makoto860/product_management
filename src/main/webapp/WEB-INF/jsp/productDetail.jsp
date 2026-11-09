<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>商品詳細</title>
</head>
<body>
    <h1>商品詳細</h1>
    <s:actionerror/>
    <s:if test="product != null">
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
                <th>予約日時</th>
                <td><s:property value="product.reservation"/></td>
            </tr>
            <tr>
                <th>在庫数</th>
                <td><s:property value="product.stock"/></td>
            </tr>
            <tr>
                <th>商品説明</th>
                <td><s:property value="product.caption"/></td>
            </tr>
        </table>
    </s:if>
    <a href="product.action">商品一覧に戻る</a>
</body>
</html>
