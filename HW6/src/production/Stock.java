package production;

import robot.*;

import java.util.ArrayList;

public class Stock {
    private ArrayList<Body> bodyStock;
    private ArrayList<Head> headStock;
    private ArrayList<LeftHand> leftHandStock;
    private ArrayList<RightHand> rightHandStock;
    private ArrayList<LeftLeg> leftLegStock;
    private ArrayList<RightLeg> rightLegStock;

    public Stock() {
        this.bodyStock = new ArrayList<>();
        this.headStock = new ArrayList<>();
        this.leftHandStock = new ArrayList<>();
        this.rightHandStock = new ArrayList<>();
        this.leftLegStock = new ArrayList<>();
        this.rightLegStock = new ArrayList<>();
    }

    public <T> boolean addPartToStock(T part) {
        if (part instanceof Body) {
            return bodyStock.add((Body) part);
        }
        if (part instanceof Head) {
            return headStock.add((Head) part);
        }
        if (part instanceof LeftHand) {
            return leftHandStock.add((LeftHand) part);
        }
        if (part instanceof RightHand) {
            return rightHandStock.add((RightHand) part);
        }
        if (part instanceof LeftLeg) {
            return leftLegStock.add((LeftLeg) part);
        }
        if (part instanceof RightLeg) {
            return rightLegStock.add((RightLeg) part);
        }
        return false;
    }

    public Body shipBodyFromStock() {
        if (bodyStock.size() == 0) {
            return null;
        }
        Body shippedBody = bodyStock.get(0);
        bodyStock.remove(0);
        return shippedBody;
    }

    public Head shipHeadFromStock() {
        if (headStock.size() == 0) {
            return null;
        }
        Head shippedHead = headStock.get(0);
        headStock.remove(0);
        return shippedHead;
    }

    public LeftHand shipLeftHandFromStock() {
        if (leftHandStock.size() == 0) {
            return null;
        }
        LeftHand shippedLeftHand = leftHandStock.get(0);
        leftHandStock.remove(0);
        return shippedLeftHand;
    }

    public RightHand shipRightHandFromStock() {
        if (rightHandStock.size() == 0) {
            return null;
        }
        RightHand shippedRightHand = rightHandStock.get(0);
        rightHandStock.remove(0);
        return shippedRightHand;
    }

    public LeftLeg shipLeftLegFromStock() {
        if (leftLegStock.size() == 0) {
            return null;
        }
        LeftLeg shippedLeftLeg = leftLegStock.get(0);
        leftLegStock.remove(0);
        return shippedLeftLeg;
    }

    public RightLeg shipRightLegFromStock() {
        if (rightLegStock.size() == 0) {
            return null;
        }
        RightLeg shippedRightLeg = rightLegStock.get(0);
        rightLegStock.remove(0);
        return shippedRightLeg;
    }

    public String printStock() {
       return "Quantity of parts in stock: Body - " + bodyStock.size()
               + ", Head - " + headStock.size()
               + ", Left hand - " + leftHandStock.size()
               + ", Right hand - " + rightHandStock.size()
               + ", Left leg - " + leftLegStock.size()
               + ", Right leg - " + rightLegStock.size();
    }
}