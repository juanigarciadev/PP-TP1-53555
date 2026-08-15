# TP1 - Programación Orientada a Objetos en Java

Trabajo Práctico N°1 de la cátedra **Paradigmas de Programación** (UTN - FRM), Unidad 1: Fundamentos de la POO e implementación básica en Java.

## Estado actual

| Ejercicio | Descripción | Estado |
|---|---|---|
| 1 | Clase `EventoUniversitario`: creación, copia y contador de instancias | ✅ Completo |
| 2 | Relaciones entre `EventoUniversitario`, `Sala`, `Actividad`, `Estudiante` e `Inscripcion` | ✅ Completo |
| 3 | Herencia y polimorfismo (`Actividad` abstracta, subclases `Charla` y `Taller`) | ⬜ Pendiente |
| 4 | Mapa de memoria de ejecución | ⬜ Pendiente |

## Cómo ejecutar

Abrir el proyecto en IntelliJ IDEA y correr `App.java` (contiene el `main`). Se recomienda ejecutar desde una terminal real (no la consola integrada del IDE) para que el limpiado de pantalla se aproveche mejor durante la navegación por los menús.

Al iniciar, el sistema precarga datos de prueba (`Utilidades.poblarSistema`): 3 estudiantes, 2 salas y 2 eventos ya creados con sus actividades e inscripciones, para poder probar los módulos sin cargar todo a mano.

## Menú principal

```
1. Gestión de eventos universitarios
2. Gestión de estudiantes
3. Inscripción a eventos
4. Gestión de salas
5. Salir del sistema
```

Cada módulo (excepto "Salir") tiene a su vez un submenú propio de **crear / mostrar / volver**, salvo el de inscripción, que guía al usuario paso a paso: elegir evento → elegir actividad → elegir estudiante por legajo.

## Estructura del proyecto

**Modelo:**
- `EventoUniversitario` — evento con ID (UUID), título, costo base, condición de gratuidad, sala asignada y lista de actividades. Contador estático de instancias. Constructor de copia (copia también sala y actividades).
- `Sala` — id y nombre. Se asigna al evento por agregación (existe independientemente del evento).
- `Actividad` — id, título, cupo máximo y lista de inscripciones. Se crea siempre a través de `EventoUniversitario.crearActividad(...)` (composición).
- `Estudiante` — legajo y nombre.
- `Inscripcion` — vincula un estudiante con una actividad, fecha (`LocalDate.now()`) y estado.

**Módulos de interacción (menús por consola):**
- `GestionEventos` — crear eventos (con sus actividades y sala asignada) y listar los existentes.
- `GestionEstudiantes` — crear y listar estudiantes.
- `GestionSalas` — crear y listar salas.
- `GestionInscripcion` — inscribir un estudiante existente en una actividad de un evento existente.

**Utilidades:**
- `Utilidades.limpiarConsola()` — limpia la pantalla entre pantallas del menú.
- `Utilidades.poblarSistema(...)` — carga los datos de prueba iniciales.
- `Utilidades.mostrarEstudiantes(...)` — listado reutilizado por distintos módulos.

**Punto de entrada:**
- `App` — contiene el `main`, declara las listas compartidas (`estudiantes`, `eventos`, `salas`) y despacha al módulo correspondiente según la opción elegida.

## Próximos pasos

- Ejercicio 3: convertir `Actividad` en clase abstracta con subclases `Charla` y `Taller`, agregar `calcularCostoEstimado()` polimórfico en `EventoUniversitario` y actualizar `crearActividad` para recibir el tipo de actividad.
- Ejercicio 4: mapa de memoria de ejecución del programa del Ejercicio 3.
