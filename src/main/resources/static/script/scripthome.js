const menuLateral = document.getElementById('menuLateral');

async function carregarTurmas() {
    menuLateral.innerHTML = '';

    try {
        const response = await fetch('/turmas');

        if (!response.ok) {
            throw new Error('Erro ao carregar turmas');
        }

        const turmas = await response.json();

        turmas.forEach(turma => {
            const btn = document.createElement('button');
            btn.innerText = turma.nome;
            btn.addEventListener('click', () => {
                // Redireciona para outra página passando o id e o nome da turma via query params
                window.location.href = `listaalunos.html?idTurma=${turma.id}&nomeTurma=${encodeURIComponent(turma.nome)}`;
            });

            menuLateral.appendChild(btn);
        });

    } catch (error) {
        console.error('Erro ao buscar turmas:', error);
    }
}

// Ao carregar a página, chama a função
document.addEventListener('DOMContentLoaded', carregarTurmas);
