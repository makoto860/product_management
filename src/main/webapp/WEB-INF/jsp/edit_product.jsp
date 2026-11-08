<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>商品編集</title>
</head>
<body>
    <h2>商品編集</h2>
    <s:form action="productUpdate" method="post">
        <s:hidden name="id" value="%{id}"/>
        <s:textfield name="name" label="商品名"/>
        <s:textfield name="price" label="価格"/>
        <s:textfield type="datetime-local"
                     name="reservation"
                     label="予約日時"/>
        <s:textfield name="stock" label="在庫数"/>
        <s:textarea name="caption"
                    label="商品説明"
                    rows="5"
                    cols="40"/>
        <s:submit value="更新"/>
    </s:form>
    <a href="product.action">商品一覧に戻る</a>
</body>
</html>
