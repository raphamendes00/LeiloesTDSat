# Gerenciador de casa de leilões

Este é um aplicativo desktop em Java para gerenciamento de uma casa de leilões. O projeto permite cadastrar, consultar, vender e consultar vendas, além de listar todos os produtos armazenados.

## Funcionalidades

- Listagem de produtos usando JTable
- Adicionar novos produtos
- Consultar produtos
- Vender produtos
- Integração com banco de dados MySQL para armazenamento persistente

## Tecnologias Utilizadas

- Java
- Swing para interface gráfica
- MySQL para banco de dados
- JDBC para conexão com o banco de dados

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:

- [JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [MySQL](https://www.mysql.com/downloads/)
- [IDE de sua preferência](https://www.jetbrains.com/idea/download/)

## Configuração do Banco de Dados

1. Crie um banco de dados no MySQL:
    ```sql
    CREATE DATABASE "nome do banco";
    ```

2. Crie a tabela necessária:
    ```sql
    USE "nome do banco";

    CREATE TABLE produtos (
        id BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
        nome TEXT DEFAULT NULL,
        valor INT(11) DEFAULT NULL,
        `status` TEXT DEFAULT NULL
    );
    ```

3. Ajuste as configurações de conexão no código conforme necessário (usuário, senha, URL do banco de dados).

## Executando o Projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/seuusuario/LeiloesTDSat.git
    ```

2. Importe o projeto na sua IDE.

3. Execute a classe `Master` para iniciar a aplicação.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

