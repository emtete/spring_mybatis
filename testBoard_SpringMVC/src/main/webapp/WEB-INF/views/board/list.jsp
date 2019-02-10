<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../includes/header.jsp" %>


<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <h1 class="h3 mb-2 text-gray-800">Tables</h1>
  <p class="mb-4">Board Tables</p>

  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
	    <div class="panel-heading" >Board List Page
	      <button id='regBtn' type="button" class="btn btn-xs text-right">Register New Button</button>
	    </div>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
            <tr>
              <th>#번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>수정일</th>
            </tr>
          </thead>
          <tbody>
          	<c:forEach items="${list}" var="board">
            <tr>
              <td><c:out value="${board.bno}"/></td>
       		  
              <td>
              		<a href='/board/get?bno=<c:out value="${board.bno}"/>'>
              		<c:out value="${board.title}"/> </a>
           	  </td>
              
              <td><c:out value="${board.writer}"/></td>
              
              <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
              <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
        
        <div class="modal fade" id="myModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title"></h4>
		      </div>
		      <div class="modal-body">
		        <p>One fine body&hellip;</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->

      </div>
    </div>
  </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->


<script type="text/javascript">



	$(document).ready(function(){ 
		
		var result = '<c:out value="${result}"/>';
		
		checkModal(result);
		
		history.replaceState({}, null, null);
		
		$("#regBtn").on("click", function(){
			
			self.location ="/board/register";
		})
		
	});
	
	
	
	function checkModal(result){
		
		if(result === '' || history.state){
			return;
		}
		
		if(parseInt(result) > 0){
			$(".modal-body").html( "게시글 " + parseInt(result) + " 번이 등록되었습니다." );
		}
		
		$("#myModal").modal("show");
	}
	
	
	
</script>


<%@ include file = "../includes/footer.jsp" %>