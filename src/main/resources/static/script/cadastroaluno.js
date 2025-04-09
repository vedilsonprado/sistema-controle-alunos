const menuLateral = document.getElementById('menuLateral');
const conteudoPrincipal = document.getElementById('conteudoPrincipal');

// Recuperar idTurma da URL
const params = new URLSearchParams(window.location.search);
const idTurma = params.get('idTurma');

if (!idTurma) {
    alert('Nenhuma turma selecionada.');
    window.location.href = 'listaalunos.html';
}

// Carregar turmas no menu lateral
async function carregarTurmas() {
    menuLateral.innerHTML = '';

    const response = await fetch('/turmas');
    const turmas = await response.json();

    turmas.forEach(turma => {
        const btn = document.createElement('button');
        btn.innerText = turma.nome;
        btn.addEventListener('click', () => {
            window.location.href = `listaalunos.html?idTurma=${turma.id}&nomeTurma=${encodeURIComponent(turma.nome)}`;
        });
        menuLateral.appendChild(btn);
    });
}

// Cadastrar aluno
async function cadastrarAluno(event) {
    event.preventDefault();

    const nome = document.getElementById('nome').value.trim();

    if (!nome) {
        alert('Informe o nome do aluno.');
        return;
    }

    const aluno = {
        nome: nome,
        turma: {
            id: idTurma
        }
    };

    const response = await fetch('/turmas/alunos', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(aluno)
    });

    if (response.ok) {
        alert('Aluno cadastrado com sucesso!');
        window.location.href = `listaalunos.html?idTurma=${idTurma}`;
    } else {
        alert('Erro ao cadastrar aluno.');
    }
}

document.addEventListener('DOMContentLoaded', () => {
    carregarTurmas();

    const form = document.getElementById('formAluno');
    form.addEventListener('submit', cadastrarAluno);
});
document.getElementById('btnSalvar').addEventListener('click', salvarAluno);
