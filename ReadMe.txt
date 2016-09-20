ReadMe
------------------------------------------------------------------------------

author: Yogesh Jeswani, Aniruddh Jhavar
------------------------------------------------------------------------------

The folder contains following files and folders:
1. ReadMe
2. readCorpus.java
3. Comparator.java
4. Barack_Obama_Medal_Freedom_ceremony.txt
5. Narendra_modi.txt
6. The_Ballot_or_the_Bullet.txt
 
-------------------------------------------------------------------------------

Instructions:

1. The program needs following libraries for running:

1. stanford-corenlp-3.5.0.jar
2. stanford-corenlp-3.5.0-javadoc.jar
3. stanford-corenlp-3.5.0-models.jar
4. stanford-corenlp-3.5.0-sources.jar
5. ejml-0.21.jar

Since the jar files are big in sizes they haven't been uploaded to the folder. For running program you need to download the above libraries.
	
2. The program is written in java and since it requires an external jar files hence it should be ran in an IDE. We have used Eclipse for it and you need to include the jar file in it.

3. To give an input file to the program you need to put the path of the input file as follows:

	Scanner scanner = new Scanner( new File("path of the file") );

	eg: Scanner scanner = new Scanner( new File("D:\\Fall_2015\\NLP\\Narendra_modi.txt") );
---------------------------------------------------------------------------------

Output: 

/*The output will contain multiple lines */
