<html>

	<!-- Include head tag -->
	<jsp:include page="head.jsp"></jsp:include>

    <body>
		
		<!-- Include dealer page navbar -->
		<jsp:include page="dealer-navbar.jsp"></jsp:include>
		<br>	
		
		<!-- The add catgeory Modal -->
		<div class="container">
		  <div class="modal fade" id="addCategoryModal">
		    <div class="modal-dialog">
		      <div class="modal-content">
		      
		        <!-- Modal Header -->
		        <div class="modal-header">
		          <h4 class="modal-title">Add new category</h4>
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		        </div>
		        
		        <!-- Modal body -->
		        <div class="modal-body">
		        <form action="dealer" method="post">
						<div class="row">
					 		<div class="form-group">
					 			<div class="col-md">
							   		<label for="categoryName">Category name</label>
							   		<input type="text" class="form-control" id="categoryName" name="categoryName" required>
					 			</div>
					 		</div>
						</div>
					  	<div class="row">
					 		<div class="col-md">
					 		<button type="submit" class="btn btn-primary" name="addCategorySubmit">Submit</button>
					 		</div>
						</div>
		        </form>
		        </div>
		        
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- The add product Modal -->
		<div class="container">
		  <div class="modal fade" id="addProductModal">
		    <div class="modal-dialog">
		      <div class="modal-content">
		      
		        <!-- Modal Header -->
		        <div class="modal-header">
		          <h4 class="modal-title">Add new product</h4>
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		        </div>
		        
		        <!-- Modal body -->
		        <div class="modal-body">
		        <form action="dealer" method="post" enctype="multipart/form-data">
					<div class="form-group">  
					  <div class="col-md">
					  	<label for="productName">Product Name</label>
						<input id="productName" name="productName" class="form-control input-md" required type="text">				    
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-md">
					  	<label for="productDescription">Product Description</label>  
					    <input id="productDescription" name="productDescription" class="form-control input-md" required type="text">
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-md">
					  	<label for="productCost">Product Cost</label>  
					    <input id="productCost" name="productCost" class="form-control input-md" required type="number" step="any">
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-md">
					  	<label for="productCategory">Product Category</label>
						<input id="productCategory" name="productCategory" class="form-control input-md" required type="text">
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-md">
					  	<label for="productQuantity">Available Quantity</label>  
					    <input id="productQuantity" name="productQuantity" class="form-control input-md" required type="text">
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-md">
			            <div class="input-group image-preview">
			                <input type="text" class="form-control image-preview-filename" disabled="disabled">
			                <span class="input-group-btn">
			                    <!-- image-preview-clear button -->
			                    <button type="button" class="btn btn-default image-preview-clear" style="display:none;">
			                        <span class="glyphicon glyphicon-remove"></span> Clear
			                    </button>
			                    <!-- image-preview-input -->
			                    <div class="btn btn-default image-preview-input">
			                        <span class="glyphicon glyphicon-folder-open"></span>
			                        <span class="image-preview-input-title">Browse</span>
			                        <input type="file" accept="image/png, image/jpeg, image/gif" name="productImage"/>
			                    </div>
			                </span>
			            </div>
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-md">
				 		<button type="submit" class="btn btn-primary" name="addProductSubmit">Submit</button>
					  </div>
					</div>
		        </form>
		        </div>
		        
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="container col-lg-12">
		<nav>
		  <div class="nav nav-tabs" id="nav-tab" role="tablist">
		    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">All products</a>
		    <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Category2</a>
		    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Category3</a>
		  </div>
		</nav>
		<div class="tab-content" id="nav-tabContent">
		  <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">All products content</div>
		  <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">Category2 content</div>
		  <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">Category3 content</div>
		</div>
		</div>
		
	</body>

</html>