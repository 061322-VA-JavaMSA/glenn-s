
async function usersList() {


    console.log(`${apiUrl}/users`);
    let response = await fetch(`${apiUrl}/users/${principal.id}/reim`, {
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
        var list = data;
        document.getElementById("waiting").style.display = "none";


        tableReim(list);
    } else {
        console.log('Unable to login.')
    }
}
usersList();
function tableReim(list) {

    let x = 1;
    for (i in list) {
        tr = document.createElement('tr');

        td = createTableData(x);
        td = createTableData(list[i].first_name);
        td = createTableData(list[i].last_name);
        td = createTableData(list[i].email);
        td = createTableData(list[i].username);
        x++;
        document.getElementById('reim_body').appendChild(tr);
    }
}

