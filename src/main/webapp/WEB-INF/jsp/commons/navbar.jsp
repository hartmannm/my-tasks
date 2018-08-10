<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div>
	    <nav>
		    <div class="nav-wrapper blue-grey darken-3">
			    <a href="${linkTo[HomeController].home}" class="brand-logo">My-Tasks</a>
			    <a href="#" data-target="mobile-demo" class="sidenav-trigger">
			    	<i class="material-icons">menu</i>
			    </a>
			    <ul class="right hide-on-med-and-down">
				    <li>
				    	<a href="${linkTo[HomeController].home}">Ínicio</a>
				    </li>
				     <li>
				    	<a href="${linkTo[TaskController].register}">Cadastrar tarefa</a>
				    </li>
				    <li>
						<a href="${linkTo[LoginController].logout}">Sair</a>
					</li>
			    </ul>
		    </div>
	  	</nav>
	
		<ul class="sidenav" id="mobile-demo">
			<li>
		    	<a href="${linkTo[HomeController].home}">Ínicio</a>
		    </li>
		     <li>
		    	<a href="${linkTo[TaskController].register}">Cadastrar tarefa</a>
		    </li>
		    <li>
				<a href="${linkTo[LoginController].logout}">Sair</a>
			</li>
		</ul>
	</div>