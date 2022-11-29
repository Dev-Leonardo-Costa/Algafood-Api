# EspecialistaRest
Curso realizado na algaworks

# Spring e Injeção de Dependências
Você vai conhecer os principais projetos do ecossistema Spring para desenvolvimento de REST APIs, como Spring Framework, Spring MVC, Spring Boot, Spring Data JPA, Spring Security, Spring Security OAuth e Spring HATEOAS.

Vai também entender definitivamente como funciona a injeção de dependências com Spring, o IoC Container, definição de beans com @Component, @Configuration e @Bean, pontos de injeção, desambiguação com @Primary, @Qualifier e anotação customizada.

Além disso, você vai aprender a trabalhar com Spring Profiles, publicação e consumo de eventos customizados, configuração de projetos com application.properties e diferenciação por profile, criação e acesso de propriedades customizadas com @Value e @ConfigurationProperties, etc.

# JPA, Hibernate e Flyway
Você vai aprender o que é ORM, como fazer mapeamento de entidades e relacionamentos com JPA (OneToMany, ManyToOne, ManyToMany, OneToOne e Embedded).

Vai também entender e trabalhar com transações no Spring, usar JPQL e Criteria do JPA, fazer joins e fetch em relacionamentos, entender e configurar um pool de conexões (Hikari), etc.

Além disso, você ainda vai ver como criar e evoluir o schema do banco de dados com Flyway, criar migrações com remanejamento de dados, reparar migrações com erros, adicionar dados de testes com callback do Flyway, etc.

E ainda, vamos instalar e usar Lombok nas nossas classes para reduzir código boilerplate.

# Spring Data JPA
aqui aprendi como fazer criação de repositórios super inteligentes com a abstração do SDJ, criação de query methods com filtros, paginação e ordenação e parâmetros nomeados, implementar repositórios customizados, consultas JPQL em arquivo XML e implementação consultas com o padrão Specifications (DDD)


Domain-Driven Design (DDD)
Durante o desenvolvimento do projeto o curso, usaremos alguns conceitos e padrões do DDD, como Repository, Aggregate, Aggregate Root, Domain Event, Domain Service, Infrastructure Service, Specification e Linguagem Ubíqua.

Fundamentos avançados de REST com Spring
Você vai dominar os fundamentos de REST definitivamente, entender o que é e o que não é esse estilo arquitetural e as constraints do REST.

Vai entender o que é de fato e a diferença conceitual e prática de uma API, Resource, Resource Model, Resource Representation, Resource Identifier, Resource Methods, Collection Resources, Singleton Resource e Sub-collection Resources.

Você também vai conhecer todos os níveis do Modelo de Maturidade de Richardson e conhecer a abordagem pragmática e purista de desenvolvedores de REST APIs.

E ainda, você vai entender com mais detalhes o protocolo HTTP, quais são os principais códigos de status do HTTP e quando usar e não usar cada um deles, identificar e entender os métodos seguros e idempotentes do HTTP, conhecer e entender quais métodos HTTP você deve usar, etc.

Você vai aprender a criar, configurar e desenvolver uma API do zero e passo a passo, usando vários projetos do ecossistema Spring.

Vai desenvolver serviços com diversos métodos HTTP, inclusive vai aprender a fazer atualização parcial com PATCH e fazer content negotiation, e tudo seguindo as boas práticas que serão discutidas e ensinadas nas aulas.

Validações com Bean Validation
Que tal aprender a fazer validações de entradas da sua API de forma profissional e avançada?

Você vai aprender a adicionar validações no seu modelo com as anotações do Bean Validation.

Vai aprender também a customizar mensagens de validação, criar validações compostas, criar validações customizadas com ConstraintValidator, criar validações customizadas em nível de classe, criar grupos de validações, validar associações em cascata, executar checagem de validações programaticamente, entender a diferença do Resource Bundle do Spring e do Bean Validation, etc.

Tratamento e modelagem de erros da API
Tratar exceptions é muito importante, mas tão importante quanto isso, é devolver como resposta o código de status HTTP adequado e uma representação padrão do problema. Infelizmente, pouca gente faz isso direito.

Mas nesse treinamento você vai aprender a tratar as exceptions e devolver uma resposta adequada e consistente (padronizada) para o consumidor da API.

