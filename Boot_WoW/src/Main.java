//Filename Main.java
//Author Isaiah Sherfick
//Part of my WoW Classic booting program to skip login queue
//Last modified on 28 Aug 2019


import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        //Prompt user for input
        System.out.println("How long (in minutes) should I wait before booting WoW for you, master?");

        //Create Scanner to parse input
        Scanner s = new Scanner(System.in);

        //Grab input
        int minutesToWait = s.nextInt();

        //Initialize Booter
        Booter b = new Booter(minutesToWait);

        //Produce output
        System.out.println("Booting WoW! Feel free to tab over to the Blizzard Launcher now; make sure to maximize it.");

        //Boot World Of Warcraft
        b.bootWoW();
    }
}
