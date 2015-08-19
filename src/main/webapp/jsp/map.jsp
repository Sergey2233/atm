<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="банки на карте ,банкоматы на карте ,банк на карте,банкоматы киев на карте,банкомат на карте">
<meta name="description" content="банки украины на карте , банкоматы на карте">
 <link rel="stylesheet" type="text/css" href="<c:url value="/css/map1.css"/>">
<title> банкоматы </title>
<script
    src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script>
var map;
function initialize() {
  var mapOptions = {
    zoom: 8,
    center: new google.maps.LatLng(54.397, 150.644)
  };
  map = new google.maps.Map(document.getElementById('mapcanvas'),
      mapOptions);
}

google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
 <div id="main">
 <div id="header">
 <%@include file="header.jsp"%> 
 </br>
 </div>
 
 <div id="formleft">  
</div>
 <div id="mapcanvas" >   
 </div>

 </div>
</body>
</html>