Você vai aprender a usar a anotação @ResponseStatus, tratar exceções em nível do controlador com @ExceptionHandler, usar a exceção padrão ResponseStatusException e tratar exceções globalmente com @ExceptionHandler, @ControllerAdvice e ResponseEntityExceptionHandler.

Vamos tratar erros de validação e atributos inexistentes, capturar a exception NoHandlerFoundException e várias outras.

Ainda, vamos discutir, implementar e estender a modelagem de erros seguindo a RFC 7807 (Problem Details for HTTP APIs).

Testes de integração
Ninguém tem dúvidas que testes de software são muito importantes, mas ainda mais se esses testes forem automatizados. Por isso, no treinamento você vai aprender a implementar testes de integração automatizados para a API.

Para implementar os testes de integração, vamos usar Spring Boot Test, REST Assured, JUnit, AssertJ e Maven Failsafe Plugin.

Vamos também implementar a limpeza e população de dados de testes para cada teste (é importante que o banco esteja em um estado consistente para não influenciar o resultado).

Boas práticas e modelagem avançada de APIs
Muitos desenvolvedores de APIs não se preocupam ou até desconhecem algumas boas práticas de mercado, por isso um dos objetivos deste treinamento é discutir e disseminar esse tipo de conhecimento entre os alunos.

Você vai aprender as 5 leis fundamentais para trabalhar com data/hora em APIs, como por exemplo, uso e tratamento de timezone na requisição, resposta e armazenamento de datas e o padrão ISO 8601 para troca de dados.

Vamos ver também como fazer customizações de configurações do Jackson usando classes de mixin, para deixar o código das entidades (model) mais limpo.

Vai aprender também as boas práticas para nomeação de URIs de recursos, escolha e configuração de estratégia de nomes de propriedades, diferença e quando usar recursos de granulação fina ou recursos de granulação grossa e como modelar conceitos abstratos e ações não-CRUD na sua API.

Vamos estudar também sobre como modelar fluxos de transições de estados de recursos, implementar Sub-collection Resources, modelar e implementar endpoints que executam ações em massa.

Discutiremos sobre as diferenças entre usar as entidades como modelo de representação dos recursos ou DTOs, para desacoplar mais os controllers, além de implementar das duas formas. Usaremos o ModelMapper para fazer Object Mapping e converter DTOs em entidades e vice-versa.

Analisaremos sobre quando usar ID sequencial ou UUID para identificar recursos, além de implementar também das duas formas, de acordo com a necessidade. Veremos sobre a granularidade do payload, quando usamos respostas massivas (chunkiness) ou mais conversacional (chattiness).

Vamos implementar e organizar as nossas classes usando alguns conceitos e padrões do DDD (Domain-Driven Design), além de discutir sobre as vantagens e desvantagens de criar exceptions de negócio de granularidade fina ou grossa.

Modelagem de projeções, pesquisas e relatórios
No mundo real, surgem várias necessidades que às vezes só estudando por conta própria nem vai passar por sua cabeça, como por exemplo projeções e pesquisas complexas.

Como a ideia do treinamento é preparar os alunos para o mundo real, você vai aprender como implementar projeções do modelo de representação de nossos recursos usando DTO e @JsonView.

Além disso, vamos estudar sobre como limitar as propriedades retornadas usando property filter do Jackson e também usando a biblioteca Squiggly.

Vamos modelar pesquisas complexas com filtros dinâmicos, paginação e ordenação e criar um endpoint que pode ser usado para consumidores que precisam de dados agregados para plotar gráficos ou exibir relatórios.

Implementaremos também um serializador customizado do Jackson para customizar propriedades de paginação na representação.

O foco do treinamento é desenvolvimento de REST APIs com Spring, mas como será que podemos modelar um recurso para disponibilizar um relatório em PDF?

Por isso mesmo, nós vamos desenvolver um relatório JasperReports com Jaspersoft Studio e disponibilizar para download em PDF em um serviço, tudo seguindo as boas práticas.

Upload e download de arquivos
Muitas vezes, precisamos implementar upload de imagens e documentos para a API. Por exemplo, o upload da foto de um produto ou foto do usuário é algo bem comum.

