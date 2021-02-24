<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Health Track - Login</title>
<%@ include file="head.jsp" %>
</head>
<body>
	<div class="container mt-md-4">
            <header class="row justify-content-center">
                <p id="titulo-pagina" class="col-lg-4 text-center h3 p-1 bg-info text-white">Login</p>
            </header>
            <c:if test="${not empty erro }">
            		<div class="row justify-content-center" >
						<div class="alert alert-danger col-lg-4 text-center ">${erro}</div>
            		</div>
			</c:if>
            <main class="row justify-content-center">
				
                <form method="post" action="login" class="col-lg-4">
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <label id="email" for="email" class="input-group-text text-info bg-white"><i class="fas fa-at"></i></label>
                        </div>
                        <input class="form-control" name="email"  type="email" placeholder="E-mail" value="paolalemes6@hotmail.com"  required>
                    </div>

                    <div class="form-group input-group mb-0">
                        <div class="input-group-prepend">
                            <label id="senha" for="senha" class="input-group-text text-info bg-white"><i class="fas fa-key"></i></label>
                        </div>
                        <input class="form-control mb-0" name="senha" type="password" placeholder="Senha" value="123456" minlength="6" required>
                    </div>
                    <div class="form-group mt-0">
                        <small class="text-muted">Esqueceu sua senha? <a class="link text-info" href="#">Clique aqui</a></small>
                    </div>

                    <div class="text-center">
                        <input class="btn btn-block btn-info rounded-pill text-center" type="submit" value="Login">
                    </div>

                   <!-- <a href="home.jsp" class="btn btn-block btn-info rounded-pill text-center">Login</a> -->
                </form>
            </main>
            <footer class="row row-cols-1 justify-content-center mt-2">
                <div class="col mb-0">
                    <p class="mb-0 text-center"><small>Não possui cadastro? </small></p>
                </div>
                <div class="col-lg-4 mt-0">
                    <a class="btn btn-block btn-info rounded-pill mt-0 px-5" href="cadastro.jsp">Cadastre-se</a>
                </div>
            </footer>
        </div>
        
        
		<%@ include file="scripts.jsp" %>
</body>
</html>