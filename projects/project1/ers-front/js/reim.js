
async function reimbursement() {


    console.log(`${apiUrl}/users/${principal.id}/reim`);
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


        tableReim(list);
    } else {
        console.log('Unable to login.')
    }
}
reimbursement();
function tableReim(list) {

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
        td.innerHTML = list[i].description;
        tr.appendChild(td);
        td = document.createElement('td');
        td.innerHTML = list[i].submitted.substring(0, 16);
        tr.appendChild(td);
        td = document.createElement('td');
        td.innerHTML = (list[i].resolved != null) ? list[i].resolved.substring(0, 16) : "";
        tr.appendChild(td);
        td = document.createElement('td');
        td.innerHTML = (list[i].resolver != null) ? list[i].resolver.username : "";
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
