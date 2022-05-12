 AISS | Group 1 | FutData
![](images/FutData-logo%20(2).png)
The API is made up by 2 resources, they will allow to handle football teams and players. The applicaiton will provide all sorts of information related to football in the 5 major leagues. 

The services related to players is detailed below.  

### Player Resource ###
| HTTP  | URI | Description |
| ------------- | ------------- | ------------- |
| GET |  /player | It returns all the players of the application. It is possible to order the players by the nationality or position with the query parameter "order", that accepts values "nationality", "-nationality",  "position" or "-position". It is also possible to filter the returned players with the  query parameter q, which returns the players whose name, position, nationality includes the string variable sent (no differences between caps and lower case).|
| GET | /player/{playerId} | It returns the player whose id = playerId. If the player does not exist, then it returns "404 Not Found". |
| POST | /player | It adds a new player whose data are sent in the body of the require message in JSON format (the id must not be sent, since it is automatically genereated). If the name of the player is not valid (null or empty) it returns an error "400 Bad Request". If it is added correctly, it returns "201 Created" with the reference to the URI and the content to the player. |
| PUT | /player  | It updates the player whose data are sent in the body of the require message in JSON format (the id must be included). If the player does not exist, it returns a "404 Not Found". If it is done correctly, it returns "204 No Content". |
| DELETE | /player/{playerId}  | It deletes the player with id = playerId. If the player does not exist, it returns "404 Not Found". If it done correctly, it returns "204 No Content". |


Each **player** has an id, name, surname, position, teamNumber, nationality, team, age. The JSON representation of the resource is:
```cpp
{
	"id":"138",
	"name":"Nabil",
	"surname":"Fekir",
	"postiom":"Midfielder",
	"teamNumber":"8",
	"nationality":"France",
	"team":"Real Betis",
	"age": "28"
}
```


### Team Resource ###
| HTTP  | URI | Descripción |
| ------------- | ------------- | ------------- |
| GET | /teams  | It allows to see all the existing teams. It is possible to order the teams by name with the parameter of query "order", which only accepts two values, "name" o "-name". Using the this parameter it will return teams whose name is equal to the parameter's value. |
| GET | /teams/{teamId} | It returns the team with id = teamId. If the team does not exist, it returns a "404 Not Found".|
| POST | /teams | It adds a new team. The data of the team are provided in the body of the request message in JSON format. The players of the team can not be added here, in order to do that it is necessary to use the post operation to add the player to a specific team.If the name of the team is not valid(null or empty), or the creation of new team with players is intended, it returns an error "400 Bad Request". If it is added correctly, it returns "201 Created" with the reference to the URI and the content of the team. |
| PUT | /teams | It updates a team whose data are sent in the body of the request message in JSON format (id of the team is necessary). If the team does not exist, it returns a "404 Not Found". If updating the players of the team is intended, it returns an error "400 Bad Request". To update the players, the resource Player should be used. If it is done correctly, it returns "204 No Content".|
| DELETE | /teams/{teamId} | It deletes the team with id = teamId. If the team does not exist, it returns a "404 Not Found". If it is done correctly, it returns "204 No Content".|
| POST |  /teams/{teamId}/{playerId} | It adds the player with id = playerId to the team with id = teamId. If the team or the player do not exist, it returns "404 Not Found". If the player is already in the team, it returns "400 Bad Request". If it adds it correctly, it returns "201 Created" with the reference to the URI and the content of the team. |
| DELETE | /teams/{teamId}/{playerId}  | It deletes the player with id= playerId of the team with id = teamId. If the team or the player do not exist, it returns "404 Not Found". If it is added correctly, it returns "204 No Content".|


A **team** has an id, name, league, coach and a group of players. JSON representation as follows:

```cpp
{
	"id":"p5",
	"name":"Manchester United",
	"league": "Premier League",
	"coach":"Ralf Rangnick",
	"players":[
		{
			"id":"s0",
			"name":"Cristiano",
			"surname":"Ronaldo",
			"postiom":"Striker",
			"teamNumber":"7",
			"nationality":"Portugal",
			"team":"Manchester United",
			"age": "37"
		},

		{			
			"id":"p3",
			"name":"Paul",
			"surname":"Pogba",
			"postiom":"Midfielder",
			"teamNumber":"6",
			"nationality":"France",
			"team":"Manchester United",
			"age": "29"
		}
		]
}

```
The services related to games are detailed below:
### Game Resource ###
| HTTP  | URI | Descripción |
| ------------- | ------------- | ------------- |
| GET | /games  | It returns all the games of the application. It is possible to filter the returned games with the  query parameter goals or team, which returns the games with total number of goals equal or above the parameter <<goals>> or for the parameter <<team>>, it returns the game in which one of the 2 teams are equal to <<team>>|
| GET | /games/{gameId} |It returns the game with id = gameId. If the team does not exist, it returns a "404 Not Found".|
| POST | /games | It adds a new game. The data of the game are provided in the body of the request message in JSON format. If the name of the teams  are not valid(null or empty), it returns an error "400 Bad Request". If it is added correctly, it returns "201 Created" with the reference to the URI and the content of the game. |
| PUT | /games | It updates the game whose data are sent in the body of the require message in JSON format (the id must be included). If the player does not exist, it returns a "404 Not Found". If it is done correctly, it returns "204 No Content". |
| DELETE | /games/{gameId}  | It deletes the game with id= gameId. If the team or the player do not exist, it returns "404 Not Found". If it is added correctly, it returns "204 No Content". |
	
A game has an id, teamHome, teamAway, goalsHome, goalsAway, date and league. JSON representation as follows:

```cpp
{
	"id":"g4",
	"teamHome":"Real Betis",
	"teamAway":"FC Sevilla",
	"goalsHome": 2,
	"goalsAway":2,
	"date": "05.05.2022",
	"league":"La Liga"
}

```

### League Resource ###
| HTTP  | URI | Descripción |
| ------------- | ------------- | ------------- |
| GET | /leagues  | It returns all the leagues. It is possible to filter the returned games with the  query parameter goals or team, which returns the games with total number of goals equal or above the parameter <<goals>> or for the parameter <<team>>, it returns the game in which one of the 2 teams are equal to <<team>>|
| GET | /games/{gameId} |It returns the game with id = gameId. If the team does not exist, it returns a "404 Not Found".|
| POST | /games | It adds a new game. The data of the game are provided in the body of the request message in JSON format. If the name of the teams  are not valid(null or empty), it returns an error "400 Bad Request". If it is added correctly, it returns "201 Created" with the reference to the URI and the content of the game. |
| PUT | /games | It updates the game whose data are sent in the body of the require message in JSON format (the id must be included). If the player does not exist, it returns a "404 Not Found". If it is done correctly, it returns "204 No Content". |
| DELETE | /games/{gameId}  | It deletes the game with id= gameId. If the team or the player do not exist, it returns "404 Not Found". If it is added correctly, it returns "204 No Content". |

	
If you want to use FutData, then click the link below:
https://futdata-349615.appspot.com/
