package house;

/**
 * Something or someone that a {@link households.Household} can interact with.
 */
public interface Interactable {

    InteractableType getInteractableType();

    int getTicks();

    enum InteractableType {
        HOUSEHOLD, DEVICE
    }
}
