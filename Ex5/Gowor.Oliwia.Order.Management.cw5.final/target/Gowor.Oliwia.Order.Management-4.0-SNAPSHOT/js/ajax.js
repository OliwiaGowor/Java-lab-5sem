/**
 * @author Oliwia Gowor
 * @version 4.0
 */

function getOrders(number, tableId) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById(tableId).innerHTML = this.responseText;
        }
    };

    xhttp.open("GET", "showAllOrders?number=" + document.getElementById(number).value, true);
    xhttp.send();
}

function getProducts(productName, priceNetto, quantinity, unit, vatRate, tableId) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById(tableId).innerHTML = this.responseText;
        }
    };

    var tmp;
    xhttp.open("GET", "showAllProducts?product=" + tmp + "&productName=" + document.getElementById(productName) + "&priceNetto=" + document.getElementById(priceNetto).value + "&quantinity=" + document.getElementById(quantinity).value + "&unit=" + document.getElementById(unit).value + "&vatRate=" + document.getElementById(vatRate).value, true);
    xhttp.send();
}

