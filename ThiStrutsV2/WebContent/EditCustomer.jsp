<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="header.jsp" />
<script>
	function changeButtonName() {
		$('#submit').val('submit');
		$('#form').submit();
	}
</script>
	<div class="container">
    <h1>CHỈNH SỬA KHÁCH HÀNG</h1>
    <br>
	<html:form action="/editCus" method="post">
        <div class="row form-group">
            <label class="col-lg-2">Mã khách hàng</label>
            <div class="col-lg-3">
            	<html:text property="maKH" styleClass="form-control" readonly="true"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Tên khách hàng</label>
            <div class="col-lg-3">
                <html:text property="tenKH" styleClass="form-control"></html:text>
                <p style="color: red"><html:errors property="tenKHError"/></p>
            </div>
            <h4 style="color: red">*</h4>
        </div>
          <div class="row form-group">
            <label class="col-lg-2">Địa chỉ</label>
            <div class="col-lg-3">
                <html:text property="diaChi" styleClass="form-control"></html:text>
                <p style="color: red"><html:errors property="diaChiError"/></p>
            </div>
            <h4 style="color: red">*</h4>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Email</label>
            <div class="col-lg-3">
                <html:text property="email" styleClass="form-control"></html:text>
                <p style="color: red"><html:errors property="emailError"/></p>
            </div>
            <h4 style="color: red">*</h4>
        </div>
         <div class="row form-group">
            <label class="col-lg-2">Điện thoại</label>
            <div class="col-lg-3">
                <html:text property="soDienThoai" styleClass="form-control"></html:text>
                <p style="color: red"><html:errors property="dienThoaiError"/></p>
            </div>
            <h4 style="color: red">*</h4>
        </div>
  
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <html:submit
		property="submit" value="Lưu" onclick="changeButtonName()"
		styleId="submit" styleClass="btn btn-success big"></html:submit>
                <html:link styleClass="btn btn-primary" action="/currentCus">Quay lại</html:link>
            </div>
        </div>
    </html:form>
</div>


<jsp:include page="footer.jsp" />