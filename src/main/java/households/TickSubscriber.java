package households;

import java.io.IOException;

/**
 * Represents a subscriber which is notified when a tick happens.
 */
public interface TickSubscriber {

    /**
     * Update state of this subscriber.
     */
    void update() throws IOException;

    /**
     * Current number of ticks of a subscriber.
     */
    int getCurrentProgress();

    /**
     * Refresh number of ticks.
     */
    void refreshProgress();
}
