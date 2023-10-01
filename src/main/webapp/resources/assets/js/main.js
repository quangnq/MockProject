let chart_btn = document.querySelector("input#chart");
let report_btn = document.querySelector("input#report");
if (chart_btn.checked == true) {
  document.querySelector(".report-display").classList.remove("active");
  document.querySelector(".report-table").classList.remove("active");
  document.querySelector(".chart-display").classList.add("active");
  document.querySelector(".report-chart").classList.add("active");
} else {
  document.querySelector(".chart-display").classList.remove("active");
  document.querySelector(".report-chart").classList.remove("active");
  document.querySelector(".report-display").classList.add("active");
  document.querySelector(".report-table").classList.add("active");
}
chart_btn.addEventListener("change", () => {
  document.querySelector(".report-display").classList.remove("active");
  document.querySelector(".report-table").classList.remove("active");
  document.querySelector(".chart-display").classList.add("active");
  document.querySelector(".report-chart").classList.add("active");
});

report_btn.addEventListener("change", () => {
  document.querySelector(".chart-display").classList.remove("active");
  document.querySelector(".report-chart").classList.remove("active");
  document.querySelector(".report-display").classList.add("active");
  document.querySelector(".report-table").classList.add("active");
});

let btn_menu = document.querySelector(".icon-email");

btn_menu.addEventListener("click", () => {
  document.querySelector(".menu").classList.toggle("active");
});