No treinamento, você vai aprender a modelar recursos para isso também, e ainda vai aprender a armazenar o arquivo no próprio servidor ou ainda no storage da Amazon S3 (ideal para aplicações cloud-native). Além de implementar, vamos discutir quando é melhor usar cada uma.

E claro, se você vai aprender a fazer upload de arquivos, vai também aprender a fazer o download deles, com o cuidado de não degradar a performance da API e também seguindo as boas práticas para as implementações serem independentes e intercambiáveis.

Envio de e-mails transacionais
Algo muito comum que quase todos os sistemas precisam é o envio de e-mails transacionais, como por exemplo, e-mails para avisar que um pedido foi confirmado, que a entrega está a caminho, etc.

Nós vamos desenvolver isso e você ainda vai aprender a montar templates de e-mails com Apache FreeMarker, para dados dinâmicos.

Ainda, vamos implementar componentes alternativos para envio de e-mails fake e sandbox, ideal para ambientes de desenvolvimento e staging, para evitar disparo de mensagens de teste para e-mails reais.

Cache de HTTP
Um assunto pouco dominado por vários programadores e que ficará na ponta da sua língua (e dos seus dedos, porque vamos implementar isso) é caching de HTTP.

Por que fazer cache? Como funciona o cache de HTTP? Quando não fazer cache? Quais são as precauções que devemos ter? Tudo isso será discutido no treinamento.

Você vai conhecer e implementar HTTP Caching com Cache-Control, entender o que são ETags (Entity Tags), implementar requisições condicionais com Deep ETags e Shallow ETags e entender como funciona a expiração e invalidação de cache.

Documentação com OpenAPI (Swagger)
APIs bem documentadas simplificam a vida dos consumidores, por isso você vai aprender como fazer isso no treinamento usando a especificação OpenAPI (antigamente conhecida como Swagger).

E para automatizar a geração do arquivo de definição baseado na especificação, usaremos a biblioteca SpringFox e depois migraremos para SpringDoc (uma biblioteca atualmente mais atualizada e com as mesmas funcionalidades), que conseguem escanear o nosso código e fazer isso "automagicamente".

Usaremos também o Swagger UI dentro do nosso projeto, para disponibilizar a documentação em uma página bonitinha, de fácil navegação pelos consumidores.

Mas nem tudo são flores. Documentar uma API parece simples, ainda mais quando se usa OpenAPI/Swagger e uma biblioteca como SpringFox ou SpringDoc, mas não se engane. Em projetos reais, vários problemas aparecem e a documentação começa a ficar inconsistente.

Mas precisamos garantir que a documentação esteja refletindo exatamente o funcionamento da API, ou seja, que esteja consistente. Por isso você vai aprender vários hacks e configurações para ajustar a documentação e deixá-la limpa e correta.

HATEOAS e Discoverability
Discoverability é a capacidade que a API dá aos consumidores de "navegar" em seus recursos sem conhecer previamente as suas URIs, e HATEOAS é um componente do REST que torna isso possível através da inclusão de hypermedia nas respostas.

Uma API que usa HATEOAS é classificada no nível máximo do modelo de maturidade de Richardson, o que também chamamos de "A glória do REST".

Vamos estudar as formas de adicionar hypermedia nas representações dos recursos, usar o Spring HATEOAS e a especificação HAL (Hypertext Application Language) para deixar a API "descobrível" e atrativa aos consumidores.

Estudaremos como criar novos links que referenciam os métodos dos controllers, incluindo links com templates e como implementar Representation Model Assemblers, para instanciar classes de modelo de representação de recursos que suportam HATEOAS.

Vamos ter muita implementação própria para deixar as coisas consistentes, mas no final, vai valer à pena. A API ficará linda! 😍

CORS e consumo de APIs com Java e JavaScript
O foco do treinamento é desenvolver REST APIs, mas todo programador precisa saber como consumir sua própria API também, para se colocar no lugar do consumidor e fazer alguns testes.

Além disso, pode ser que você precise consumir APIs de terceiros, então é sempre bom saber como fazer isso.

Você vai aprender a consumir a API usando a linguagem Java e JavaScript.

E vai também entender a Política de Mesma Origem (Same Origin Policy), que os navegadores implementam, como funciona o CORS (incluindo os cabeçalhos), como habilitar CORS na API por método, controlador ou globalmente.

