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

    public boolean addBodyToStock(Body body) {
        return bodyStock.add(body);
    }

    public boolean addHeadToStock(Head head) {
        return headStock.add(head);
    }

    public boolean addLeftLegToStock(LeftLeg leftLeg) {
        return leftLegStock.add(leftLeg);
    }

    public boolean addRightLegToStock(RightLeg rightLeg) {
        return rightLegStock.add(rightLeg);
    }

    public boolean addRightHandToStock(RightHand rightHand) {
        return rightHandStock.add(rightHand);
    }

    public boolean addLeftHandToStock(LeftHand leftHand) {
        return leftHandStock.add(leftHand);
    }

    public Body shipBodyFromStock() {
        if (bodyStock.size() == 0) {
            return null;
        }
        return bodyStock.remove(0);
    }

    public Head shipHeadFromStock() {
        if (headStock.size() == 0) {
            return null;
        }
        return headStock.remove(0);
    }

    public LeftHand shipLeftHandFromStock() {
        if (leftHandStock.size() == 0) {
            return null;
        }
        return leftHandStock.remove(0);
    }

    public RightHand shipRightHandFromStock() {
        if (rightHandStock.size() == 0) {
            return null;
        }
        return rightHandStock.remove(0);
    }

    public LeftLeg shipLeftLegFromStock() {
        if (leftLegStock.size() == 0) {
            return null;
        }
        return leftLegStock.remove(0);
    }

    public RightLeg shipRightLegFromStock() {
        if (rightLegStock.size() == 0) {
            return null;
        }
        return rightLegStock.remove(0);
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