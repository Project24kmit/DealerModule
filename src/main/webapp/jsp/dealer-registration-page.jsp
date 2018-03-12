<html>

	<!-- Include head tag -->
	<jsp:include page="head.jsp"></jsp:include>

    <body>
    	<jsp:include page="navbar-without-buttons.jsp"></jsp:include>
		<br>
		<div class="container col-md-7">
			<div class="col-md-10">
			<div class="row">
						<form>
							<div class="col-sm-12">
								<div class="row">
									<div class="col-sm-6 form-group">
										<label>First Name</label>
										<input type="text" class="form-control">
									</div>
									<div class="col-sm-6 form-group">
										<label>Last Name</label>
										<input type="text" class="form-control">
									</div>
								</div>					
								<div class="form-group">
									<label>Address</label>
									<textarea rows="2" class="form-control"></textarea>
								</div>
								<div class="row">
									<div class="col-sm-6 form-group">
										<label>Title</label>
										<input type="text" class="form-control">
									</div>		
									<div class="col-sm-6 form-group">
										<label>Company</label>
										<input type="text" class="form-control">
									</div>	
								</div>						
							<div class="form-group">
								<label>Phone Number</label>
								<div class="input-group mb-3">
								  <div class="input-group-prepend">
								    <span class="input-group-text" id="basic-addon1">+91</span>
								  </div>
								  <input type="text" class="form-control" aria-label="phonenumber" aria-describedby="basic-addon1">
								</div>
							</div>		
							<div class="form-group">
								<label>Email Address</label>
								<input type="text" placeholder="sample@company.com" class="form-control">
							</div>
							<div class="form-group">
								<input type="checkbox" aria-label="Checkbox for following text input" required>
								<button type="button" class="btn btn-link" data-toggle="modal" data-target="#dealerPrivacyPolicyModal">
								I read privacy policies of this company.
								</button>
							</div>
							<button type="button" class="btn btn-info">Submit</button>					
							</div>
						</form> 
						</div>
			</div>
		</div>
    </body>

</html>