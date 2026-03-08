# canary-labs-challenge

## Language used: Java

## How to run:

1) Run Tests

`./gradlew test`

2) Compile & Run

`./gradlew run --console plain -q`

This will hide any other output and run my program.

3) Enter command
You will be prompted to enter a command. Your options are:

select, filter, and sort.

Examples:
select FirstName,LastName
filter GPA > 2.25
sort GPA desc

## Design Choices
I decided to make an CsvOperation interface, since this ensures that all operations are consistent in structure, and it also makes it easier to create new operations in the future by just creating a new class that implements the CsvOperation interface. This was also chosen for the Strategy pattern, using CsvOperation as a way to run any strategy (or operation in this project) dynamically at runtime. We see this in the Main class, which selects which CsvOperation to run given the user's input. All these CsvOperation derivatives have an "execute" method, which means that we can blindly call this method without knowing which operation was selected.

## Future Extensions
In the future, I think it would be useful to implement nested queries (for example, `select FirstName,LastName | filter GPA > 2.25`) for more complex operations with multiple steps. It would also be useful to implement more features found in SQL, such as a limit operator that only displays the first X results, or aggregate methods like sum and average for summary statistics. Finally, I could expand the current filters, such as adding >= and <= as valid comparisons for the FilterOperation.