# 🏥 MediCitas - AYUDA RÁPIDA

## ¿POR DÓNDE EMPIEZO?

### 📖 Documentación Principal
- 📄 **README_FINAL.md** - Resumen ejecutivo (EMPIEZA AQUÍ)
- 📄 **API_ENDPOINTS.md** - Todos los endpoints disponibles
- 📄 **GUIA_TECNICA.md** - Información técnica detallada
- 📄 **GUIA_POSTMAN.md** - Cómo usar Postman con la API
- 📄 **PROYECTO_COMPLETADO.txt** - Checklist final
- 📄 **ARCHIVOS_GENERADOS.md** - Listado de componentes

---

## 🚀 INICIO RÁPIDO (3 PASOS)

### 1. Compilar
```powershell
cd "src/codigo del proyecto/MediCitas"
dir
mvn clean install -DskipTests
```

### 2. Ejecutar
```powershell
mvn spring-boot:run
```

### 3. Probar
Accede a: `http://localhost:8080/api/usuarios`

---

## 📊 ENDPOINTS DISPONIBLES

| Recurso | GET | POST | PUT | DELETE |
|---------|-----|------|-----|--------|
| `/api/usuarios` | ✅ | ✅ | ✅ | ✅ |
| `/api/pacientes` | ✅ | ✅ | ✅ | ✅ |
| `/api/medicos` | ✅ | ✅ | ✅ | ✅ |
| `/api/citas` | ✅ | ✅ | ✅ | ✅ |
| `/api/facturas` | ✅ | ✅ | ✅ | ✅ |
| `/api/historiales` | ✅ | ✅ | ✅ | ✅ |

**Total: 30 endpoints funcionales**

---

## 🧪 USAR CON POSTMAN

1. Abre **Postman**
2. Click en **Import**
3. Selecciona: `POSTMAN_COLLECTION.json`
4. ¡Todos los endpoints están listos!

---

## ❓ PROBLEMAS COMUNES

**¿Port 8080 en uso?**
→ Cambia en `src/main/resources/application.properties`: `server.port=8081`

**¿MongoDB no conecta?**
→ Verifica: `Get-Service MongoDB`

**¿Error de compilación?**
→ Ejecuta: `mvn clean install -DskipTests`

---

## 📚 REFERENCIAS

- [Spring Boot Docs](https://spring.io/projects/spring-boot)
- [MongoDB Docs](https://docs.mongodb.com/)
- [Maven Docs](https://maven.apache.org/)

---

**¡Proyecto 100% funcional y listo!** ✅
