package Celebrity_Game;

public class Game {
    private int roundNumber; 
    private int maxRounds; 
    private Player winner; 
    private Player loser;
    private Player currentPlayer;
    private Celebrity currentCelebrity;
    private int celebritiesRevealed;
    private int turnsTaken;

    private Celebrity RyanCoogler;
    private Celebrity BenicioDelToro;
    private Celebrity TimotheeChalame;
    private Celebrity KateHudson;
    private Celebrity ChloeZhao;
    private Celebrity JacobElordi;



    public Game() {
        this.roundNumber = 0;
        this.winner = null;
        this.celebritiesRevealed = 0;
        this.turnsTaken = 0;

        RyanCoogler = new Celebrity("Ryan Coogler", "Who directed Sinners?");
        BenicioDelToro = new Celebrity("BenicioDelToro", "Who is a supporting actor in One Battle After Another?");
        TimotheeChalame = new Celebrity("Timothee Chalame", "Who is the leading actor in Marty Supreme?");
        KateHudson = new Celebrity("Kate Hudson", "Who is the leading actress in Song Sung Blue?");
        ChloeZhao = new Celebrity("Chloe Zhao", "Who is the director of Hamnet?");
        JacobElordi = new Celebrity("Jacob Elordi", "Who is the supporting actor in Frankenstein?");

    }

    public void playGame(Player player1, Player player2, int maxRounds) {
        this.maxRounds = maxRounds;
        for (int i = 0; i < maxRounds; i++) {
            playRound();
        }

        if (player1.getScore() > player2.getScore()) {
            winner = player1;
            loser = player2;
        } else if (player2.getScore() > player1.getScore()) {
            winner = player2;
            loser = player1;
        } else {
            winner = null; // It's a tie
        }
    }

    public void endGame() {
        if (winner != null) {
            System.out.println("The winner is " + winner.getName());
            System.out.println("Final Score: " + winner.getScore() + " - " + loser.getScore());
        } else {
            System.out.println("The game ended in a tie!");
        }

        System.out.println(); 
        System.out.println("Thanks for playing!");

        System.exit(0); 
    }

    public Player determineStartingPlayer(Player player1, Player player2) {
        double result = Math.random();
        if (result < 0.5) {
            return player1;
        } else {
            return player2;
        }
    }

    public void resetRoundData() {
        this.currentCelebrity = null;
        this.celebritiesRevealed = 0;
        this.turnsTaken = 0;
    }

    public void playRound() {
        roundNumber++;
        System.out.println(); 
        System.out.println("Starting Round " + roundNumber);

        resetRoundData();
    }
}
