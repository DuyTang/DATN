<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>Đăng Nhập Hệ Thống</h3>
		<html:form action="/login" method="post">
			<div class="row form-group">
				<label class="col-lg-2">Tên Đăng Nhập</label>
				<div class="col-lg-3">
				 <html:text property="username" value=""></html:text><br>
				 <p style="color: red;">
				 <html:errors property="userError"/>
				 </p>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Mật Khẩu</label>
				<div class="col-lg-3">
				<html:password property="password" value=""></html:password><br>
				<p style="color: red;">
				 <html:errors property="passError"/>
				 </p>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					
				</div>
			</div>
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<html:submit styleClass="btn btn-primary">Đăng nhập</html:submit>
					<button class="btn btn-primary" type="reset">Hủy</button>
				</div>
			</div>
		</html:form>
	</div>
</body>
</html>