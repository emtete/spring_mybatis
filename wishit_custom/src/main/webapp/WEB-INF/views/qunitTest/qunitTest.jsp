<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>QUnit Example</title>
  <link rel="stylesheet" href="https://code.jquery.com/qunit/qunit-2.9.2.css">
</head>
<body>
  <div id="qunit"></div>
  <div id="qunit-fixture"></div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script src="resources/js/crud/register.js" type="text/javascript"></script>
	<script src="resources/js/crud/getDetail.js" type="text/javascript"></script>
	<!-- <script src="resources/js/crud/getList.js" type="text/javascript"></script> -->
	
	<script src="resources/js/reLoad.js" type="text/javascript"></script>
  <script src="https://code.jquery.com/qunit/qunit-2.9.2.js"></script>
  

  <script>
    QUnit.test( "getCustomVoModule Test", function( assert ) {
        
      getCustomVoModule.getVoByAjax(
        { "busiNum" : '111-11-11111' },
        function(data) { console.log(data); },
        function(error) { console.log('fail'); }
      );  
      assert.ok( true , '' );
    });

   

// console.log('data : '+Object.keys(data));
//         console.log('data[0] : '+data[0]);
//         console.log('keys(data[0]) : '+Object.keys(data[0]) );

  </script>

</body>
</html>