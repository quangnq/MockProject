<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<<<<<<< HEAD
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
=======
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

>>>>>>> c676f400732b4cbd90c17387999ce2b7cd863e19
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ReportInjectionResult</title>
<link rel="stylesheet"
	href="<c:url value="/resources/assets/css/fontawesome-free-6.4.2-web/css/all.min.css" />" />
<link
	href="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="<c:url value="/resources/assets/css/main.css" />" />
<style>
.report-hidden {
	display: none;
}
</style>
</head>

<body>
	<div class="header">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="content-header">
						<div class="logo">
							<a href="#"> <img
								src="<c:url value="/resources/assets/img/logo.png" />" alt=""
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
								<img src="<c:url value="/resources/assets/img/avatar.png" />"
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
								<li class="menu-item"><a href="#" class="menu-link active"
									id="report-link">Report <i class="fa-solid fa-plus"
										id="report-icon"></i>
								</a>
									<div class="report-hidden">
										<ul>
											<li class="menu-item"><a href="#" class="menu-link">Report
													Customer</a></li>
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
						<h1 class="heading-content">REPORT INJECTION RESULT</h1>
						<div class="content-top">
							<div class="display-type">
								<h3 class="text-display-type">Display type</h3>
								<input class="form-check-input" type="radio" id="report"
									name="display_type" value="report" /> <label for="report">Report</label>
								<input checked class="form-check-input" type="radio" id="chart"
									name="display_type" value="chart" /> <label for="chart">Chart</label>
							</div>
							<div class="chart-display">
								<label for="year">Select year:</label> <br /> <select
									class="form-select select-chart" name="year" id="year">
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									<option value="2020">2020</option>
									<option value="2021">2021</option>
								</select>
							</div>
							<div class="report-display">
								<div class="group-input">
									<h6 class="title-input">Inject Date:</h6>
									<div class="wrapper-input">

										<label for="from-date">From:</label> <input id="from-date"
											type="date" class="form-control" />
									</div>
								</div>
								<div class="group-input">
									<h6 class="title-input">ㅤ</h6>
									<div class="wrapper-input">

										<label for="to-date">To:</label> <input id="to-date"
											type="date" class="form-control" />
									</div>
								</div>
								<div class="group-input">
									<h6 class="title-input">Prevention:</h6>
									<div class="wrapper-input">

										<input id="Prevention" type="text" class="form-control" />
									</div>
								</div>
								<div class="group-input">
									<h6 class="title-input">Vaccine type:</h6>
									<div class="wrapper-input">

										<select class="form-select select-chart" name="year"
											id="Vaccine">
											<option selected>--Select vaccine</option>
											<c:forEach var="vaccineTypeDto" items="${vaccineTypeDtoList}">
												<option value="${vaccineTypeDto.vaccineTypeId}"><c:out
														value="${vaccineTypeDto.vaccineTypeName}" /></option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="group-input">
									<h6 class="title-input">Action:</h6>
									<div class="wrapper-input">

										<button type="reset">Reset</button>
										<button type="filter" style="margin-left: 8px;">Filter</button>
									</div>
								</div>
							</div>
						</div>
						<div class="content-bottom">
							<div class="report-chart">
								<h3 class="text-report-chart">REPORT INJECTION RESULT</h3>
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
												<th>Vaccine</th>
												<th>Prevention</th>
												<th>Customer name</th>
												<th>Date of Inject</th>
												<th>Num of Inject</th>
											</tr>
										<thead>
										<tbody>
											<c:forEach var="injectionResultReportDto"
												items="${injectionResultReportDtoList}">
												<tr>
													<td>${injectionResultReportDto.injectionResultId}</td>
													<td>${injectionResultReportDto.vaccineEntity.vaccineName}</td>
													<td>${injectionResultReportDto.prevention}</td>
													<td>${injectionResultReportDto.customerEntity.fullName}</td>
													<td>${injectionResultReportDto.injectionDate}</td>
													<td>${injectionResultReportDto.numberOfInjection}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="pagination" >
									<span class="text-pagination"> Showing 1 to 5 of <c:out
											value="${fn:length(injectionResultReportDtoList)}" /> entries
									</span>
									<div class="pagination-list" id = "pagination-container">
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
	<script src="<c:url value="/resources/assets/js/chart.js" />"></script>

<<<<<<< HEAD
	<script>
