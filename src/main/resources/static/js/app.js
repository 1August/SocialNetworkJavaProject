const form = document.querySelector("#postForm")
// const connectBtn = document.querySelector("#connect")
// const disconnectBtn = document.querySelector("#disconnect")
const addPostBtn = document.querySelector("#addPostBtn")

const newCommentForms = document.querySelectorAll('.post')




if (newCommentForms){
    newCommentForms.forEach(form => form.addEventListener('submit', e => {
        e.preventDefault()

        // const userId = document.querySelector('#userId').value
        let email = document.querySelector('#email').innerHTML
        let postId = form.querySelector('.postId').value
        let comment = form.querySelector('.newComment textarea').value
        const newComment = { postId, email, content: comment }

        stompClient.send('/post/comment', {}, JSON.stringify(newComment));
    }))
}

let stompClient = null;

const connect = () => {
    let sockJS = new SockJS("http://localhost:8080/ws")
    stompClient = Stomp.over(sockJS)
    stompClient.connect({}, ()=>{ console.log("Connected") }, () => { console.log("Error") })
}
connect()

const sendPost = post => {
    // let userId = document.querySelector('#userId').value
    const newPost = {...post }

    stompClient.send('/post', {}, JSON.stringify(newPost))
}

form.addEventListener("submit", e=>{ e.preventDefault() })

// connectBtn.addEventListener('click', ()=>{ connect() })
// disconnectBtn.addEventListener('click', ()=>{ disconnect() })
addPostBtn.addEventListener('click', ()=>{
    const title = document.querySelector('#postTitle').value
    const content = document.querySelector('#postContent').value
    const email = document.querySelector('#email').innerHTML

    sendPost({ title, content, email })
})



// function setConnected(connected) {
//     $("#connect").prop("disabled", connected);
//     $("#disconnect").prop("disabled", !connected);
//     if (connected) {
//         $("#conversation").show();
//     }
//     else {
//         $("#conversation").hide();
//     }
//     $("#greetings").html("");
// }


// function disconnect() {
//     if (stompClient !== null) {
//         stompClient.disconnect();
//     }
//     setConnected(false);
//     console.log("Disconnected");
// }





// -----------------------------------------------------------












// function setConnected(connected) {
//     $("#connect").prop("disabled", connected);
//     $("#disconnect").prop("disabled", !connected);
//     if (connected) {
//         $("#conversation").show();
//     }
//     else {
//         $("#conversation").hide();
//     }
//     $("#greetings").html("");
// }
//
// function connect(){
//
//     const sockJS = new SockJS('http://localhost:8080/ws')
//     stompClient = Stomp.over(sockJS)
//     stompClient.connect({}, frame => {
//         console.log('Connected: ' + frame);
//         // stompClient.subscribe('/user', function (post) {
//         //     showGreeting(JSON.parse(post.body).content)
//         // })
//     })
//
//     //
//     // let socket = new SockJS("localhost:8080/topic/user/posts")
//     // setConnected(true)
//
//
//
//
//     // const socket = new SockJS('/ourWebsocket');
//     // stompClient = Stomp.over(socket)
//     // stompClient.connect({}, function (frame) {
//     //     // setConnected(true)
//     //     console.log('Connected: ' + frame);
//     //     stompClient.subscribe('/topic/user/posts', function (post) {
//     //         showGreeting(JSON.parse(post.body).content)
//     //     })
//     // })
// }
//
// function disconnect() {
//     if (stompClient !== null) {
//         stompClient.disconnect();
//     }
//     setConnected(false);
//     console.log("Disconnected");
// }
//
// function sendPost(post) {
//     const newPost = {...post}
//
//     stompClient.send("/post", {}, JSON.stringify(newPost));
// }
//
// // function showGreeting(post) {
// //     $(".postContainer").append("" +
// //         "<div class = 'post'>" +
// //             "<h1 class = 'postTitle'>" + post.title + "</h1>" +
// //             "<p class='postContent'>" +  post.content + "</p>" +
// //             "<h5 class='postAuthor'> Autor - <span class='postCreatedDate'> Date </span> </h5>" +
// //             "<div class='newComment'> " +
// //                 "<textarea></textarea> " +
// //                 "<button class='submit'>Send</button>" +
// //             "</div> " +
// //             "<div class='comments'>" +
// //                 "<h3>Comments:</h3>" +
// //                 // "<div class='comment'>" +
// //                 //     "<h3 class='commentAuthor'>Maks</h3>" +
// //                 //     "<p class='message'>Text</p>" +
// //                 //     "<h5>01.01.2020</h5>" +
// //                 // "</div>" +
// //             "</div>" +
// //         "</div>");
// // }
//
//
// // const postBtn = document.querySelector('#postForm input[type="submit"]')
// //
// // postBtn.addEventListener('click', e => {
// //     e.preventDefault()
//
//     // connect()
//     // const post = {
//     //     title: document.querySelector('#postTitle'),
//     //     content: document.querySelector('#postContent')
//     // }
//     // sendPost(post)
// // })
//
// $(function () {
//     $("form").on('submit', e => {
//         e.preventDefault();
//     })
//
//     $( "#connect").click(() => { connect(); });
//     $( "#disconnect").click(() => { disconnect(); });
//     $( "#send").click(() => { sendPost(); });
//     // connect()
//     // sendPost()
// });
//
