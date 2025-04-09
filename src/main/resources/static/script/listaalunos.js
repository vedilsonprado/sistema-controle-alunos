 const menuLateral = document.getElementById('menuLateral');
 const tituloTurma = document.getElementById('tituloTurma');
 const listaAlunos = document.getElementById('listaAlunos');
 const conteudoPrincipal = document.getElementById('conteudoPrincipal');

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

 async function carregarAlunosDaTurma(idTurma, nomeTurma) {
     tituloTurma.innerText = nomeTurma;
     listaAlunos.innerHTML = '';

     const response = await fetch(`/turmas/${idTurma}/alunos`);
     const alunos = await response.json();

     alunos.forEach(aluno => {
         const card = document.createElement('div');
         card.classList.add('card-aluno');

         const img = document.createElement('img');
         img.src = aluno.foto || 'img/usuario-sem-foto.png';
         img.alt = 'Foto do aluno';

         const nome = document.createElement('p');
         nome.innerText = aluno.nome;

         card.appendChild(img);
         card.appendChild(nome);

         card.addEventListener('click', () => {
             window.location.href = `perfilaluno.html?idAluno=${aluno.id}`;
         });

         listaAlunos.appendChild(card);
     });

    const botaoAdicionar = document.createElement('button');
    botaoAdicionar.innerText = 'Adicionar';
    botaoAdicionar.classList.add('botao-adicionar');
    botaoAdicionar.addEventListener('click', () => {
        window.location.href = `cadastroaluno.html?idTurma=${idTurma}`;
    });
    conteudoPrincipal.insertBefore(botaoAdicionar, listaAlunos);
 }

 document.addEventListener('DOMContentLoaded', async () => {
     await carregarTurmas();

     const urlParams = new URLSearchParams(window.location.search);
     const idTurma = urlParams.get('idTurma');
     const nomeTurma = urlParams.get('nomeTurma');

     if (idTurma && nomeTurma) {
         await carregarAlunosDaTurma(idTurma, nomeTurma);
     }
 });
