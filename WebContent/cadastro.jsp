<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Health Track - Cadastro</title>
<%@ include file="head.jsp" %>
</head>
<body>
	<div class="container mt-md-4">
            <header class="row justify-content-center">
                <p id="titulo-pagina" class="col-lg-4 text-center h3 p-1 bg-info text-white">Cadastro</p>
            </header>
            <main class="row justify-content-center">
            	<c:if test="${not empty msg }">
					<div class="alert alert-success">${msg}</div>
				</c:if>
				<c:if test="${not empty erro }">
					<div class="alert alert-danger">${erro}</div>
				</c:if>
				
                <form method="post" action="usuario" class="col-lg-4">
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <label id="nome" for="nome" class="input-group-text text-info"><i class="fas fa-user-alt"></i></label>
                        </div>
                        <input name="nome" class="form-control" type="text" placeholder="Nome" required>
                    </div>

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <label id="dtnasc" for="dtnasc" class="input-group-text text-info"><i class="fas fa-calendar-alt"></i></label>
                        </div>
                        <input name="nascimento" class="form-control" placeholder="Nascimento" type="text" onfocus="(this.type='date')" onblur="(this.type='text')" id="date" required>            
                    </div>

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <label id="genero" for="genero" class="input-group-text text-info"><i class="fas fa-female"></i> / <i class="fas fa-male"></i></label>
                        </div>
                        <select class="custom-select" name="genero" required>
                            <option selected disabled>Gênero</option>
                            <option value="feminino">Feminino</option>
                            <option value="masculino">Masculino</option>
                        </select>
                    </div>

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <label id="altura" for="altura" class="input-group-text text-info"><i class="fas fa-ruler"></i></label>
                        </div>
                        <input name="altura" class="form-control" type="number" placeholder="Altura (cm)" required>
                    </div>


                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <label id="email" for="email" class="input-group-text text-info"><i class="fas fa-at"></i></label>
                        </div>
                        <input class="form-control" name="email" type="email" placeholder="E-mail" required>
                    </div>

                    <div class="form-group input-group mb-0">
                        <div class="input-group-prepend">
                            <label id="senha" for="senha" class="input-group-text text-info"><i class="fas fa-key"></i></label>
                        </div>
                        <input class="form-control mb-0" name="senha" type="password" placeholder="Senha" minlength="6" required>
                    </div>
                    <div class="form-group mt-0">
                        <small class="text-muted">Sua senha deve conter no mínino 6 caracteres</small>
                    </div>

                     <div class="text-center">
                        <input class="btn btn-block btn-info rounded-pill text-center" type="submit" value="Cadastrar-se">
                    </div> 

                    <!--<a href="home.jsp" class="btn btn-block btn-info rounded-pill text-center">Cadastrar-se</a>-->
                </form>
            </main>
            <footer class="row row-cols-1 justify-content-center mt-2">
                <div class="col mb-0">
                    <p class="mb-0 text-center"><small>Já possui cadastro?</small></p>
                </div>
                <div class="col-lg-4 mt-0">
                    <a class="btn btn-block btn-info rounded-pill mt-0 px-5" href="login.jsp">Login</a>
                </div>
            </footer>
        </div>
        
       <%@ include file="scripts.jsp" %>

</body>
</html>