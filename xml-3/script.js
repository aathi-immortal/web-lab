
var parser, xmlDoc;
var text = "<bookstore><book>" +
    "<title>Everyday Italian</title>" +
    "<title>Everyday Italian</title>"
"<author>Giada De Laurentiis</author>" +
    "<year>2005</year>" +
    "</book></bookstore>";

parser = new DOMParser();
xmlDoc = parser.parseFromString(text, "text/xml");

    
document.getElementById("demo").innerHTML  = xmlDoc.getElementsByTagName("title")[0].innerHTML;
// document.getElementById("demo").innerHTML =

