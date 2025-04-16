const menuLateral = document.getElementById('menuLateral');
const nomeAluno = document.getElementById('nomeAluno');
const emailAluno = document.getElementById('emailAluno');
const fotoAluno = document.getElementById('fotoAluno');

async function carregarTurmas() {
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

async function carregarAluno() {
    const params = new URLSearchParams(window.location.search);
    const idAluno = params.get('idAluno');

    if (!idAluno) {
        alert('Aluno não encontrado');
        return;
    }

    const response = await fetch(`/api/alunos/${idAluno}`);
    const aluno = await response.json();

    nomeAluno.innerText = aluno.nome;
    emailAluno.innerText = aluno.email;

    // Aqui pode personalizar se tiver a imagem do aluno
    if (aluno.fotoUrl) {
        fotoAluno.src = aluno.fotoUrl;
    }
}

carregarTurmas();
carregarAluno();
