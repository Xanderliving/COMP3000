
![Logo](https://github.com/Xanderliving/COMP3000/blob/main/Logo.png)



# Pick 'n' Mixologist

Pick 'n' Mixologist is a combination of a software and phyical machine that allows user to become mixologists.

Using a Raspberry Pi and API routes, the applcaition and the Pi can connect to bring cocktails to the user.


## Features

- Make you own function
- Correct measurments dispensed from machine
- Able to change what liquids are in the machine
- Database full or pre made cocktails
- Working pumps and relays


## Technologies
This application used a range of different technologies such as

- Rapberry Pi
The Rapberry Pi is the main part of the machine as it controls the relays and pumps by reading off the API that it also soruces.
- Peristaltic pump
The peristaltic pumps are vacume pumps that are food and liquid safe. The are acurate at measuring the amount of liquid that is dispensed.
- Relay
As the Raspberry Pi doesnt have enough power, relays allow a battery to be conneted to the circuit so the pumps can be powered.
- MongoDB
MongoDB is the database system used for the applciation and keeps the cocktail recipies information.
- Laser Cutter
The laser cutter using CAD was used to make the machine box
## API Reference

#### Get all cocktails in the database

```http
  GET /api/data/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### Get one cocktail

```http
  GET /api/data/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | ID for cocktail |
| `Name`      | `string` | **Required**. Id of item to fetch |
| `Gin`      | `int` | **Required**. |
| `Vodka`      | `int` | **Required**. |
| `Tequila`      | `int` | **Required**. |
| `Rum`      | `int` | **Required**. |
| `Coke`      | `int` | **Required**. |
| `Lemonade`      | `int` | **Required**. |
| `Extra`      | `string` | **Required**. |
| `Category`      | `string` | **Required**. |
| `Units`      | `int` | **Required**. |

#### Get all cocktails in the database

```http
  GET /pumps/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### PUT one cocktail

```http
  GET /pumps/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |
| `Pump`      | `string` | **Required**. |
| `Status`      | `String` | **Required**. |





## Installation

Installing the project needs two steps

Installing on android

- Download Android Studio
- Download App folder
- Unzip folder and run on Android Studio
- Run emulator

Installing on Raspberry Pi

- Download 'Raspberry Pi' folder onto a SD
- Insert into Raspberry Pi
- Run these 2 commands

```
python Controller.py
node app.js

```
