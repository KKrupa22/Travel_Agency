function getAvailableTable(tableId) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        document.getElementById(tableId).innerHTML = this.responseText;
    }
  };
  
  xhttp.open("POST", "AvailableServlet", true);
  xhttp.send();
}

function deleteTrip(tripId, tableId, errorInfo) {
    document.getElementById(errorInfo).innerHTML ="&nbsp;";
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById(tableId).innerHTML = this.responseText;
        }
        if (this.readyState === 4 && this.status === 400) {
            document.getElementById(errorInfo).innerHTML = this.responseText;
        }
    };
  
  xhttp.open("GET", "TripDeleteServlet?id=" + tripId, true);
  xhttp.send();
}

function updateTrip(tripId, country, city, depPlace, price, date, tableId, errorInfo) {
    document.getElementById(errorInfo).innerHTML ="&nbsp;";
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById(tableId).innerHTML = this.responseText;
        }
        if (this.readyState === 4 && this.status === 400) {
            document.getElementById(errorInfo).innerHTML = this.responseText;
        }
    };
    
  var ar1 = document.getElementById(country+tripId).value;
  var ar2 = document.getElementById(city+tripId).value;
  var ar3 = document.getElementById(depPlace+tripId).value;
  var ar4 = document.getElementById(price+tripId).value;
  var ar5 = document.getElementById(date+tripId).value;
  
  xhttp.open("GET", "TripUpdateServlet?tripId=" + tripId + "&country=" + ar1 + "&city=" + ar2 + "&depPlace=" + ar3 + "&price=" + ar4 + "&date=" + ar5, true);
  xhttp.send();
}

function insertTrip(country, city, depPlace, price, date, tableId, errorInfo) {
    document.getElementById(errorInfo).innerHTML ="&nbsp;";
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById(tableId).innerHTML = this.responseText;
        }
        if (this.readyState === 4 && this.status === 400) {
            document.getElementById(errorInfo).innerHTML = this.responseText;
        }
    };
    
  var ar1 = document.getElementById(country).value;
  var ar2 = document.getElementById(city).value;
  var ar3 = document.getElementById(depPlace).value;
  var ar4 = document.getElementById(price).value;
  var ar5 = document.getElementById(date).value;
  
  xhttp.open("GET", "InsertServlet?country=" + ar1 + "&city=" + ar2 + "&depPlace=" + ar3 + "&price=" + ar4 + "&date=" + ar5, true);
  xhttp.send();
}
