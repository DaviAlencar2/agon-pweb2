
Agon
/
transfoeme o pdf que mandei aqui em markdown para eu colocar no readme do projeto

08:15

Examinaram-se diagramas visuais para converter PDF em markdown
Examinaram-se diagramas visuais para converter PDF em markdown
Agora vou ver as páginas com conteúdo visual (diagrama de classes e fluxo do sistema):


Mobilizou recursos para converter PDF em markdown
Mobilizou recursos para converter PDF em markdown
Perfeito! Tenho todo o conteúdo. Agora vou gerar o README.md completo:


Criou um arquivo, leu um arquivo
Criou um arquivo, leu um arquivo
Pronto! O README.md foi gerado com todo o conteúdo do PDF, incluindo:

Descrição do projeto e atores
Funcionalidades obrigatórias detalhadas
Modelo de objetos em ASCII art (representando o diagrama de classes)
Fluxo do sistema em ASCII art
Backlog completo com as 25 tarefas
Todos os 9 casos de uso com pré/pós-condições e passos
Tabela de tecnologias obrigatórias
Critérios de avaliação com pontuação
Regras gerais da disciplina
Readme
Documento · MD
nao quero emojis

08:17

Identificou preferência por conteúdo sem emojis
Identificou preferência por conteúdo sem emojis
Pronto, sem emojis.

Readme
Documento · MD






Claude é uma IA e pode cometer erros. Por favor, verifique as respostas.
Readme · MD
Copiar

# Agon — Sistema de Corridas de Perguntas

> **Disciplina:** Programação para a Web II  
> **Curso:** TSI em Sistemas para a Internet — IFPB  
> **Professor:** Frederico Costa Guedes Pereira
 
---

## Descrição

O **Agon** é um sistema gamificado de corridas de desafios. Os participantes competem em "corridas" de tarefas rápidas (tipo desafios) respondendo perguntas dentro de um tempo limite e acumulam pontos.

Os usuários entram no sistema, escolhem uma **corrida** (tarefa com tempo limitado) e tentam completá-la respondendo perguntas. O sistema registra pontos, exibe um ranking, usa **sessão HTTP** para controlar tentativas, **interceptadores** para impedir acessos indevidos e **Flash Attributes** para exibir avisos.

### Atores

- **Participante** — usuário que compete nas corridas
- **Administrador** — usuário que gerencia corridas e perguntas

---

## Funcionalidades Obrigatórias

### Autenticação Simples por Nome

- Usuário digita apenas um nome para entrar (sem segurança avançada).
- O nome fica salvo na sessão HTTP.
- O sistema redireciona para o lobby após o login.
- Se o usuário não estiver na sessão, o interceptor bloqueia todas as páginas internas.

### Lista de Corridas

Cada corrida exibe:
- Título
- Descrição
- Tempo limite (ex.: 60 segundos)
- Quantidade de perguntas

### Participação na Corrida

- Ao entrar, a sessão registra o início da corrida e o tempo restante.
- As perguntas são exibidas uma a uma (via Thymeleaf).
- A resposta é validada e o sistema avança para a próxima pergunta.
- Ao terminar ou estourar o tempo → redirect para a tela de **resultado**.

### Ranking

- Ranking geral exibindo:
    - Nome do usuário
    - Corrida disputada
    - Pontuação
    - Data

### Mensagens Amigáveis

Flash Attributes são usados nos redirects, por exemplo:
- *"Corrida já começou"*
- *"Tempo esgotado"*
- *"Parabéns! Você marcou 8 pontos!"*

---

## Modelo de Objetos

