const API_URL = "http://localhost:8080/api/livros";

/* =========================
   LISTAR / FILTRAR LIVROS
========================= */
async function listarLivros(filtros = {}) {
  let url = `${API_URL}/listarLivros`;

  const params = new URLSearchParams();
  Object.entries(filtros).forEach(([chave, valor]) => {
    if (valor !== "" && valor !== null && valor !== undefined) {
      params.append(chave, valor);
    }
  });

  if ([...params].length > 0) {
    url = `${API_URL}/filtrar?${params.toString()}`;
  }

  try {
    const response = await fetch(url);
    if (!response.ok) throw new Error("Erro ao buscar livros");

    const livros = await response.json();
    const container = document.getElementById("cardsContainer");
    container.innerHTML = "";

    if (!Array.isArray(livros) || livros.length === 0) {
      container.innerHTML = "<p>Nenhum livro encontrado.</p>";
      return;
    }

    livros.forEach(l => {
      const card = document.createElement("div");
      card.className = "card";

      const statusCor =
        l.status?.toLowerCase() === "disponivel" ? "green" : "red";

      card.innerHTML = `
        <img src="${l.capa || "https://via.placeholder.com/300x200?text=Sem+Capa"}">
        <div class="card-content">
          <h3>${l.titulo}</h3>
          <p><b>Autor:</b> ${l.autor}</p>
          <p><b>Gênero:</b> ${l.genero}</p>
          <p><b>Ano:</b> ${l.anoPublicacao}</p>
          <p><b>Páginas:</b> ${l.paginas}</p>
          <p><b>Preço:</b> R$ ${Number(l.preco).toFixed(2)}</p>
          <p><b>Status:</b>
            <span style="color:${statusCor}; font-weight:bold;">
              ${l.status}
            </span>
          </p>
        </div>
        <div class="card-actions">
          <button onclick="editarLivro(${l.id}, ${l.preco}, '${l.status}')">Editar</button>
          <button onclick="deletarLivro(${l.id})">Excluir</button>
        </div>
      `;

      container.appendChild(card);
    });

  } catch (error) {
    console.error("Erro:", error);
  }
}

/* =========================
   CADASTRAR LIVRO
========================= */
document.querySelector("form").addEventListener("submit", async (e) => {
  e.preventDefault();

  const livro = {
    titulo: document.getElementById("titulo").value,
    autor: document.getElementById("autor").value,
    genero: document.getElementById("genero").value,
    anoPublicacao: Number(document.getElementById("anoPublicacao").value),
    paginas: Number(document.getElementById("paginas").value),
    preco: Number(document.getElementById("preco").value),
    status: document.getElementById("status").value,
    capa: document.getElementById("capa").value
  };

  await fetch(`${API_URL}/cadastrarLivro`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(livro)
  });

  e.target.reset();
  listarLivros();
});

/* =========================
   DELETAR LIVRO
========================= */
async function deletarLivro(id) {
  if (!confirm("Deseja excluir este livro?")) return;

  await fetch(`${API_URL}/deletarLivro/${id}`, {
    method: "DELETE"
  });

  listarLivros();
}

/* =========================
   EDITAR LIVRO
========================= */
async function editarLivro(id, precoAtual, statusAtual) {
  const novoPreco = prompt("Novo preço:", precoAtual);
  const novoStatus = prompt("Novo status (disponivel / emprestado):", statusAtual);

  if (!novoPreco || !novoStatus) return;

  await fetch(`${API_URL}/atualizarLivro/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      preco: Number(novoPreco),
      status: novoStatus
    })
  });

  listarLivros();
}

/* =========================
   FILTRAR
========================= */
document.getElementById("btnFiltrar").addEventListener("click", () => {
  listarLivros({
    autor: document.getElementById("filtroAutor").value,
    titulo: document.getElementById("filtroTitulo").value,
    anoPublicacao: document.getElementById("filtroAno").value,
    preco: document.getElementById("filtroPreco").value,
    status: document.getElementById("filtroStatus").value
  });
});

/* =========================
   LIMPAR FILTROS
========================= */
document.getElementById("btnLimpar").addEventListener("click", () => {
  ["filtroAutor", "filtroTitulo", "filtroAno", "filtroPreco", "filtroStatus"]
    .forEach(id => document.getElementById(id).value = "");
  listarLivros();
});

/* =========================
   INICIAR
========================= */
listarLivros();
