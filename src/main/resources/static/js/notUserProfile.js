const addToFriendsRequestBtn = document.querySelector('#addRequest')
const deleteFromFriendsRequestBtn = document.querySelector('#deleteFromFriends')

addToFriendsRequestBtn.addEventListener('click', () => {
    let requestedUserEmail = document.querySelector('#email').innerHTML
    // const newPost = {...post }

    stompClient.send('/addFriendRequest', {}, JSON.stringify({ requestedUserEmail }))
})