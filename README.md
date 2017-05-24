# Evaluate request rate performance

## Problem
We need to evaluate our request rate performance and to do that we decided to save

the average millisecond (as Integer) per second and evaluate the data for the entire

week. The Integers range is between 0 and 1000, we want to know the median of milliseconds

(as Integer).

Simple example, imagine the following data: [4, 1, 6, 3, 7, 8, 7], to calculate the median

we need to sort it, [1, 3, 4, 6, 7, 7, 8] and identify the median, in this case the Integer 6.

(is the middle index, has 3 items on the left side and 3 on the right side).

Write a Stats class to be able to collect samples (as Integer) and output the median (as

Integer).

## Built With
1. Java 8
2. Maven

## About Application:
1. DDD has been followed
2. TDD has been followed with automated tests
3. Code has been thoroughly documented!

## Run
1. mvn package
2. java -jar target/target/statistics-0.0.1-SNAPSHOT.jar "4, 1, 6, 3, 7, 8, 7"

## Author
Sana Talha
