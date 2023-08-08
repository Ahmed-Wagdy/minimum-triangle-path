# Minimum-triangle-path

A command-line program that reads a text-format triangle

from standard input and outputs a minimal path to the standard-
output 

# How to Run

### Run through sbt
```
sbt run

*Then enter triangle data line by line, each line is space separated
*End input by typing `EOF` and press enter or add an empty line the press enter

example:
1
1 2
2 3 4
EOF

Or 

1 
1 2
2 3 4
(empty line here)
```

### Test through sbt 
```
sbt test
```

### Using Jar file

```
sbt assembly 

*this will create a jar file inside the target directory

*find the path to the jar file and run:

java -jar {PATH_TO_JAR_FILE}

*Then enter triangle data line by line, each line is space separated
*End input by typing `EOF` and press enter or add an empty line the press enter

example:
1
1 2
2 3 4
EOF

Or 

1 
1 2
2 3 4
(empty line here)
```

### you can pipe the data from file to stdIn using jar:
```
 cat {TEST_DATA} |  java -jar {PATH_TO_JAR}
 
 *please make sure that the test data file's last line is `EOF`
```
