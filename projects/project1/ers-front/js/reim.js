// Checks if a user is already logged in, if yes redirect to homepage

async function reimbursement() {



    let response = await fetch(`${apiUrl}/users/${principal.id}/reim`, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },

    });
    console.log(response.status);
    if (response.status == 200) {
        let data = await response.json();

        /*
            persisting the User object sent back to session storage for use in other pages
            Session Storage only allows persistence of Strings so the JS Object is converted to a JSON string using JSON.stringify
         */
        var list = data;


        tableReim(list);
    } else {
        console.log('Unable to login.')
    }
}
reimbursement();
function tableReim(list) {
    // "id": 3,
    // "amount": 14.25,
    // "submitted": 1657075563396,
    // "resolved": null,
    // "receipt": null,
    // "author": {
    //   "id": 1,
    //   "username": "mike",
    //   "role": {
    //     "id": 1,
    //     "user_role": "employee"
    //   }
    // },
    // "resolver": {
    //   "id": 30,
    //   "username": "mwaumsleyq",
    //   "role": {
    //     "id": 2,
    //     "user_role": "manager"
    //   }
    // },
    // "reim_status": {
    //   "id": 2,
    //   "reimb_status": "approved"
    // },
    // "reim_type": {
    //   "id": 1,
    //   "reimb_type": "lodging"
    // }

    let x = 1;
    for (i in list) {
        tr = document.createElement('tr');
        td = document.createElement('td');
        td.innerHTML = x;
        tr.appendChild(td);
        td = document.createElement('td');
        td.innerHTML = list[i].amount;
        tr.appendChild(td);
        td = document.createElement('td');
        td.innerHTML = list[i].submitted.substring(0, 16);
        tr.appendChild(td);
        td = document.createElement('td');
        td.innerHTML = (list[i].resolved != null) ? list[i].resolved.substring(0, 16) : "";
        tr.appendChild(td);
        td = document.createElement('td');
        td.innerHTML = list[i].resolver.username;
        tr.appendChild(td);
        td = document.createElement('td');
        td.innerHTML = list[i].reim_status.reimb_status;
        tr.appendChild(td);
        td = document.createElement('td');
        td.innerHTML = list[i].reim_type.reimb_type;
        tr.appendChild(td);


        x++;
        document.getElementById('reim_body').appendChild(tr);
    }
}