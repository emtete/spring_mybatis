<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../includes/header.jsp" %>


<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <h1 class="h3 mb-2 text-gray-800">Board Register</h1>
  <p class="mb-4">Board Register</p>

  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">Board Read Page</h6>
    </div>
    <div class="card-body">
    
    	<div class="form-group">
    		<label>Bno</label> 
    		<input class="form-control" name='bno' 
    			value='<c:out value="${board.bno}"/>' readonly="readonly">
    	</div>
    	
    	<div class="form-group">
    		<label>Title</label> 
    		<input class="form-control" name='title' 
    			value='<c:out value="${board.title}"/>' readonly="readonly">
    	</div>
    	
    	<div class="form-group">
    		<label>Text area</label> 
    		<textarea class="form-control" rows="3" name='content' readonly="readonly"
    			><c:out value="${board.content}"/>
    		</textarea>
    	</div>
    	
    	<div class="form-group">
    		<label>Writer</label> 
    		<input class="form-control" name='writer' 
    			value='<c:out value="${board.writer}"/>' readonly="readonly">
    	</div>
    
    	
    	<button data-opener='modify' class="btn btn-default">
    		<a href="/board/modify?bno=<c:out value="${board.bno}"/>" />Modify</a>
    	</button>	
    	<button data-opener='list' class="btn btn-info">
    		<a href="/board/list">List</a>
    	</button>	
      
    </div>
  </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->




<%@ include file = "../includes/footer.jsp" %>