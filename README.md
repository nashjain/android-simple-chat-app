## Table of Contents

 - [How to run server](#how-to-run-server)
 - [API Example](#api-example)
 - [Known Issues](#known-issues)

You'll need to run the server (https://github.com/nashjain/java-legacy-chat-server) locally and then update the code with your local IP address.

How to run server:
===
* download and double click on target/chat-server.jar
or
* java -jar target/chat-server.jar

API example:
==
* http://localhost:4567/send?message=Yo_this_is_a_message&senderName=naresh
* http://localhost:4567/fetchAllMessages

Known Issues
==
* Null pointer exception if no response server
* Can't send message starting with " "
* All strings (e.g. hint texts)are not externalized