Segurança com Spring Security, OAuth2 e JWT
Uma coisa muito importante em qualquer API é a segurança, por isso nós vamos aprofundar bastante nesse assunto.

Para começar, vamos implementar uma autenticação básica HTTP usando Spring Security. Esse tipo de autenticação é útil em alguns casos, por isso não poderia faltar.

Mas em cenários mais complexos, precisamos de uma solução melhor para autorizar clientes a usarem a API, e por isso você vai aprender sobre OAuth2.

Vamos implementar o Resource Server e Authorization Server em projetos separados e também no mesmo projeto.

Ou seja, você aprenderá a implementar para pequenos projetos, onde geralmente eles ficam juntos e também para grandes projetos, onde geralmente eles ficam separados.

Você vai aprender a implementar e usar os seguintes fluxos de autorização do OAuth2: Resource Owner Password Credentials Flow, Client Credentials Flow, Implicit Flow e Authorization Code Flow.

Você vai aprender sobre a diferença entre access token e refresh token e como gerar um novo access token através de um refresh token, além de discutirmos sobre o cuidado que você deve ter com cada tipo de token.

E além disso, vai também aprender a implementar PKCE (Proof Key for Code Exchange), que é uma extensão para Authorization Code Flow recomendada para clientes públicos, como Single-Page Applications e aplicações nativas (desktop ou mobile).

Inicialmente, o Authorization Server (AS) será implementado com Spring Security OAuth2, também conhecida como "stack antiga".

O Resource Server (RS) será implementado usando a nova stack do Spring Security para OAuth2.

Depois, migraremos o Authorization server para a nova solução do ecossistema: o Spring Authorization Server. No final, você terá tanto o AS como o RS usando a nova stack de OAuth2 do Spring.

Vamos estudar sobre a diferença entre Opaque Tokens e Transparent Tokens, e vamos implementar das duas formas.

Com Opaque Tokens, temos que armazenar esses tokens em algum lugar, por isso vamos configurar o, um banco NoSQL do tipo chave-valor, e configurar a aplicação Spring para usá-lo. Fica bem melhor que guardar os tokens na memória da aplicação.

Vamos configurar o Authorization Server para carregar o cadastro de clients OAuth (aplicações consumidoras) do banco de dados, para evitar que isso fique hard-coded.

E ainda, vamos implementar Transparent Tokens com JWT (JSON Web Tokens).

Aprenderemos o que é e como funciona o JWT e como assinar os tokens com algoritmo simétrico (HMAC SHA-256) e assimétrico (RSA SHA-256) e qual é a diferença entre eles.

Vamos também customizar o código de login, para validar o usuário e senha no banco de dados da aplicação e adicionar claims públicas no payload do JWT.

A segurança da aplicação será planejada para ter as entidades de usuário, grupo e permissão, por isso será bem granular.

Para garantir que os endpoints só possam ser acessados pelos usuários autorizados, vamos implementar a segurança usando Method Security, as anotações @PreAuthorize e @PostAuthorize e Spring Expression Language (SpEL).

Usaremos as authorities e roles para restringir os acessos dos usuários, além de conhecer e usar também os escopos (scopes) do OAuth2.

Criaremos também meta-anotações de segurança, para simplificar o código dos controllers e nos beneficiar de reaproveitamento de código.

Faremos ainda um controle de segurança contextual, ainda mais granular, como por exemplo quando um usuário só pode acessar um registro que é seu, ou seja, mesmo que tenha acesso ao endpoint, não é permitido que ele acesse o registro de um outro usuário.

E por fim, vamos implementar a inclusão de links (hypermedia) de acordo com as permissões do usuário (evitando a inclusão de links que não são acessíveis por falta de permissão).

Cloud-native APIs
A aplicação que vamos desenvolver no treinamento será cloud-native, ou seja, planejaremos desde o início pensando que ela será implantada na nuvem.

E isso faz uma grande diferença, porque desenvolver para a nuvem tem algumas peculiaridades. Temos que tomar alguns cuidados. Mas claro, a mesma aplicação poderá ser implantada fora da nuvem também, em um servidor de intranet.

Dockerização da aplicação
Docker é uma plataforma de containers muito usada e requisitada atualmente no mercado de trabalho, porque ela facilita muito o desenvolvimento, testes e deploy de aplicações.

