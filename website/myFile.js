

function myFunction()
{
document.getElementById("demo").innerHTML="My First JavaScript Function";
}

/**
 * Create cookie with javascript
 *
 * @param {string} name cookie name
 * @param {string} value cookie value
 * @param {int} days2expire
 * @param {string} path
 */
function create_cookie(name, value, days2expire, path) {
  var date = new Date();
  date.setTime(date.getTime() + (days2expire * 24 * 60 * 60 * 1000));
  var expires = date.toUTCString();
  document.cookie = name + '=' + value + ';' +
                   'expires=' + expires + ';' +
                   'path=' + path + ';';
}


function michaelCookie(name, value) {
document.cookie = name + '=' + value + ';';
//document.cookie="username=John Doe";
}


