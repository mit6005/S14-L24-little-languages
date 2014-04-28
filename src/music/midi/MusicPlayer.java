package music.midi;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import music.*;

/**
 * MusicPlayer can play a Music expression on the computer's MIDI synthesizer.
 */
public class MusicPlayer {
    public static final int BEATS_PER_MINUTE = 120;
    public static final int TICKS_PER_BEAT = 64;
    
    /**
     * Play the music
     * @throws MidiUnavailableException if no MIDI device is available to play on
     */
    public void play(Music m) throws MidiUnavailableException, InvalidMidiDataException {
        SequencePlayer player = new SequencePlayer(BEATS_PER_MINUTE, TICKS_PER_BEAT);
        
        // load the player with a sequence created from music
        m.play(player, 1);
        
        // start playing
        player.play();
    }
}
