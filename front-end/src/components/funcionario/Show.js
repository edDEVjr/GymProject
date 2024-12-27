import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom"; // Para pegar o ID da URL

import "./Show.css";

const ShowFuncionario = () => {
  const { id } = useParams(); // Pega o ID da rota (ex.: /funcionario/:id)
  const [funcionario, setFuncionario] = useState(null); // Estado para armazenar o funcionário
  const [error, setError] = useState(null); // Para tratar erros
  const [loading, setLoading] = useState(true); // Estado de carregamento

  useEffect(() => {
    const fetchFuncionario = async () => {
      try {
        const response = await fetch(`http://localhost:8080/funcionario/${id}`);
        if (response.ok) {
          const data = await response.json();
          setFuncionario(data); // Atualiza o estado com os dados do funcionário
          setError(null); // Limpa qualquer erro anterior
        } else {
          setError("Funcionário não encontrado.");
        }
      } catch (error) {
        setError("Erro ao buscar os dados do funcionário.");
      } finally {
        setLoading(false); // Finaliza o carregamento
      }
    };

    fetchFuncionario();
  }, [id]); // A dependência `id` garante que a busca será feita ao mudar de ID

  if (loading) {
    return <p>Carregando...</p>;
  }

  if (error) {
    return <p>{error}</p>;
  }

  // Certifique-se de que o funcionário está carregado antes de acessar suas propriedades
  if (!funcionario) {
    return <p>Nenhum dado disponível.</p>;
  }

  return (
    <div>
      <h1>Detalhes do Funcionário</h1>
      <p><strong>Nome:</strong> {funcionario.nome}</p>
      <p><strong>CPF:</strong> {funcionario.cpf}</p>
      <p><strong>Data de Nascimento:</strong> {funcionario.dataNascimento}</p>
    </div>
  );
};

export default ShowFuncionario;
