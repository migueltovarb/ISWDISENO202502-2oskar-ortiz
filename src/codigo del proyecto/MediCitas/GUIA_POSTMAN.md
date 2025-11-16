# 🧪 GUÍA COMPLETA POSTMAN - MediCitas

## 📌 Inicio Rápido en Postman

### Paso 1: Importar Colección
1. Abre **Postman**
2. Click en **Import** (superior izquierda)
3. Selecciona **Upload File**
4. Busca y selecciona: `POSTMAN_COLLECTION.json`
5. Click en **Import**

✅ **¡Todos los 30 endpoints están listos!**

---

## 📂 Estructura de la Colección

La colección está organizada en **6 carpetas** (una por recurso):

```
MediCitas API
├── USUARIOS (5 requests)
├── PACIENTES (5 requests)
├── MEDICOS (5 requests)
├── CITAS (5 requests)
├── FACTURAS (5 requests)
└── HISTORIALES (5 requests)
```

---

## 🧪 FLUJO DE PRUEBA COMPLETO

### 1️⃣ CREAR USUARIO
**Request:** `POST /api/usuarios`

```json
{
  "nombre": "Juan Pérez",
  "email": "juan@example.com",
  "password": "password123",
  "rol": "PACIENTE"
}
```

**Resultado esperado:** 200 OK con ID generado
```json
{
  "id": "67389a1f8c1d2e4f5a6b7c8d",
  "nombre": "Juan Pérez",
  "email": "juan@example.com",
  "password": "password123",
  "rol": "PACIENTE"
}
```

**✅ Guarda el `id` para usar después**

---

### 2️⃣ CREAR PACIENTE
**Request:** `POST /api/pacientes`

```json
{
  "nombre": "Carlos García",
  "edad": 35,
  "correo": "carlos@example.com",
  "telefono": "+57 3001234567",
  "historialMedico": "Sin antecedentes"
}
```

**Resultado esperado:** 200 OK con ID generado

**✅ Guarda el `id` para usar después**

---

### 3️⃣ CREAR MÉDICO
**Request:** `POST /api/medicos`

```json
{
  "nombre": "Dr. Juan López",
  "especialidad": "Cardiología",
  "telefono": "+57 3009876543",
  "email": "drjuan@example.com"
}
```

**Resultado esperado:** 201 Created con ID generado

**✅ Guarda el `id` para usar después**

---

### 4️⃣ CREAR CITA
**Request:** `POST /api/citas`

```json
{
  "fecha": "2025-11-20",
  "hora": "10:30",
  "motivo": "Consulta general",
  "estado": "CONFIRMADA",
  "idMedico": "{ID_DEL_MEDICO}",
  "idPaciente": "{ID_DEL_PACIENTE}"
}
```

⚠️ **Reemplaza:**
- `{ID_DEL_MEDICO}` con el ID del médico creado
- `{ID_DEL_PACIENTE}` con el ID del paciente creado

**Resultado esperado:** 200 OK

**✅ Guarda el `id` para usar después**

---

### 5️⃣ CREAR FACTURA
**Request:** `POST /api/facturas`

```json
{
  "fechaEmision": "2025-11-16",
  "montoTotal": 150000,
  "metodoPago": "TARJETA_CREDITO",
  "descripcion": "Consulta médica general",
  "pacienteId": "{ID_DEL_PACIENTE}",
  "citaId": "{ID_DE_LA_CITA}"
}
```

⚠️ **Reemplaza:**
- `{ID_DEL_PACIENTE}` con el ID del paciente
- `{ID_DE_LA_CITA}` con el ID de la cita

**Resultado esperado:** 200 OK

---

### 6️⃣ CREAR HISTORIAL MÉDICO
**Request:** `POST /api/historiales`

```json
{
  "pacienteId": "{ID_DEL_PACIENTE}",
  "antecedentes": "Hipertensión controlada",
  "alergias": "Penicilina",
  "medicamentos": "Losartán 50mg",
  "observaciones": "Paciente estable"
}
```

⚠️ **Reemplaza:**
- `{ID_DEL_PACIENTE}` con el ID del paciente

**Resultado esperado:** 200 OK

---

## 🔍 CONSULTAR DATOS

### GET - Listar Todos
```
GET /api/usuarios
GET /api/pacientes
GET /api/medicos
GET /api/citas
GET /api/facturas
GET /api/historiales
```

**Resultado esperado:** 200 OK + Array JSON

