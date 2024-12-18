function getAvailableTable(tableTripId, budget) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        document.getElementById(tableTripId).innerHTML = this.responseText;
    }
  };
  
  var ar1 = document.getElementById(budget).value;
  
  xhttp.open("GET", "BudgetServlet?budget=" + ar1, true);
  xhttp.send();
}
