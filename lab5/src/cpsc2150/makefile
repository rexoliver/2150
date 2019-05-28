default: setMods/MultiSetApp.java setMods/DoubleSetApp.java setMods/SetAbs.java setMods/ArraySet.java setMods/ListSet.java setMods/ISet.java
	javac -Xlint setMods/MultiSetApp.java setMods/DoubleSetApp.java setMods/ArraySet.java setMods/SetAbs.java setMods/ListSet.java setMods/ISet.java

runInt: setMods/MultiSetApp.class setMods/ArraySet.class setMods/ListSet.class setMods/ISet.class setMods/SetAbs.class
	java setMods.MultiSetApp

runDouble: setMods/DoubleSetApp.class setMods/ArraySet.class setMods/ListSet.class setMods/ISet.class setMods/SetAbs.class
	java setMods.DoubleSetApp

test: setMods/MultiSetApp.java setMods/SetAbs.java setMods/ArraySet.java setMods/ListSet.java setMods/ISet.java setMods/TestListSet.java setMods/TestArraySet.java
	javac -Xlint -cp .:/usr/share/java/junit4.jar setMods/MultiSetApp.java setMods/ArraySet.java setMods/SetAbs.java setMods/ListSet.java setMods/ISet.java setMods/TestListSet.java setMods/TestArraySet.java

testArr: setMods/MultiSetApp.class setMods/SetAbs.class setMods/ArraySet.class setMods/ListSet.class setMods/ISet.class setMods/TestArraySet.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore setMods.TestArraySet

testList: setMods/MultiSetApp.class setMods/SetAbs.class setMods/ArraySet.class setMods/ListSet.class setMods/ISet.class setMods/TestListSet.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore setMods.TestListSet

clean:
	rm -f setMods/*.class
