const initDOM = () => setLblValue();
document.addEventListener("DOMContentLoaded", initDOM);

function send() {
    let imgAltered = document.getElementById("imgAltered");
    let img = document.getElementById("file").files[0];
    let pixSize = document.getElementById("volume").value;
    const formData = new FormData();
    formData.append("file", img);
    formData.append("size", pixSize);
    fetch("http://localhost:8080/pixelizator/pixelizator", {
        method: 'POST',
        body: formData

    }).then(r => r.arrayBuffer())
        .then(blobParts => {
            let blob = new Blob([blobParts], {tupe: 'image/jpg'});
            return URL.createObjectURL(blob);
        })
        .then(scc => {
            imgAltered.src = src;
            imgAltered.style.visibility = "visible";
            getParameter();
            download();
        }).catch(console.error);
}

function getParameter() {
    let sizeElement = document.getElementById("size");
    let sizePicture = document.getElementById("sizePicture");
    let size = document.getElementById("file").files[0].size;
    let width = document.getElementById("file").offsetWidth;
    let height = document.getElementById("file").offsetHeight;

    if (size < 1000000)
        size = Math.floor(size / 1000) + 'KB';
    else
        size = Math.floor(size / 1000000) + 'MB';
    sizeElement.innerText = 'Size of file: ' + size;
    sizePicture.innerText = 'Size of picture: ' + height + 'x' + width;
}

function download() {
    let src = document.getElementById("imgAltered").getAttribute("src");
    let divImage = document.getElementById("download");
    let jpeg = document.getElementById("linkDownload");

    divImage.style.display = "block";
    jpeg.setAttribute("href", src);

}

function setLblValue() {
    document.getElementById("lblValue").innerHTML = 'x' + (document.getElementById("volume").value);
}