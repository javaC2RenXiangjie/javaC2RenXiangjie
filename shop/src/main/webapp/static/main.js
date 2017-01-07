// console.log("hello  World");
//
// var a = document.createElement("a")
// a.innerText = "bing"
// a.href = "http://www.bing.com"
// div.appendChild (a)
//
// var name = document.getElementById('name');
// name.onclick = function() {
//   return console.log("fsfsf");
// }
//
// var button = document.getElementById('button')
//  button.addEventListener("click", function() {
//    console.log("sssssss");
//  } ,false);

var parent = document.getElementById("parent");
parent.addEventListener("click", function() {
  console.log("parent button");
}, false);
// stopPropagation();
// var parent = document.getElementById("parent");
// parent.addEventListener("click", print, false);

var child = document.getElementById("child");
parent.addEventListener("click", function() {
  console.log("child button");
}, false);

var child = document.getElementById("pas");
parent.addEventListener("click", function() {
  console.log("pas button");
}, false);

document.querySelector('a').addEventListener('click', function(e) {
  e.preventDefault();
}, false);
