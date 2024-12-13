import React, { useState, useEffect } from "react";

const ShowFuncionarios = () => {
  const [funcionarios, setFuncionarios] = useState([]);
  const [message, setMessage] = useState("");

  // Buscar a lista de funcionários
  useEffect(() => {
    const fetchFuncionarios = async () => {
      try {
        const response = await fetch("http://localhost:8080/funcionario"); // Chama a API Spring
        if (response.ok) {
          const data = await response.json();
          setFuncionarios(data); // Atualiza o estado com a lista de funcionários
        } else {
          setMessage("Erro ao carregar a lista de funcionários.");
        }
      } catch (error) {
        setMessage("Erro na comunicação com o servidor.");
      }
    };

    fetchFuncionarios();
  }, []); // O array vazio faz com que a requisição seja feita apenas uma vez quando o componente for montado

  return (
    <div>
      <h1>Lista de Funcionários</h1>
      {message && <p>{message}</p>}

      <table>
        <thead>
          <tr>
            <th>Nome</th>
            <th>CPF</th>
            <th>Data de Nascimento</th>
          </tr>
        </thead>
        <tbody>
          {funcionarios.length > 0 ? (
            funcionarios.map((funcionario) => (
              <tr key={funcionario.id}>
                <td>{funcionario.nome}</td>
                <td>{funcionario.cpf}</td>
                <td>{funcionario.dataNascimento}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4">Nenhum funcionário encontrado.</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default ShowFuncionarios;
