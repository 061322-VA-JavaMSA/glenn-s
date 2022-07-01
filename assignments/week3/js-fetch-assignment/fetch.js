// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

/*
    - When button is clicked, send http request to API for a specific id
    - get the id value from input box
    - send request to PokeAPI
        - Method: GET
        - Headers: None
        - Body: None
        - url: https://pokeapi.co/api/v2/pokemon/ + id from input box
    - might have to convert JSON to JS object
    - populate the data in Section
*/
let baseApiURL = 'https://pokeapi.co/api/v2/pokemon';

async function getData() {
    console.log('Button was clicked!');
    let id = document.getElementById('dataInput').value;
    console.log(`id = ${id}`);

    let httpResponse = await fetch(`${baseApiURL}/${id}`);

    if (httpResponse.status >= 200 && httpResponse.status < 300) {
        let data = await httpResponse.json();

        populateData(data);

    } else {
        console.log('Invalid request.');
    }
}

function populateData(response) {
    document.getElementById('data').innerHTML = '';
    // name url

    var abilities = response.abilities;

    var table = document.createElement('table');
    var tableDiv = document.getElementById('data');
    //response.name
    var h1 = document.createElement('h1');
    h1.innerHTML = response.name;
    tableDiv.appendChild(h1);

    var tr;
    tr = document.createElement('tr');
    td = document.createElement('th');
    td.innerHTML = "Name";
    tr.appendChild(td);
    table.appendChild(tr);
    td = document.createElement('th');
    td.innerHTML = "Url";
    tr.appendChild(td);
    table.appendChild(tr);

    for (const property in abilities) {
        tr = document.createElement('tr');
        td = document.createElement('td');
        td.innerHTML = abilities[property]['ability']['name'];
        tr.appendChild(td);
        td = document.createElement('td');
        td.innerHTML = abilities[property]['ability']['url'];
        tr.appendChild(td);
        table.appendChild(tr);
    }
    tableDiv.appendChild(table);
}

