public class moveWildCard extends WildCard{

    private Square moveToSquare;
    private boolean isSq;
    private boolean isRi;

    public moveWildCard(String cardName, boolean isSquare, boolean isRiver, Square square) {
        super(cardName);
        setMoveToSquare(square);
        setIsSquare(isSquare);
        setIsRiver(isRiver);
    }

    public void execute(Player player) {
        if (isSq == true && isRi == false) {
            player.getPiece().move(moveToSquare);

        } else if (isSq == true && isRi == true) {
            int playerPos = player.getPiece().getPos();
            int diff = 0;
            int smallestDiff = 40;
            int currentPos = 5;
            int riverPos = 0;
            for (int i = 0; i < 4; i++){
                diff = Math.abs(playerPos - currentPos);
                if (diff <= smallestDiff){
                    smallestDiff = diff;
                    riverPos = currentPos;
                }
                currentPos += 10;
            }
            player.getPiece().move(BackFromTheBrink.board.getSquare(riverPos));

        } else {
            player.getPiece().move(-3);
        }

    }

    private void setMoveToSquare(Square square){
        this.moveToSquare = square;
    }

    private void setIsSquare(boolean bool){
        this.isSq = bool;
    }

    private void setIsRiver(boolean bool){
        this.isRi = bool;
    }

}
