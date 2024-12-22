package lecture.forex.service;

import lecture.forex.model.Position;

import java.util.ArrayList;
import java.util.List;

public class PositionService {

    private List<Position> openedPositions = new ArrayList<>();

    /**
     * Opens a position and adds it to the in-memory list (mocking an API call).
     *
     * @param position The position details (currency pair, direction, quantity).
     */
    public void openPosition(Position position) {
        // Add the position to the local list
        openedPositions.add(position);

        // Log success (mocking actual API behavior)
        System.out.println("Position opened: " + position);
    }

    /**
     * Closes a position by removing it from the in-memory list (mocking an API call).
     *
     * @param positionId The ID of the position to close.
     */
    public void closePosition(String positionId) {
        // Remove the position based on its ID
        boolean removed = openedPositions.removeIf(pos -> positionId.equals(pos.getPositionId()));

        // Log the result
        if (removed) {
            System.out.println("Position closed: ID = " + positionId);
        } else {
            System.out.println("Position not found: ID = " + positionId);
        }
    }

    /**
     * Retrieves all currently opened positions (mocking an API call).
     *
     * @return A list of opened positions.
     */
    public List<Position> getOpenedPositions() {
        // Return the list of opened positions
        return openedPositions;
    }
}