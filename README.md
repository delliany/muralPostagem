# Mural de postagens Backend

Apresentar as postagens feitas pelos usuários com os comentário, curtidas, viwes e não curtidas

## Tecnologias 

- Java 8
- Spring Boot
- Rest
- Maven
- Git
- Eclipse
- H2

Foi optado em utilizar essa tecnologias por ser bastante usadas no mercado de trabalho, por ter experência e tambem por ser uma aplicação simples não precisaria uma tecnologia mais robusta, como no caso da utilização do banco de dados H2 que é nativa na configuração do Spring Boot e é simples de usar.
Próxima etapa será a criação da parte de frontend em uma versão Angular 12 e outra em React 18


## Teste da Aplicação

Executa pelo Spring Boot e testa as requisições pelo PostMan ou aplicativo semelhante

No Eclipse - MuralPostagemApplication - Run As - Java Application

No terminal na pasta da aplicação 
```sh  
mvn spring-boot:run 
```

A aplicação irá inserir 2 usuários no banco de dados ao inicializar a aplicação

![image](https://user-images.githubusercontent.com/7042663/191817113-ec1cf5a0-fb5e-4d53-91ff-adb52887c89f.png)

## Banco de dados H2

http://localhost:8080/h2-console

![image](https://user-images.githubusercontent.com/7042663/191767845-c86bb2d0-528f-40ae-8070-42bd98879682.png)


## Teste no PostMan

#### POST logar-usuario

Fazer autenticação do usuário

http://localhost:8080/mural-postagem/logar-usuario

```sh
json
{
  "email": "maria@gmail.com",
  "password": "87654321"
}
```

#### PUT editar-usuario

Editar dados do usuário

http://localhost:8080/mural-postagem/editar-usuario

```sh
json
{
  "id": 2,
  "name": "Maria Vitoria editado",
  "email": "maria@gmail.com",
  "password": 87654321,
  "hasAuthorization": true
}
```

#### GET post

Buscar postagem pelo id

http://localhost:8080/mural-postagem/post/1


#### GET listar-todos-posts

Buscar todas as postagens

http://localhost:8080/mural-postagem/listar-todos-posts


#### GET listar-posts-usuario

Buscar as postagens do usuário

http://localhost:8080/mural-postagem/listar-posts-usuario/1


#### POST novo-post

Fazer autenticação do usuário

http://localhost:8080/mural-postagem/novo-post

```sh
json
{
  "user": {
    "id": 2
  },
  "title": "Primeiro Post",
  "description": "Texto Post"
}
```

#### PUT editar-post

Editar a postagem

http://localhost:8080/mural-postagem/editar-post

```sh
json
{
  "id": 1,
  "user": {
    "id": 1
  },
  "title": "Primeiro Post editado",
  "description": "Texto Post editado"
}
```


#### DEL deletar-post

Deletar postagem

http://localhost:8080/mural-postagem/deletar-post/1


#### POST novo-comentario

Criar comentário da postagem

http://localhost:8080/mural-postagem/novo-comentario

```sh
json
{
  "user": {
    "id": 1
  },
  "post": {
    "id": 1
  },
  "description": "Primeiro comentário"
}
```


#### PUT deletar-comentario

Deletar dinamicamente o comentário

http://localhost:8080/mural-postagem/deletar-comentario

```sh
json resposta
{
    "id": 1,
    "user": {
        "id": 1,
        "name": "Pedro Silva",
        "email": "pedro@gmail.com",
        "password": "12345678",
        "hasAuthorization": false,
        "hibernateLazyInitializer": {}
    },
    "post": {
        "id": 1,
        "user": {
            "id": 2,
            "name": "Maria Vitoria",
            "email": "maria@gmail.com",
            "password": "87654321",
            "hasAuthorization": true,
            "hibernateLazyInitializer": {}
        },
        "title": "Primeiro Post",
        "description": "Texto Post",
        "photo": null,
        "likes": 0,
        "dislikes": 0,
        "views": 0,
        "hibernateLazyInitializer": {}
    },
    "description": "Primeiro comentário",
    "deleteType": "USER",
    "labelDeleteType": "Comentário deletado pelo usuário do comentário"
}
```


#### PUT curtir-post

Curtir uma postagem

http://localhost:8080/mural-postagem/curtir-post

```sh
json Resposta
{
    "id": 1,
    "user": {
        "id": 1,
        "name": "Pedro Silva",
        "email": "pedro@gmail.com",
        "password": "12345678",
        "hasAuthorization": false,
        "hibernateLazyInitializer": {}
    },
    "title": "Primeiro Post",
    "description": "Texto Post atualizado",
    "photo": null,
    "likes": 1,
    "dislikes": 0,
    "views": 0
}
```


#### PUT descurtir-post

Não curtir uma postagem

http://localhost:8080/mural-postagem/descurtir-post

```sh
json Resposta
{
    "id": 1,
    "user": {
        "id": 1,
        "name": "Pedro Silva",
        "email": "pedro@gmail.com",
        "password": "12345678",
        "hasAuthorization": false,
        "hibernateLazyInitializer": {}
    },
    "title": "Primeiro Post",
    "description": "Texto Post atualizado",
    "photo": null,
    "likes": 0,
    "dislikes": 1,
    "views": 0
}
```


