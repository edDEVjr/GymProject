import { React } from "react";
import { useLocation } from "react-router-dom";
import "./NavBar.css"




function NavBar() {
    const location = useLocation();
    return (
        <nav  class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <div className="logo">GP</div>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        {location.pathname !== "/" && (
                            <li class="nav-item" className="link">
                                <a class="nav-link active" aria-current="page" href="/">Home</a>
                            </li>
                        )}
                        
                        {location.pathname !== "/funcionario" && (
                            <li class="nav-item" className="link">
                                <a class="nav-link active" aria-current="page" href="/funcionario">Funcionario</a>
                            </li>
                        )}
                        {location.pathname !== "/cliente" && (
                            <li class="nav-item" className="link">
                                <a class="nav-link active" aria-current="page" href="/#">Cliente</a>
                            </li>
                        )}
                        {location.pathname === "/funcionario" && (
                            <li class="nav-item" className="link">
                                <a class="nav-link active" aria-current="page" href="/funcionario/new">Cadastrar Funcionario</a>
                            </li>
                        )}
                    </ul>
                </div>
            </div>
        </nav>
    )

}

export default NavBar;