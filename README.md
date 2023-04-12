# calendarweb
In this project, we get the open-source code from: https://code.daypilot.org/41760/using-javascript-html5-event-calendar-in-spring-boot-java. This source code includes only one page, which allows us to create, resize events. All events are saved to H2 database. 
![image](https://user-images.githubusercontent.com/108050962/231344259-643fa3dc-d50d-4194-b7a8-e60510b59dbd.png)

We configured authentication & authorization and created sign-in, sign-up pages. With this change, users can enroll and log in to use this application. After login, users can see and edit their own events on calendar. All users and events information is saved to MySQL.
Sign-in page: 
![image](https://user-images.githubusercontent.com/108050962/231343197-c5dad0ee-cf02-48b8-9f73-b104ddf65cfc.png)
Sign-up page: 
![image](https://user-images.githubusercontent.com/108050962/231343385-929895c1-2572-46d8-8f2d-62e6abe2c99e.png)
Calendar page: 
![image](https://user-images.githubusercontent.com/108050962/231343606-70941a31-5d5c-4b1c-b080-e137ecca309f.png)

In the near future, we plan to make some more improvements: 
- Add some data fields to event objects (such as location, note, category, etc.) and user can enter more details about their events.
- Create multiple modes of calendar: daily, weekly, monthly.
- Allow users to review and edit their account information.
