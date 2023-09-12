To run this, navigate to Lab0 , then run the following commands:

javac -cp junit-4.13.2.jar "./src/c/TestMe.java" "./src/u/TestMeTests.java"

java -cp "junit-4.13.2.jar:hamcrest-core-1.3.jar:./src/" org.junit.runner.JUnitCore u.TestMeTests