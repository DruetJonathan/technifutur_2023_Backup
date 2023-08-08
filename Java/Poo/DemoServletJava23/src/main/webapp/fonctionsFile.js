function functionButtonForm() {
    var x = document.getElementById("addForm");
    if (x.style.display === "none") {
        x.style.display = "block";
        document.getElementById("articleProd").style.filter = "blur(1rem)";
        document.getElementById("articleProd").style.pointerEvents = "none";
    } else {
        x.style.display = "none";
        document.getElementById("articleProd").style.filter = "blur(0)";
        document.getElementById("articleProd").style.pointerEvents = "auto";
    }
}
