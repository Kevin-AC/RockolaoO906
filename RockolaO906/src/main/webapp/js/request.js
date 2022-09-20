const url = "http://localhost:8080/"
//"https://minticloud.uis.edu.co/c3s9grupo6/"

function sendRequest(endpoint, method, data) {
    let request = new XMLHttpRequest();
    request.open(method, url+endpoint);
    request.responseType = 'json';
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(data ? JSON.stringify(data): data);
    return request;
}