### GET - Obtener por ID
```
GET /api/usuarios/{id}
GET /api/pacientes/{id}
GET /api/medicos/{id}
GET /api/citas/{id}
GET /api/facturas/{id}
GET /api/historiales/{id}
```

⚠️ **Reemplaza `{id}` con un ID real**

**Resultado esperado:** 200 OK + Objeto JSON

---

## ✏️ ACTUALIZAR DATOS

### PUT - Actualizar Usuario
```
PUT /api/usuarios/{id}

{
  "nombre": "Juan Pérez Actualizado",
  "email": "juan.nuevo@example.com",
  "password": "newpassword123",
  "rol": "MEDICO"
}
```

**Resultado esperado:** 200 OK + Objeto actualizado

### PUT - Actualizar Paciente
```
PUT /api/pacientes/{id}

{
  "nombre": "Carlos García Actualizado",
  "edad": 36,
  "correo": "carlos.nuevo@example.com",
  "telefono": "+57 3007654321",
  "historialMedico": "Alergia a la Penicilina"
}
```

### PUT - Actualizar Médico
```
PUT /api/medicos/{id}

{
  "nombre": "Dr. Juan López Rodríguez",
  "especialidad": "Cardiología y Arritmias",
  "telefono": "+57 3005551111",
  "email": "dr.juan.nuevo@example.com"
}
```

### PUT - Actualizar Cita
```
PUT /api/citas/{id}

{
  "fecha": "2025-11-21",
  "hora": "14:00",
  "motivo": "Consulta de seguimiento",
  "estado": "CONFIRMADA",
  "idMedico": "{ID_DEL_MEDICO}",
  "idPaciente": "{ID_DEL_PACIENTE}"
}
```

### PUT - Actualizar Factura
```
PUT /api/facturas/actualizar/{id}

{
  "fechaEmision": "2025-11-16",
  "montoTotal": 180000,
  "metodoPago": "TRANSFERENCIA",
  "descripcion": "Consulta médica + laboratorio",
  "pacienteId": "{ID_DEL_PACIENTE}",
  "citaId": "{ID_DE_LA_CITA}"
}
```

### PUT - Actualizar Historial
```
PUT /api/historiales/actualizar/{id}

{
  "pacienteId": "{ID_DEL_PACIENTE}",
  "antecedentes": "Hipertensión, Diabetes tipo 2",
  "alergias": "Penicilina, Aspirina",
  "medicamentos": "Losartán 50mg, Metformina 500mg",
  "observaciones": "Paciente requiere seguimiento cada 3 meses"
}
```

---

## 🗑️ ELIMINAR DATOS

```
DELETE /api/usuarios/{id}
DELETE /api/pacientes/{id}
DELETE /api/medicos/{id}
DELETE /api/citas/{id}
DELETE /api/facturas/{id}
DELETE /api/historiales/{id}
```

**Resultado esperado:** 204 No Content

---

## 💡 CONSEJOS PARA POSTMAN

### 1. Usar Variables
**Declarar variable global:**
1. Click en **Environment** (ajustes)
2. Click en **New**
3. Agrega variables:
   ```
   base_url: http://localhost:8080
   paciente_id: {id_del_paciente}
   medico_id: {id_del_medico}
   ```

**Usar en requests:**
```
{{base_url}}/api/usuarios
/api/pacientes/{{paciente_id}}
```

### 2. Tests Automáticos
Agregar a cada request (Tab "Tests"):

```javascript
// Test: Verificar status 200
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

// Test: Verificar response JSON
pm.test("Response is JSON", function () {
    pm.response.to.be.json;
});

// Guardar ID para usar después
var jsonData = pm.response.json();
pm.environment.set("created_id", jsonData.id);
```

### 3. Pre-request Scripts
Antes de ejecutar (Tab "Pre-request Script"):

```javascript
// Timestamp automático
var timestamp = new Date().toISOString();
pm.environment.set("timestamp", timestamp);
```

### 4. Collections Runner
Ejecutar múltiples requests en secuencia:

1. Click en **Runner** (arriba a la izquierda)
2. Selecciona la colección
3. Click en **Run**
4. Ve cómo se ejecutan todos los requests automáticamente

---

## 📊 EJEMPLO DE CICLO COMPLETO

### Paso 1: Preparar Postman
```
1. Importar colección POSTMAN_COLLECTION.json
2. Crear Environment "MediCitas Local"
3. Agregar variable: base_url = http://localhost:8080
```

