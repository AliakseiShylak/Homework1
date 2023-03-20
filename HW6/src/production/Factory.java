package production;

import robot.*;

import java.util.Random;

public class Factory {
    private Part[] parts;
    public Factory() {
        this.parts = Part.values();
    }

    private final Random RANDOM = new Random();

    public void produceRandomPartAndPutInStock(Stock stock) {
        switch (parts[RANDOM.nextInt(parts.length)]) {
            case BODY:
                stock.addPartToStock(new Body());
                break;
            case HEAD:
                stock.addPartToStock(new Head());
                break;
            case LEFT_HAND:
                stock.addPartToStock(new LeftHand());
                break;
            case RIGHT_HAND:
                stock.addPartToStock(new RightHand());
                break;
            case LEFT_LEG:
                stock.addPartToStock(new LeftLeg());
                break;
            case RIGHT_LEG:
                stock.addPartToStock(new RightLeg());
                break;
        }
    }
}
