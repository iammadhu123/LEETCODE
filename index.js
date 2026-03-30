var opener = document.getElementById("opener");
var closer = document.getElementById("closer");
var sidebar = document.getElementById("sidebar");
var main = document.getElementById("main");

opener.addEventListener("click", open);
closer.addEventListener("click", close);

var open = false;

function open() {
    if (!open) {
        sidebar.style.width = '250px';
        main.style.marginLeft = '250px';
        open = true;
    } else {
        close();
    }
}

function close() {
    sidebar.style.width = '0';
    main.style.marginLeft = '0';
    open = false;
}