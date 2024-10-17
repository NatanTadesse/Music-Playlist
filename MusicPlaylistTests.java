import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class MusicPlaylistTests {
    private MusicPlaylist playlist;

	 @BeforeEach
	 public void setUp() {
		playlist = new MusicPlaylist();
	 }

	 @Test
	 public void testAddSong() {
		playlist.addSong("Song 1");
		assertEquals("Song 1", playlist.playSong());
	 }

	 @Test
	 public void testPlaySong() {
        playlist.addSong("Song 1");
        String playedSong = playlist.playSong();
        assertNotNull(playedSong);
        assertEquals("Song 1", playedSong);
    }

	 @Test
	 public void testClearHistory() {
        playlist.addSong("Song 1");
        playlist.playSong();
        playlist.clearHistory();
        assertTrue(playlist.getHistory().isEmpty());
    }

	 @Test
	 public void testDeleteHistory() {
		playlist.addSong("Song 1");
		playlist.addSong("Song 2");
		playlist.playSong();
		playlist.playSong();
		playlist.deleteHistory(1);
		Stack<String> history = playlist.getHistory();
		assertEquals(1, history.size()); 
		assertEquals("Song 1", history.pop());
	}
	
	@Test
	public void testGetHistory() {
		playlist.addSong("Song 1");
		playlist.playSong();

		Stack<String> history = playlist.getHistory();
		assertEquals(1, history.size());
		assertEquals("Song 1", history.pop());
	}
}