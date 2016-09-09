#  Stack Example

IMPORTANT: DO NOT FORK OR CLONE THIS REPO. INSTEAD USE "DOWNLOAD ZIP" OPTION.

For this example, download hamcrest-all-1.3.jar and add to project build path. 

Eclipse: add hamcrest as external jar, making sure it's above Junit in build order. Otherwise a security violation exception might be thrown. 

NEW: An easier way is to use Maven to manage all the dependencies, including JUnit and Mockito. Then you can remove all the external libraries and jars from Eclipse build configuration.
I have added a POM file, which you can use. With Maven, specified dependencies will be automatically downloaded and included in build configuration. There is a reason why people use dependency management tools such as Gradle and Maven. 


 