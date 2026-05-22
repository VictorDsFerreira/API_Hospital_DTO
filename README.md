# 🏥 Hospital API

API RESTful para gerenciamento hospitalar desenvolvida com **Spring Boot**, utilizando o padrão **DTO** para separação entre camadas de entrada e saída de dados.

---

## 🚀 Tecnologias

- Java 17+
- Spring Boot
- Spring Data JPA
- Jakarta Validation
- Lombok
- Banco de dados relacional (configurável via `application.properties`)

---

## 📁 Estrutura do Projeto

```
com.api.hospital
├── configs/         # Tratamento global de exceções (ControllerAdvice)
├── controller/      # Endpoints REST
├── dto/             # Objetos de transferência de dados (Request e Response)
├── model/           # Entidades JPA
├── repository/      # Interfaces de acesso ao banco de dados
└── service/         # Regras de negócio
```

---

## ⚙️ Como executar

### Pré-requisitos

- Java 17+
- Maven
- Banco de dados configurado (MySQL, PostgreSQL, H2, etc.)

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/VictorDsFerreira/API_Hospital_DTO.git
   cd API_Hospital_DTO
   ```

2. Configure o banco de dados em `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/hospital
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

A API estará disponível em: `http://localhost:8080`

---

## 📌 Endpoints

Todos os recursos seguem o padrão CRUD com os métodos `GET`, `POST`, `PUT` e `DELETE`.

### 👨‍⚕️ Médico — `/medico`

| Método | Endpoint       | Descrição               |
|--------|----------------|-------------------------|
| GET    | `/medico`      | Lista todos os médicos  |
| GET    | `/medico/{id}` | Busca médico por ID     |
| POST   | `/medico`      | Cadastra um novo médico |
| PUT    | `/medico/{id}` | Atualiza médico por ID  |
| DELETE | `/medico/{id}` | Remove médico por ID    |

**Body (POST/PUT):**
```json
{
  "nome": "Dr. João Silva",
  "especialidade": "Cardiologia",
  "crm": "12345-SP"
}
```

---

### 🧑 Paciente — `/paciente`

| Método | Endpoint         | Descrição                 |
|--------|------------------|---------------------------|
| GET    | `/paciente`      | Lista todos os pacientes  |
| GET    | `/paciente/{id}` | Busca paciente por ID     |
| POST   | `/paciente`      | Cadastra um novo paciente |
| PUT    | `/paciente/{id}` | Atualiza paciente por ID  |
| DELETE | `/paciente/{id}` | Remove paciente por ID    |

**Body (POST/PUT):**
```json
{
  "nome": "Maria Oliveira",
  "cpf": "123.456.789-00",
  "telefone": "(11) 99999-9999"
}
```

---

### 📋 Prontuário — `/prontuario`

| Método | Endpoint           | Descrição                   |
|--------|--------------------|-----------------------------|
| GET    | `/prontuario`      | Lista todos os prontuários  |
| GET    | `/prontuario/{id}` | Busca prontuário por ID     |
| POST   | `/prontuario`      | Cadastra um novo prontuário |
| PUT    | `/prontuario/{id}` | Atualiza prontuário por ID  |
| DELETE | `/prontuario/{id}` | Remove prontuário por ID    |

**Body (POST/PUT):**
```json
{
  "tipoSanguineo": "O+",
  "alergia": "Penicilina",
  "observacoes": "Paciente hipertenso"
}
```

---

### 💊 Receita — `/receita`

| Método | Endpoint        | Descrição                |
|--------|-----------------|--------------------------|
| GET    | `/receita`      | Lista todas as receitas  |
| GET    | `/receita/{id}` | Busca receita por ID     |
| POST   | `/receita`      | Cadastra uma nova receita|
| PUT    | `/receita/{id}` | Atualiza receita por ID  |
| DELETE | `/receita/{id}` | Remove receita por ID    |

**Body (POST/PUT):**
```json
{
  "medicamento": "Amoxicilina",
  "dosagem": "500mg",
  "duracaoDias": 7
}
```

---

### 🏦 Convênio — `/convenio`

| Método | Endpoint         | Descrição                 |
|--------|------------------|---------------------------|
| GET    | `/convenio`      | Lista todos os convênios  |
| GET    | `/convenio/{id}` | Busca convênio por ID     |
| POST   | `/convenio`      | Cadastra um novo convênio |
| PUT    | `/convenio/{id}` | Atualiza convênio por ID  |
| DELETE | `/convenio/{id}` | Remove convênio por ID    |

**Body (POST/PUT):**
```json
{
  "nome": "Unimed",
  "cnpj": "12.345.678/0001-90"
}
```

---

### 📅 Consulta — `/consulta`

| Método | Endpoint         | Descrição                 |
|--------|------------------|---------------------------|
| GET    | `/consulta`      | Lista todas as consultas  |
| GET    | `/consulta/{id}` | Busca consulta por ID     |
| POST   | `/consulta`      | Cadastra uma nova consulta|
| PUT    | `/consulta/{id}` | Atualiza consulta por ID  |
| DELETE | `/consulta/{id}` | Remove consulta por ID    |

**Body (POST/PUT):**
```json
{
  "dataHora": "2025-05-10T14:00:00",
  "motivo": "Dor de cabeça persistente",
  "valor": 150.00,
  "paciente": { "id": 1 },
  "medico": { "id": 2 },
  "convenio": { "id": 1 },
  "receita": { "id": 3 }
}
```

---

## 🛡️ Tratamento de Erros

A API possui tratamento global de exceções via `@RestControllerAdvice`:

| Situação                     | Status HTTP | Resposta                          |
|------------------------------|-------------|-----------------------------------|
| Validação de campos inválidos| `400`       | Lista de mensagens de erro        |
| Regra de negócio violada     | `400`       | Mensagem descritiva do erro       |
| Erro interno no servidor     | `500`       | `"Erro interno no servidor"`      |

**Exemplo de resposta de erro:**
```json
{
  "erros": ["Nome é obrigatório!", "CPF é obrigatório!"]
}
```

---

## 🗂️ Modelo de Dados

```
Paciente ──(1:1)──► Prontuario
Paciente ──(1:N)──► Consulta
Medico   ──(1:N)──► Consulta
Convenio ──(1:N)──► Consulta
Receita  ──(1:N)──► Consulta
```

---

## 👤 Autor

**Victor Ferreira**  
[github.com/VictorDsFerreira](https://github.com/VictorDsFerreira)
