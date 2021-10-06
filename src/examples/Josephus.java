package examples;
import structures.chain.circular.CircularChainUpDown;
import structures.chain.util.ChainUpDownListIterator;

public class Josephus {
    
    CircularChainUpDown<Integer> soldiers;
    
    public static void main(String[] args) {
        new Josephus(10, 41, 2); 
    }

    /**
     * Run the Josephus problem
     * @param killInterval Kill interval M-th person
     * @param amountSoldiers Amount of soldiers
     * @param amountFriends Amount of people to save
     */
    public Josephus(int killInterval, int amountSoldiers, int amountFriends) {
        soldiers = new CircularChainUpDown<>();
        
        for(int i = 0; i < amountSoldiers; i++) {
            soldiers.add(i);
        }

        ChainUpDownListIterator<Integer> iter = soldiers.listIterator();
        
        System.out.println(soldiers);

        while(soldiers.size() > amountFriends) {
            for(int i = 0; i < killInterval - 1; i++) {
                iter.nextElem();
                System.out.print(iter.getLastReturnedElem().get());
                System.out.println(" - alive");
            }
            iter.nextElem();

            iter.remove();
            System.out.print(iter.getLastReturnedElem().get());
            System.out.println(" - killed");
            
            System.out.println(soldiers);
        }
    }
}
