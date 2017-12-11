package exercicio02.questao13.model;

public class NumberUtils {
    public int n;

    public boolean isPar(){
        if(n%2 == 0)
            return true;
        else
            return false;
    }
    public boolean isOdd(){
        if(isPar())
            return true;
        else
            return false;
    }

    public boolean isPrime(){
        int cont = 0;
        for(int i = this.n; i > 0; i--)
            if(this.n%i == 0)
                cont++;
        if(cont == 2)
            return true;
        else
            return false;
    }

    public String printCount(){
        String count = "";
        for(int i = 0; i <= this.n; i++)
            count += i + " ";
        return count;
    }

    public String printReverseCount(){
        String count = "";
        for(int i = this.n; i >= 0; i--)
            count += i + " ";
        return count;
    }
}
