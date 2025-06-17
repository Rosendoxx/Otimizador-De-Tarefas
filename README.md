# 🗂️ Otimizador de Tarefas – Java com Salvamento em Arquivo

Este é um programa desenvolvido em **Java puro** com o objetivo de gerenciar tarefas (estilo to-do list) através do terminal. O diferencial é que as tarefas **são salvas automaticamente em um arquivo `.txt`**, o que permite reabri-las mesmo após encerrar o programa.

---

## ✅ Funcionalidades

- ✅ Adicionar nova tarefa (com nome e descrição)
- ❌ Remover tarefa pelo nome
- 📋 Listar tarefas pendentes e concluídas
- ✔️ Marcar tarefa como concluída
- 💾 Salvar e carregar tarefas do arquivo `tarefas.txt` automaticamente

---

## 🧩 Como funciona

O programa utiliza:
- Uma classe `Tarefa` com `nome`, `descrição` e `status`
- Um `ArrayList` para armazenar todas as tarefas
- Arquivo `.txt` para **persistência dos dados**
- Operações feitas via terminal (modo console)

**Formato do arquivo salvo:** 
Nome da tarefa;Descrição da tarefa;true/false

## 🛠️ Tecnologias e Conceitos usados
- Java 11+
- Programação Orientada a Objetos (POO)
- Manipulação de arquivos (`File`, `FileWriter`, `PrintWriter`, `Scanner`)
- Estrutura de dados: `ArrayList`
- Tratamento de exceções com `try` / `catch`
- Boas práticas de encapsulamento e modularização

---

## 💻 Como executar o projeto
### 1. Clone o repositório
```bash
git clone https://github.com/SEU-USUARIO/otimizador-tarefas-java.git
```bash
**### 2. Compile o código**
- javac Tarefa.java
```bash
**### 3. Execute o programa**
- java Tarefa

---

**OBS: o arquivo "Tarefas.txt" será criado automaticamente**
