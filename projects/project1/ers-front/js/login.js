principal = "";
// Checks if a user is already logged in, if yes redirect to homepage
if (principal) {
    // window.location.href = "./index.html";
}

// Setting up event listener for login button
let loginButton = document.getElementById('submitButton');
loginButton.addEventListener('click', login);

async function login() {

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    let response = await fetch(`${apiUrl}/auth`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'username': `${username}`,
            'password': `${password}`
        })
    });
    document.getElementById("waiting").style.display = "block";
    document.getElementById("login-form").style.display = "none";

    if (response.status == 200) {
        let data = await response.json();

        /*
            persisting the User object sent back to session storage for use in other pages
            Session Storage only allows persistence of Strings so the JS Object is converted to a JSON string using JSON.stringify
         */
        sessionStorage.setItem('principal', JSON.stringify(data));
        document.getElementById("waiting").style.display = "none";
        window.location.href = "./index.html";
        document.getElementById('message').innerHTML = `<div class="alert alert-success" role="alert">
        login Successful
    </div>`;
    } else {
        document.getElementById("login-form").style.display = "block";
        document.getElementById("waiting").style.display = "none";
        document.getElementById('message').innerHTML = `<div class="alert alert-danger" role="alert">
        Login Failed.
    </div>`;
    }
}