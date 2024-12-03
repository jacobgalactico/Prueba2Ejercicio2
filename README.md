# Prueba2Ejercicio2
LINK: https://github.com/jacobgalactico/Prueba2Ejercicio2.git
Esta es una aplicación de Android para gestionar eventos. La aplicación permite a los usuarios añadir, ver y eliminar eventos. Los eventos se guardan utilizando `SharedPreferences` para que permanezcan disponibles incluso después de cerrar y volver a abrir la aplicación.

## Características

- Añadir nuevos eventos con detalles como nombre, descripción, dirección, precio y fecha.
- Ver detalles de los eventos.
- Eliminar eventos.
- Soporte para los idiomas inglés y español.

## Capturas de Pantalla

![Pantalla Principal](screenshots/main_screen.png)
![Pantalla de Añadir Evento](screenshots/add_event_screen.png)
![Pantalla de Detalle de Evento](screenshots/event_detail_screen.png)

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/jacobgalactico/Prueba2Ejercicio2.git
    ```
2. Abre el proyecto en Android Studio.
3. Construye y ejecuta el proyecto en un dispositivo Android o emulador.

## Dependencias

- [Gson](https://github.com/google/gson) para la serialización y deserialización de JSON.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) para construir la interfaz de usuario.

## Uso

### Añadir un Evento

1. Haz clic en el botón de acción flotante con el icono "+".
2. Rellena los detalles del evento en el formulario.
3. Haz clic en el botón "Guardar" para guardar el evento.

### Ver Detalles del Evento

1. Haz clic en un evento en la lista para ver sus detalles.

### Eliminar un Evento

1. Haz clic en el icono de la papelera junto al evento que deseas eliminar.

## Estructura del Proyecto

- `MainActivity.kt`: La actividad principal que muestra la lista de eventos.
- `AddEventActivity.kt`: La actividad para añadir un nuevo evento.
- `EventDetailActivity.kt`: La actividad para ver los detalles del evento.
- `Event.kt`: La clase de datos que representa un evento.
- `ui/theme`: Contiene el tema y el estilo de la aplicación.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.
