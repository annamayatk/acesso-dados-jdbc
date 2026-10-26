# acesso-dados-jdbc

Acesso a banco de dados com JDBC em Java.

Projeto desenvolvido como parte do curso de Java do professor [Nelio Alves](https://github.com/acenelio).

## Projeto principal

### [Seller Management](./sellermanagementjdbc)

Aplicação Java de console para gerenciar vendedores e departamentos, usando JDBC puro e o padrão DAO.

- CRUD de vendedores
- Busca de vendedores por departamento
- Listagem ordenada por nome
- Relacionamento muitos-para-um, reaproveitando a mesma instância de `Department`

## Projetos iniciais

As pastas `jdbc1` a `jdbc5` são exercícios introdutórios, para praticar os fundamentos de JDBC antes de montar o projeto principal. Consultas, inserção, atualização, exclusão com tratamento de integridade e controle de transação (commit e rollback).

## Tecnologias

- Java
- JDBC
- MySQL
- Padrão DAO
