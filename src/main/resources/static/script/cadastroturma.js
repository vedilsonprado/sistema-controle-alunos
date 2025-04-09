const menuLateral = document.getElementById('menuLateral');

// Carrega as turmas no menu lateral
async function carregarTurmas() {
    menuLateral.innerHTML = '';

    const response = await fetch('/turmas');
    const turmas = await response.json();

    turmas.forEach(turma => {
        const btn = document.createElement('button');
        btn.innerText = turma.nome;
        btn.addEventListener('click', () => {
            alert('Você está na tela de cadastro. Volte para a página inicial para visualizar os alunos.');
        });
        menuLateral.appendChild(btn);
    });
}

// Cadastro da turma
const formCadastroTurma = document.getElementById('formCadastroTurma');

formCadastroTurma.addEventListener('submit', async (event) => {
    event.preventDefault();

    const nomeTurma = document.getElementById('nomeTurma').value;

    const response = await fetch('/turmas', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nome: nomeTurma })
    });

    if (response.ok) {
        alert('Turma cadastrada com sucesso!');
        window.location.href = 'index.html';
    } else {
        alert('Erro ao cadastrar a turma.');
    }
});

// Executa assim que carregar a página
carregarTurmas();
