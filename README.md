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

## Notes
SongDAOImpl and PlaylistDAOImpl import entities, which may seem like a Clean Architecture violation. These Piazza posts [1](https://piazza.com/class/l5v1b8gfz6b60m/post/557) and [2](https://piazza.com/class/l5v1b8gfz6b60m/post/320), say it's ok
to allow the gateway to return entities directly.

## Queue Notes
The song queue entity is a singleton class- there will only ever be one instance of a queue at a time. This design was chosen rather than making the song queue a subclass of a playlist (since both objects contain lists of song objects), because of the vast differences between the two objects (the only common factor within between them is one of their attributes). 
