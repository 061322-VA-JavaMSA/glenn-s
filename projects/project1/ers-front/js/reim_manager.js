
async function reimbursement() {


    let response = await fetch(`${apiUrl}/reim`, {
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
reimbursement();
function tableReim(list) {

    let x = 1;
    for (i in list) {
        tr = document.createElement('tr');

        td = createTableData(x);
        td = createTableData(list[i].amount);
        td = createTableData(list[i].description);
        td = createTableData(list[i].submitted.substring(0, 16));
        td = createTableData((list[i].resolved != null) ? list[i].resolved.substring(0, 16) : "&nbsp;");
        td = createTableData((list[i].resolver != null) ? list[i].resolver.username : "&nbsp;");

        td = document.createElement('td');
        td.setAttribute('id', 'td_status' + list[i].id);
        td.innerHTML = list[i].reim_status.reimb_status;
        tr.appendChild(td);

        td = createTableData(list[i].reim_type.reimb_type);

        td = document.createElement('td');
        if (list[i].reim_status.reimb_status == 'pending') {
            td.appendChild(approveButton(list[i].id));
            td.appendChild(denyButton(list[i].id));
        }
        td.appendChild(viewButton(list[i].id));

        td.style.width = '20%';

        tr.appendChild(td);

        x++;
        document.getElementById('reim_body').appendChild(tr);
    }
}


function approveButton(id) {
    /* <button type="button" class="btn btn-success">Approve</button> */
    let button = document.createElement('button');
    button.setAttribute('id', 'approve_button' + id);
    button.setAttribute('class', 'btn btn-success mr-1');
    button.innerHTML = "Approve";
    button.addEventListener('click', appoveSend.bind(null, id));
    return button;
}

function denyButton(id) {
    /* <button type="button" class="btn btn-danger">Deny</button> */
    let button = document.createElement('button');
    button.setAttribute('id', 'deny_button' + id);
    button.setAttribute('class', 'btn btn-danger mr-1');
    button.addEventListener('click', denySend.bind(null, id));

    button.innerHTML = "Deny";
    // button.addEventListener('click', test(principal.id));
    return button;
}

function viewButton(id) {
    /* <button type="button" class="btn btn-warning">View</button> */
    let button = document.createElement('button');
    button.setAttribute('class', 'btn btn-warning');
    button.innerHTML = "View";
    // button.addEventListener('click', function () { alert("hi"); });
    return button;
}



async function appoveSend(id) {

    let response = await fetch(`${apiUrl}/reim/${id}`, {
        method: 'PUT',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: JSON.stringify({
            'user_id': principal.id,
            'status': "approved"
        })
    });

    if (response.status == 200) {
        document.getElementById('td_status' + id).innerHTML = "approved";
        document.getElementById('approve_button' + id).remove();
        document.getElementById('deny_button' + id).remove();

    } else {

    }
}

async function denySend(id) {

    let response = await fetch(`${apiUrl}/reim/${id}`, {
        method: 'PUT',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: JSON.stringify({
            'user_id': principal.id,
            'status': "denied"
        })
    });

    if (response.status == 200) {
        document.getElementById('td_status' + id).innerHTML = "denied";
        document.getElementById('approve_button' + id).remove();
        document.getElementById('deny_button' + id).remove();

    } else {

    }
}