
function getAvailableTable(tableId) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        document.getElementById(tableId).innerHTML = this.responseText;
    }
  };
  
  xhttp.open("GET", "AvailableServlet", true);
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

