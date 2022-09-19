function loadDataAutor(){
    let request = sendRequest('autor/list','GET','')
    let table = document.getElementById('autor-table');
    table.innerHTML="";
    request.onload= function (){
         let data = request.response;
         console.log(data);
         data.forEach((element,index)=> {
            table.innerHTML += `
              <tr class="table-warning">
                   <th>${element.idAutor}</th>
                   <td>${element.nombreAutor}</td>
                   <td>${element.apellidoAutor}</td>
                   <td>
                        <button style="border-radius:20px;" type="button" class="btn btn-outline-success" onclick="window.location='form_autor.html?id=${element.idAutor}'" >Editar</button>
                        <button style="border-radius:20px; " type="button" class="btn btn-outline-danger" onclick='deleteAutor(${element.idAutor})'>Eliminar</button>
                   </td>
              </tr>
              `
           
         });
    }
    request.onerror = function(){
         table.innerHTML=`
         <tr>
              <td colspan="6">Error al recuperar los datos del autor</td>
         </tr>`
    }
}

function loadAutor(idAutor){
    let request = sendRequest('autor/list/'+idAutor,'GET','')
    let id = document.getElementById('autor-id')
    let name = document.getElementById('autor-name')
    let lastname = document.getElementById('autor-apellido')
    request.onload = function (){
         let data = request.response
         id.value = data.idAutor
         name.value = data.nombreAutor
         lastname.value = data.apellidoAutor
    }
    request.onerror  = function (){
         alert('Error al recuperar los datos del autor.')
    }
}

function deleteAutor(idAutor){
    var Delete = window.confirm("Está seguro de eliminar este autor permanentemente?");
    if(Delete === true){
        window.alert('Autor eliminado satisfactoriamente');
        let request = sendRequest('autor/list/'+idAutor,'DELETE','')
        request.onload=function(){
            loadDataAutor();
        }
        request.onerror= function(){
            alert('Error al intentar eliminar el autor de id '+idProducto)
        }
    }
}


function saveAutor(){
    let name = document.getElementById('autor-name').value
    let apellido = document.getElementById('autor-apellido').value
    let crearAutor = {'nombreAutor':name, 'apellidoAutor':apellido}
    
    var Save = window.confirm("Está seguro de guardar este autor?");
    if(Save === true){
        window.alert('Autor guardado satisfactorianente');
        let request = sendRequest('autor/','POST',crearAutor)
        console.log("guardar autor "+request.response+" info "+crearAutor)
        request.onload = function(){
             window.location ='autor.html';
        }
        request.onerror = function (){
            alert('Error al guardar el autor')
        }
    }
}

function updateAutor(){
    let id = document.getElementById('autor-id').value
    let name = document.getElementById('autor-name').value
    let apellido = document.getElementById('autor-apellido').value
    let data = {'idAutor':id, 'nombreAutor':name, 'apellidoAutor':apellido}
         
    var Update = window.confirm("Está seguro de actualizar este autor?");
    if(Update === true){
        window.alert('Autor actualizado satisfactorianente');
        let request = sendRequest('autor/list/'+id,'PUT',data)
        console.log("actualizar autor "+request.response+" info "+ data)
        request.onload = function(){
             window.location ='autor.html';
        }
        request.onerror = function (){
            alert('Error al actualizar el autor')
        }
    }
}