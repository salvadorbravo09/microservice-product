# Microservice Products

### Microservicio para la gestión de productos relacionados con categorías. Ofrece funcionalidades de CRUD para listar, crear, actualizar y eliminar productos.

---

## 📋 Requisitos
Entorno de desarrollo:

1. **[IntelliJ IDEA](https://www.jetbrains.com/idea/download/)** (versión recomendada: *2024.3.1 Community Edition*)
2. **[Spring Boot](https://spring.io/projects/spring-boot)** (*versión: 3.4.1*)
3. **[MySQL](https://www.mysql.com/downloads/)** (*versión: 8.0* o superior)
4. **[Postman](https://www.postman.com/downloads/)** para probar las API REST.

---

## 🚀 Instalación y Configuración

### 1. Clona el repositorio
```bash
git clone https://github.com/salvadorbravo09/microservice-product.git
cd microservice-product
```

### 2. Configura la base de datos
```bash
CREATE DATABASE products_db;
```

### 3. Configura las credenciales en el archivo application.properties en variables de entorno
```bash
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

### 4. Construye y ejecuta la aplicación de entorno
```bash
./mvnw spring-boot:run
```

## **Endpoints de la API**
| **Método** | **Endpoint**            | **Descripción**              |
|------------|-------------------------|------------------------------|
| GET        | `/api/products`         | Listar todos los productos   |
| POST       | `/api/products`         | Crear un nuevo producto      |
| PUT        | `/api/products/{id}`    | Actualizar un producto       |
| DELETE     | `/api/products/{id}`    | Eliminar un producto         |

---

## **🛠️ Tecnologías Utilizadas**
- **Spring Boot**
- **MySQL**
- **Lombok**
- **MapStruct**
- **Postman**

---

## **💡 Funcionalidades Principales**

### **Gestión de Productos**
- Crear, leer, actualizar y eliminar productos.
- Asociar productos con categorías.

### **Validaciones**
- Validaciones a nivel de DTO para garantizar datos consistentes.

### **Mapeo Automático**
- Uso de MapStruct para simplificar la conversión entre entidades y DTOs.

---

## **📄 Licencia**
Este proyecto está bajo la licencia [MIT](https://opensource.org/licenses/MIT). Siéntete libre de usar, modificar y distribuir el código.

---

## **🤝 Contribuciones**
¡Las contribuciones son bienvenidas!