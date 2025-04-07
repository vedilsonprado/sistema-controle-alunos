const form = document.getElementById('formAluno');

form.addEventListener('submit', function(event) {
    event.preventDefault();

    const aluno = {
        nome: document.getElementById('nome').value,
        email: document.getElementById('email').value,
        telefone: document.getElementById('telefone').value
    };

    fetch('http://localhost:8080/api/alunos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(aluno)
    })
    .then(response => {
        if (response.ok) {
            alert('Aluno cadastrado com sucesso!');
            window.location.href = 'index.html';
        } else {
            alert('Erro ao cadastrar aluno.');
        }
    });
});
