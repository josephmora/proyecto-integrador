window.addEventListener('load', function () {


    const formulario = document.querySelector('#update_paciente_form');
    formulario.addEventListener('submit', function (event) {
        let studentId = document.querySelector('#paciente_id').value;


        const formData = {
            id: document.querySelector('#paciente_id').value,
            name: document.querySelector('#nombre').value,
            lastname: document.querySelector('#apellido').value,

        };


        const url = '/pacientes';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })


    function findBy(id) {
          const url = '/pacientes'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let student = data;
              document.querySelector('#paciente_id').value = paciente.id;
              document.querySelector('#nombre').value = paciente.name;
              document.querySelector('#apellido').value = paciente.lastname;

              document.querySelector('#div_paciente_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }