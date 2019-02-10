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
      <h6 class="m-0 font-weight-bold text-primary">Board Register</h6>
    </div>
    <div class="card-body">
    
    	<form role="form" action="/board/register" method="post">
			<div class="form-group">
				<label>Title</label> 
				<input class="form-control" name="title">
			</div>
			<div class="form-group">
				<label>Text area</label>
				<textarea class="form-control" rows="3" name='content'></textarea>
			</div>
			<div class="form-group">
				<lavel>Writer</lavel>
				<input class="form-control" name="writer">
			</div>
			<button type="submit" class="btn btn-default">Submit Button</button>
			<button type="reset" class="btn btn-default">Reset Button</button>
		</form>
      
    </div>
  </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->




<%@ include file = "../includes/footer.jsp" %>