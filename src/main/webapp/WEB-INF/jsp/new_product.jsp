<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>新規商品登録</title>
</head>
<body>
    <h1>新規商品登録</h1>
	<s:form action="productSave" method="post">
	    <s:textfield name="name" label="商品名"/>
	    <s:textfield name="price" label="価格"/>
		<s:textfield type="datetime-local"
		             name="reservation"
		             label="予約日時"
					 placeholder="入力してください"/>
	    <s:textfield name="stock" label="在庫数"/>
	    <s:textarea name="caption" label="商品説明"/>
	    <s:actionerror/>
	    <s:submit value="登録"/>
	</s:form>
    <a href="product.action">商品一覧に戻る</a>
</body>
</html>