```
┌─────────────────────────────────┐
│           Participante          │
├─────────────────────────────────┤
│ - id: Long                      │
│ - nome: String                  │
│ - email: String                 │
│ - admin: Boolean                │
│ - corridasFeitas: List<Corrida> │
└──────────────┬──────────────────┘
               │ corridasFeitas (0..*)
               │
┌──────────────▼──────────────────┐       ┌──────────────────────────────────┐
│             Corrida             │       │             Resultado            │
├─────────────────────────────────┤       ├──────────────────────────────────┤
│ - id: Long                      │◄──────│ - id: Long                       │
│ - titulo: String                │corrida│ - participante: Participante     │
│ - descricao: String             │       │ - corrida: Corrida               │
│ - tempoSegundos: Integer        │       │ - pontuacao: BigDecimal          │
│ - ativa: Boolean                │       │ - dataHora: LocalDateTime        │
│ - perguntas: List<Pergunta>     │       └──────────────────────────────────┘
└──────────────┬──────────────────┘
               │ perguntas (0..*)
               │
┌──────────────▼──────────────────┐
│             Pergunta            │
├─────────────────────────────────┤
│ - id: Long                      │
│ - enunciado: String             │
│ - alternativas: List<String>    │
│ - respostaCorreta: Integer      │
│ - corrida: Corrida              │
└─────────────────────────────────┘
```
 
---

## Fluxo do Sistema

```
(inicio)
    |
    v
[Login] --> [Sala de Perguntas] --> [Iniciar Corrida]
                                           |
                                           v
                               [Pergunta 1] --> [Pergunta 2] --> ... --> [Pergunta N]
                                                                               |
                                                                               v
                                                                        [Resultado]
                                                                               |
                                                                               v
                                                                         [Ranking]
                                                                               |
                                                                               v
                                                                          [Logout]
                                                                               |
                                                                               v
                                                                            (fim)
```
 
---

## Backlog de Tarefas

### Autenticação e Sessão
1. Criar tela de login simples (nome do jogador).
2. Implementar controlador de login.
3. Armazenar nome do jogador na sessão.
4. Criar interceptor para bloquear acesso se não houver jogador na sessão.
5. Criar tela de logout.

### Lobby e Corridas
6. Criar tela com lista de corridas disponíveis.
7. Criar entidade `Corrida` e repositório.
8. Criar CRUD básico para `Corrida` (opcional: só admin).
9. Criar serviço para buscar corridas ativas.
10. Criar tela de detalhes da corrida.

### Perguntas e Execução da Corrida
11. Criar entidade `Pergunta` e repositório.
12. Criar CRUD de Perguntas (opcional).
13. Criar controlador para iniciar corrida.
14. Salvar tempo de início da corrida na sessão.
15. Criar fluxo de exibição de perguntas uma a uma (Thymeleaf).
16. Validar resposta enviada pelo jogador.
17. Controlar tempo restante.
18. Ao terminar ou estourar tempo → redirect para tela de resultado.
19. Exibir mensagens com Flash Attributes.

### Resultado e Ranking
20. Criar entidade `Resultado`.
21. Persistir pontuação final.
22. Criar tela de ranking geral.
23. Criar ranking por corrida.

### Extras (Opcionais)
24. Criar dashboard admin com lista de corridas e perguntas.
25. Criar animação / barra de progresso de tempo em Thymeleaf.

---

## Casos de Uso

### UC01 – Admin cadastra corrida
**Pré-condição:** Não há
1. Usuário solicita cadastro de corrida.
2. Sistema pede dados da corrida (título, etc.).
3. Sistema cadastra corrida e pergunta se usuário quer cadastrar perguntas para ela.
4. Usuário responde sim → vai para o cadastro de perguntas.
5. Usuário responde não → vai para o cadastro de corridas.

**Pós-condição:** Corrida registrada na base.
 
---

### UC02 – Admin exclui corrida
**Pré-condição:** Corridas estarem cadastradas
1. Usuário solicita corridas cadastradas.
2. Sistema apresenta corridas.
3. Usuário indica a corrida a ser excluída.
4. Sistema pede confirmação de exclusão.
5. Usuário confirma.
6. Sistema exclui corrida.

**Pós-condição:** Corrida excluída na base.
 
---

### UC03 – Admin modifica corrida
**Pré-condição:** Corridas estarem cadastradas
1. Usuário solicita corridas cadastradas.
2. Sistema apresenta corridas.
3. Usuário indica a corrida a ser modificada.
4. Sistema modifica corrida.

**Pós-condição:** Corrida modificada na base.
 
---

