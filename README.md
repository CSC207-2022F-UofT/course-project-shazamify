# Project Hightlights and Summaries by Feature

## Project Setup
JDK >= 11

## Setting up the Database
Install Docker (if on Windows follow this link https://docs.docker.com/desktop/install/windows-install/). 

You can verify it was installed correctly by opening a terminal and running

```docker -v```

This project uses MongoDB as the database implementation.

Run the following command in a terminal

```
cd src/main/docker
docker-compose up -d
```

Once the docker container is initialized the `moveToDatabase()` method in SongDownloader can move the songs in `src/resources/songs` to the database.

## DAOImpl Notes
SongDAOImpl and PlaylistDAOImpl import entities, which may seem like a Clean Architecture violation. These Piazza posts [1](https://piazza.com/class/l5v1b8gfz6b60m/post/557) and [2](https://piazza.com/class/l5v1b8gfz6b60m/post/320), say it's ok
to allow the gateway to return entities directly.

The DAO design pattern acts as an API for the database and implements CRUD operations (Create, Read, Update, Delete).

## Queue Notes
The song queue entity is a singleton class- there will only ever be one instance of a queue at a time. This design was chosen rather than making the song queue a subclass of a playlist (since both objects contain lists of song objects), because of the vast differences between the two objects (the only common factor within between them is one of their attributes).


## User interaction
### Observer pattern
- implemented in the interface adaptor layer
- Observable: the current (login) user's friendList
- Observer: an interface implemented by all friend manager controllers

When the user's friendList changes in response to actions of accept/ deny a friend request or delete a friend, the controller that's responsible for the action calls the observer interface's setFriendList() method, which calls each of the friend manager controllers to update their local friendList attribute.
