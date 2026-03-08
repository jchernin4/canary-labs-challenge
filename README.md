# canary-labs-challenge

Language used: Java

How to run:

1) Compile

javac -d out $(find src -name "*.java")
java -cp out Main

2) Enter command
You will be prompted to enter a command. Your options are:

select, filter, and sort.

Examples:
select FirstName,LastName
filter GPA > 2.25
sort GPA desc