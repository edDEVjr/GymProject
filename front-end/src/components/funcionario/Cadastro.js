
import React, { useState } from "react";
import "./Cadastro.css"

const CreateFuncionario = () => {
  const [formData, setFormData] = useState({
    nome: "",
    cpf: "",
    dataNascimento: "",
  });
  const [message, setMessage] = useState("");

  // Atualiza os valores do formulário
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  // Envia os dados para o backend
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/funcionario/new", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          nome: formData.nome,               // Correspondendo ao nome do campo
          cpf: formData.cpf,                 // Correspondendo ao nome do campo
          dataNascimento: formData.dataNascimento,  // Correspondendo ao nome do campo
        }),
      });

      if (response.ok) {
        const data = await response.json();
        //Mostrar mensagem
        setMessage(`Funcionário cadastrado com sucesso! Nome: ${data.nome}`);
        //redireciona para /funcionario
        window.location.href = "/funcionario";
      } else {
        setMessage("Erro ao cadastrar o funcionário.");
      }
    } catch (error) {
      setMessage("Erro na comunicação com o servidor.");
    }
  };

  return (
    <div>
      <h1>Cadastrar Funcionário</h1>
      <form className="form" onSubmit={handleSubmit}>
        <div>
          <label>Nome:</label>
          <input
            type="text"
            name="nome"                   // Correspondente ao campo no estado
            value={formData.nome}         // Usando o estado correto
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>CPF:</label>
          <input
            type="text"
            name="cpf"                    // Correspondente ao campo no estado
            value={formData.cpf}          // Usando o estado correto
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Data de Nascimento:</label>
          <input
            type="date"
            name="dataNascimento"        // Correspondente ao campo no estado
            value={formData.dataNascimento} // Usando o estado correto
            onChange={handleChange}
            required
          />
        </div>
        <button className="button" type="submit">Cadastrar</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
};

export default CreateFuncionario;

