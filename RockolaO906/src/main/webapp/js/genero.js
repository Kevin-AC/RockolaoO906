function loadDataGenero(){
    let request = sendRequest('generocancion/list', 'GET', '');
    let table = document.getElementById('genero-table');
    table.innerHTML = "";
    request.onload = function () {
        let data = request.response;
        console.log(data);
        data.forEach((element)=>{
            table.innerHTML += `
              <tr>
                   <th>${element.idGenero}</th>
                   <td>${element.genero}</td>
                   <td>
                        <button style="border-radius: 20px;" type="button" class="btn btn-success" onclick="window.location = 'form_genero.html?id=${element.idGenero}'">Editar</button>
                        <button style="border-radius: 20px;" type="button" class="btn btn-danger" onclick='deleteGenero(${element.idGenero})'>Eliminar</button>
                    </td>
                    </tr>
            `
        });
    };
    request.onerror = function() {
        table.innerHTML = `
            <tr>
                <td colspan="7">Error al consultar la base de datos de la tabla género</td>
            </tr>
        `
    };
}

function loadGenero(idGenero) {
    let request = sendRequest('generocancion/list/' + idGenero, 'GET', '');
    let id = document.getElementById('genero-id');
    let genero = document.getElementById('genero');
    
    request.onload = function () {
        let data = request.response;
        console.log(data);
        id.value = data.idGenero;
        genero.value = data.genero;
        };
    request.onerror = function () {
        alert('Error al recuperar el género seleccionado');
    };
}

function deleteGenero(idGenero) {
    var eliminar = window.confirm("Seguro de eliminar este género?");
    if (eliminar === true) {
        window.alert('Género eliminado');
        let request = sendRequest('generocancion/list/' + idGenero, 'DELETE', '');
        request.onload = function () {
            loadDataGenero();
        };
    }
}

function saveGenero(){
    let genero = document.getElementById('genero').value
    let crearGenero = {'genero':genero} 
    var Save = window.confirm("Está seguro de guardar este género?");
    if(Save === true){
        window.alert('Género guardado satisfactoriamente');
        let request = sendRequest('generocancion/','POST',crearGenero)
        console.log("guardar género "+request.response+" info "+crearGenero)
        request.onload = function(){
             window.location ='Genero.html';
        }
        request.onerror = function (){
            alert('Error al guardar el género')
        }
    }
}

function updateGenero(){
    let id = document.getElementById('genero-id').value
    let genero = document.getElementById('genero').value
    let Data= {'idGenero':id, 'genero':genero} 
    var update = window.confirm("Está seguro de actualizar este género?");
    if(update=== true){
        window.alert('Género actualizado satisfactoriamente');
        let request = sendRequest('generocancion/','POST',Data)
        console.log("Guardar género "+request.response+" info "+Data)
        request.onload = function(){
             window.location ='Genero.html';
        }
        request.onerror = function (){
            alert('Error al actualizar este género')
        }
    }
}