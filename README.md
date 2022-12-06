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
## DAOImpl Notes
SongDAOImpl and PlaylistDAOImpl import entities, which may seem like a Clean Architecture violation. These Piazza posts [1](https://piazza.com/class/l5v1b8gfz6b60m/post/557) and [2](https://piazza.com/class/l5v1b8gfz6b60m/post/320), say it's ok
to allow the gateway to return entities directly.

## Queue Notes
The song queue entity is a singleton class- there will only ever be one instance of a queue at a time. This design was chosen rather than making the song queue a subclass of a playlist (since both objects contain lists of song objects), because of the vast differences between the two objects (the only common factor within between them is one of their attributes).


## Design Patterns
### Factory Pattern
- implemented in the entities layer, like UserFactory.
- Can be used to initialize different types of Users(CommonUser, PremiumUser, Guest)
By using UserFactory creating different types of User, we can obscure the creation process for these related objects.

### Facade Pattern
- implemented in the use case layer
- Can be used to encapsulate the code that each subclass only have one responsibility.

Facade class: UserRegUseCase and QueueUseCase
subclasses: UserRegHelper, UserRecommendPasswordHelper, QueueHelper

When the UserRegUseCase receive requests from UserRegController, it will distribute the works into subclasses, and each subclass will only have one responsibility.
UserRegHelper will register the User into UserDatabase, and UserRecommendPasswordHelper responsible for giving out recommend password.

### Observer Pattern
- implemented in the interface adaptor layer
- Observable: UserStatusViewModel, including current LoggedIn User Status, like entities UserName, UserAvatar, UserFriendList and UserPlaylist
- Observer: Controllers and UIs.

The UserStatusViewModel is a Singleton Class that visible by the package. Everytime the user logged into the system, the UserLogPresenter will update the UserStatusViewModel, and send update to various of subscribers that implement UserStatusObserver.

### Singleton Pattern
- implemented in interface adapter Layer, mostly view models.
- Having private constructor and static .getInstance()

Used to make the ViewModels observable for the package, unique and potentially able to implements interface and extends superclasses.
UIs and Controllers would be able to access information that is pre-prepared, and don't need to go through different layers.

### Dependency Injection
- implemented in use case layer.
- 