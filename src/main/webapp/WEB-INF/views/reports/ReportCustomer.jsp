<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ReportCustomer</title>
<link rel="stylesheet"
	href="<c:url value="/resources/assets/css/fontawesome-free-6.4.2-web/css/all.min.css" />" />
<link
	href="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="<c:url value="/resources/assets/css/main.css" />" />
</head>
<body>
	<div class="header">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="content-header">
						<div class="logo">
							<a href="#"> <img
								src="<c:url value="/resources/assets/img/logo.png"/>" alt=""
								width="40" />
							</a>
						</div>
						<div class="icon-search">
							<span> <i class="fa-solid fa-magnifying-glass"></i>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="main">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="sidebar">
						<div class="info-user">
							<div class="avatar-user">
								<img src="<c:url value="/resources/assets/img/avatar.png"/>"
									alt="" />
							</div>
							<h4 class="name-user">Admin</h4>
							<div class="email-user">
								<h5 class="text-email">admin@fsoft.com.vn</h5>
								<span class="icon-email"> <i
									class="fa-solid fa-angle-down"></i>
								</span>
							</div>
						</div>
						<div class="menu active">
							<ul class="menu-list">
								<li class="menu-item"><a href="#" class="menu-link">Home
										<i class="fa-solid fa-plus"></i>
								</a></li>
								<li class="menu-item"><a href="#" class="menu-link">Employee
										management <i class="fa-solid fa-plus"></i>
								</a></li>
								<li class="menu-item"><a href="#" class="menu-link">Customer
										management <i class="fa-solid fa-plus"></i>
								</a></li>
								<li class="menu-item"><a href="#" class="menu-link">Vaccine
										type management <i class="fa-solid fa-plus"></i>
								</a></li>
								<li class="menu-item"><a href="#" class="menu-link">Vaccine
										management <i class="fa-solid fa-plus"></i>
								</a></li>
								<li class="menu-item"><a href="#" class="menu-link">Injection
										Schedule <i class="fa-solid fa-plus"></i>
								</a></li>
								<li class="menu-item"><a href="#" class="menu-link">Injection
										Result <i class="fa-solid fa-plus"></i>
								</a></li>
								<li class="menu-item"><a href="#" class="menu-link">News
										<i class="fa-solid fa-plus"></i>
								</a></li>
								<li class="menu-item"><a href="#" class="menu-link">Report
										<i class="fa-solid fa-plus"></i>
								</a>
									<div class="report-hidden">
										<ul>
											<li class="menu-item"><a href="#"
												class="menu-link active">Report Customer</a></li>
											<li class="menu-item"><a href="#" class="menu-link">Report
													Vaccine</a></li>
										</ul>
									</div></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="content">
						<h1 class="heading-content">REPORT CUSTOMER</h1>
						<div class="content-top">
							<div class="display-type">
								<h3 class="text-display-type">Display type:</h3>
								<input checked class="form-check-input" type="radio" id="report"
									name="display_type" value="report" /> <label for="report">Report</label>
								<input class="form-check-input" type="radio" id="chart"
									name="display_type" value="chart" /> <label for="chart">Chart</label>
							</div>
							<div class="chart-display">
								<label for="yearSelector">Select year:</label> <br />
								<select class="form-select select-chart" name="yearSelector" id="yearSelector">
									<c:forEach items="${baseChartDto.yearAndMonthValue}" var="entry">
										<%--	lặp map value, entry.key get ra key là năm									--%>
										<option value="${entry.key}"><c:out value="${entry.key}" /></option>
									</c:forEach>
								</select>
							</div>
							<form id="filter-form">
								<div class="report-display">
									<div class="group-input">
										<h6 class="title-input">Date of Birth:</h6>
										<div class="wrapper-input">
											<label for="fromDate">From:</label>
											<input id="fromDate" name="fromDate" type="date" class="form-control" />
										</div>
									</div>
									<div class="group-input">
										<h6 class="title-input">ㅤ</h6>
										<div class="wrapper-input">
											<label for="toDate">To:</label>
											<input id="toDate" name="toDate" type="date" class="form-control" />
										</div>
									</div>
									<div class="group-input">
										<h6 class="title-input">Full name:</h6>
										<div class="wrapper-input">
											<input id="fullName" name="fullName" type="text" class="form-control" />
										</div>
									</div>
									<div class="group-input">
										<h6 class="title-input">Address:</h6>
										<div class="wrapper-input">
											<input id="address" name="address" type="text" class="form-control" />
										</div>
									</div>
									<div class="group-input">
										<h6 class="title-input">Action:</h6>
										<div class="wrapper-input">
											<button type="reset">Reset</button>
											<button type ="button" style="margin-left: 8px;" id="btnFilter">Filter</button>
										</div>
									</div>
								</div>
							</form>	
						</div>
						<div class="content-bottom">
							<div class="report-chart">
								<h3 class="text-report-chart">REPORT CUSTOMER</h3>
								<div class="container-chart">
									<canvas width="400" height="150" id="myChart"></canvas>
								</div>
							</div>
							<div class="report-table">
								<div class="table-wrapper">
									<table id="table-id">
										<thead>
											<tr>
												<th>No.</th>
												<th>Full name</th>
												<th>Date of birth</th>
												<th>Address</th>
												<th>Indentity card</th>
												<th>Num of Inject</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="reportDto" items="${customerReportDtoList}">
											<tr>
												<td>${reportDto.customerId}</td>
												<td>${reportDto.fullName}</td>
												<td>${reportDto.dateOfBirth}</td>
												<td>${reportDto.address}</td>
												<td>${reportDto.identityCard}</td>
												<td>${reportDto.numberOfInjection}</td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="pagination">
									<span class="text-pagination">Showing
										<span id="start-page">1</span> to
										<span id="end-page">5</span> of
										<span id="total-entries"><c:out value="${fn:length(customerReportDtoList)}" /></span> entries
									</span>
									<div class="pagination-list" id="pagination-container">
										<div class="pagination-item prev">
											<span><i class="fa-solid fa-angles-left"></i></span>
										</div>
										<c:forEach var="page" begin="1" end="${totalPages}">
											<div class="pagination-item">
												<span>${page}</span>
											</div>
										</c:forEach>
										<div class="pagination-item next">
											<span><i class="fa-solid fa-angles-right"></i></span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" />"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/assets/js/chart.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/js/jquery-3.6.4.min.js" />"></script>

	<script>
		$("#yearSelector").change(function(){
			// khi select năm, thì thay đổi data của chart và update lại
			let yearInt = parseInt($('#yearSelector').val());
			// thay đổi data khi thay đổi năm
			chart.data.datasets[0].data = mapYearAndMonthValue.get(yearInt);
			// cập nhật lại chart
			chart.update();
		});
		const ctx = document.getElementById("myChart");
		const mapYearAndMonthValue = new Map();

		let dataMonth =[];
		<c:forEach items="${baseChartDto.yearAndMonthValue}" var="entry">
		// for map để lấy ra các key năm
		// entry.key : lấy ra key năm
		// entry.value : lấy ra list value tháng của năm tương ứng
		dataMonth =[];
		<c:forEach var="item" items="${entry.value}" varStatus="myIndex">
		// for list value tháng của năm tương ứng để lấy ra từng value tháng
		// myIndex.index : lấy ra index
		dataMonth[${myIndex.index}] = ${item};
		</c:forEach>
			// set value tháng vào năm tương ứng
			mapYearAndMonthValue.set(${entry.key}, dataMonth);
		</c:forEach>
		// console.log(mapYearAndMonthValue.get(2022));
		// console.log($('#yearSelector').val());
		const chart = new Chart(ctx, {
			type : "bar",
			data : {
				labels : [ "January", "February", "March", "April", "May",
					"June", "July", "August", "September", "October",
					"November", "December", ],
				datasets : [ {
					label : "",
					// get data khi lần đầu khởi chạy lên.
					data : mapYearAndMonthValue.get(parseInt($('#yearSelector').val())),
					borderWidth : 1,
					borderColor : "#7EDCE9",
					backgroundColor : "#7EDCE9",
				}, ],
			},
			options : {
				scales : {
					y : {
						beginAtZero : true,
					},
				},
				plugins : {
					legend : {
						display : false, // Ẩn chú thích (label)
					},
				},
				layout : {
					padding : 20,
				},
			},
		});
	</script>
	<script src="<c:url value="/resources/assets/js/main.js"/>"></script>
	<script>
		document
				.addEventListener(
						"DOMContentLoaded",
						function() {
							const table = document.getElementById("table-id");
							const paginationContainer = document
									.getElementById("pagination-container");

							// Số hàng trên mỗi trang
							const rowsPerPage = 5;

							// Trang hiện tại
							let currentPage = 1;

							// Tính tổng số trang
							const totalRows = table
									.querySelectorAll("tbody tr").length;
							const totalPages = Math.ceil(totalRows
									/ rowsPerPage);

							// Hiển thị trang đầu tiên ban đầu
							showPage(currentPage);

							// Hàm để hiển thị trang cụ thể
							function showPage(page) {
								currentPage = page;

								// Tính vị trí bắt đầu và kết thúc của trang
								const startIndex = (page - 1) * rowsPerPage;
								const endIndex = startIndex + rowsPerPage;

								// Ẩn tất cả các hàng trong phần tbody
								const tbodyRows = table
										.querySelectorAll("tbody tr");
								tbodyRows
										.forEach(function(row, index) {
											if (index >= startIndex
													&& index < endIndex) {
												row.style.display = "table-row";
											} else {
												row.style.display = "none";
											}
										});

								// Tạo và cập nhật nút pagination
								updatePagination();
							}

							// Hàm để cập nhật nút pagination
							function updatePagination() {
								paginationContainer.innerHTML = ""; // Xóa nội dung cũ

								// Tạo nút "Previous"
								const prevButton = document
										.createElement("div");
								prevButton.classList.add("pagination-item",
										"prev");
								prevButton.innerHTML = `<span><i class="fa-solid fa-angles-left"></i></span>`;
								prevButton.addEventListener("click",
										function() {
											if (currentPage > 1) {
												showPage(currentPage - 1);
											}
										});
								paginationContainer.appendChild(prevButton);

								// Tạo nút cho từng trang
								const maxVisiblePages = 5; // Số trang tối đa có thể hiển thị
								const halfVisiblePages = Math
										.floor(maxVisiblePages / 2);
								const firstVisiblePage = Math.max(currentPage
										- halfVisiblePages, 1);
								const lastVisiblePage = Math.min(currentPage
										+ halfVisiblePages, totalPages);

								if (firstVisiblePage > 1) {
									// Add ellipsis if not on the first page
									const ellipsisButton = document
											.createElement("div");
									ellipsisButton.classList
											.add("pagination-item");
									ellipsisButton.textContent = "...";
									paginationContainer
											.appendChild(ellipsisButton);
								}

								for (let page = firstVisiblePage; page <= lastVisiblePage; page++) {
									const pageButton = document
											.createElement("div");
									pageButton.classList.add("pagination-item");
									pageButton.textContent = page;
									pageButton.addEventListener("click",
											function() {
												showPage(page);
											});
									if (page === currentPage) {
										pageButton.classList.add("active");
									}
									paginationContainer.appendChild(pageButton);
								}

								if (lastVisiblePage < totalPages) {
									// Add ellipsis if not on the last page
									const ellipsisButton = document
											.createElement("div");
									ellipsisButton.classList
											.add("pagination-item");
									ellipsisButton.textContent = "...";
									paginationContainer
											.appendChild(ellipsisButton);
								}

								// Tạo nút "Next"
								const nextButton = document
										.createElement("div");
								nextButton.classList.add("pagination-item",
										"next");
								nextButton.innerHTML = `<span><i class="fa-solid fa-angles-right"></i></span>`;
								nextButton.addEventListener("click",
										function() {
											if (currentPage < totalPages) {
												showPage(currentPage + 1);
											}
										});
								paginationContainer.appendChild(nextButton);
							}

							// Gọi hàm updatePagination() ban đầu
							updatePagination();
							
							// Hàm để hiển thị trang cụ thể
							function showPage(page) {
							    currentPage = page;

							    // Tính vị trí bắt đầu và kết thúc của trang
							    const startIndex = (page - 1) * rowsPerPage;
							    const endIndex = startIndex + rowsPerPage;

							    // Ẩn tất cả các hàng trong phần tbody
							    const tbodyRows = table.querySelectorAll("tbody tr");
							    tbodyRows.forEach(function(row, index) {
							        if (index >= startIndex && index < endIndex) {
							            row.style.display = "table-row";
							        } else {
							            row.style.display = "none";
							        }
							    });

							    // Cập nhật thông tin trang
							    const startPage = startIndex + 1;
							    const endPage = Math.min(endIndex, totalRows);
							    document.getElementById("start-page").textContent = startPage;
							    document.getElementById("end-page").textContent = endPage;

							    // Tạo và cập nhật nút pagination
							    updatePagination();
							}

						});

		// Hàm để đặt lại giá trị các trường nhập liệu
		function resetForm() {
			// Đặt giá trị của các trường vào giá trị mặc định hoặc rỗng
			document.getElementById("fromDate").value = "";
			document.getElementById("toDate").value = "";
			document.getElementById("fullName").value = "";
			document.getElementById("address").value = "";
			// Đặt giá trị của các trường khác ở đây nếu cần thiết
		}

		document.addEventListener("DOMContentLoaded", function() {
			// Lắng nghe sự kiện click trên nút "Reset"
			const resetButton = document.querySelector("button[type='reset']");
			resetButton.addEventListener("click", function() {
				// Gọi hàm resetForm() để đặt lại giá trị các trường
				resetForm();
			});
		});

		$("#btnFilter").click(function() {
			var toDate = $("#toDate").val();
			if (toDate.trim() && !Date.parse(toDate)) {
				alert('To Date Value is invalid');
				return;
			}
			var fromDate = $("#fromDate").val();
			if (fromDate.trim() && !Date.parse(fromDate)) {
				alert('From Date Value is invalid');
				return;
			}
			$("#filter-form").submit();
		});

		initValueSearch();
		// khởi tạo lại giá trị cho khung search
		function initValueSearch() {

			<c:if test="${not empty searchDto.toDate}">
			$("#toDate").val('${searchDto.toDate}');
			</c:if>

			<c:if test="${not empty searchDto.fromDate}">
			$("#fromDate").val('${searchDto.fromDate}');
			</c:if>

			<c:if test="${not empty searchDto.fullName}">
			$("#fullName").val('${searchDto.fullName}');
			</c:if>

			<c:if test="${not empty searchDto.address}">
			$("#address").val(${searchDto.address});
			</c:if>
		}
	</script>

</body>
</html>
