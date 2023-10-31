public class Game
{
    int runs = 10000;
    int choice;
    int prize;
    int shown;
    double wins = 0;

    public Game()
    {
        runNoChange();
        runChange();
    }

    //choose same curtain
    public void runNoChange()
    {
        //random chosen curtain
        choice = (int) Math.floor(Math.random() *(3-1+1)+1);
        for(int i=0; i < runs; i++)
        {
            prize = (int) Math.floor(Math.random() *(3-1+1)+1);
            shown = (int) Math.floor(Math.random() *(3-1+1)+1);
            while(shown == prize || shown == choice)
            {
                shown = (int) Math.floor(Math.random() *(3-1+1)+1);
            }
            if(choice == prize)
                wins++;
        }
        System.out.println(wins/runs*100);
    }
    //change curtain
    public void runChange()
    {

        //random chosen curtain
        choice = (int) Math.floor(Math.random() *(3-1+1)+1);
        for(int i=0; i < runs; i++)
        {
            //get prize curtain
            prize = (int) Math.floor(Math.random() *(3-1+1)+1);
            //get shown curtain
            shown = (int) Math.floor(Math.random() *(3-1+1)+1);
            //reroll shown curtain if not third choice
            while(shown == prize || shown == choice)
            {
                shown = (int) Math.floor(Math.random() *(3-1+1)+1);
            }
            //reroll user curtain to not be initial curtain
            int temp = choice;
            while(choice == temp)
            {
                choice = (int) Math.floor(Math.random() *(3-1+1)+1);
            }

            //increment wins if choice is correct
            if(choice == prize)
                wins++;
        }
        System.out.println(wins/runs*100);
    }

}