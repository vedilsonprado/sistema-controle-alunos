const menuLateral = document.getElementById('menuLateral');
const tituloTurma = document.getElementById('tituloTurma');
const listaAlunos = document.getElementById('listaAlunos');

// Carrega as turmas no menu lateral
async function carregarTurmas() {
    menuLateral.innerHTML = '';

    const response = await fetch('/turmas');
    const turmas = await response.json();

    turmas.forEach(turma => {
        const botaoTurma = document.createElement('button');
        botaoTurma.innerText = turma.nome;
        botaoTurma.addEventListener('click', () => {
            window.location.href = `listaalunos.html?idTurma=${turma.id}&nomeTurma=${encodeURIComponent(turma.nome)}`;
        });

        menuLateral.appendChild(botaoTurma);
    });
}

// Carrega os alunos de uma turma específica
async function carregarAlunosDaTurma(idTurma, nomeTurma) {
    tituloTurma.innerText = `Alunos da Turma: ${nomeTurma}`;

    const response = await fetch(`/turmas/${idTurma}/alunos`);

    if (!response.ok) {
        listaAlunos.innerHTML = '<p>Erro ao buscar alunos da turma.</p>';
        return;
    }

    const alunos = await response.json();

    listaAlunos.innerHTML = '';

    alunos.forEach(aluno => {
        // Cria o card do aluno
        const cardAluno = document.createElement('div');
        cardAluno.classList.add('card-aluno');

        // Cria a imagem do aluno
        const imagemAluno = document.createElement('img');
        imagemAluno.src = aluno.foto || 'https://via.placeholder.com/150'; // Caso não tenha foto
        imagemAluno.alt = `Foto de ${aluno.nome}`;

        // Cria o nome do aluno
        const nomeAluno = document.createElement('p');
        nomeAluno.innerText = aluno.nome;

        // Adiciona evento de clique no card para ir ao perfil
        cardAluno.addEventListener('click', () => {
            window.location.href = `perfilaluno.html?idAluno=${aluno.id}`;
        });

        // Monta o card
        cardAluno.appendChild(imagemAluno);
        cardAluno.appendChild(nomeAluno);

        // Adiciona o card à lista
        listaAlunos.appendChild(cardAluno);
    });
}

// Função que pega os parâmetros da URL
function obterParametrosURL() {
    const params = new URLSearchParams(window.location.search);
    return {
        idTurma: params.get('idTurma'),
        nomeTurma: params.get('nomeTurma')
    };
}

// Inicializa a página
document.addEventListener('DOMContentLoaded', () => {
    carregarTurmas();

    const { idTurma, nomeTurma } = obterParametrosURL();

    if (idTurma && nomeTurma) {
        carregarAlunosDaTurma(idTurma, nomeTurma);
    }
});
