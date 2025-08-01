Curso Arquitetura Limpa - API Spring Boot
📋 Sobre o Projeto
Esta API foi desenvolvida como parte prática do curso de Arquitetura Limpa com Java, implementando os conceitos e princípios da Clean Architecture utilizando Spring Boot e tecnologias modernas do ecossistema Java.
🎯 Objetivo
O projeto tem como objetivo demonstrar a aplicação prática dos conceitos de Arquitetura Limpa (Clean Architecture) propostos por Robert C. Martin (Uncle Bob), organizando o código em camadas bem definidas e respeitando as dependências entre elas.
🏗️ Arquitetura

# Playlist no youtube https://www.youtube.com/playlist?list=PLUOqm1GRyVXaJG29--_tYtO8AkMChovx1

Desenvolvido com ❤️ durante o Curso de Arquitetura Limpa
# Roteiro

### Aula 0

- Apresentação teórica
- Roteiro do curso
- Apresentação do projeto

### Aula 1

- Criação do projeto
- Criação dos módulos

### Aula 2

- Criação das entidades
- Criação das exceptions

### Aula 3

- Criação dos casos de uso

### Aula 4

- Implementação dos casos de uso parte 1

### Aula 5

- Implementação dos casos de uso parte 2

### Aula 6

- Refatoração(Inicialmente nessa aula iriamos criar as entidades e repositories)
- Configuração dos applications

### Aula 7

- Criação das migrations
- Criação das entities spring
- Criação dos repositories spring

### Aula 8

- Service/Controller → Create User / Shopkeeper
- Service/Controller → Tax Number / Email Available

### Aula 9

- Service → FindWalletByTaxNumber
- Service → TransactionPinValidate
- Service → TransactionValidate

### Aula 10

- Service/Controller → Consultar saldo
- Service → Create Transaction
- Service/Controller → Efetuar transferência

### Aula 11

- Teste transfer
- Service → UpdateTransactionPin
- Service → Notification

### Aula 12

- Refatoração transfer

### Aula 13

- Tratamento das Exceptions

### Aula 14

- Authentication

### Aula 15

- Authorization

## Desafio PicPay: https://github.com/PicPay/picpay-desafio-backend

Temos 2 tipos de usuários, os comuns e lojistas, ambos têm carteira com dinheiro e realizam transferências entre eles. Vamos nos atentar **somente** ao fluxo de transferência entre dois usuários.

Requisitos:

- Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail.
- Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários.
- Lojistas **só recebem** transferências, não enviam dinheiro para ninguém.
- Validar se o usuário tem saldo antes da transferência.
- Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este mock para simular (https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6).
- A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia.
- No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este mock para simular o envio (http://o4d9z.mocklab.io/notify).
- Este serviço deve ser RESTFul.

# Projeto

### Diagrama de módulo e pacotes
https://www.dropbox.com/scl/fi/n9wiwad8b0dmgiflwo4if/digrama-de-modulo.png?rlkey=7tgcbofbmk0ee1fsxqj5ubz6z&st=4o6cmfaz&dl=0
https://www.dropbox.com/scl/fi/bul5lutosdavcii8tlqti/digrama-de-pacote.png?rlkey=mzdtb1xnjv3lwz1zi0u9uguex&st=7kmz29lu&dl=0

### Diagrama de classes (Somente Domain)
https://www.dropbox.com/scl/fi/x7jb7d6gqcvjvs872ijhw/diagram-de-classe.png?rlkey=jois4koz4g16ahv7q8pbfla05&st=y44yfdk2&dl=0

### Diagrama de caso de uso
https://www.dropbox.com/scl/fi/0mtqm54tkce983a3zhuc8/diagrama-de-caso-de-uso.png?rlkey=pr5ia63d5o3wxy3t0n3efyvth&st=fvroc4mf&dl=0

# Ferramentas

- Java 17,
- Spring Boot 3.1,
- Postman
- Intellij
