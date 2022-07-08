// Checks if a user is already logged in, if yes redirect to homepage
if (!principal) {
    window.location.href = "./index.html";
}
async function profileLoad() {


    console.log(`${apiUrl}/users/${principal.id}`);
    let response = await fetch(`${apiUrl}/users/${principal.id}`, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },

    });
    if (response.status == 200) {
        let data = await response.json();

        /*
            persisting the User object sent back to session storage for use in other pages
            Session Storage only allows persistence of Strings so the JS Object is converted to a JSON string using JSON.stringify
         */
        var profileData = data;
        document.getElementById('first_name').value = profileData.first_name;
        document.getElementById('last_name').value = profileData.last_name;
        document.getElementById('email').value = profileData.email;
        document.getElementById('password').value = '';
    } else {
        console.log('Unable to login.')
    }
}
profileLoad();
// Setting up event listener for add button
let addButton = document.getElementById('submitButton');
addButton.addEventListener('click', add);

async function add() {

    let first_name = document.getElementById('first_name').value;
    let last_name = document.getElementById('last_name').value;
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    let response = await fetch(`${apiUrl}/user/${principal.id}`, {
        method: 'PUT',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: JSON.stringify({
            'first_name': `${first_name}`,
            'last_name': `${last_name}`,
            'email': `${email}`,
            'password': `${password}`
        })
    });

    if (response.status == 200) {
        let data = await response.json();

        /*
            persisting the User object sent back to session storage for use in other pages
            Session Storage only allows persistence of Strings so the JS Object is converted to a JSON string using JSON.stringify
         */

        document.getElementById('message').innerHTML = `<div class="alert alert-success" role="alert">
        Added Successfully
    </div>`;


    } else {
        document.getElementById('message').innerHTML = `<div class="alert alert-danger" role="alert">
        Unable to add.
    </div>`;
    }
}