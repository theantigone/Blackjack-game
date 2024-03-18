import java.util.*;
//NAME: Quang Hoang

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        //Create stacks and queues
        Stack deck = new Stack();
        Queue playerHand = new LinkedList();
        Queue dealerHand = new LinkedList();
        
        //Populate deck
        int total=0;
        for(int i=1; i<=10; i++)
        {
            deck.push(i);
            deck.push(i);
            deck.push(i);
            deck.push(i);
        }
        
        //Shuffle deck
        Collections.shuffle(deck);
        
        //Deal initial cards
        playerHand.add(deck.pop());
        dealerHand.add(deck.pop());
        playerHand.add(deck.pop());
        dealerHand.add(deck.pop());
        
        //Get player's name
        System.out.print("What is your name?? ");
        String name = input.nextLine();
        String champion = "Twisted Fate";
        System.out.println("The dealer's name is "+champion+".\n\nTwisted Fate (fictional character) is an infamous cardsharp and swindler who has gambled and charmed his way across much of the known world, earning the enmity and admiration of the rich and foolish alike. He rarely takes things seriously, greeting each day with a mocking smile and an insouciant swagger. In every possible way, Twisted Fate always has an ace up his sleeve (not proven to always have an ace up his sleeve.)\nGood luck.\n");
        
        
        //Game loop
        while(true)
        {
            //Show player's hand
            System.out.print(name + "'s cards: ");
            System.out.print(playerHand);
            System.out.println(" Total: "+total(playerHand));
            
            //Check if player has blackjack
            if(total(playerHand) == 21)
            {
                System.out.println("Blackjack! Let us see if "+champion+" can get a blackjack as well.\n\n"+champion+": \"It's all in the cards.\"");
                break;
            }
            
            //Check if player has busted
            if(total(playerHand) > 21)
            {
                System.out.println("You busted! You lose the card game.\n\n"+champion+": \"Lookin' good.\"");
                break;
            }
            
            //Get player's decision
            System.out.print("Would you like to \"hit\" or \"stand\"? ");
            String decision = input.next();
            
            //Hit
            if(decision.equalsIgnoreCase("hit"))
            {
                //Add next card to player's hand
                playerHand.add(deck.pop());
            }
            
            //Stand
            else if(decision.equalsIgnoreCase("stand"))
            {
                break;
            }
            
            //Invalid input
            else
            {
                System.out.println("Invalid input. Try again!");
            }
            
            System.out.println();
        }
        
        System.out.println();
        
        //Show dealer's hand
        System.out.print(champion+"'s cards: ");
        System.out.println(dealerHand);
        System.out.println(champion+"'s total: " + total(dealerHand));
        
        //Game loop
        while(total(dealerHand) < 17)
        {
            //Add next card to dealer's hand
            dealerHand.add(deck.pop());
            
            //Show dealer's hand
            System.out.print(champion+"'s cards: ");
            System.out.println(dealerHand);
            System.out.println(champion+"'s total: " + total(dealerHand));
        }
        
        System.out.println();
        
        //Determine winner
        if(total(dealerHand) > 21 && total(playerHand) > 21)
        {
          System.out.println(champion+" busted, but you still lose the game because you busted first.\n\n"+champion+": \"Don't mind if I do.\"");
        }
        
        else if(total(dealerHand) > 21 && total(playerHand) <= 21)
        {
          System.out.println(champion+" busted! You win the card game!\n\n"+champion+": \"Lady Luck is smilin' at you.\"");
        }

        else if(total(dealerHand) <= 21 && total(playerHand) > 21)
        {
          System.out.println("You busted! You lose the card game... You'll get 'em next time!\n\n"+champion+": \"I'm one of a kind.\"");
        }
          
        else if(total(playerHand) > total(dealerHand))
        {
          System.out.println("Your total is higher! You win the card game!\n\n"+champion+": \"Lucky them.\"");
        }
        
        else if(total(playerHand) < total(dealerHand))
        {
          System.out.println("Your total is lower! You lose.\n\n"+champion+": \"Never lost a fair game... or played one.\"");
        }
        
        else
        {
            System.out.println("You push. It is a draw of the cards (tie.)\n\n"+champion+": \"Just the luck of the draw.\"");
        }
    }
    
    //Returns the sum of the given hand
    public static int total(Queue hand)
    {
        int sum = 0;
        
        for(Object card : hand)
        {
            sum += (int)card;
        }
        
        return sum;
    }
}