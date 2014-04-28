package music;

import music.midi.SequencePlayer;

/**
 * Music represents a piece of music played by multiple instruments.
 */
public interface Music {
    /**
     * @return total duration of this piece
     */
    double duration();
    
    /**
     * Transpose all notes upward or downward in pitch.
     * Requires m != null
     * @return m' such that for all notes n in m, the corresponding note n' in m'
     *   has n'.pitch() == n.pitch().transpose(semitonesUp).  Otherwise m' is identical
     *   to m.
     */
    Music transpose(int semitonesUp);
    
    /**
     * Play this piece.
     * @param player player to play on
     * @param atTick when to play
     * @return play time in ticks
     */
    int play(SequencePlayer player, int atTick);
}
