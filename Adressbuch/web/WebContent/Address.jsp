
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="adress" class="adressbook.Adress" scope="request"/>
<jsp:setProperty name="adress" property="id"/>
${adress.read(param.id)}
<br>
<br>

<h1>${adress.christianname} ${adress.name}</h1>
			<strong>Email:</strong> <a href="mailto:${adress.email}">${adress.email}</a><br>
         	<strong>Telefon:</strong> ${adress.phone}<br>
            <strong>Mobil:</strong> ${adress.mobile}<br>
            <strong>Geburtstag:</strong> ${adress.birthday}
  
           <a href="/Adressbuch/AddressList.jsp" class="btn btn-default">Zurück</a>
           <a href="/Adressbuch/AdressForm.jsp?id=${param.id}" class="btn btn-primary">Bearbeiten</a>
           <form method="Post" action="DeleteServlet">
           <button type="submit" name="id" value="${adress.id}">Löschen</button><br>
           </form>
           