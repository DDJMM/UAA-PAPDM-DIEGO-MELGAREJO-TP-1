# UAA-PAPDM-DIEGO-MELGAREJO-TP-1
# Recetas Cocina App

Esta es una aplicación Android para gestionar y mostrar recetas de cocina. Los usuarios pueden agregar nuevas recetas, ver detalles como el tiempo de preparación, ingredientes, calorías por porción, y eliminar recetas si lo desean.

## Estructura del Proyecto

El proyecto utiliza **Jetpack Compose** para construir la interfaz de usuario y sigue una estructura sencilla con los siguientes componentes principales:

### `MainActivity.kt`

- **MainActivity**: Es la actividad principal que establece el contenido de la aplicación usando un tema personalizado llamado `RecetasCocinaTheme`.
- Dentro de `setContent()`, la función `RecetasApp()` se utiliza para renderizar la interfaz principal de la aplicación.

### `RecetasApp.kt`

- **RecetasApp()**: Componente principal que maneja el estado de la lista de recetas y muestra el formulario para agregar recetas, así como la lista de recetas ya agregadas.
- **RecetaForm()**: Formulario para introducir los datos de la receta (nombre, tiempo de preparación, ingredientes, calorías y URL de la imagen).
- **ItemReceta()**: Componente que muestra los detalles de cada receta en una tarjeta con opciones para eliminarla.
- **InfoReceta()**: Componente que organiza y muestra los detalles individuales de la receta (como el tiempo de preparación, ingredientes y calorías).

### `Receta.kt`

- **Receta**: Es una data class que modela una receta con los siguientes atributos:
  - `name`: Nombre del plato.
  - `tiempo`: Tiempo de preparación.
  - `ingredientes`: Ingredientes del plato.
  - `calorias`: Calorías por porción.
  - `imageUrl`: URL de una imagen representativa del plato.

## Requisitos

- **Android Studio**: Asegúrate de tener Android Studio instalado en tu máquina.
- **Kotlin**: El proyecto está desarrollado en Kotlin.

## Cómo ejecutar la aplicación

Sigue estos pasos para ejecutar la aplicación en tu entorno local:

1. Clona el repositorio en tu máquina:
   git clone https://github.com/tu-usuario/recetas-cocina.git
   
3. Abre el proyecto en Android Studio.
4. Conecta un dispositivo físico o usa un emulador de Android.
5. Haz clic en el botón Run
6. La aplicación se iniciará en el dispositivo/emulador.

Funcionalidades
    Agregar recetas: Usa el formulario en la pantalla principal para agregar una receta.
    Ver recetas: Las recetas agregadas se muestran en una lista con todos sus detalles.
    Eliminar recetas: Puedes eliminar cualquier receta de la lista
