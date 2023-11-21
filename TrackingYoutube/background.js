let tabIdToPreviousUrl = new Map();
let lastTabUrl = null;
let listTabIsPlayingYoutube = [];

let isDone = false;
chrome.tabs.onUpdated.addListener(function (tabId, changeInfo, tab) {
    let previousTab = tabIdToPreviousUrl.get(tabId)
    if (changeInfo.status === 'complete') {
        if (previousTab != null) {
            if (previousTab.includes("www.youtube.com/watch") && previousTab != tab.url && isDone == false) {
                chrome.windows.create({
                    url: 'popup/popupAlert.html',
                    type: 'popup',
                    width: 550,
                    height: 200,
                    left: (1000) - (550 / 2),
                    top: (928 / 2) - (200 / 2)
                });
                console.log(isDone)
            }
        }
        tabIdToPreviousUrl.set(tabId, tab.url)
        listTabIsPlayingYoutube = [];
        chrome.tabs.query({},function(tabs){
            for(let i = 0 ; i < tabs.length;i++){
                if(tabs[i].url.includes("www.youtube.com/watch")){
                    listTabIsPlayingYoutube.push(tabs[i].id)
                }
            }
        })
    }
});

chrome.tabs.onCreated.addListener(function (tab) {
    if (lastTabUrl.includes("www.youtube.com/watch") && isDone == false) {
        chrome.windows.create({
            url: 'popup/popupAlert.html',
            type: 'popup',
            width: 550,
            height: 200,
            left: (1000) - (550 / 2),
            top: (928 / 2) - (200 / 2)
        });
        console.log(isDone)
    }

    lastTabUrl = tab.url;
});
chrome.tabs.onActivated.addListener(function (activeInfo) {
    chrome.tabs.get(activeInfo.tabId, (res) => {
        if (res.status === 'complete') {
            if (lastTabUrl != null) {
                if (lastTabUrl.includes("www.youtube.com/watch") && isDone == false) {
                    chrome.windows.create({
                        url: 'popup/popupAlert.html',
                        type: 'popup',
                        width: 550,
                        height: 200,
                        left: (1000) - (550 / 2),
                        top: (928 / 2) - (200 / 2)
                    });
                }

            }
            lastTabUrl = res.url;
        }
    })

})

chrome.tabs.onRemoved.addListener(function (tabid, removed) {
    console.log(tabid,removed)
    if(listTabIsPlayingYoutube.includes(tabid)){
        chrome.windows.create({
            url: 'popup/popupAlert.html',
            type: 'popup',
            width: 550,
            height: 200,
            left: (1000) - (550 / 2),
            top: (928 / 2) - (200 / 2)
        });
        listTabIsPlayingYoutube.pop(tabid)
    }
    
})
async function addUserVideo(idUser, idVideo, currentTime, totalTime) {
    let res = await fetch("http://localhost:9000/api/add-video-user",
        {
            method: "post",
            body: JSON.stringify({
                "idUser": idUser,
                "idVideo": idVideo,
                "currentTime": currentTime,
                "totalTime": totalTime
            }),
            headers: {
                "Content-Type": "application/json",
            },
        })
}
async function addVideo(id, title) {
    let res = await fetch("http://localhost:9000/api/add-video",
        {
            method: "post",
            body: JSON.stringify({
                "name": `${title}`,
                "id": `${id}`

            }),
            headers: {
                "Content-Type": "application/json",
            },
        }).then((response) => {
            return response.json().then((data) => {
                return data;
            }).catch((err) => {
                console.log(err);
            })
        });

}
async function checkIfVideoExist(id) {
    let res = await fetch(`http://localhost:9000/api/get-video?id=${id}`);
    const video = await res.json();
    return video;
}
async function checkIfUserExist(id) {
    let res = await fetch(`http://localhost:9000/api/get-user?id=${id}`);
    const user = await res.json();
    return user;
}

async function addUser(id, email) {
    let res = await fetch("http://localhost:9000/api/add-user",
        {
            method: "post",
            body: JSON.stringify({
                "email": email,
                "id": id
            }),
            headers: {
                "Content-Type": "application/json",
            },
        }).then((res) => res.json())
        .then((data) => {
            return data;
        })
}





chrome.runtime.onMessage.addListener((message, sender, sendResponse) => {
    switch (message.type) {
        case "sendData":
            chrome.identity.getProfileUserInfo(function (userInfo) {
                if (message.data[1] < message.data[2]) {
                    isDone = false;
                }
                else {
                    isDone = true
                }
                if (userInfo != null) {
                    checkIfVideoExist(message.data[0]).then(val => {
                        if (val.response == false) {
                            addVideo(message.data[0], message.data[3]);
                        }
                    })
                    checkIfUserExist(userInfo.id).then(userVal => {
                        if (userVal.response == false) {
                            addUser(userInfo.id, userInfo.email);
                        }
                    })
                    addUserVideo(userInfo.id, message.data[0], message.data[1], message.data[2])
                }
            })
            break;
        case "endedVideo":
            isDone = true;
            console.log("done")
            break;

        default:
            console.log("erro")
            break;
    }
})