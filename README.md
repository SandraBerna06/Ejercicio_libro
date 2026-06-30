# 📚 Gestión de Biblioteca (Java + MySQL)

Aplicación de consola en Java diseñada para gestionar el inventario de una biblioteca utilizando una base de datos MySQL mediante JDBC.

---

## 🛠️ Estructura del Proyecto

El código está organizado en las siguientes clases:

* **`ConexionBD.java`**: Gestiona la conexión con la base de datos MySQL.
* **`Libro.java`**: Modelo de datos que define los atributos de un libro.
* **`LibroDAO.java`**: Capa de persistencia (Data Access Object) con las operaciones CRUD.
* **`Main.java`**: Clase principal que ejecuta el menú interactivo.
* **`MetodosComunes.java`**: Utilidades para la validación de entrada de datos por teclado.

---

## ⚙️ Configuración de la Base de Datos

Para inicializar el entorno, ejecuta el siguiente script en tu servidor MySQL:

```sql
CREATE DATABASE biblioteca_db;

USE biblioteca_db;

CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    genero VARCHAR(50),
    precio DOUBLE,
    disponible BOOLEAN
);
