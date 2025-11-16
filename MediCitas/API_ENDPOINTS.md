# 🏥 MediCitas - Sistema de Gestión de Citas Médicas

## 📋 Descripción General

Sistema completo de gestión de citas médicas construido con:
- **Backend:** Spring Boot 3.5.7
- **Base de Datos:** MongoDB
- **Java:** 25 LTS
- **Maven:** 3.9.11

---

## 🚀 Inicio Rápido

### 1️⃣ Requisitos Previos
- Java 25 instalado
- MongoDB ejecutándose en `localhost:27017`
- Maven en el PATH

### 2️⃣ Compilar el Proyecto
```bash
cd "ruta/al/proyecto/MediCitas"
set PATH=C:\Users\Admin\maven\bin;%PATH%
mvn clean install -DskipTests
```

### 3️⃣ Ejecutar la Aplicación
```bash
mvn spring-boot:run
```

✅ **La aplicación estará disponible en:** `http://localhost:8080`

---

## 📚 API ENDPOINTS

### 🔐 USUARIOS (`/api/usuarios`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/usuarios` | Obtener todos los usuarios |
| `GET` | `/api/usuarios/{id}` | Obtener usuario por ID |
| `POST` | `/api/usuarios` | Crear nuevo usuario |
| `PUT` | `/api/usuarios/{id}` | Actualizar usuario |
| `DELETE` | `/api/usuarios/{id}` | Eliminar usuario |

#### Ejemplo: Crear Usuario
```json
POST /api/usuarios
Content-Type: application/json

{
  "nombre": "Juan Pérez",
  "email": "juan@example.com",
  "password": "password123",
  "rol": "PACIENTE"
}
```

---

### 👥 PACIENTES (`/api/pacientes`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/pacientes` | Obtener todos los pacientes |
| `GET` | `/api/pacientes/{id}` | Obtener paciente por ID |
| `POST` | `/api/pacientes` | Crear nuevo paciente |
| `PUT` | `/api/pacientes/{id}` | Actualizar paciente |
| `DELETE` | `/api/pacientes/{id}` | Eliminar paciente |

#### Ejemplo: Crear Paciente
```json
POST /api/pacientes
Content-Type: application/json

{
  "nombre": "Carlos García",
  "edad": 35,
  "correo": "carlos@example.com",
  "telefono": "+57 3001234567",
  "historialMedico": "Sin antecedentes"
}
```

---

### 👨‍⚕️ MÉDICOS (`/api/medicos`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/medicos` | Obtener todos los médicos |
| `GET` | `/api/medicos/{id}` | Obtener médico por ID |
| `POST` | `/api/medicos` | Crear nuevo médico |
| `PUT` | `/api/medicos/{id}` | Actualizar médico |
| `DELETE` | `/api/medicos/{id}` | Eliminar médico |

#### Ejemplo: Crear Médico
```json
POST /api/medicos
Content-Type: application/json

{
  "nombre": "Dr. Juan López",
  "especialidad": "Cardiología",
  "telefono": "+57 3009876543",
  "email": "drjuan@example.com"
}
```

---

### 📅 CITAS (`/api/citas`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/citas` | Obtener todas las citas |
| `GET` | `/api/citas/{id}` | Obtener cita por ID |
| `POST` | `/api/citas` | Crear nueva cita |
| `PUT` | `/api/citas/{id}` | Actualizar cita |
| `DELETE` | `/api/citas/{id}` | Eliminar cita |

#### Ejemplo: Crear Cita
```json
POST /api/citas
Content-Type: application/json

{
  "fecha": "2025-11-20",
  "hora": "10:30",
  "motivo": "Consulta general",
  "estado": "CONFIRMADA",
  "idMedico": "ID_DEL_MEDICO",
  "idPaciente": "ID_DEL_PACIENTE"
}
```

---

### 💳 FACTURAS (`/api/facturas`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/facturas` | Obtener todas las facturas |
| `GET` | `/api/facturas/{id}` | Obtener factura por ID |
| `POST` | `/api/facturas` | Crear nueva factura |
| `PUT` | `/api/facturas/actualizar/{id}` | Actualizar factura |
| `DELETE` | `/api/facturas/{id}` | Eliminar factura |

#### Ejemplo: Crear Factura
```json
POST /api/facturas
Content-Type: application/json

{
  "fechaEmision": "2025-11-16",
  "montoTotal": 150000,
  "metodoPago": "TARJETA_CREDITO",
  "descripcion": "Consulta médica general",
  "pacienteId": "ID_DEL_PACIENTE",
  "citaId": "ID_DE_LA_CITA"
}
```

---

### 📋 HISTORIALES MÉDICOS (`/api/historiales`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/historiales` | Obtener todos los historiales |
| `GET` | `/api/historiales/{id}` | Obtener historial por ID |
| `POST` | `/api/historiales` | Crear nuevo historial |
| `PUT` | `/api/historiales/actualizar/{id}` | Actualizar historial |
| `DELETE` | `/api/historiales/{id}` | Eliminar historial |

