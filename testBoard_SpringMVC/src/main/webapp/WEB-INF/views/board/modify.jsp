<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../includes/header.jsp" %>


<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <h1 class="h3 mb-2 text-gray-800">Board Modify Page</h1>
  <p class="mb-4">Board Modify</p>

  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">Board Modify Page</h6>
    </div>
    <div class="card-body">
    
	    <form role="form" action="/board/modify" method="post" >
	    	<div class="form-group">
	    		<label>Bno</label> 
	    		<input class="form-control" name='bno' 
	    			value='<c:out value="${board.bno}"/>' readonly="readonly">
	    	</div>
	    	
	    	<div class="form-group">
	    		<label>Title</label> 
	    		<input class="form-control" name='title' 
	    			value='<c:out value="${board.title}"/>' >
	    	</div>
	    	
	    	<div class="form-group">
	    		<label>Text area</label> 
	    		<textarea class="form-control" rows="3" name='content' 
	    			><c:out value="${board.content}"/>
	    		</textarea>
	    	</div>
	    	
	    	<div class="form-group">
	    		<label>Writer</label> 
	    		<input class="form-control" name='writer' 
	    			value='<c:out value="${board.writer}"/>' readonly="readonly">
	    	</div>
	    	
	    	<div class="form-group">
	    		<label>RegDate</label> 
	    		<input class="form-control" name='regDate' 
	    			value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regDate}"/>' 
	    			readonly="readonly">
	    	</div>
	    	
	    	<div class="form-group">
	    		<label>Update Date</label> 
	    		<input class="form-control" name='updateDate' 
	    			value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}"/>' 
	    			readonly="readonly">
	    	</div>
	    
	    	
	    	<button type="submit" data-opener='modify' class="btn btn-default">
	    		<a href="/board/modify?bno=<c:out value="${board.bno}"/>" />Modify</a>
	    	</button>
	    		
	    	<button type="submit" data-opener='remove' class="btn btn-default">
	    		<a href="/board/modify?bno=<c:out value="${board.bno}"/>" />Remove</a>
	    	</button>	
	    	
	    	<button type="submit" data-opener='list' class="btn btn-info">
	    		<a href="/board/list">List</a>
	    	</button>	
	    	
	    	
	      </form>
    </div>
  </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->




<%@ include file = "../includes/footer.jsp" %>




















