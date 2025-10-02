# Agenda CLI

Um projeto simples em Java para gerenciar contatos via linha de comando.
Permite adicionar, remover, listar e buscar contatos, reforçando conceitos de **POO**, coleções (`List`) e tratamento de entrada do usuário.

---

## Funcionalidades

- Adicionar novo contato (nome, telefone, e-mail)
- Remover contato pelo código da lista
- Listar todos os contatos
- Buscar contato pelo nome
- Confirmação antes de sair do programa

---

## Pré-requisitos

- Java 17+
- Maven 3+

---

## Estrutura do projeto

```
agendaCLI/
├── src/
│   ├── main/java/org/example/agenda/   # Código-fonte
│   │   ├── Main.java
│   │   ├── Agenda.java
│   │   └── Contato.java
│   └── test/java/org/example/agenda/   # Testes unitários (opcional)
├── pom.xml                             # Configuração do Maven
└── .gitignore                          # Ignora target/, IDE e arquivos temporários
```

---

## Como executar

1. Clone o repositório:

```bash
git clone https://github.com/luis-jagella/agendaCLI.git
cd agendaCLI
```

2. Compile e execute com Maven:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="org.example.agenda.Main"
```

3. Use a CLI conforme o menu interativo:

```
---- Agenda de Contatos -------------
1- Adicionar novo contato
2- Remover contato
3- Buscar contato por nome
4- Listar todos os contatos
5- Fechar
-------------------------------------
```

---

## Observações

- Ao fechar o programa, **os dados não são salvos**. Todos os contatos serão perdidos.
- As entradas são validadas para evitar erros no menu e na seleção de contatos.
- Pode ser facilmente expandido para salvar os dados em arquivo ou banco de dados.

---

## Tecnologias

- Java 17+
- Maven

---

## Contribuição

Contribuições são bem-vindas!

1. Fork o projeto
2. Crie uma branch para sua feature:
```bash
git checkout -b feature/nome-da-feature
```
3. Commit suas alterações:
```bash
git commit -m "Descrição da feature"
```
4. Push para sua branch:
```bash
git push origin feature/nome-da-feature
```
5. Abra um Pull Request