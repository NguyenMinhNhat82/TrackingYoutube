const API_KEY = "AIzaSyCDA10kaD1XUzIYQt-_F3JjNzcTXOgfHqc"

//format time of the video to display (second)
function formatTime(sec) {
  sec = Math.floor(sec)
  if (sec < 60) {
    let str = ""
    sec < 10 ? str = `00:0${sec}` : str = `00:${sec}`
    return str
  }
  else if (sec < 3600) {
    let min = Math.floor(sec / 60)
    let second = sec - min * 60
    let timeM = "", timeS = "";
    min < 10 ? timeM = `0${min}` : timeM = min + ""
    second < 10 ? timeS = `0${second}` : timeS = second + ""
    return `${timeM}:${timeS}`
  }
  else {
    let hour = Math.floor(sec / 3600);
    let min = Math.floor((sec - hour * 3600) / 60)
    let second = sec - hour * 3600 - min * 60;
    let timeH = "", timeM = "", timeS = "";
    hour < 10 ? timeH = `0${hour}` : timeM = hour + ""
    min < 10 ? timeM = `0${min}` : timeM = min + ""
    second < 10 ? timeS = `0${second}` : timeS = second + ""
    return `${timeH}:${timeM}:${timeS}`
  }
}
window.onload = () => {

  chrome.identity.getProfileUserInfo(function (userInfo) {
    console.log(userInfo)
    if (userInfo.id != "") {
      async function loadDataToRender() {
        let res = await fetch(`http://localhost:9000/api/video?id=${userInfo.id}`).then((response) => {
          return response.json().then((data) => {
            let table = `<table class="table" id="content-table">
            <thead>
              <tr>
                <th scope="col">Video</th>
                <th scope="col">Last watched at</th>
              </tr>
            </thead>
            <tbody id="body-table">`
            for (let i = 0; i < data.length; i++) {
              let element = `<tr>
                    <th scope="row">
                    <a href="https://www.youtube.com/watch?v=${data[i][2]}"
                      class="link-secondary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
                      >${data[i][3]}</a>
                      </th>
                      <td>${formatTime(data[i][0])}/${formatTime(data[i][1])}</td>
                      </tr>`
              table += element;
            }
            table+=`</tbody>
            </table>`
            let content = document.getElementById('main');
            content.innerHTML+= table
            let linked = document.getElementsByClassName("link-secondary");
            for (var i=0; i < linked.length; i++) {
              linked[i].onclick = function(){
                chrome.tabs.update( {url:this.getAttribute("href")});
              }
          };

          }).catch((err) => {
            console.log(err);
          })
        });;
      }
      loadDataToRender();
    }
    else{
      document.getElementById("content").innerText = "You have not sign in or login yet"
    }
  })
}


