
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="adressList" class="adressbook.AdressList" scope="request"/>
<jsp:setProperty name="adressList" property="suchtext"/>

      <h1>Adressbuch</h1>
 
  
            <form method="GET">
                <div class="input-group">
                    <input name="suchtext" type="search" class="form-control" placeholder="Suche...">
                    <span class="input-group-btn">
                      <button type="submit">Suche</button>
                    </span>
                    <br>
              
            </form>
       
   
      <c:forEach items="${adressList.getListe()}" var="adress">
     		<br>
             <strong>${adress.addressform} ${adress.christianname} ${adress.name}</strong><br>
            ${adress.street} ${adress.number}<br>
            ${adress.postcode} ${adress.city}<br>
            ${adress.country}<br>
          
            <em>Email:</em> <a href="mailto:${adress.email}">${adress.email}</a><br>
            <em>Telefon:</em> ${adress.phone}<br>
            <em>Mobil:</em> ${adress.mobile}<br>
            <em>Geburtstag:</em> ${adress.birthday}<br>
     
              <a href="/Adressbuch/Address.jsp?id=${adress.id}">Details</a><br>
              <form method="Post" action="DeleteServlet">
              <button type="submit" name="id" value="${adress.id}">Löschen</button><br>
        	  </form>
         
      </c:forEach>
	
	<br><br>
    <form method="Post" action="AdressForm.jsp">
    <button type="submit">Neuen anlegen</button><br>
    </form>
    </div>


