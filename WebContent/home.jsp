<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Heath Track - Home</title>
<%@ include file="head.jsp" %>
</head>
<body>
      <header class="container fixed-top bg-white">
         <ul class="nav nav-tabs">
             <li class="nav-item">
               <a class="nav-link active" href="home.jsp">Home</a>
             </li>
             <li class="nav-item">
               <a class="nav-link text-info" href="login"><i class="fas fa-sign-out-alt"></i></a>
             </li>
           </ul>
       </header>
       
	  	 
       <main class="home container">
      	 <c:if test="${empty user }">
		    <span class="navbar-text text-danger" style="margin-right:10px" >
		        ${erro }
		  	</span>	
	  	 </c:if>
	  	 <c:if test="${not empty user }">
            <div class="card-deck py-2">

                <div class="card border-info container mt-1">
                    <div class="row card-header border-info text-info my-0 py-0">
                        <p class="col p-0 m-0"><i class="fas fa-user-alt"></i>Dados</p>
                        <a class="col-1 text-info" href="configuracoes.jsp"><i class="fas fa-pencil-alt"></i></a>
                    </div>

                    <div class="row align-items-center">
                        <div class="col-2 m-0 p-0 pl-2">
                            <a class="btn btn-outline-info p-3 " href="#"><i class="fas fa-camera"></i></a>
                        </div>
                        <div class="col-10">
                            <div class="card-body p-1 m-0">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item m-0 p-0 text-center">Usuario: <small>${user}</small></li>
                                    <li class="list-group-item m-0 p-0 text-center">Idade: <small>23 anos <small class="text-muted"> (06/09/1997)</small></small></li>
                                    <li class="list-group-item m-0 p-0 text-center">Altura: <small>1,72 m <small class="text-muted"></small></small></li>
                                    <li class="list-group-item m-0 p-0 text-center">I.M.C.: <small>22,99 <small class="text-muted">(Normal)</small></small></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card border-info container">
                    <div class="row card-header border-info text-info my-0 py-0">
                        <p class="col p-0 m-0"><i class="fas fa-weight"></i> Peso</p>
                        <a class="col-1 text-info" href="adicionarPeso.jsp"><i class="fas fa-plus text-right"></i></a>
                    
                    </div>
                    <div class="card-body p-1 m-0">
                        <p class="card-text m-0 p-0"><small>Você perdeu 1kg desde a última pesagem</small></p>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item m-0 p-0 text-center"><small>68 kg <small class="text-muted">01/03/20</small></small></li>
                            <li class="list-group-item m-0 p-0 text-center"><small>69 kg <small class="text-muted">01/02/20</small></small></li>
                            <li class="list-group-item m-0 p-0 text-center"><small>70 kg <small class="text-muted">01/01/20</small></small></li>
                        </ul>
                    </div>
                </div>

            </div>

            <div class="card-deck pb-2">
                <div class="card border-info container">
                    <div class="row card-header border-info text-info my-0 py-0">
                        <p class="col p-0 m-0"><i class="fas fa-heartbeat"></i> Batimentos Cardíacos</p>
                        <a class="col-1 text-info" href="adicionarBatimentos.jsp"><i class="fas fa-plus text-right"></i></a>
                    
                    </div>
                    <div class="card-body p-1 m-0">
                        <p class="card-text m-0 p-0"><small>Seus batimentos aumentaram</small></p>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item m-0 p-0 text-center"><small>72 b.p.m. <small class="text-muted">01/03/20</small></small></li>
                            <li class="list-group-item m-0 p-0 text-center"><small>69 b.p.m. <small class="text-muted">01/02/20</small></small></li>
                            <li class="list-group-item m-0 p-0 text-center"><small>68 b.p.m. <small class="text-muted">01/01/20</small></small></li>
                        </ul>
                    </div>
                </div>

                <div class="card border-info container">
                    <div class="row card-header border-info text-info my-0 py-0">
                        <p class="col p-0 m-0"><i class="fas fa-heartbeat"></i> Pressão Arterial</p>
                        <a class="col-1 text-info" href="adicionarPressao.jsp"><i class="fas fa-plus text-right"></i></a>
                    
                    </div>                        

                    <div class="card-body p-1 m-0">
                        <p class="card-text m-0 p-0"><small>Sua pressão arterial aumentou</small></p>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item m-0 p-0 text-center"><small>150/90 mmHg <small class="text-muted">01/03/20</small></small></li>
                            <li class="list-group-item m-0 p-0 text-center"><small>110/70 mmHg <small class="text-muted">01/03/20</small></small></li>
                            <li class="list-group-item m-0 p-0 text-center"><small>120/80 mmHg <small class="text-muted">01/03/20</small></small></li>
                        </ul>
                    </div>
                </div>

            </div>

            <div class="card-deck pb-2">
                <div class="card border-info container">
                    <div class="row card-header border-info text-info my-0 py-0">
                        <p class="col p-0 m-0"><i class="fas fa-utensils"></i> Refeições</p>
                        <a class="col-1 text-info" href="adicionarRefeicao.jsp"><i class="fas fa-plus text-right"></i></a>
                    
                    </div>
                    <div class="card-body p-1 m-0">
                        <p class="card-text m-0 p-0"><small>Sua ingestão de calorias aumentou 950kcal</small></p>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item m-0 p-0 text-center"><small>1250 kcal - Almoço <small class="text-muted">01/03/20</small></small></li>
                            <li class="list-group-item m-0 p-0 text-center"><small>300 kcal - Café da Manhã <small class="text-muted">01/03/20</small></small></li>
                            <li class="list-group-item m-0 p-0 text-center"><small>200 kcal - Jantar <small class="text-muted">29/02/20</small></small></li>
                        </ul>
                    </div>
                </div>

                <div class="card border-info container">
                    <div class="row card-header border-info text-info my-0 py-0">
                        <p class="col p-0 m-0"><i class="fas fa-dumbbell"></i> Atividades Físicas</p>
                        <a class="col-1 text-info" href="adicionarAtividade.jsp"><i class="fas fa-plus text-right"></i></a>
                    
                    </div>                        

                    <div class="card-body p-1 m-0">
                        <p class="card-text m-0 p-0"><small>Seu gasto de calorias diminuiu 50kcal</small></p>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item m-0 p-0 text-center"><small>50 kcal - Caminhada <small class="text-muted">01/02/20</small></small></li>
                            <li class="list-group-item m-0 p-0 text-center"><small>100 kcal - Corrida <small class="text-muted">01/02/20</small></small></li>
                            <li class="list-group-item m-0 p-0 text-center"><small>50 kcal - Caminhada <small class="text-muted">01/01/20</small></small></li>
                        </ul>
                    </div>
                </div>

            </div>

         </c:if>
        </main>
        
        <%@ include file="footer.jsp" %>
        
		<%@ include file="scripts.jsp" %>
        
</body>
</html>