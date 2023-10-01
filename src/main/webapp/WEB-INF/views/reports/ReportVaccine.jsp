<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ReportVaccine</title>
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/fontawesome-free-6.4.2-web/css/all.min.css" />" />
      <link href="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
      <link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css" />" />
  </head>
  <body>
    <div class="header">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="content-header">
              <div class="logo">
                <a href="#">
                  <img src="<c:url value="/resources/assets/img/logo.png"/>" alt="" width="40" />
                </a>
              </div>
              <div class="icon-search">
                <span>
                  <i class="fa-solid fa-magnifying-glass"></i>
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
                  <img src="<c:url value="/resources/assets/img/avatar.png"/>" alt="" />
                </div>
                <h4 class="name-user">Admin</h4>
                <div class="email-user">
                  <h5 class="text-email">admin@fsoft.com.vn</h5>
                  <span class="icon-email">
                    <i class="fa-solid fa-angle-down"></i>
                  </span>
                </div>
              </div>
              <div class="menu active">
                <ul class="menu-list">
                  <li class="menu-item">
                    <a href="#" class="menu-link"
                      >Home
                      <i class="fa-solid fa-plus"></i>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a href="#" class="menu-link"
                      >Employee management
                      <i class="fa-solid fa-plus"></i>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a href="#" class="menu-link"
                      >Customer management
                      <i class="fa-solid fa-plus"></i>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a href="#" class="menu-link"
                      >Vaccine type management
                      <i class="fa-solid fa-plus"></i>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a href="#" class="menu-link"
                      >Vaccine management
                      <i class="fa-solid fa-plus"></i>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a href="#" class="menu-link"
                      >Injection Schedule
                      <i class="fa-solid fa-plus"></i>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a href="#" class="menu-link"
                      >Injection Result
                      <i class="fa-solid fa-plus"></i>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a href="#" class="menu-link"
                      >News
                      <i class="fa-solid fa-plus"></i>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a href="#" class="menu-link"
                      >Report
                      <i class="fa-solid fa-plus"></i>
                    </a>
                    <div class="report-hidden">
                      <ul>
                        <li class="menu-item">
                          <a href="#" class="menu-link">Report Customer</a>
                        </li>
                        <li class="menu-item">
                          <a href="#" class="menu-link active">Report Vaccine</a>
                        </li>
                      </ul>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="col-lg-9">
            <div class="content">
              <h1 class="heading-content">REPORT VACCINE</h1>
              <div class="content-top">
                <div class="display-type">
                  <h3 class="text-display-type">Display type</h3>
                  <input
                    class="form-check-input"
                    type="radio"
                    id="report"
                    name="display_type"
                    value="report" />
                  <label for="report">Report</label>
                  <input
                    checked
                    class="form-check-input"
                    type="radio"
                    id="chart"
                    name="display_type"
                    value="chart" />
                  <label for="chart">Chart</label>
                </div>
                <div class="chart-display">
                  <label for="year">Select year:</label>
                  <br />
                  <select
                    class="form-select select-chart"
                    name="year"
                    id="year">
                    <option value="2018">2018</option>
                    <option value="2019">2019</option>
                    <option value="2020">2020</option>
                    <option value="2021">2021</option>
                  </select>
                </div>
                <div class="report-display">
                  <div class="group-input">
                    <h6 class="title-input"> Next injection date: </h6>
                    <div class="wrapper-input">

                      <label for="from-date">Begin:</label>
                      <input id="from-date" type="text" class="form-control" />
                    </div>
                  </div>
                  <div class="group-input">
                    <h6 class="title-input">ㅤ</h6>
                    <div class="wrapper-input">

                      <label for="to-date">End:</label>
                      <input id="to-date" type="text" class="form-control" />
                    </div>
                  </div>
                  
                  <div class="group-input">
                    <h6 class="title-input">Vaccine type: </h6>
                    <div class="wrapper-input">

                      <select class="form-select select-chart" name="year" id="Vaccine" >
                        <option selected>--Select vaccine</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                        <option value="2021">2021</option>
                      </select>
                    </div>
                  </div>
                  <div class="group-input">
                    <h6 class="title-input">Origin: </h6>
                    <div class="wrapper-input">

                      <input id="Origin" type="text" class="form-control" />
                    </div>
                  </div>
                  <div class="group-input">
                    <h6 class="title-input">Action: </h6>
                    <div class="wrapper-input">

                      <button type = "reset">Reset</button>
                      <button style="margin-left: 8px;">Filter</button>
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
                  
                  <table id="table-id">
                    <tr>
                      <th>No.</th>
                      <th>Vaccine name</th>
                      <th>Vaccine type</th>
                      <th>Num of Inject</th>
                      <th>Begin next inject date</th>
                      <th>End next inject date</th>
                      <th>Origin</th>
                    </tr>
                    <tr>
                      <td>0</td>
                      <td>Vaccine chống cúm</td>
                      <td>Vaccine bất hoạt</td>
                      <td>14</td>
                      <td>13/11/2018</td>
                      <td>29/11/2018</td>
                      <td>Viet Nam</td>
                    </tr>
                    <tr>
                      <td>1</td>
                      <td>Vaccine ngừa bệnh ban đào</td>
                      <td>Vaccine bất hoạt</td>
                      <td>143</td>
                      <td>30/10/2018</td>
                      <td>27/11/2018</td>
                      <td>Viet Nam</td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>Vaccine viêm gan siêu vi A</td>
                      <td>Vaccine sống,giảm độc lực</td>
                      <td>66</td>
                      <td></td>
                      <td></td>
                      <td>Trung Quoc</td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>Vaccine ngừa bệnh sốt vàng</td>
                      <td>Vaccine sống,giảm độc lực</td>
                      <td>30</td>
                      <td></td>
                      <td></td>
                      <td>Nhat Ban</td>
                    </tr>
                   
                  </table>
                  <div class="pagination">
                    <span class="text-pagination">
                      Showing 1 to 4 of 4 entries
                    </span>
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

    <script>
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
    <script src="<c:url value="/resources/assets/js/main.js"/>"></script>
    <script>
      document.addEventListener("DOMContentLoaded", function () {
        const table = document.getElementById("table-id");
        const paginationItems = document.querySelectorAll(".pagination-item");
    
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
    
          // Cập nhật trạng thái của các nút pagination-item
          paginationItems.forEach(function (item, index) {
            if (index === page) {
              item.classList.add("active");
            } else {
              item.classList.remove("active");
            }
          });
        }
    
        // Lắng nghe sự kiện click trên các nút pagination-item
        paginationItems.forEach(function (item, index) {
          item.addEventListener("click", function () {
            if (index === 0) {
              // Trang trước
              if (currentPage > 1) {
                showPage(currentPage - 1);
              }
            } else if (index === totalPages + 1) {
              // Trang tiếp theo
              if (currentPage < totalPages) {
                showPage(currentPage + 1);
              }
            } else {
              // Trang cụ thể
              showPage(index);
            }
          });
        });
      });

      // Hàm để đặt lại giá trị các trường nhập liệu
    function resetForm() {
      // Đặt giá trị của các trường vào giá trị mặc định hoặc rỗng
      document.getElementById("from-date").value = "";
      document.getElementById("to-date").value = "";
      document.getElementById("Vaccine").value = "";
      document.getElementById("Origin").value = "";
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
     
    </script>
    
  </body>
</html>
