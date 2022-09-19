function loadDataCancion() {
    let request = sendRequest('cancion/list', 'GET', '');
    let table = document.getElementById('cancion_table');
    table.innerHTML = "";
    request.onload = function () {
        let data = request.response;
        console.log(data);
        data.forEach((element)=>{
            table.innerHTML += `
                <tr>
                    <th>${element.idCancion}</th>
                    <td>${element.nombreCancion}</td>
                    <td>${element.autor.nombreAutor} ${element.autor.apellidoAutor}</td>
                    <td>${element.genero.genero}</td>
                    <td>${element.fechaPublicacion}</td>
                    <td>
                        <button style="border-radius: 20px;" type="button" class="btn btn-success" onclick="window.location = 'form_cancion.html?id=${element.idCancion}'">Editar</button>
                        <button style="border-radius: 20px;" type="button" class="btn btn-danger" onclick='deleteCancion(${element.idCancion})'>Eliminar</button>
                    </td>
                </tr>
            `
        });
    };
    request.onerror = function() {
        table.innerHTML = `
            <tr>
                <td colspan="7">Error al consultar la base de datos de la tabla cancion</td>
            </tr>
        `
    };
}

function loadCancion(idCancion) {
    let request = sendRequest('cancion/list/' + idCancion, 'GET', '');
    let id = document.getElementById('cancion_id');
    let namecan = document.getElementById('nombre_cancion');
    let Autor = document.getElementById('AutorId');
    let Genero = document.getElementById('GeneroId');
    let fecha = document.getElementById('fechaP_cancion');

    request.onload = function () {
        let data = request.response;
        console.log(data);
        id.value = data.idCancion;
        namecan.value = data.nombreCancion;
        Autor.innerText = data.autor.nombreAutor + " " + data.autor.apellidoAutor;
        Genero.innerText = data.genero.genero;
        fecha.value = data.fechaPublicacion;
    };
    request.onerror = function () {
        alert('Error al recuperar la canción seleccionada');
    };
}

function deleteCancion(idCancion) {
    var eliminar = window.confirm("Seguro de eliminar esa canción?");
    if (eliminar === true) {
        window.alert('Canción eliminada');
        let request = sendRequest('cancion/list/' + idCancion, 'DELETE', '');
        request.onload = function () {
            loadDataCancion();
        };
    }
}

function saveCancion() {
    let selectAut = document.getElementById('listaAutor').value;
    let selectGen = document.getElementById('listaGen').value;
    let namecan = document.getElementById('nombre_cancion').value;
    let fecha = document.getElementById('fechaP_cancion').value;

    let data = {
        'nombreCancion': namecan, 'autor': {'idAutor': selectAut},
        'genero': {'idGenero': selectGen}, 'fechaPublicacion': fecha
    };

    var save = window.confirm("Seguro de guardar esta canción?");
    if (save === true) {
        window.alert('Canción guardada');
        let request = sendRequest('cancion/', 'POST', data);
        request.onload = function () {
            window.location = 'cancion.html';
        };
        request.onerror = function () {
            alert('Error al guardar la canción.');
        };
    }
}

function updateCancion() {
    let selectAut = document.getElementById('listaAutor').value;
    let selectGen = document.getElementById('listaGen').value;
    let id = document.getElementById('cancion_id').value;
    let namecan = document.getElementById('nombre_cancion').value;
    let fecha = document.getElementById('fechaP_cancion').value;

    let data = {
        'idCancion': id,
        'nombreCancion': namecan, 'autor': {'idAutor': selectAut},
        'genero': {'idGenero': selectGen}, 'fechaPublicacion': fecha
    };

    var update = window.confirm("Seguro de actualizar esta canción?");
    if (update === true) {
        window.alert('Canción actualizada');
        let request = sendRequest('cancion/list/' + id, 'PUT', data);
        request.onload = function () {
            window.location = 'cancion.html';
        };
        request.onerror = function () {
            alert('Error al actualizar la canción.');
        };
    }
}

function datosSelectAutor() {
    let request1 = sendRequest('autor/list', 'GET', '');
    var select = document.getElementById('listaAutor');
    let Autor = document.getElementById('AutorId');
    request1.onload = function() {
        let dataAut = request1.response;
        for (var i=0; i<dataAut.length; i++) {
            optionsAut = document.createElement("option");
            optionsAut.value = dataAut[i].idAutor;
            optionsAut.text = dataAut[i].nombreAutor + " " + dataAut[i].apellidoAutor;
            try {
                select.add(optionsAut);
            } catch (error) {
                select.appendChild(optionsAut);
            }
        }
        select.insertAdjacentHTML('beforeend', optionsAut);
        select.addEventListener('change', (event)=>{
            console.log(event.target.value);
            Autor.innerText = ": " + select.options[select.selectedIndex].text;
        });
    }
}

function datosSelectGenero() {
    let request2 = sendRequest('generocancion/list', 'GET', '');
    var select2 = document.getElementById('listaGen');
    let Genero = document.getElementById('GeneroId');
    request2.onload = function() {
        let dataGen = request2.response;
        for (var j=0; j<dataGen.length; j++) {
            optionsGen = document.createElement("option");
            optionsGen.value = dataGen[j].idGenero;
            optionsGen.text = dataGen[j].genero;
            try {
                select2.add(optionsGen);
            } catch (error) {
                select2.appendChild(optionsGen);
            }
        }
        select2.insertAdjacentHTML('beforeend', optionsGen);
        select2.addEventListener('change', (event)=>{
            console.log(event.target.value);
            Genero.innerText = ": " + select2.options[select2.selectedIndex].text;
        });
    }
}