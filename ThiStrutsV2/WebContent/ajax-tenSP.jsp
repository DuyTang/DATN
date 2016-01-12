<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html:form>
	<html:select property="tenSP" styleId="tenSP" onchange="ajaxGetMaLoaiSP()" styleClass="form-control smallCombobox" style="width: 500px">
		<html:optionsCollection name="orderDetailForm" property="arrSanPham"
			label="tenSP" value="maLoaiSP"></html:optionsCollection>
	</html:select>
</html:form>