### UC04 – Admin cadastra pergunta
**Pré-condição:** Haver corridas cadastradas previamente
1. Usuário solicita cadastro de pergunta.
2. Sistema pede corrida onde será cadastrada.
3. Sistema pede texto da pergunta, pontos da pergunta, respostas possíveis e a resposta correta.
4. Sistema cadastra pergunta.

**Pós-condição:** Pergunta registrada na corrida.
 
---

### UC05 – Admin exclui pergunta
**Pré-condição:** Pergunta a ser excluída existir
1. Sistema apresenta perguntas cadastradas para uma corrida.
2. Usuário solicita exclusão de uma pergunta específica.
3. Sistema pede confirmação da exclusão.
4. Sistema exclui pergunta.

**Pós-condição:** Pergunta removida da corrida.
 
---

### UC06 – Admin lista perguntas cadastradas
**Pré-condição:** Não há
1. Usuário solicita lista de perguntas cadastradas numa corrida.
2. Sistema apresenta perguntas cadastradas.

**Pós-condição:** Não há.
 
---

### UC07 – Participante vê sala de corridas
**Pré-condição:** Não há
1. Usuário participante solicita a sala de corridas.
2. Sistema apresenta sala de corridas.

**Pós-condição:** Não há.
 
---

### UC08 – Participante inicia corrida
**Pré-condição:** Usuário teve acesso à sala de perguntas
1. Usuário participante escolhe iniciar corrida.
2. Sistema registra hora de início da corrida.
3. **LOOP:** Para cada pergunta *i* da corrida:
    - a) Sistema apresenta pergunta *i*.
    - b) Usuário responde a pergunta.
    - c) Sistema computa os pontos.
4. Sistema apresenta resultado da corrida totalizando os pontos.
5. Sistema sugere link para o ranking geral (UC09).

**Pós-condição:** A corrida é marcada como já respondida (apenas destaque visual).
 
---

### UC09 – Participante consulta ranking geral
**Pré-condição:** Não há
1. Usuário participante solicita o ranking geral.
2. Sistema exibe ranking geral de participantes.
3. Sistema destaca o usuário no ranking.
4. Caso o usuário não tenha pontuação, sistema indica isso.

**Pós-condição:** Não há.
 
---

## Tecnologias Obrigatórias

| Tecnologia | Uso |
|---|---|
| Spring MVC | Controladores da aplicação |
| Sessão HTTP | Controle de autenticação e estado da corrida |
| Flash Attributes | Mensagens entre redirects |
| Redirects | Navegação pós-ação |
| Thymeleaf | Renderização das views |
| Interceptadores | Bloqueio de acesso sem autenticação |
| JPA / Repositories | Persistência dos dados |
| Validações | Entrada de dados nos formulários |
 
---

## Critérios de Avaliação

| # | Caso de Uso | Pontos |
|---|---|:---:|
| 1 | UC01 – Admin cadastra corrida | 10 |
| 2 | UC02 – Admin exclui corrida | 10 |
| 3 | UC03 – Admin modifica corrida | 10 |
| 4 | UC04 – Admin cadastra pergunta | 10 |
| 5 | UC05 – Admin exclui pergunta | 10 |
| 6 | UC06 – Admin lista perguntas cadastradas | 10 |
| 7 | UC07 – Participante vê sala de corridas | 10 |
| 8 | UC08 – Participante inicia corrida | 10 |
| 9 | UC09 – Participante consulta ranking geral | 10 |
| 10 | Usabilidade geral da UI | 10 |
| | **Total** | **100** |
 
---

## Regras Gerais

- **Uso de IA é proibido.** Não é permitido usar ChatGPT, GitHub Copilot ou recursos similares para gerar código Spring/Java. Equipes flagradas terão nota **zerada**. Equipe que denunciar outra por uso de GPT ganha **+5 pontos** por denúncia.
- O sistema precisa estar **funcional** no dia da apresentação. Demonstrações muito incompletas não serão aceitas.
- Cada equipe deve disponibilizar no Classroom a **URL do repositório Git** do projeto. A análise de participação nos commits poderá alterar a nota individual — poucos commits ou commits irrelevantes implicam em nota baixa para aquele membro.
- **Todas as equipes devem assistir a todas as apresentações.** Falta implica em perda de pontos individuais.
 


