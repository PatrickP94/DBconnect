<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="adress" class="adressbook.Adress" scope="request"></jsp:useBean>
   	 ${adress.read(param.id)}
<c:if test="${(pageContext.request.isUserInRole('administrator'))||
              (pageContext.request.isUserInRole('admin7'))&&(adress.postcode>69999) && (adress.postcode<80000)}">
    <c:catch var="catchException">

    </c:catch>
    
    <div class="page-header">
      <h1>Adresse bearbeiten</h1>
    </div>

    <c:if test="${catchException != null}">
        	<h1>Es ist ein Fehler aufgetreten</h1>
        	${catchException}
        </div>
    </c:if>
    <c:if test="${catchException == null}">
    <form method="GET" action="SaveServlet"  accept-charset="utf-8">
        <c:if test="${param.id != null}">
            <input name="id" type="hidden" value="${param.id}"/>
        </c:if>
        <h2>Name</h2>
        <div class="row">
            <div class="col-xs-4">
                <label for="addressform">Anrede</label>
                <select id="addressform" name="addressform" class="form-control">
                    <option ${adress.addressform.equals("Frau") ? "selected" : ""} value="Frau">Frau</option>
                    <option ${adress.addressform.equals("Herr") ? "selected" : ""} value="Herr">Herr</option>
                </select>
            </div>
            <div class="col-xs-offset-8"></div>
        </div>
        <div class="row">
            <div class="col-xs-6">
                <label for="christianname">Vorname</label>
                <input id="christianname" name="christianname" type="text" class="form-control" placeholder="Vorname" value="${adress.christianname}">
            </div>
            <div class="col-xs-6">
                <label for="name">Nachname</label>
                <input id="name" name="name" type="text" class="form-control" placeholder="Nachname" value="${adress.name}">
            </div>
        </div>
        <h2>Anschrift</h2>
        <div class="row">
            <div class="col-xs-8">
                <label for="street">Straße</label>
                <input id="street" name="street" type="text" class="form-control" placeholder="Straße" value="${adress.street}">
            </div>
            <div class="col-xs-4">
                <label for="number">Hausnummer</label>
                <input id="number" name="number" type="number" class="form-control" placeholder="Hausnummer" value="${adress.number}" min="1" step="1">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-4">
                <label for="postcode">Postleitzahl</label>
                <input id="postcode" name="postcode" type="text" class="form-control" placeholder="Postleitzahl" value="${adress.postcode}">
            </div>
            <div class="col-xs-8">
                <label for="city">Stadt</label>
                <input id="city" name="city" type="text" class="form-control" placeholder="Stadt" value="${adress.city}">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <label for="country">Land</label>
                <input id="country" name="country" type="text" class="form-control" placeholder="Land" value="${adress.country}">
            </div>
        </div>
        <h2>Kontakt</h2>
        <div class="row">
            <div class="col-xs-12">
                <label for="email">Email</label>
                <input id="email" name="email" type="email" class="form-control" placeholder="Email" value="${adress.email}">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-6">
                <label for="phone">Telefon</label>
                <input id="phone" name="phone" type="tel" class="form-control" placeholder="Telefon" value="${adress.phone}">
            </div>
            <div class="col-xs-6">
                <label for="mobile">Mobil</label>
                <input id="mobile" name="mobile" type="tel" class="form-control" placeholder="Mobil" value="${adress.mobile}">
            </div>
        </div>
        <h2>Geburtstag</h2>
        <div class="row">
            <div class="col-xs-12">
                <label for="birthday">Geburtstag</label>
                <input id="birthday" name="birthday" type="date" class="form-control" placeholder="Geburtstag" value="${adress.birthday}">
            </div>
        </div>
        <hr/>
        <c:if test="${param.id == null }">
        <a href="/Adressbuch/AddressList.jsp" class="btn btn-primary">Abbrechen</a>
        </c:if>
        <c:if test="${param.id != null }">
		<a href="/Adressbuch/Address.jsp?id=${param.id}" class="btn btn-primary">Abbrechen</a>
		</c:if>
        <button type="submit" >Speichern</button>
    </form>

 </c:if>
 </c:if>
 <c:if test="${pageContext.request.isUserInRole('kunde')}">
 <h1>Keine Berechtigung!</h1><br>
 <a href="/Adressbuch/AddressList.jsp" class="btn btn-default">Zurück zum Adressbuch</a>
 </c:if>