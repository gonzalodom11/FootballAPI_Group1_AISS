# Implementación de una API REST 

Práctica 5 de la asignatura AISS

La API REST estará formada por dos recursos que permitirán manipular listas de reproducción y canciones respectivamente. 

El contrato de servicios de listas de reproducción se detalla a continuación. No todas las opciones han sido implementadas en el código proporcionado. El objetivo de esta práctica es se implementen todos los métodos necesarios para que la API funcione como se detalla a continuación. 

### Recurso Song ###
| HTTP  | URI | Descripción |
| ------------- | ------------- | ------------- |
| GET |  /song | Devuelve todas las canciones de la aplicación. •	Es posible ordenar las canciones por el álbum o el artista con el parámetro de query “order”, que acepta los valores “album”, “-album”, “artist” o “-artist”. •	También es posible filtrar las canciones devueltas con el parámetro de query “q”, que devuelve aquellas canciones cuyo título, álbum o artista contengan la cadena enviada (ignorando mayúsculas y minúsculas).|
| GET | /song/{songId}  |  Devuelve la canción con id=songId. Si la canción no existe devuelve un “404 Not Found”. |
| POST | /song | Añade una nueva canción cuyos datos se pasan en el cuerpo de la petición en formato JSON (no se debe pasar id, se genera automáticamente). Si el nombre de la canción no es válido (null o vacío) devuelve un error “400 Bad Request”. Si se añade satisfactoriamente, devuelve “201 Created” con la referencia a la URI y el contenido de la canción. |
| PUT | /song  | Actualiza la canción cuyos datos se pasan en el cuerpo de la petición en formato JSON (deben incluir el id de la canción). Si la canción no existe, devuelve un “404 Not Found”. Si se realiza correctamente, devuelve “204 No Content”. |
| DELETE | /song/{songId}  |  Elimina la canción con id=songId. Si la canción no existe, devuelve un “404 Not Found”. Si se realiza correctamente, devuelve “204 No Content”.|

Cada **canción** tiene un identificador, _título, nombre del artista, álbum y año_. La representación JSON del recurso es:

```cpp
{
	"id":"s3",
	"title":"Smell Like Teen Spirit",
	"artist":"Nirvana",
	"album":"Nevermind",
	"year":"1991"
}
```


### Recurso Playlist ###
| HTTP  | URI | Descripción |
| ------------- | ------------- | ------------- |
| GET | /lists  | Ver todas las listas de reproducción existentes. •	Es posible ordenar las listas por nombre con el parámetro de query “order”, que solo acepta dos valores, “name” o “-name”. •	También es posible filtrar las listas devueltas con dos parámetros de query: “isEmpty”, que devuelve listas sin canciones si vale “true” o listas con canciones si vale “false”; “name”, que devuelve las listas cuyo nombre coincida exactamente con el valor del parámetro. |
| GET | /lists/{playlistId} | Devuelve la lista con id=playlistId. Si la lista no existe devuelve un “404 Not Found”. |
| POST | /lists | Añadir una nueva lista de reproducción. Los datos de la lista (nombre y descripción) se proporcionan en el cuerpo de la petición en formato JSON. Las canciones de la lista no se pueden incluir aquí, para ello se debe usar  la operación POST específica para añadir una canción a una lista (a continuación). Si el nombre de la lista no es válido (nulo o vacío), o se intenta crear una lista con canciones, devuelve un error “400 Bad Request”. Si se añade satisfactoriamente, devuelve “201 Created” con la referencia a la URI y el contenido de la lista. |
| PUT | /lists | Actualiza la lista cuyos datos se pasan en el cuerpo de la petición en formato JSON (deben incluir el id de la lista).  Si la lista no existe, devuelve un “404 Not Found”. Si se intenta actualizar las canciones de la lista, devuelve un error “400 Bad Request”. Para actualizar las canciones se debe usar el recurso Song mostrado previamente. Si se realiza correctamente, devuelve “204 No Content”. |
| DELETE | /lists/{playlistId} | Elimina la lista con id=playlistId. Si la lista no existe, devuelve un “404 Not Found”. Si se realiza correctamente, devuelve “204 No Content”. |
| POST |  /lists/{playlistId}/{songId} | Añade la canción con id=songId a la lista con id=playlistId. Si la lista o la canción no existe, devuelve un “404 Not Found”. Si la canción ya está incluida en la lista devuelve un “400 Bad Request”. Si se añade satisfactoriamente, devuelve “201 Created” con la referencia a la URI y el contenido de la lista. |
| DELETE | /lists/{playlistId}/{songId}  | Elimina la canción con id=songId de la lista con id=playlistId. Si la lista o la canción no existe, devuelve un “404 Not Found”. Si se realiza correctamente, devuelve “204 No Content”.|


Una **lista de reproducción** tiene un _identificador, nombre, descripción y un conjunto de canciones_. La representación JSON de este recurso es:

```cpp
{
	"id":"p5",
	"name":"AISSPlayList",
	"description":"AISS PlayList",
	"songs":[
		{
			"id":"s0",
			"title":"Rolling in the Deep",
			"artist":"Adele",
			"album":"21",
			"year":"2011"
		},

		{			
			"id":"s1",
			"title":"One",
			"artist":"U2",
			"album":"Achtung Baby",
			"year":"1992"
		}
		]
}

```
