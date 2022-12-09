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
The history queue has been somewhat completed, however it can be noticed that there is no implementation of it. The reason for that is, due to time constraints, the song recommender (which is the primary reason we decided on implementing the queue history in the first place) was placed on hold until functionality of our main program was accomplished.

The song player will get the first song in queue when the skip button is clicked. However, due to the song player being unable to recognize when a song is finished, it is imperative to click the skip button to move to the next song.
Pressing play on a song inside the queue will delete every song before it in the queue. There can be duplicate songs in the queue. Users can re-order, delete, or overwrite the queue with buttons.

## Radio Notes
### API Interaction - TBD
The structure of various radio features was made with the intention of having an API serve as a database/source of our radio station objects. Unfortunately due to time constraints and various unforeseen issues, the API calls currently do not function as intended. Various RadioStation objects have been created to serve as a demonstrative of how the rest of the radio features are supposed to function. 

### Liking and Saving Radio Stations - TBD 
The RadioStation entities have an attribute called "like" attached to them. This is because there is a planned feature of users being able to like certain radio stations and have it then be added into a sort of psuedo-playlist of their favourite radio stations. Unfortunately due to time constraints this feature was placed on hold in order to prioritize the main functionality of our program.

## User Interaction Notes
Friend limit :10 (increase or decrease by changing the FRIEND_LIMIT in SendFriendRequestHelper)

Click on the button in circle to access friend list:

![image](https://user-images.githubusercontent.com/43018428/206616536-9a4a6e50-2ec2-4fdf-bb83-96144c7a4d14.png)


## User Notes
- Illegal User Password & UserName: Only check for the illegal symbal. i.e. Any simbal that is not Alphanumeric.
- Change Avatar: Click the Avatar Button in setting to change the avatar. Note: It only support .jpg file;

## Playlist Notes
- Finished features: Playlist Create/Modify ABR, Entities, Back-end integration, User integration. Logic/Interface Adapters for all Playlist's feature: Create playlist, add/delete/reorder songs, change privacy, PlaylistCollection showcase, delete playlist, etc.
- In development: full UI integration
## Design Patterns
### Factory Pattern
- implemented in the entities layer, like UserFactory.
- Can be used to initialize different types of Users(CommonUser, PremiumUser, Guest)
By using UserFactory creating different types of User, we can obscure the creation process for these related objects.

### Facade Pattern
- implemented in the use case layer
- Can be used to encapsulate the code that each subclass only have one responsibility.

Facade class: UserRegUseCase, QueueFUC, QueueGetUseCase, QueueUUseCase
subclasses: UserRegHelper, UserRecommendPasswordHelper, QueueFHelper, QueueGetHelper, QueueUHelper

When the UserRegUseCase receive requests from UserRegController, it will distribute the works into subclasses, and each subclass will only have one responsibility.
UserRegHelper will register the User into UserDatabase, and UserRecommendPasswordHelper responsible for giving out recommend password.

The queue helpers are responsible for doing the actual list modifiying/updating. It will access the singleton queue and do necessary changes.

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

## Testing notes
### User Testing toolKit
- Change Avatar Testing tool: initialize Controller.

- Change Password Testing tool: initialize Controller.

- Generate Ten User: generate 10 Users by pattern(Detail see file documentation)

- UserDatabaseEraser: Erase the User Database

- UserLogTestingTool: Handy tool to log in multiple users

- UserRegTestingTool: Handy tool to register multiple user.


### Radio Testing, Or Lack Thereof
There is one test currently implemented that tests a radio feature - the general search engine test. Beyond that there are no present tests for radio for two very specific reasons. 

The first reason being that the current main function of radio beyond being searched for is to stream audio in real time. It is not exactly possible to create at test case for audio playing correctely, and thus there are no test cases present. 

The second reason is that the other main functions of radio would have been RadioLike and the Favourite Radio Station collections. As noted above, these features have been put on hold, and thus no test cases have been made for them. 

## GitHub actions

Added GitHub action to start up MongoDB server on default port so DAO tests can run on build. Look into how to ignore certain tests, specifically SongDownloader.
