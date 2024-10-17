// Natan Tadesse
// 06/4/2024
// Music Playlist
/* This class serves as the main driver for the MusicPlaylist application. It interacts 
    with the user, takes input from the console, and performs operations
    on the MusicPlaylist object accordingly. */
import java.util.*;

public class MusicPlaylistMain {
    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the CSE 122 Music Playlist!");
        menu();

        String response = scan.nextLine();

        while(!response.equalsIgnoreCase("Q")) {
            if (response.equalsIgnoreCase("A")) {
                System.out.print("Enter song name: ");
                String song = scan.nextLine();
                playlist.addSong(song);
                System.out.println("Successfully added " + song);
                System.out.println();
            }
            else if (response.equalsIgnoreCase("P")) {
                String song = playlist.playSong();
                System.out.println("Playing song: " + song);
                System.out.println();
            }
            else if (response.equalsIgnoreCase("Pr")) {
                playlist.printHistory();
            }
            else if (response.equalsIgnoreCase("C")) {
                playlist.clearHistory();
            }
            else if (response.equalsIgnoreCase("D")) {
                System.out.println("A positive number will delete from recent history.");
                System.out.println("A negative number will delete from the beginning of history.");
                System.out.print("Enter number of songs to delete: ");
                String reply = scan.nextLine();
                int num = Integer.parseInt(reply);
                playlist.deleteHistory(num);
            }
            System.out.println();
            menu();
            response = scan.nextLine();
        }
    }

    // Prints the menu options to the console.
    // Parameters:
    //   - none
    // Returns: 
    //   - none
    //  Exceptions:
    //   - none
    public static void menu() {
        System.out.println("(A) Add song");
        System.out.println("(P) Play song");
        System.out.println("(Pr) Print history");
        System.out.println("(C) Clear history");
        System.out.println("(D) Delete from history");
        System.out.println("(Q) Quit");
        System.out.println();
        System.out.print("Enter your choice: "); 
    }
}