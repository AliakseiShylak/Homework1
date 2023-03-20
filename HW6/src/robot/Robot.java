package robot;

public class Robot {
    private Body body;
    private Head head;
    private LeftHand leftHand;
    private RightHand rightHand;
    private LeftLeg leftLeg;
    private RightLeg rightLeg;

    public Robot(Body body, Head head, LeftHand leftHand, RightHand rightHand, LeftLeg leftLeg, RightLeg rightLeg) {
        this.body = body;
        this.head = head;
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.leftLeg = leftLeg;
        this.rightLeg = rightLeg;
    }
}
