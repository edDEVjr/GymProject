
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import CreateFuncionario from './components/Cadastro';
import ShowFuncionarios from './components/Show';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/funcionario" element={<ShowFuncionarios />} />
          <Route path="/funcionario/new" element={<CreateFuncionario />} />
          
        </Routes>
        
      </Router>
      
    </div>
  );
}

export default App;
