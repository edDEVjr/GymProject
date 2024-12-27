import React,{ useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";

const UpdateFuncionario = () => {
    const [formData, setFormData] = useState({
        nome: "",
        cpf: "",
        dataNascimento: "",
    });
    const [message, setMessage] = useState("");
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        const fetchFuncionario = async () => {
            try {
                const response = await fetch(`http://localhost:8080/funcionario/${id}`);
                if (response.ok) {
                    const data = await response.json();
                    setFormData({
                        nome: data.nome,
                        cpf: data.cpf,
                        dataNascimento: data.dataNascimento,
                    });
                } else {
                    setMessage("Funcionario nao Encontrado")
                }
            } catch (error) {
                setMessage("Erro na comunicacao com o servidor")
            }
        };

        fetchFuncionario();
    }, [id]);

    //Atualiza os valores do fomulario
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    //Envia os dados atualizados para o backend
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch(`http://localhost:8080/funcionario/${id}/edit`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    nome: formData.nome,
                    cpf: formData.cpf,
                    dataNascimento: formData.dataNascimento,
                }),
            });
            if (response.ok) {
                setMessage("Funcionário atualizado com sucesso!");
                navigate("/funcionario"); // Redireciona para a página de funcionários
            } else {
                setMessage("Erro ao atualizar o funcionário.");
            }
        } catch (error) {
            setMessage("Erro na comunicacao com o servidor")
        }
    }

    return (
        <div>
            <h1>Editar Funcionário</h1>
            <form className="form" onSubmit={handleSubmit}>
                <div>
                    <label>Nome:</label>
                    <input
                        type="text"
                        name="nome"
                        value={formData.nome}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>CPF:</label>
                    <input
                        type="text"
                        name="cpf"
                        value={formData.cpf}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Data de Nascimento:</label>
                    <input
                        type="date"
                        name="dataNascimento"
                        value={formData.dataNascimento}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button className="button" type="submit">Atualizar</button>
            </form>
            {message && <p>{message}</p>}
        </div>
    );


};

export default UpdateFuncionario;