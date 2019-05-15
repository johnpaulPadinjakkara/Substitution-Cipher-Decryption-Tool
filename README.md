# Substitution-Cipher-Decryption-Tool
Java desktop application which can decrypt substitution cipher encrypted text.

Running the project:

Running the project from Compiler 
*This project developed using Eclipse IDE for Java, 
1. Open the project “Substitution Cipher Decrypter” in Eclipse or any Java supported IDE
2. Run the project or run the View/DecryptionView
3. The GUI will provide a user guide to operate the software.

Running the project from JAR file, 
*executable Jar is provided with the submission, 
1. Double click the .JAR file to run the software
2. The GUI will provide a user guide to operate the software.


User Guide to the software:

Main Flow: 
1. Enter the Cipher Text,  Encrypted using Substitution Cipher in the Panel 1
	a. if you don’t have the Cipher Text you can generated from “Generate Cipher Text” Panel
2. Upload training file from “Training Module” and Click “Train” to train the system, a sample Training file is provided, N-Grams also can be selected before training, (its must to train the system before use)
3. Select the Parameters for the Decryption algorithm, 
4. The system will show a progress bar depending on the generation size, when its done it will popup with Decrypted text, Key, and other related informations, 

Extra Functions:
1. Generate Cipher Text
a. using this module you can encrypts any English text into Cipher text, 
b. Copy and past Plane text and click Encrypt
c. you can also upload Text file to encrypt 
d. the encrypted key will be displayed in the “Encrypted key” section, 

2. Quick Check for Fitness 
a. user can check the fitness of any key using this module, 

3. To Compare (bruteForce)
a. in this the user can check the time complexity of the bruteForce method, 
