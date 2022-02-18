let friends = document.querySelectorAll(".friend")
let requested_friends = document.querySelectorAll(".requested_friend")
let friends_name = document.querySelectorAll(".friends_list #nameSurname")
let requested_friends_name = document.querySelectorAll(".requested_friends #nameSurname")

function liveSearch() {
    let search_query = document.getElementById("search").value;

    for (let i = 0; i < friends.length; i++) {
        if(friends_name[i].textContent.toLowerCase()
            .includes(search_query.toLowerCase())) {
            friends[i].classList.remove("is-hidden");
        } else {
            friends[i].classList.add("is-hidden");
        }
    }

    for (let i = 0; i < requested_friends.length; i++) {
        if(requested_friends_name[i].textContent.toLowerCase()
            .includes(search_query.toLowerCase())) {
            requested_friends[i].classList.remove("is-hidden");
        } else {
            requested_friends[i].classList.add("is-hidden");
        }
    }
}
