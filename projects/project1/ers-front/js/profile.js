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
        document.getElementById("profile_form").style.display = "block";
        document.getElementById("waiting").style.display = "none";
    } else {
    }
}
profileLoad();
// Setting up event listener for update button
let addButton = document.getElementById('submitButton');
addButton.addEventListener('click', update);

async function update() {

    let first_name = document.getElementById('first_name').value;
    let last_name = document.getElementById('last_name').value;
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    let response = await fetch(`${apiUrl}/users/${principal.id}`, {
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
        // let data = await response.json();

        /*
            persisting the User object sent back to session storage for use in other pages
            Session Storage only allows persistence of Strings so the JS Object is converted to a JSON string using JSON.stringify
         */

        document.getElementById('message').innerHTML = `<div class="alert alert-success" role="alert">
            Updated Successfully
        </div>`;


    } else {
        document.getElementById('message').innerHTML = `<div class="alert alert-danger" role="alert">
        Unable to update.
    </div>`;
    }
}