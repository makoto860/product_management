🟥技術
Struts2
JDK25
jsp
Tomcat9
MYSQL

🟥URL
http://localhost:8080/ProductManagement/

🟥
strutsの設定方法
Group Id	com.example
Artifact Id	ProductManagement
Version	1.0-SNAPSHOT
Packaging	war


tomcat9を指定
プロジェクト
ランタイム
tomcat9を指定


Mavenを更新する
1. ProductManagement を右クリック
2. Maven
3. Update Project
4. OK

JDKを25に変更
1. 画面上部の「Eclipse」→「Settings」
2. 左側の「Java」を展開
3. 「Installed JREs」をクリック



ターミナルでJDKを確認
java -version

DATABASEを作成
CREATE DATABASE product_management
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;


MYSQLのパスワード
khcoqfjcdh359

MYSQLを開く
mysql -u root -p
