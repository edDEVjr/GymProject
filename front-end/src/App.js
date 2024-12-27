import React from 'react';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import Home from './components/Home';
import CreateFuncionario from './components/funcionario/Create';
import Funcionarios from './components/funcionario/Index';
import NavBar from './components/NavBar';
import ShowFuncionario from './components/funcionario/Show';
import UpdateFuncionario from './components/funcionario/Update';

function App() {
  return (
    <div className="App">
      <Router>
        <NavBar />
        <Routes>
          <Route></Route>
          <Route path='/' element={<Home/>} />
          <Route path="/funcionario" element={<Funcionarios />} />
          <Route path="/funcionario/new" element={<CreateFuncionario />} />
          <Route path='/funcionario/:id' element={<ShowFuncionario />} />
          <Route path='/funcionario/:id/edit' element={<UpdateFuncionario />} />
          
        </Routes>
        
      </Router>
      
    </div>
  );
}

export default App;