=======
                </table>
                <c:set var="recordsOfPage" value="${5}" />
                <c:set var="totalRecords" value="${injectionResultReportDtoList.size()}" />
                <fmt:parseNumber var = "totalPages" integerOnly = "true" type = "number" value = "${totalRecords / recordsOfPage}" />
                <c:if test = "${totalRecords % recordsOfPage > 0}">
                    <c:set var="totalPages" value="${totalPages + 1}" />
                </c:if>

                <div class="pagination">

                  <span class="text-pagination">
                    Showing 1 to <c:out value = "${recordsOfPage}"/> of <c:out value = "${totalRecords}"/> entries
                  </span>
                  <div class="pagination-list">
                    <div class="pagination-item prev">
                      <span><i class="fa-solid fa-angles-left"></i></span>
                    </div>
                    <div class="pagination-item active">
                      <span>1</span>
                    </div>
                    <c:forEach var = "i" begin = "2" end = "${totalPages}">
                      <div class="pagination-item">
                        <span>${i}</span>
                      </div>
                    </c:forEach>
                    <div class="pagination-item">
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

  <script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" />"
    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
    crossorigin="anonymous"></script>
  <script src="<c:url value="/resources/assets/js/chart.js" />"></script>

  <script>
>>>>>>> c676f400732b4cbd90c17387999ce2b7cd863e19
    const ctx = document.getElementById("myChart");
    new Chart(ctx, {
      type: "bar",
      data: {
        labels: [
          "January",
          "February",
          "March",
          "April",
          "May",
          "June",
          "July",
          "August",
          "September",
          "October",
          "November",
          "December",
        ],
        datasets: [
          {
            label: "",
            data: [0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 4, 1],
            borderWidth: 1,
            borderColor: "#7EDCE9",
            backgroundColor: "#7EDCE9",
          },
        ],
      },
      options: {
        scales: {
          y: {
            beginAtZero: true,
          },
        },
        plugins: {
          legend: {
            display: false, // Ẩn chú thích (label)
          },
        },
        layout: {
          padding: 20,
        },
      },
    });
  </script>
	<script src="<c:url value="/resources/assets/js/main.js" />"></script>
	<script>
	document.addEventListener("DOMContentLoaded", function () {
		  const table = document.getElementById("table-id");
		  const paginationContainer = document.getElementById("pagination-container");

		  // Số hàng trên mỗi trang
		  const rowsPerPage = 5;

		  // Trang hiện tại
		  let currentPage = 1;

		  // Tính tổng số trang
		  const totalRows = table.querySelectorAll("tbody tr").length;
		  const totalPages = Math.ceil(totalRows / rowsPerPage);

		  // Hiển thị trang đầu tiên ban đầu
		  showPage(currentPage);

		  // Hàm để hiển thị trang cụ thể
		  function showPage(page) {
		    currentPage = page;

		    // Tính vị trí bắt đầu và kết thúc của trang
		    const startIndex = (page - 1) * rowsPerPage;
		    const endIndex = startIndex + rowsPerPage;

		    // Ẩn tất cả các hàng trong phần tbody
		    const tbodyRows = table.querySelectorAll("tbody tr");
		    tbodyRows.forEach(function (row, index) {
		      if (index >= startIndex && index < endIndex) {
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
		    const prevButton = document.createElement("div");
		    prevButton.classList.add("pagination-item", "prev");
		    prevButton.innerHTML = `<span><i class="fa-solid fa-angles-left"></i></span>`;
		    prevButton.addEventListener("click", function () {
		      if (currentPage > 1) {
		        showPage(currentPage - 1);
		      }
		    });
		    paginationContainer.appendChild(prevButton);

		    // Tạo nút cho từng trang
		    const maxVisiblePages = 5; // Số trang tối đa có thể hiển thị
		    const halfVisiblePages = Math.floor(maxVisiblePages / 2);
		    const firstVisiblePage = Math.max(currentPage - halfVisiblePages, 1);
		    const lastVisiblePage = Math.min(currentPage + halfVisiblePages, totalPages);

		    if (firstVisiblePage > 1) {
		      // Add ellipsis if not on the first page
		      const ellipsisButton = document.createElement("div");
		      ellipsisButton.classList.add("pagination-item");
		      ellipsisButton.textContent = "...";
		      paginationContainer.appendChild(ellipsisButton);
		    }

		    for (let page = firstVisiblePage; page <= lastVisiblePage; page++) {
		      const pageButton = document.createElement("div");
		      pageButton.classList.add("pagination-item");
		      pageButton.textContent = page;
		      pageButton.addEventListener("click", function () {
		        showPage(page);
		      });
		      if (page === currentPage) {
		        pageButton.classList.add("active");
		      }
		      paginationContainer.appendChild(pageButton);
		    }

		    if (lastVisiblePage < totalPages) {
		      // Add ellipsis if not on the last page
		      const ellipsisButton = document.createElement("div");
		      ellipsisButton.classList.add("pagination-item");
		      ellipsisButton.textContent = "...";
		      paginationContainer.appendChild(ellipsisButton);
		    }

		    // Tạo nút "Next"
		    const nextButton = document.createElement("div");
		    nextButton.classList.add("pagination-item", "next");
		    nextButton.innerHTML = `<span><i class="fa-solid fa-angles-right"></i></span>`;
		    nextButton.addEventListener("click", function () {
		      if (currentPage < totalPages) {
		        showPage(currentPage + 1);
		      }
		    });
		    paginationContainer.appendChild(nextButton);
		  }


		  // Gọi hàm updatePagination() ban đầu
		  updatePagination();
		});



    // Hàm để đặt lại giá trị các trường nhập liệu
    function resetForm() {
      // Đặt giá trị của các trường vào giá trị mặc định hoặc rỗng
      document.getElementById("from-date").value = "";
      document.getElementById("to-date").value = "";
      document.getElementById("Prevention").value = "";
      document.getElementById("Vaccine").value = "";
      const vaccineSelect = document.getElementById("Vaccine");
      vaccineSelect.selectedIndex = 0;
      // Đặt giá trị của các trường khác ở đây nếu cần thiết
    }

    document.addEventListener("DOMContentLoaded", function () {
      // Lắng nghe sự kiện click trên nút "Reset"
      const resetButton = document.querySelector("button[type='reset']");
      resetButton.addEventListener("click", function () {
        // Gọi hàm resetForm() để đặt lại giá trị các trường
        resetForm();
      });
    });

    document.addEventListener("DOMContentLoaded", function () {
  // Lắng nghe sự kiện click trên nút "Filter"
  const filterButton = document.querySelector("button[type='filter']");
  filterButton.addEventListener("click", function () {
    // Lấy giá trị của các trường tìm kiếm
    const fromDate = document.getElementById("from-date").value;
    const toDate = document.getElementById("to-date").value;
    const prevention = document.getElementById("Prevention").value;
    const vaccine = document.getElementById("Vaccine").value;

    // Lấy danh sách tất cả các hàng trong bảng
    const tableRows = document.querySelectorAll("#table-id tbody tr");

    // Duyệt qua các hàng và kiểm tra điều kiện tìm kiếm
    tableRows.forEach(function (row) {
      const injectDate = row.querySelector("td:nth-child(5)").textContent;
      const rowPrevention = row.querySelector("td:nth-child(3)").textContent;
      const rowVaccine = row.querySelector("td:nth-child(2)").textContent;

      // Kiểm tra xem hàng phù hợp với các điều kiện tìm kiếm hay không
      const dateMatch = (fromDate === "" || toDate === "" || (injectDate >= fromDate && injectDate <= toDate));
      const preventionMatch = (prevention === "" || rowPrevention.includes(prevention));
      const vaccineMatch = (vaccine === "Select vaccine" || rowVaccine === vaccine);

      // Nếu hàng phù hợp với tất cả các điều kiện tìm kiếm, hiển thị nó, ngược lại ẩn nó
      if (dateMatch && preventionMatch && vaccineMatch) {
        row.style.display = "table-row";
      } else {
        row.style.display = "none";
      }
    });
  });
});


    document.addEventListener("DOMContentLoaded", function () {
    // Lấy tham chiếu đến biểu tượng "+" và dòng con ẩn
    const reportIcon = document.getElementById("report-icon");
    const reportHidden = document.querySelector(".report-hidden");

    // Lắng nghe sự kiện click trên biểu tượng "+"
    reportIcon.addEventListener("click", function () {
      // Kiểm tra nếu dòng con đang ẩn, thì hiển thị nó và thay đổi biểu tượng thành "-"
      if (reportHidden.style.display === "none") {
        reportHidden.style.display = "block";
        reportIcon.classList.remove("fa-plus");
        reportIcon.classList.add("fa-minus");
      } else {
        // Ngược lại, ẩn nó và thay đổi biểu tượng thành "+"
        reportHidden.style.display = "none";
        reportIcon.classList.remove("fa-minus");
        reportIcon.classList.add("fa-plus");
      }
    });
  });

    
  </script>

</body>

</html>