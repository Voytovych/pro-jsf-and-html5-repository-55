if (!window["progressBar"]) {
    var progressBar = {};
}

progressBar.init = function init(componentId, forId) {
    var media = document.getElementById(forId + "\:media-player");
    var bar = document.getElementById(componentId + "\:progress");
    media.addEventListener("timeupdate", function() {
        var percent = Math.floor((100 / media.duration) * media.currentTime);
        bar.value = percent;
    });
}
