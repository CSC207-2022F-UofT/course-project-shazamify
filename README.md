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

## User interaction
### Observer pattern
- implemented in the interface adaptor layer
- Observable: the current (login) user's friendList
- Observer: an interface implemented by all friend manager controllers

When the user's friendList changes in response to actions of accept/ deny a friend request or delete a friend, the controller that's responsible for the action calls the observer interface's setFriendList() method, which calls each of the friend manager controllers to update their local friendList attribute.