Você vai aprender o que é Docker e como configurá-lo para rodar o projeto do curso em containers.

Além disso, vamos escalar a nossa aplicação para mais containers em ambiente de desenvolvimento, usando Poor Man's Load Balancer (com DNS Round Robin do próprio Docker Engine) e um Proxy Reverso em Nginx, para testar e evitar problemas quando o projeto for escalar em produção.

E vamos usar também o Docker Compose, para facilitar ainda mais a nossa vida. Um único comando será suficiente para colocar toda a aplicação no ar (incluindo as dependências, como MySQL, Redis e Nginx).

Deploy em produção na nuvem da Amazon
Se a nossa API é cloud-native, nós faremos o deploy dela na nuvem.

A aplicação Spring irá rodar em containers Docker na plataforma da Amazon Web Services (AWS), usando Elastic Container Service (ECS) e Fargate. É uma coisa linda! 💙

Vamos usar também o Amazon Elastic Container Registry (ECR), um excelente serviço de Docker Registry da Amazon alternativo ao Docker Hub, para armazenar as imagens da nossa aplicação.

E não para por aí… além do S3 para armazenamento das fotos dos produtos, você vai aprender a configurar uma instância do MySQL com o Amazon Relational Database Service (RDS).

O balanceamento de carga será configurado também, usando Amazon Elastic Load Balancer (ELB) com HTTPS habilitado através de um certificado TLS emitido pelo AWS Certificate Manager (ACM).

A instância do Redis será criada no serviço da Redislabs, que é a principal patrocinadora do Redis e que mantém um excelente serviço gerenciado dentro dos principais fornecedores de nuvem do mundo, incluindo a própria AWS.

Nenhuma informação sensível ou que pode mudar de acordo com o ambiente ficará dentro do projeto.

Além de usarmos Spring Profiles, você vai aprender a gerenciar as configurações da aplicação (variáveis de ambiente) de forma organizada e segura usando AWS Systems Manager Parameter Store, seguindo a recomendação do The Twelve-Factor App.

Ou seja, uma mesma imagem Docker do nosso projeto poderá ser executada em qualquer ambiente, bastando apenas que as variáveis de ambiente sejam definidas.

E tem mais: você vai aprender a registrar um domínio .com.br na internet e configurar um subdomínio para a REST API, como por exemplo api.algafood.com.br.

A maior parte dos serviços da AWS que vamos usar entram no nível gratuito (Free Tier), mas você vai aprender logo no início como configurar um alerta de orçamento para evitar ser surpreendido com uma conta indesejada.

Configuração e gerenciamento de logs
Ninguém duvida que fazer logging das mensagens importantes e erros é essencial para qualquer aplicação, mas para aplicações cloud-native, onde implantamos em containers descartáveis, temos que tomar cuidado.

Não podemos fazer logging para um appender de filesystem, ou seja, armazenar os logs na própria máquina, porque podemos descartar e instanciar uma nova a qualquer momento e os logs poderiam ser perdidos.

Por isso, vamos usar um serviço de gerenciamento de logs na nuvem, para onde vamos configurar a transmissão das mensagens de maneira assíncrona.

O legal é que essas ferramentas agregam os logs de todas as instâncias (containers) e fica muito mais fácil e seguro analisar os logs.

Versionamento de APIs
Uma hora ficará tão difícil manter a mesma API, que você vai sentir necessidade de criar ou alterar funcionalidades que quebram a compatibilidade com os consumidores.

O problema é que você já pode ter vários consumidores usando a API e pode ficar difícil ou até impossível migrar todos eles em uma pequena janela de tempo.

Nesse caso, você precisará implementar uma nova versão, e aí surgem várias dúvidas.

No treinamento, nós vamos estudar melhor sobre quando versionar uma API, quais as estratégias para separar o código-fonte da API antiga e da API nova e vamos implementar a seleção de versão por Media Types e por URIs.

Você vai aprender como evoluir a sua API sem quebrar os clientes (que é o ideal, já que criar uma nova versão é uma dor de cabeça que você deve evitar).

Vamos estudar também quando e como implementar depreciação e remoção de suporte de uma API, para que você faça uma transição de versões de forma mais suave.
