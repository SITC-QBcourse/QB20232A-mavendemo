<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>株式会社KONEKO.consulting教学部官网</title>
</head>
<body>
    <center>
        <form action="login_check.jsp" method="post">
            <table>
                <tr>
                    <td colspan="3" style="text-align:center">
                        用户登录
                    </td>
                </tr>
                <tr>
                    <td>用户姓名</td>
                    <td><input type="text" name="name"/></td>
                    <td><input type="submit" value="提交"/></td>
                </tr>
                <tr>
                    <td>用户密码</td>
                    <td><input type="password" name="password"/></td>
                    <td><input type="reset" value="重置"/></td>
                </tr>
                <tr>
                    <td>验证密钥</td>
                    <td><input type="text" name="code" maxlength="4" size="12"></td>
                    <td><img src="image.jsp" style="vertical-align:-8px; margin-left:-38px"></td>
                </tr>
                <tr>
                    <td colspan="3" style="text-align:center">
                        KONEKO.consulting欢迎您
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>