# canary-labs-challenge

## Language used: Java

## How to run:

1) Compile & Run

javac -d out $(find src -name "*.java")
java -cp out Main

2) Enter command
You will be prompted to enter a command. Your options are:

select, filter, and sort.

Examples:
select FirstName,LastName
filter GPA > 2.25
sort GPA desc

## Design Choices
I decided to make an abstract CsvOperation class, since this ensures that all operations are consistent in structure, and it also makes it easier to create new operations in the future by just creating a new class that extends the CsvOperation class.

## Future Extensions
In the future, I think it would be useful to implement nested queries (for example, `select FirstName,LastName & filter GPA > 2.25`) for more complex operations. It would also be useful to implement more features similar to SQL, such as a limit operator that only displays the first X results, or aggregate methods like sum and average for summary statistics. Finally, I could expand the current filters, such as adding >= and <= as valid comparisons for the FilterOperation.