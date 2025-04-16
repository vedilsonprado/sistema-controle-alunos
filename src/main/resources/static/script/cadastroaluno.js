const menuLateral = document.getElementById('menuLateral');

// Carregar Turmas no Menu Lateral
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

// Pegar ID da Turma da URL
const urlParams = new URLSearchParams(window.location.search);
const idTurma = urlParams.get('idTurma');

if (!idTurma) {
	alert('Turma não selecionada!');
	window.location.href = 'index.html';
}

// Evento Salvar Aluno
document.addEventListener('DOMContentLoaded', () => {
	const formCadastro = document.getElementById('formCadastroAluno');

	formCadastro.addEventListener('submit', async (event) => {
		event.preventDefault();

		const nome = document.getElementById('nome').value.trim();

		if (!nome) {
			alert('Preencha o nome do aluno.');
			return;
		}

		const aluno = {
			nome: nome,
			turma: {
				id: idTurma
			}
		};

		const response = await fetch('/api/alunos', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(aluno)
		});

		if (response.ok) {
			alert('Aluno cadastrado com sucesso!');
			window.location.href = `listaalunos.html?idTurma=${idTurma}`;
		} else {
			alert('Erro ao cadastrar aluno.');
		}
	});
});

carregarTurmas();
