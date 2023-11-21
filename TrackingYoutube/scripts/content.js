
function doWithOutAdvertise() {
    //send to Background.js to storage data
    var video = document.getElementsByClassName('video-stream');

    if (video[0] != null) {
        video[0].ontimeupdate = () => {
            let timeOfCurrentVideo = []
            if (document.location.href.includes("watch?v=")
                && document.getElementsByClassName('video-stream')[0].currentTime != 0) {
                //send ID of video
                timeOfCurrentVideo.push(document.location.href.split("v=")[1])
                //send current time user is watching
                timeOfCurrentVideo.push(document.getElementsByClassName('video-stream')[0].currentTime)
                //send full time of current video
                timeOfCurrentVideo.push(document.getElementsByClassName('video-stream')[0].duration)
                //send title of video
                timeOfCurrentVideo.push(document.title.split(" - YouTube"))
                chrome.runtime.sendMessage({ data: timeOfCurrentVideo, type: "sendData" }, (response) => {
                })
            }

        }
        video[0].onended = () =>{
            chrome.runtime.sendMessage({type: "endedVideo" }, (response) => {
            })
        }

    }

}
function run() {
    if(window.location.href.includes("www.youtube.com/watch")){
            doWithOutAdvertise();  
    }
}
window.onload = run;
window.addEventListener('yt-navigate-start', run, true);



