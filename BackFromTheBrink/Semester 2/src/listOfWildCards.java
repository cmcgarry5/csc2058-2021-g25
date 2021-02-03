public class listOfWildCards {

    WildCard advanceJaguar = new moveWildCard("Advance to Jaguar", true, false, BackFromTheBrink.board.getSquare(3));
    WildCard advanceBlueWhale = new moveWildCard("Advance to Blue Whale", true, false, BackFromTheBrink.board.getSquare(37));
    WildCard advanceNearestRiver = new moveWildCard("Advance to the Nearest River", true, true,null);
    WildCard advanceTravel = new moveWildCard("Advance to Travel Square", true, false, BackFromTheBrink.board.getSquare(0));
    WildCard backThree = new moveWildCard("Go Back 3 Squares", false, false, null);
    WildCard advanceHidingSafari = new moveWildCard("Caught by Predator, advance to Hiding in Safari", true, false, BackFromTheBrink.board.getSquare(10));
    WildCard rescueTeam = new EscapeCard("Escape Safari Card");
    WildCard conservationGrant = new receiveMatWildCard("Received a Grant", false, false, 200);
    WildCard maintenance = new payUpWildCard("Assessed for Maintenance", true, 0);
    WildCard breedingSuccessful = new receiveMatWildCard("Successful Breeding", true, false, 0);
    WildCard electedChairman = new payUpWildCard("Elected As Chairman", false, 50);
    WildCard endOfMonth = new payUpWildCard("Food Bills", false, 100);
    WildCard feeRefund = new receiveMatWildCard("Conservation Fee Refund", false, false, 200);
    WildCard conservationScheme = new receiveMatWildCard("Conservation Scheme", false, true, 0);
}
