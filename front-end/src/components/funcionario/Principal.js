import React, { useState, useEffect } from "react";

const Funcionarios = () => {
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
    <div className="container mt-5">
      <h1 className="text-center mb-4">Lista de Funcionários</h1>
      <table className="table table-striped table-hover">
        <thead className="table-dark">
          <tr>
            <th>#</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Data de Nascimento</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {funcionarios.length > 0 ? (
            funcionarios.map((funcionario, index) => (
              <tr key={funcionario.id}>
                <td>{index + 1}</td>
                <td>{funcionario.nome}</td>
                <td>{funcionario.cpf}</td>
                <td>{funcionario.dataNascimento}</td>
                <td>
                  <button className="btn btn-primary btn-sm me-2">Editar</button>
                  <button className="btn btn-danger btn-sm">Excluir</button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5" className="text-center">
                Nenhum funcionário encontrado.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};
      

export default Funcionarios;
