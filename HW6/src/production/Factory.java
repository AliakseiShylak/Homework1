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
                stock.addBodyToStock(new Body());
                break;
            case HEAD:
                stock.addHeadToStock(new Head());
                break;
            case LEFT_HAND:
                stock.addLeftHandToStock(new LeftHand());
                break;
            case RIGHT_HAND:
                stock.addRightHandToStock(new RightHand());
                break;
            case LEFT_LEG:
                stock.addLeftLegToStock(new LeftLeg());
                break;
            case RIGHT_LEG:
                stock.addRightLegToStock(new RightLeg());
                break;
        }
    }
}
