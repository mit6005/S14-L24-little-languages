package music;

import music.midi.SequencePlayer;

/**
 * Forever represents a piece of music playing over and over in an 
 * infinite loop. 
 */
public class Forever implements Music {
    private final Music m;
    
    private void checkRep() {
        assert m != null;
    }
    
    /**
     * Make a Forever.
     * @param m music to loop forever
     */
    public Forever(Music m) {
        this.m = m;
        checkRep();
    }

    /**
     * @return piece of music that loops forever
     */
    public Music loop() {
        return m;
    }
    
    /**
     * @return duration of this forever, i.e. positive infinity
     */
    public double duration() {
        return Double.POSITIVE_INFINITY;
    }
    
    /**
     * Transpose the piece in this forever
     */
    public Music transpose(int semitonesUp) {
        return new Forever(m.transpose(semitonesUp));
    }
    
    /**
     * Play the piece in this forever, forever, up to a maximum play time
     */
    public int play(SequencePlayer player, int atTick) {
        int maximumPlaybackTicks = player.ticksPerBeat() * player.beatsPerMinute() * 10 /*minutes*/;
        int ticksElapsed = 0;
        if (m.duration() != 0) {
            while (ticksElapsed < maximumPlaybackTicks) {
                ticksElapsed += m.play(player, atTick + ticksElapsed);
            }
        }
        return ticksElapsed;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + m.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Forever other = (Forever) obj;
        if (!m.equals(other.m)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "forever(" + m + ")";
    }
}