#### Ejemplo: Crear Historial
```json
POST /api/historiales
Content-Type: application/json

{
  "pacienteId": "ID_DEL_PACIENTE",
  "antecedentes": "Hipertensión controlada",
  "alergias": "Penicilina",
  "medicamentos": "Losartán 50mg",
  "observaciones": "Paciente estable"
}
```

---

## 📊 Modelos de Datos

### Usuario
```java
{
  "id": "ObjectId",
  "nombre": "string",
  "email": "string",
  "password": "string",
  "rol": "ADMIN|MEDICO|PACIENTE"
}
```

### Paciente
```java
{
  "id": "ObjectId",
  "nombre": "string",
  "edad": "int",
  "correo": "string",
  "telefono": "string",
  "historialMedico": "string"
}
```

### Médico
```java
{
  "id": "ObjectId",
  "nombre": "string",
  "especialidad": "string",
  "telefono": "string",
  "email": "string"
}
```

### Cita
```java
{
  "id": "ObjectId",
  "fecha": "date",
  "hora": "time",
  "motivo": "string",
  "estado": "CONFIRMADA|CANCELADA|COMPLETADA",
  "idMedico": "string",
  "idPaciente": "string"
}
```

### Factura
```java
{
  "id": "ObjectId",
  "fechaEmision": "date",
  "montoTotal": "double",
  "metodoPago": "TARJETA_CREDITO|TRANSFERENCIA|EFECTIVO",
  "descripcion": "string",
  "pacienteId": "string",
  "citaId": "string"
}
```

### Historial Médico
```java
{
  "id": "ObjectId",
  "pacienteId": "string",
  "antecedentes": "string",
  "alergias": "string",
  "medicamentos": "string",
  "observaciones": "string"
}
```

---

## 🧪 Pruebas con Postman

### Importar Colección
1. Abre **Postman**
2. Click en **Import**
3. Selecciona el archivo `POSTMAN_COLLECTION.json`
4. ¡Listo! Todos los endpoints están disponibles

### Flujo de Prueba Recomendado

#### 1️⃣ **Crear Datos de Base**
- Crear un usuario
- Crear un paciente
- Crear un médico

#### 2️⃣ **Crear Cita**
- Usar los IDs del paciente y médico creados
- Crear una nueva cita

#### 3️⃣ **Crear Factura**
- Usar el ID del paciente y cita
- Crear una factura

#### 4️⃣ **Crear Historial**
- Usar el ID del paciente
- Crear un historial médico

#### 5️⃣ **Probar Actualizaciones**
- Actualizar cada entidad con nuevos valores

#### 6️⃣ **Probar Eliminaciones**
- Eliminar las entidades creadas

---

## ✅ Estado de la API

### ✨ Completado
- ✅ Controllers (CRUD completo)
- ✅ Services (Lógica de negocio)
- ✅ Repositories (Acceso a datos MongoDB)
- ✅ Models (Estructuras de datos)
- ✅ CORS habilitado
- ✅ Endpoints GET implementados
- ✅ Endpoints POST implementados
- ✅ Endpoints PUT implementados
- ✅ Endpoints DELETE implementados

### 🔄 Funcionalidades Avanzadas (Opcionales)
- 🔒 Autenticación y autorización
- 📝 Validación de entrada
- 📊 Paginación de resultados
- 🔍 Búsqueda avanzada
- 📈 Reportes y estadísticas

---

## 🛠️ Estructura del Proyecto

```
MediCitas/
├── src/
│   ├── main/
│   │   ├── java/com/medicitas/
│   │   │   ├── controller/        # Controllers REST
│   │   │   ├── service/           # Servicios de negocio
│   │   │   ├── model/             # Entidades MongoDB
│   │   │   ├── repository/        # Interfaces de acceso a datos
│   │   │   └── MediCitasApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml                         # Dependencias Maven
└── POSTMAN_COLLECTION.json        # Colección de endpoints
```

---

## 📝 Notas Importantes

1. **MongoDB**: Asegúrate de que esté ejecutándose en `localhost:27017`
2. **Puerto**: La aplicación corre en `http://localhost:8080`
3. **CORS**: Habilitado para acceso desde cualquier origen
4. **Base de datos**: Se crea automáticamente en MongoDB

---

## 🤝 Soporte

Si encuentras problemas:
1. Verifica que MongoDB esté ejecutándose
2. Revisa los logs de Spring Boot
3. Asegúrate de usar los IDs correctos en las relaciones
4. Valida el formato JSON enviado

---

## 📅 Última Actualización
**16 de Noviembre de 2025**

---

**¡Sistema 100% funcional y listo para usar!** 🎉
