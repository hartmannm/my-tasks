# my-tasks

Está é uma aplicação para agendamento de tarefas.

Anteriormente fiz uma aplicação semelhante usando apenas servlets e JSP. Está aplicação irá funcionar da mesma maneira, porém, será feira utilizando o Vraptor 4 e JPA(Hibernate) com arquitetura MVC.

É uma aplicação simples, feita apenas para fins de estudo do framework Vraptor e da especificação JPA.
Como é para fins de estudo, optei por usar o padrão MVC ao invés de construir uma API REST e e um cliente que consuma a API. Também optei por controlar as transações da JPA manualmente, o que me permitirá usar alguns componentes do Vraptor(como interceptors) e melhorar meu domínio sobre essa tecnologia.

Tecnologias utilizadas:
* Java 8
* Vraptor 4
* JPA (Hibernate)
* Wildfly 8.1
* MySQL 8.0.11
* Maven
* Bootstrap
* JQuery Validate
