# Benjamin Weapons

Benjamin Weapons es un mod de Minecraft Java Edition diseñado para **NeoForge 1.21.1**. Su objetivo es agregar armas mágicas personalizadas y balanceadas para la etapa avanzada del juego (late-game), comenzando por la **Espada de Aether**.

---

## Características

*   **Espada de Aether (`benjamin_weapons:aether_sword`)**: Una espada mágica forjada con energía celestial.
*   **Poder Especial (Lentitud)**: Al golpear a una entidad viva, existe una probabilidad del **25%** de aplicarle **Lentitud I** durante **2 segundos**, reproduciendo un sonido de campanas de amatista y efectos visuales de partículas de portal.
*   **Cooldown del Poder**: El poder especial tiene un tiempo de reutilización (cooldown) inicial de **3 segundos** para evitar abusos y mantener el equilibrio.
*   **Compatibilidad Cliente-Servidor**: Toda la lógica crítica (daño, efectos, cooldowns, sonidos y partículas) se procesa en el servidor para evitar desincronizaciones en multijugador.
*   **Tooltip Elegante**: El objeto posee una descripción traducible que se muestra en un tono violeta claro mágico.
*   **Receta Temática**: Se fabrica utilizando recursos mágicos de Minecraft (Amatista, Netherite y Blaze).
*   **Pestaña Creativa propia**: Todos los objetos del mod se ubican dentro de su propia pestaña creativa llamada "Benjamin Weapons".
*   **Altamente Configurable**: Permite ajustar las estadísticas y comportamientos del arma y sus efectos sin necesidad de recompilar.

---

## Requisitos

*   **Minecraft**: Java Edition `1.21.1`
*   **Mod Loader**: NeoForge (compatible con la versión `21.1.68` o superior)
*   **Java**: `Java 21` (JDK 21)

---

## Obtención de la Espada

Además de fabricarse en supervivencia o buscarse en la pestaña creativa propia, se puede obtener usando el siguiente comando:

```mcfunction
/give @p benjamin_weapons:aether_sword
```

---

## Receta de Fabricación

Se fabrica en la mesa de trabajo de 3x3 organizando los ingredientes de forma vertical:

```text
[A]
[N]
[B]
```

Donde:
*   **A**: Fragmento de Amatista (`minecraft:amethyst_shard`)
*   **N**: Lingote de Netherite (`minecraft:netherite_ingot`)
*   **B**: Vara de Blaze (`minecraft:blaze_rod`)

---

## Configuración del Mod

El mod genera automáticamente un archivo de configuración al iniciarse por primera vez.

*   **Ubicación**: `config/benjamin_weapons-common.toml`

### Propiedades Disponibles

| Propiedad | Tipo | Valor por defecto | Rango | Descripción | Requiere Reinicio |
| :--- | :--- | :--- | :--- | :--- | :--- |
| `attackDamageBonus` | Double | `3.5` | `0.0` a `100.0` | Daño adicional de la espada (Netherite es +4, Diamante es +3). | **Sí** |
| `attackSpeed` | Double | `-2.4` | `-4.0` a `4.0` | Modificador de velocidad de ataque (el final es 4.0 + mod; -2.4 = 1.6). | **Sí** |
| `durability` | Integer | `1750` | `1` a `100000` | Usos de durabilidad totales de la espada de Aether. | **Sí** |
| `effectId` | String | `"minecraft:slowness"` | N/A | ID de registro del efecto a aplicar al golpear una entidad. | No |
| `effectDuration` | Integer | `2` | `0` a `3600` | Duración del efecto aplicado en segundos. | No |
| `effectLevel` | Integer | `1` | `1` a `255` | Nivel del efecto (1 = Nivel I, 2 = Nivel II, etc.). | No |
| `activationChance` | Double | `25.0` | `0.0` a `100.0` | Probabilidad de activación del efecto al golpear (0 a 100%). | No |
| `cooldownSeconds` | Integer | `3` | `0` a `3600` | Cooldown del poder especial en segundos. | No |
| `enableParticles` | Boolean | `true` | N/A | Activa o desactiva la generación de partículas al impactar. | No |
| `particleCount` | Integer | `20` | `1` a `100` | Cantidad de partículas generadas en cada activación. | No |
| `enableSound` | Boolean | `true` | N/A | Activa o desactiva el sonido mágico (amatista) al impactar. | No |

---

## Instalación

### Para Jugadores (Cliente)

1.  Descarga e instala la versión recomendada de **NeoForge para Minecraft 1.21.1**.
2.  Ejecuta Minecraft una vez con el perfil de NeoForge instalado para generar las carpetas.
3.  Ve a la carpeta de datos de Minecraft (`%appdata%/.minecraft/` en Windows).
4.  Copia el archivo `benjamin_weapons-1.0.0.jar` dentro de la carpeta `mods`.
5.  Inicia el juego seleccionando el perfil de NeoForge.

### Para Servidores

1.  Prepara tu servidor dedicado compatible con **NeoForge 1.21.1**.
2.  Coloca el archivo `benjamin_weapons-1.0.0.jar` en la carpeta `mods` del servidor.
3.  Acepta los términos de la EULA (`eula.txt` en `true`).
4.  Inicia el servidor.
5.  *Nota*: Todos los clientes que se conecten al servidor deben tener instalado el mod en su carpeta `mods`.

---

## Desarrollo del Proyecto

Si deseas modificar o extender este mod:

1.  Asegúrate de tener instalado **Java 21 (JDK 21)**.
2.  Clona el repositorio.
3.  Importa el proyecto en tu IDE preferido (se recomienda **IntelliJ IDEA** como proyecto Gradle).
4.  Sincroniza Gradle para descargar las dependencias de NeoForge y de Minecraft.
5.  Utiliza los comandos de compilación y pruebas.

### Comandos de Gradle

Para entornos Linux / MacOS:

```bash
./gradlew clean         # Limpia las carpetas de compilación
./gradlew build         # Compila el código y empaqueta el mod en build/libs/
./gradlew runData       # Ejecuta los generadores de datos (datagen)
./gradlew runClient     # Lanza el cliente de Minecraft de prueba
./gradlew runServer     # Lanza el servidor de Minecraft de prueba
```

Para entornos Windows (PowerShell / Command Prompt):

```powershell
.\gradlew.bat clean
.\gradlew.bat build
.\gradlew.bat runData
.\gradlew.bat runClient
.\gradlew.bat runServer
```

---

## Licencia

Este proyecto está liberado bajo la licencia **MIT**. Consulta el archivo `LICENSE` para más detalles.

---

## Aviso Legal

Este proyecto es un mod independiente para Minecraft y **no está afiliado, asociado ni respaldado** por Mojang Studios, Microsoft ni el equipo de NeoForged. Minecraft es una marca registrada de Mojang Synergies AB.