### Paso 2: Ejecutar Requests
```
1. POST /api/usuarios → Guardar ID
2. POST /api/pacientes → Guardar ID
3. POST /api/medicos → Guardar ID
4. POST /api/citas → Usar IDs guardados
5. POST /api/facturas → Usar IDs guardados
6. POST /api/historiales → Usar ID paciente
```

### Paso 3: Verificar
```
7. GET /api/usuarios → Ver todos
8. GET /api/pacientes → Ver todos
9. GET /api/medicos → Ver todos
```

### Paso 4: Actualizar
```
10. PUT /api/pacientes/{id} → Actualizar
11. GET /api/pacientes/{id} → Verificar cambios
```

### Paso 5: Limpiar
```
12. DELETE /api/historiales/{id} → Eliminar
13. DELETE /api/facturas/{id} → Eliminar
14. DELETE /api/citas/{id} → Eliminar
```

---

## 🔧 HEADERS IMPORTANTES

### Content-Type
```
Content-Type: application/json
```

### Accept
```
Accept: application/json
```

### Ejemplos de Header en Postman
```
Headers Tab:
- Key: Content-Type
  Value: application/json

- Key: Accept
  Value: application/json
```

---

## ❌ ERRORES COMUNES Y SOLUCIONES

### Error: "Cannot connect to localhost:8080"
```
✅ Solución:
   1. Verifica que mvn spring-boot:run está ejecutándose
   2. Verifica que MongoDB está corriendo
   3. Intenta en http://localhost:8080/api/usuarios
```

### Error: "404 Not Found"
```
✅ Solución:
   1. Verifica la URL del endpoint
   2. Verifica que el ID existe
   3. Usa GET /api/{recurso} para listar todos
```

### Error: "400 Bad Request"
```
✅ Solución:
   1. Verifica el formato JSON
   2. Verifica que todos los campos requeridos están presentes
   3. Verifica el Content-Type header
```

### Error: "500 Internal Server Error"
```
✅ Solución:
   1. Verifica los logs del servidor
   2. Verifica que MongoDB está funcionando
   3. Verifica la sintaxis del JSON
```

---

## 🔐 VALIDACIONES

### Usuarios
```json
{
  "nombre": "string (requerido)",
  "email": "string (requerido)",
  "password": "string (requerido)",
  "rol": "ADMIN | MEDICO | PACIENTE (requerido)"
}
```

### Pacientes
```json
{
  "nombre": "string (requerido)",
  "edad": "number (requerido)",
  "correo": "string (requerido)",
  "telefono": "string (requerido)",
  "historialMedico": "string (requerido)"
}
```

### Médicos
```json
{
  "nombre": "string (requerido)",
  "especialidad": "string (requerido)",
  "telefono": "string (requerido)",
  "email": "string (requerido)"
}
```

### Citas
```json
{
  "fecha": "date (requerida)",
  "hora": "time (requerida)",
  "motivo": "string (requerido)",
  "estado": "CONFIRMADA | CANCELADA | COMPLETADA (requerido)",
  "idMedico": "string (requerido)",
  "idPaciente": "string (requerido)"
}
```

---

## 📈 ESTADÍSTICAS DE USO

**Endpoints por tipo:**
- GET: 12 (2 por recurso)
- POST: 6 (1 por recurso)
- PUT: 6 (1 por recurso)
- DELETE: 6 (1 por recurso)

**Total: 30 endpoints funcionales**

---

## ✅ CHECKLIST ANTES DE EMPEZAR

- ✅ Servidor ejecutándose (`mvn spring-boot:run`)
- ✅ MongoDB corriendo
- ✅ Postman instalado
- ✅ Colección importada
- ✅ URL base configurada: `http://localhost:8080`
- ✅ Environment creado (opcional pero recomendado)

---

## 📚 DOCUMENTACIÓN RELACIONADA

- 📄 `API_ENDPOINTS.md` - Documentación detallada de endpoints
- 📄 `GUIA_TECNICA.md` - Información técnica del proyecto
- 📄 `README_FINAL.md` - Resumen ejecutivo

---

## 🎓 CONCLUSIÓN

Con esta guía puedes:
✅ Importar la colección en Postman
✅ Probar todos los 30 endpoints
✅ Crear, actualizar y eliminar datos
✅ Entender el flujo completo de la API

**¡Listo para empezar a probar MediCitas!** 🚀

---

*Guía Postman - MediCitas*
*Versión 1.0 - 16 de Noviembre de 2025*
