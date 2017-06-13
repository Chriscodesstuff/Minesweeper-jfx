javac -d bin -cp bin;lib src/com/paradox/grids/*.java
javac -d bin -cp bin;lib src/com/paradox/tiles/*.java
javac -d bin -cp bin;lib src/com/paradox/games/*.java
javac -d bin -cp bin;lib src/com/paradox/runners/*.java
java -cp bin;lib;resources com.paradox.runners.MainRunner
