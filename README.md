# ¡Bienvenido/a a RetroLife!
Somos Gonzalo Carrascal, Alejandro Aguado, Diego García y Carlos Benedito, y vamos a presentar nuestra aplicación.

**RetroLife** se basará en una tienda de artículos vintage online con una extenso catálogo y múltiples funciones. 
Esta aplicación irá dirigida a un público reducido, el cuál serán personas de una edad superior a los 30 años, que quieran disfrutar y revivir momentos del pasado a través de nuestros productos.

El primer diseño de **RetroLife** se puede ver en [Figma](https://www.figma.com/file/bpAjXUWg5DidAo2MKjUhxy/RetroLife?type=design&node-id=0-1&mode=design&t=bubrK2oznE3k72Pf-0).

# Funcionalidades
**RetroLife** contará con las siguientes funcionalidades:
1. Registro de usuario.
2. Login de usuario.
3. Catálogo.
4. Perfil (ver mi perfil, mis pedidos, ajustes de cookies, información sobre RetroLife, información legal).
5. Carrito.
6. Métodos de pago.
7. Filtro de búsqueda.
8. Cerrar sesión.
# Diseño
El diseño de **RetroLife** será intuitivo y simple, con la intención de no desviar la atención de los productos y con cierta facilidad de uso.

Nuestro color principal es el blanco, que aporta modernismo y elegancia a la aplicación, y el color secundario es el azul, que transmite confianza y seguridad. El último aspecto es esencial ya que al usar formas de pago en nuestra aplicación, los clientes deben sentirse seguros y confiados al comprar nuestros productos.

**RetroLife** estará desarrollada con un estilo personalizado mediante el empleo de Material3.

# Casos de uso
Nuestra aplicación hará llamadas a la base de datos para las siguientes funciones:

1. Registrar los usuarios.
2. En el login, comprobar que los datos introducidos estén en la base de datos.
3. El catálogo cogerá la lista de productos de la base de datos, y los plasmará en el ReyclerView.
4. Registrar las direcciones de envios.

# Actividades en Android Studio
**RetroLife** dispondrá de las siguintes actividades:

1. SplashScreen (con animación en el drawable).
  <img width="158" alt="image" src="https://github.com/gonzalocmiFP/RetroLife/assets/132547871/fb186458-aac0-4697-9d84-0aa999d40811">


2. Actividad para el login.
  <img width="161" alt="image" src="https://github.com/gonzalocmiFP/RetroLife/assets/132547871/829b4ff1-2b6c-4aa1-abd8-1eadff371ec1">


3. Actividad para el registro.
  <img width="167" alt="image" src="https://github.com/gonzalocmiFP/RetroLife/assets/132547871/ef74310d-e0f7-4fc9-b323-848777a9ac04">


4. RecyclerView (con un "row.xml", una clase "Adaptador", y otra clase "Model").
  <img width="160" alt="image" src="https://github.com/gonzalocmiFP/RetroLife/assets/132547871/195d55f2-9b67-4d40-8453-b3ecb7e0d3b1">


5. Actividad para seleccionar y añadir productos al carrito dentro del ReyclerView (aplicando un "onClick" que envíe la posición y una lista con imágenes, nombres y precios de la base de datos, dependiendo del elemento que selecciones en el RecyclerView para poder plasmarlo en un ImageView, TextView...).
  <img width="160" alt="image" src="https://github.com/gonzalocmiFP/RetroLife/assets/132547871/5ab103ff-aba1-4e4e-8719-a37b53fde6b3">


6. Actividad para el carrito (lista que vaya cargando elementos añadidos por el usuario).
  <img width="167" alt="image" src="https://github.com/gonzalocmiFP/RetroLife/assets/132547871/86e69feb-c2f5-4733-83cd-2330065a9e13">


7. Actividad para el pago e ingreso de dirección de envío.
  <img width="167" alt="image" src="https://github.com/gonzalocmiFP/RetroLife/assets/132547871/e020e2a7-194b-4d84-9aae-a1e51a351795">
