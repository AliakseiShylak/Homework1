package country;

import production.Stock;
import robot.*;

import java.util.ArrayList;

public class Country {
    private final String nameOfCountry;
    private Body body;
    private Head head;
    private LeftHand leftHand;
    private RightHand rightHand;
    private LeftLeg leftLeg;
    private RightLeg rightLeg;
    private ArrayList<Robot> army;

    public Country(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
        this.body = null;
        this.head = null;
        this.leftHand = null;
        this.rightHand = null;
        this.leftLeg = null;
        this.rightLeg = null;
        this.army = new ArrayList<>();
    }

    public boolean takePartsFromStock(Stock stock) {
        int count = 0;
        if (body == null) {
            body = stock.shipBodyFromStock();
            if (body != null) {
                count++;
            }
        }
        if (head == null) {
            head = stock.shipHeadFromStock();
            if (head != null) {
                count++;
            }
        }
        if (leftHand == null) {
            leftHand = stock.shipLeftHandFromStock();
            if (leftHand != null) {
                count++;
            }
        }
        if (rightHand == null) {
            rightHand = stock.shipRightHandFromStock();
            if (rightHand != null) {
                count++;
            }
        }
        if (leftLeg == null) {
            leftLeg = stock.shipLeftLegFromStock();
            if (leftLeg != null) {
                count++;
            }
        }
        if (rightLeg == null) {
            rightLeg = stock.shipRightLegFromStock();
            if (rightLeg != null) {
                count++;
            }
        }
        return count > 0 ? true : false;
    }

    public boolean collectRobot() {
        if (body != null
                && head != null
                && leftHand != null
                && rightHand != null
                && leftLeg != null
                && rightLeg != null
        ) {
            army.add(new Robot(body, head, leftHand, rightHand, leftLeg, rightLeg));
            body = null;
            head = null;
            leftHand = null;
            rightHand = null;
            leftLeg = null;
            rightLeg = null;
            return true;
        }
        return false;
    }

    public int getSizeOfArmy() {
        return army.size();
    }

    public String printDataAboutAndPartsForRobot() {
        return "Army of country " + nameOfCountry
                + " consists of " + army.size()
                + " robots. Parts for robot: "
                + "Body - " + (body == null ? "no" : "yes")
                + ", Head - " + (head == null ? "no" : "yes")
                + ", Left hand - " + (leftHand == null ? "no" : "yes")
                + ", Right hand - " + (rightHand == null ? "no" : "yes")
                + ", Left leg - " + (leftLeg == null ? "no" : "yes")
                + ", Right leg - " + (rightLeg == null ? "no" : "yes");
    }
}
