// Natan Tadesse
// 06/4/2024
// Music Playlist
/* This class represents a music playlist. It maintains a queue of songs to be 
    played and a history stack of songs that have been played. It provides
    methods to add songs to the playlist, play songs, and manage the history of played songs. */
import java.util.*;

public class MusicPlaylist {
    private Queue<String> playlist;
    private Stack<String> history;
    
    private void transferToStack(Stack<String> source, Stack<String> location) {
        while(!source.isEmpty()) {
            location.push(source.pop());
        }
        while (!location.isEmpty()) {
            source.push(location.pop());
        }
    }

    private void removeFromTop(int num) {
        for (int i = 0; i < num; i++) {
            this.history.pop();
        }
    }

    private void removeFromBottom(int num) {
        Stack<String> auxStack = new Stack<>();
        while (this.history.size() > num) {
            auxStack.push(this.history.pop());
        }
        this.history.clear();
        while (!auxStack.isEmpty()) {
            this.history.push(auxStack.pop());
        }
    }

    // Constructor that initializes the playlist and history
    // Parameters:
    //   - none
    // Returns: 
    //   - none
    //  Exceptions:
    //   - none
    public MusicPlaylist() {
        this.playlist = new LinkedList<>();
        this.history = new Stack<>();
    }

    // Adds a song to the playlist
    // Parameters:
    //   - song: String representing the song to be added
    // Returns: 
    //   - none
    //  Exceptions:
    //   - none
    public void addSong(String song) {
        this.playlist.add(song);
    }

    // Plays a song from the playlist and adds it to the history
    // Parameters:
    //   - none
    // Returns: 
    //   - song: String representing the song that was played
    //  Exceptions:
    //   - Throws an IllegalStateException if the playlist is empty
    public String playSong() {
        if (this.playlist.isEmpty()) {
            throw new IllegalStateException("no songs in playlist!");
        }
        String song = this.playlist.remove();
        this.history.push(song);
        return song;
    }
    
    // Prints the history of played songs to the console
    // Parameters:
    //   - none
    // Returns: 
    //   - song: String representing the song that was played
    //  Exceptions:
    //   - Throws an IllegalStateException if the history is empty
    public void printHistory() {
        if (this.history.isEmpty()) {
            throw new IllegalStateException("The history is empty!");
        }
        Stack<String> auxHistory = getHistory();
        while (!auxHistory.isEmpty()) {
            System.out.println("    " + auxHistory.pop());
        }
    }

    // Returns a copy of the history stack
    // Parameters:
    //   - none
    // Returns: 
    //   - auxHistory: A Stack<String> representing the history of played songs
    //  Exceptions:
    //   - none
    public Stack<String> getHistory() {
        Stack<String> auxHistory = new Stack<>();
        for (String song : history) {
            auxHistory.push(song);
        }
        return auxHistory;
    }

    // Clears the history of played songs
    // Parameters:
    //   - none
    // Returns: 
    //   - none
    //  Exceptions:
    //   - none
    public void clearHistory() {
        this.history.clear();
    }

    // Deletes songs from the history, positive # deletes from top, negative # deletes from bottom
    // Parameters:
    //   - num: int representing the number of songs to delete from the history
    // Returns: 
    //   - none
    //  Exceptions:
    //   - Throws an IllegalArgumentException if the abs value of num is greater than history size
    public void deleteHistory (int num) {
        if (Math.abs(num) > this. history.size()) {
            throw new IllegalArgumentException("number greater than playlist size!");
        }
        
        if (num > 0) {
            removeFromTop(num);
        }
        else if (num < 0) {
            removeFromBottom(Math.abs(num));
        }
    }
}