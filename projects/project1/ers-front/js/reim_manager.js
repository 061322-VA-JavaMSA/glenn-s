
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

        // td = createTableData(x);
        // tr.appendChild(td);
        // td = createTableData(list[i].amount);
        // tr.appendChild(td);
        // td = createTableData(list[i].description);
        // tr.appendChild(td);
        // td = createTableData(list[i].submitted.substring(0, 16));
        // tr.appendChild(td);
        // td = createTableData((list[i].resolved != null) ? list[i].resolved.substring(0, 16) : "&nbsp;");
        // tr.appendChild(td);
        // td = createTableData((list[i].resolver != null) ? list[i].resolver.username : "&nbsp;");
        // tr.appendChild(td);
        // td = createTableData(list[i].reim_status.reimb_status);
        // tr.appendChild(td);
        // td = createTableData(list[i].reim_type.reimb_type);
        // tr.appendChild(td);
        // td = document.createElement('td');
        // if (list[i].reim_status.reimb_status == 'pending') {
        //     td.appendChild(approveButton(list[i].id, tr, x));
        //     td.appendChild(denyButton(list[i].id, tr, x));
        // }
        // td.appendChild(viewButton(list[i].id));
        // td.style.width = '20%';
        // tr.appendChild(td);
        createList(x, list[i], tr);
        x++;
        document.getElementById('reim_body').appendChild(tr);
    }
}


function approveButton(id, tr, x) {
    /* <button type="button" class="btn btn-success">Approve</button> */
    let button = document.createElement('button');
    button.setAttribute('class', 'btn btn-success mr-1');
    button.innerHTML = "Approve";
    button.addEventListener('click', appoveSend.bind(null, id, tr, x));
    return button;
}

function denyButton(id, tr, x) {
    /* <button type="button" class="btn btn-danger">Deny</button> */
    let button = document.createElement('button');
    button.setAttribute('class', 'btn btn-danger mr-1');
    button.addEventListener('click', denySend.bind(null, id, tr, x));

    button.innerHTML = "Deny";
    // button.addEventListener('click', test(principal.id));
    return button;
}

function viewButton(id) {
    /* <button type="button" class="btn btn-warning">View</button> */
    let button = document.createElement('button');
    button.setAttribute('class', 'btn btn-warning');
    button.innerHTML = "View";
    button.addEventListener('click', viewSend.bind(null, id));
    return button;
}



async function appoveSend(id, tr, x) {

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
        let data = await response.json();
        let list = data;
        tr.innerHTML = "";
        createList(x, list, tr);
    } else {

    }
}

async function denySend(id, tr, x) {

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
        let data = await response.json();
        let list = data;
        tr.innerHTML = "";
        createList(x, list, tr);
    } else {

    }
}

async function viewSend(id) {

    let response = await fetch(`${apiUrl}/reim/${id}`, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    });

    if (response.status == 200) {
        let data = await response.json();
        let list = data;
        let single = document.getElementById('view-single');
        let ul = document.createElement('ul');

        let resolved = (list.resolved != null) ? list.resolved.substring(0, 16) : "&nbsp;";
        let resolver = (list.resolver != null) ? list.resolver.username : "&nbsp;"
        let button = document.createElement('button');
        button.setAttribute('class', 'btn btn-info mr-1');
        button.addEventListener('click', viewTable);

        button.innerHTML = "Click to return";

        ul.setAttribute('class', 'list-group list-group-flush');
        single.innerHTML = "";
        ul.innerHTML = `<li class="list-group-item"><span class="btn btn-primary">Amount</span>&nbsp; ${list.amount}</li>` +
            `<li class="list-group-item"><span class="btn btn-primary">Description</span>&nbsp;  ${list.description}</li>` +
            `<li class="list-group-item"><span class="btn btn-primary">Submitted</span>&nbsp;  ${list.submitted.substring(0, 16)}</li>` +
            `<li class="list-group-item"><span class="btn btn-primary">Resolved</span>&nbsp;  ${resolved}</li>` +
            `<li class="list-group-item"><span class="btn btn-primary">Resolver</span>&nbsp;  ${resolver}</li>` +
            `<li class="list-group-item"><span class="btn btn-primary">Status</span>&nbsp;  ${list.reim_status.reimb_status}</li>` +
            `<li class="list-group-item"><span class="btn btn-primary">Type</span>&nbsp;  ${list.reim_type.reimb_type}</li>`;
        single.append(button);

        single.append(ul);
        document.getElementById("main-table").style.display = "none";
        document.getElementById("view-single").style.display = "block";
    } else {
    }
}

function viewTable() {
    document.getElementById("main-table").style.display = "block";
    document.getElementById("view-single").style.display = "none";
}

function createList(x, list, tr) {
    td = createTableData(x);
    tr.appendChild(td);
    td = createTableData(list.amount);
    tr.appendChild(td);
    td = createTableData(list.description);
    tr.appendChild(td);
    td = createTableData(list.submitted.substring(0, 16));
    tr.appendChild(td);
    td = createTableData((list.resolved != null) ? list.resolved.substring(0, 16) : "&nbsp;");
    tr.appendChild(td);
    td = createTableData((list.resolver != null) ? list.resolver.username : "&nbsp;");
    tr.appendChild(td);
    td = createTableData(list.reim_status.reimb_status);
    tr.appendChild(td);
    td = createTableData(list.reim_type.reimb_type);
    tr.appendChild(td);
    td = document.createElement('td');
    if (list.reim_status.reimb_status == 'pending') {
        td.appendChild(approveButton(list.id, tr, x));
        td.appendChild(denyButton(list.id, tr, x));
    }
    td.appendChild(viewButton(list.id));
    td.style.width = '20%';
    tr.appendChild(td);
}